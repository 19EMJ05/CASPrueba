
package com.aplicacion.WebAplicacion.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class ConfSeguridad{
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
        System.out.println("erooldasdasdasdsa");
        return http
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/VerInventario").permitAll()
                        .requestMatchers("/IngresarProductos").permitAll()
                        .requestMatchers("/SalidaProductos/").permitAll()
                        .requestMatchers("/AltaProductos").permitAll()
                        .requestMatchers("/BajaProductos").permitAll()
                        .requestMatchers("/AumetarP").permitAll()
                        .requestMatchers("/DisminuirP").permitAll()
                        .requestMatchers("/SacarInventario").permitAll()
                        .requestMatchers("/Historico").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form->form.defaultSuccessUrl("/",true)
                ).logout(config->config.logoutSuccessUrl("/")).build();
    }
    
}


