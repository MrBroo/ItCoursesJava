package byfayzullayev.itcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("FILE")
@Table(name = "FILE_SINGLE_TABLE")
@Entity(name = "FILE_SINGLE_TABLE")
public class FileStorage extends BaseEntity implements Serializable {

private String name;
private String extansion;
private Long fileSize;
private String contentType;
@Lob
private byte[] data;
private String uploadPath;
}
