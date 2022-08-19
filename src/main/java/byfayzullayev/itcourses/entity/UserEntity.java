package byfayzullayev.itcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private Long phoneNumber;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleEntity> role = new ArrayList<>();

}
