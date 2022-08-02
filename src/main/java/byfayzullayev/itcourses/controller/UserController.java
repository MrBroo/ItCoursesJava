package byfayzullayev.itcourses.controller;

import byfayzullayev.itcourses.model.receive.user.UserSignUpReceiveModel;
import byfayzullayev.itcourses.model.receive.user.UserSignInReceiveModel;
import byfayzullayev.itcourses.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/itCourses/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping("/add")
    public HttpEntity<?> addUser(@Valid @RequestBody UserSignUpReceiveModel userSignUpReceiveModel) {
        return ResponseEntity.ok(userService.addUser(userSignUpReceiveModel));
    }

    @CrossOrigin
    @PostMapping("/login")
    public HttpEntity<?> login(@Valid @RequestBody UserSignInReceiveModel userSignInReceiveModel) {
        return ResponseEntity.ok(userService.login(userSignInReceiveModel));
    }
}
