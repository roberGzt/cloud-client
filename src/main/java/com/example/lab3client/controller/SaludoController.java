package com.example.lab3client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @Value("${nombre}")
    String nombre;

    @GetMapping("/")
    public String mostrarSaludo() {
        return "Hola " + nombre;
    }
}
