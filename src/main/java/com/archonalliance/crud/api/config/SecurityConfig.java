package com.archonalliance.crud.api.config;

import com.archonalliance.crud.api.model.AuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable) //POST allowed if disabled
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/login").permitAll();
                    registry.requestMatchers("/admin/**", "/").hasRole("ADMIN");
                    registry.anyRequest().authenticated();
                })
                .formLogin(httpSecurityFormLoginConfigurer -> {
                    httpSecurityFormLoginConfigurer.loginPage("/login")
                            .successHandler(new AuthenticationSuccessHandler())
                            .permitAll()
                            .failureUrl("/login?error=true");
                })
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails adminUser1 = User.builder()
                .username("oscar.ramos")
                .password("$2a$10$AkyiqYExu82HG6Qecty1ue/surAAetjJcfjOJcasg7kfBvl5F8nQ2")
                .roles("ADMIN")
                .build();
        UserDetails adminUser2 = User.builder()
                .username("javier.quintana")
                .password("$2a$10$fGd8EaMsuhCXl0Bt/SLOceeX.m4hWE0xKzYbs89aoVHPUsWmWQDNy")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(adminUser1, adminUser2);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
