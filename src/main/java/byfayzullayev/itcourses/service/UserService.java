package byfayzullayev.itcourses.service;

import byfayzullayev.itcourses.entity.RoleEntity;
import byfayzullayev.itcourses.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity saveUser(UserEntity user);
    RoleEntity saveRole(RoleEntity role);
    void addRoleToUser(String username, String roleName);
    UserEntity getUser(String username);
    List<UserEntity>getUsers();
}
