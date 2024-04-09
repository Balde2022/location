package com.ocprojecttree.location.Controllers.Users;

import com.ocprojecttree.location.Models.Users.AuthenticationResponse;
import com.ocprojecttree.location.Models.Users.User;
import com.ocprojecttree.location.Services.Jwt.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/auth")
public class UserController {
    private final AuthenticationService authService;

    public UserController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody User request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public  ResponseEntity<AuthenticationResponse> login(@RequestBody User request){
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @GetMapping("/me")
    public ResponseEntity<List<User>> me(){
        return ResponseEntity.ok(authService.loadAllUsers());
    }

    @GetMapping("/meByEmail")
    public  ResponseEntity<Optional<User>> me(String email){
        return ResponseEntity.ok(authService.loadUserByEmail(email));
    }

    @GetMapping(path = "/test")
    public String demo(){
        return "Bonjour";
    }

}
