package byfayzullayev.itcourses.model.receive;

import byfayzullayev.itcourses.Entity.RoleEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserSignUpReceiveModel {


    @JsonProperty("fullName")
    @NotEmpty(message = "username bo`sh bo`lishi kerakemas")
    private String fullName;

    @JsonProperty("phone_number")
    @NotEmpty(message = "telefon raqam bo`sh bo`lishi kerakemas")
    private Long phoneNumber;

    @JsonProperty("username")
    @NotEmpty(message = "username bo`sh bo`lishi kerakemas")
    private String username;

    @NotEmpty(message = "password bo`sh bo`lishi kerakemas")
    private String password;

    @JsonProperty("user_role")
    private RoleEnum roleEnum;

}
