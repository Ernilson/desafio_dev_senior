package br.com.unifor.config;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext req, ContainerResponseContext res) throws IOException {
        // Ajuste a origem se quiser restringir (p.ex.: http://localhost:4200)
        res.getHeaders().putSingle("Access-Control-Allow-Origin", "http://localhost:4200");
        res.getHeaders().putSingle("Access-Control-Allow-Credentials", "true");
        res.getHeaders().putSingle("Vary", "Origin"); // evita cache incorreto de CORS
        res.getHeaders().putSingle(
                "Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization, x-requested-with");
        res.getHeaders().putSingle(
                "Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD, PATCH");
        // Se desejar expor cabeçalhos
        res.getHeaders().putSingle("Access-Control-Expose-Headers", "Content-Disposition, Location");
    }
}


