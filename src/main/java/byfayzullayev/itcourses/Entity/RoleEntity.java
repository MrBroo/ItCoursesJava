package byfayzullayev.itcourses.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class RoleEntity {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;
}
