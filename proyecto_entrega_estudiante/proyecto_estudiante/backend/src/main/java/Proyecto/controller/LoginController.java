package Proyecto.controller;

import Proyecto.dto.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class LoginController {

    // usuario y contraseña "quemados" para el proyecto
    private static final String USUARIO_VALIDO = "admin";
    private static final String PASSWORD_VALIDA = "1234";

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        if (request.getUsuario() == null || request.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Usuario y contraseña son obligatorios"));
        }

        if (USUARIO_VALIDO.equals(request.getUsuario())
                && PASSWORD_VALIDA.equals(request.getPassword())) {

            // para algo más real se usaría JWT o sesión, pero aquí solo devolvemos OK
            return ResponseEntity.ok(Map.of("mensaje", "Login correcto"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Credenciales incorrectas"));
        }
    }
}
