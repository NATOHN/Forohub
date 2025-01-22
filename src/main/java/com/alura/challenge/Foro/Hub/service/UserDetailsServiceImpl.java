package com.alura.challenge.Foro.Hub.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Aquí se debería conectar con la base de datos para obtener el usuario
        // De momento, retornaremos un usuario estático para fines de prueba
        return User.builder()
                .username("admin")
                .password("{bcrypt}$2a$10$VdZRwlANw8ECdMBBxfTdz.5oGhVZ43CmzZaKMRhVmw.gFd.q03k7y") // Contraseña cifrada: "admin123"
                .roles("USER")
                .build();
    }

    public boolean isValidUser(String username, String password) {
        // Aquí puedes agregar una lógica de validación para verificar las credenciales.
        // Por ejemplo, verificar en la base de datos si el usuario existe y su contraseña es correcta.
        return "admin".equals(username) && "admin123".equals(password);
    }
}
