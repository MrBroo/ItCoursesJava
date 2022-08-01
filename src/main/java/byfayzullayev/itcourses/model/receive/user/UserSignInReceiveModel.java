package byfayzullayev.itcourses.model.receive.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSignInReceiveModel {

    @JsonProperty("username")
    @NotBlank(message = "username bo`sh bo`lishi kerakemas")
    private String username;


    @NotBlank(message = "password bo`sh bo`lishi kerakemas")
    private String password;

}
