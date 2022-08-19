package byfayzullayev.itcourses.service;

import byfayzullayev.itcourses.entity.RoleEntity;
import byfayzullayev.itcourses.entity.UserEntity;
import byfayzullayev.itcourses.repository.RoleRepository;
import byfayzullayev.itcourses.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImplements implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity saveUser(UserEntity user) {
         log.info("Saving new user {} to the database", user.getUsername(), user.getPhoneNumber(), user.getFullName());
       user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public RoleEntity saveRole(RoleEntity role) {
        log.info("Saving new role {} to the database", role.getName());

        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {} ", roleName, username);

        UserEntity userEntity = userRepository.findByUsername(username);
        RoleEntity roleEntity = roleRepository.findByName(roleName);
        userEntity.getRole().add(roleEntity);
    }

    @Override
    public UserEntity getUser(String username) {
        log.info("Fetching user {}", username);

        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserEntity> getUsers() {
        log.info("SaviFetching all users");

        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      UserEntity user = userRepository.findByUsername(username);
      if (user == null){
          log.error("User not found in the database");
          throw new UsernameNotFoundException("User not found in the database");
      }else{
          log.info("User found in the database: {}", username);
      }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
      user.getRole().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
