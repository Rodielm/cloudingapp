package es.uv.twcam.cloudingreactive.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * SecurityConfiguration
 */

@Configuration
@EnableReactiveMethodSecurity
@EnableWebFlux
public class SecurityConfiguration {

    
}