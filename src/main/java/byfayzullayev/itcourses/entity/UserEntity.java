package byfayzullayev.itcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class UserEntity extends BaseEntity implements UserDetails {

    private String fullName;
    private Long phoneNumber;
    private String username;
    private String password;
    private boolean active = true;

    @ManyToOne(fetch = FetchType.EAGER)
    private List<RoleEntity> roleEntityList;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roleEntityList;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

}