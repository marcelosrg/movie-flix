package io.github.marcelosrg.movieflix.controller;

import io.github.marcelosrg.movieflix.dtos.request.LoginRequest;
import io.github.marcelosrg.movieflix.dtos.request.UserRequest;
import io.github.marcelosrg.movieflix.dtos.response.LoginResponse;
import io.github.marcelosrg.movieflix.dtos.response.UserResponse;
import io.github.marcelosrg.movieflix.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest){
        UserResponse response = this.userService.register(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        LoginResponse response = this.userService.login(loginRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response.token());
    }

}
