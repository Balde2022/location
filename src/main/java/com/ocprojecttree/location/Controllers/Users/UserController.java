package com.ocprojecttree.location.Controllers.Users;

import com.ocprojecttree.location.Models.Users.AuthenticationResponse;
import com.ocprojecttree.location.Models.Users.User;
import com.ocprojecttree.location.Services.Jwt.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
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
}
