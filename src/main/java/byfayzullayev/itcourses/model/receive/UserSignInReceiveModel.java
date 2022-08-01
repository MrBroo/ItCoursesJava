package byfayzullayev.itcourses.model.receive;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserSignInReceiveModel {

    @JsonProperty("username")
    @NotEmpty(message = "username bo`sh bo`lishi kerakemas")
    private String username;

    @NotEmpty(message = "password bo`sh bo`lishi kerakemas")
    private String password;

}
