package service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstudiantesApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstudiantesApplication.class, args);

        // mostrar mensaje de inicio
        System.out.println("=================================");
        System.out.println("Sistema de Estudiantes - UPANA");
        System.out.println("=================================");
        System.out.println("Servidor iniciado en: http://localhost:8080");
        System.out.println("");
        System.out.println("Endpoints disponibles:");
        System.out.println("  GET    /students          - Ver todos");
        System.out.println("  GET    /students/{id}     - Ver uno");
        System.out.println("  POST   /students          - Crear");
        System.out.println("  PUT    /students/{id}     - Actualizar todo");
        System.out.println("  PATCH  /students/{id}     - Actualizar parcial");
        System.out.println("  DELETE /students/{id}     - Eliminar");
        System.out.println("=================================");
    }
}