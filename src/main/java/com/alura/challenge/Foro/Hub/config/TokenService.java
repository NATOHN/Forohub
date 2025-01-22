package com.alura.challenge.Foro.Hub.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class TokenService {

    // Definimos la clave secreta en formato de `SecretKey` generada correctamente
    private static final String SECRET_KEY_STRING = "cambiarEstaClaveSecretaPorAlgoMasSeguro123456"; // Debe ser de al menos 256 bits.
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());

    private static final long EXPIRATION_TIME = 86400000; // Tiempo de expiración: 1 día en milisegundos

    /**
     * Genera un token JWT a partir del nombre de usuario proporcionado.
     *
     * @param username El nombre de usuario para el que se generará el token.
     * @return El token JWT generado.
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)  // El "subject" es el nombre de usuario
                .setIssuedAt(new Date()) // La fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Fecha de expiración
                .signWith(SECRET_KEY)  // Firma el token con la clave secreta
                .compact();  // Genera el token JWT como cadena compacta
    }

    /**
     * Valida si el token JWT proporcionado es válido.
     *
     * @param token El token JWT a validar.
     * @return `true` si es válido, `false` en caso contrario.
     */
    public boolean isTokenValid(String token) {
        try {
            JwtParser parser = Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY) // Establece la clave secreta para validar la firma
                    .build();

            parser.parseClaimsJws(token); // Si no lanza excepción, el token es válido
            return true;
        } catch (SignatureException e) {
            System.err.println("Error: La firma del token es inválida."); // Control de firmas inválidas
        } catch (Exception e) {
            System.err.println("Error: El token no es válido: " + e.getMessage()); // Otras excepciones al validar
        }
        return false; // Si ocurre cualquier excepción, no es válido
    }

    /**
     * Extrae el nombre de usuario del token JWT proporcionado.
     *
     * @param token El token JWT del que se extraerá el nombre de usuario.
     * @return El nombre de usuario contenido en el token.
     */
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // Usa la misma clave para validar la firma
                .build()
                .parseClaimsJws(token) // Extrae las "claims" del token
                .getBody()
                .getSubject();  // Obtiene el "subject", que contiene el nombre de usuario
    }
}