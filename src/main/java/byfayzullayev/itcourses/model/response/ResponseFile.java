package byfayzullayev.itcourses.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseFile {
    private String name;
    private String url;
    private String type;
    private long size;
}
