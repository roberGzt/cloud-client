package com.example.lab3client.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NombresEquiposController {

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/")
    public String mostrarSaludo() {
        return obtenerString("LAB-4-NOMBRES-API") + ", " + obtenerString("LAB-4-LEMAS-API");
    }

    private String obtenerString(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0) {
            URI uri = list.get(0).getUri();
            if (uri != null) {
                return (new RestTemplate()).getForObject(uri, String.class);
            }
        }
        return null;
    }
}
