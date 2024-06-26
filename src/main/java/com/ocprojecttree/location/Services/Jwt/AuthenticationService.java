package com.ocprojecttree.location.Services.Jwt;

import com.ocprojecttree.location.Models.Users.AuthenticationResponse;
import com.ocprojecttree.location.Models.Users.User;
import com.ocprojecttree.location.Models.Users.UserDto.LoginRequest;
import com.ocprojecttree.location.Models.Users.UserDto.RegisterRequest;
import com.ocprojecttree.location.Repository.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Configuration
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtServiceImp jwtService;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService(UserRepository repository, PasswordEncoder passwordEncoder, JwtServiceImp jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        Date date = new Date();
        user.setCreated_at(date);
        user.setUpdated_at(date);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user = repository.save(user);
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail() ,
                        request.getPassword()
                )
        );
        User user = repository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.generateToken(user);

        return  new AuthenticationResponse(token);
    }

    public Optional<User> loadUserByEmail(String email){
        return repository.findByEmail(email);
    }

    public List<User> loadAllUsers(){
        return repository.findAll();
    }
}
