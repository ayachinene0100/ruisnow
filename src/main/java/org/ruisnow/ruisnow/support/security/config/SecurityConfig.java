package org.ruisnow.ruisnow.support.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 为简单起见，先关闭CSRF保护
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize.requestMatchers("/portal/**").authenticated())
            .formLogin(form ->
                form.successHandler(new LoginSuccessHandler())
                    .failureHandler(new LoginFailureHandler())
                    .permitAll());
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/signUp");
    }
}
