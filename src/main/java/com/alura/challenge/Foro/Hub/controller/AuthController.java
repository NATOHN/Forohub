package com.alura.challenge.Foro.Hub.controller;

import com.alura.challenge.Foro.Hub.config.TokenService;
import com.alura.challenge.Foro.Hub.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        // Verificar las credenciales del usuario (esto debe hacerse en UserDetailsServiceImpl)
        if (userDetailsService.isValidUser(username, password)) {
            String token = tokenService.generateToken(username);  // Generar el token
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
