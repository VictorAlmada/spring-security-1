package com.victor.spring_security_1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	// 1. Define dois usuários em memória
	@Bean
	InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {
		UserDetails user = User.builder().username("user").password(encoder.encode("123456")).roles("USER").build();

		UserDetails admin = User.builder().username("admin").password(encoder.encode("admin123")).roles("ADMIN").build();

		return new InMemoryUserDetailsManager(user, admin);
	}

	// 2. Configura a autenticação e autorização
	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // desativa proteção CSRF (só para facilitar teste via Postman)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN") // apenas ADMIN
                .requestMatchers("/user/**").hasRole("USER") // apenas USER
                .requestMatchers("/dashboard", "/home", "/login").authenticated() // ambos podem acessar
                .anyRequest().denyAll() // bloqueia qualquer outra rota não configurada
            )
            
            .headers(headers -> headers.frameOptions().disable()) // necessário para o H2 funcionar em iframe
//            .httpBasic(Customizer.withDefaults());
            .formLogin(form -> form.loginPage("/login").permitAll()) // nossa rota customizada
            .logout(logout -> logout.logoutSuccessUrl("/login?logout"));

        return http.build();
    }

	// 3. Define o encoder de senha (BCrypt)
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
