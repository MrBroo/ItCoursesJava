package byfayzullayev.itcourses.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CardEntity extends BaseEntity{
    private String name;
    private String about;
}
