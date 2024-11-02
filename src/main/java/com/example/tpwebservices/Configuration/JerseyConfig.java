package com.example.tpwebservices.Configuration;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
@Primary
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("com.example.Service.CompteRestJaxApi");
    }
}
