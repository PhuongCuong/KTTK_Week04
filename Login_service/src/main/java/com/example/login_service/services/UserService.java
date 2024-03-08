//package com.example.login_service.services;
//
//import com.example.login_service.config.JwtService;
//import com.example.login_service.dto.RegisterDTO;
//import com.example.login_service.modules.User;
//import com.example.login_service.response.AuthenticationResponse;
//import com.example.login_service.responsitory.UserResponsitory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//
//    private final UserResponsitory userResponsitory;
//    private final JwtService jwtService;
//
//    @PostMapping(value = "/create-user", consumes = "application/json")
//    public ResponseEntity<String> createUser(@RequestBody User user) {
//        userResponsitoryRedis.save(user);
//        return ResponseEntity.status(HttpStatus.OK).body("{\"status\": 200, \"create\": \"ok\"}");
//    }
//
//}
