package com.example.lab3client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SaludoController {

    @Value("${nombre:Hello default}")
    String nombre;
    @Value("${lema:Hello default}")
    String lema;

    @GetMapping("/")
    public String mostrarSaludo() {
        return "Hola " + nombre + ", " + lema;
    }
}
