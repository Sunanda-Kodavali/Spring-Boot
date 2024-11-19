package com.example.f13_SpringSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.authorizeHttpRequests(authorize ->
                        authorize.requestMatchers("/secure").authenticated()

                                .requestMatchers("/admin").hasRole("ADMIN")
                                .anyRequest()
                                .permitAll())
                .formLogin(Customizer.withDefaults()).build();

    }


    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails sunanda = User.withDefaultPasswordEncoder().username("sunanda").password("sunanda").roles("ADMIN").build();
        UserDetails hari = User.withDefaultPasswordEncoder().username("hari").password("hari").roles("USER").build();

        return new InMemoryUserDetailsManager(sunanda, hari);
    }


}
