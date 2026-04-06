package dev.anuradha.financeapp.config;

import dev.anuradha.financeapp.security.RoleFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableMethodSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        // User endpoints
                        .requestMatchers(HttpMethod.POST,  "/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,   "/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/users/{id}").hasRole("ADMIN")

                        // Financial Record endpoints
                        .requestMatchers(HttpMethod.POST,   "/records").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,    "/records").hasAnyRole("ADMIN", "ANALYST", "VIEWER")
                        .requestMatchers(HttpMethod.PUT,    "/records/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/records/{id}").hasRole("ADMIN")

                        // Dashboard endpoints
                        .requestMatchers(HttpMethod.GET, "/dashboard/summary").hasAnyRole("ADMIN", "ANALYST")

                        .anyRequest().authenticated()
                )
                .addFilterBefore(new RoleFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
