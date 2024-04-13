package com.ocprojecttree.location.Controllers.Users;

import com.ocprojecttree.location.Models.Users.AuthenticationResponse;
import com.ocprojecttree.location.Models.Users.User;
import com.ocprojecttree.location.Models.Users.UserDto.LoginRequest;
import com.ocprojecttree.location.Models.Users.UserDto.RegisterRequest;
import com.ocprojecttree.location.Services.Jwt.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/auth")
@Tag(name = "auth")
public class UserController {
    private final AuthenticationService authService;

    public UserController(AuthenticationService authService) {
        this.authService = authService;
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/me")
    public ResponseEntity<List<User>> me(){
        return ResponseEntity.ok(authService.loadAllUsers());
    }
    @Operation(
            description = "Get endpoint for user register",
            summary = "Création d'un compte utilisateur ",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @Operation(
            description = "Get endpoint for user login",
            summary = "Connexion au compte utilisateur ",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @PostMapping("/login")
    public  ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
