package com.example.login_service.controller;

import com.example.login_service.config.JwtService;
import com.example.login_service.dto.RegisterDTO;
import com.example.login_service.modules.User;
import com.example.login_service.response.AuthenticationResponse;
import com.example.login_service.responsitory.UserResponsitory;
import com.example.login_service.services.CustomUserDetailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserResponsitory userResponsitory;
//    private final UserService userService;
    private final JwtService jwtService;
    private final CustomUserDetailService userDetailService;

    @PostMapping(value = "/create-user", consumes = "application/json")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userResponsitory.save(user);
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"create\": \"ok\"}");
    }

    @PostMapping(value = "/login-user", consumes = "application/json")
    public ResponseEntity<String> LoginUser(String email,String password) {
//        System.out.println(email);
//        System.out.println(password);
        String jwt = "";
        if(email == null || password == null){
            return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"login\": \"error\"}");
        }else {
            var user = userResponsitory.findUserByEmail(email);
            if(user != null){
                if(user.get().getPassword().equalsIgnoreCase(password)){
                    var userDetail = userDetailService.loadUserByUsername(email);
                    jwt = jwtService.generateToken(userDetail);
                }

            }else {
                return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"login\": \"error\"}");
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"login\": \"" +jwt+ "\"}");


    }


}
