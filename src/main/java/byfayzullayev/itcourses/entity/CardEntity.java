package byfayzullayev.itcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("CARD")
@Table(name = "CARD_SINGLE_TABLE")
@Entity(name = "CARD_SINGLE_TABLE")
public class CardEntity extends BaseEntity{
    private String name;
    private String about;
}
