package byfayzullayev.itcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class RoleEntity implements GrantedAuthority {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;

    @Override
    public String getAuthority() {
        return roleEnum.name();
    }
}
