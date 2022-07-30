package byfayzullayev.itcourses.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class UserEntity extends BaseEntity{

    private String fullName;
    private String phoneNumber;
    private String username;
    private String password;

}
