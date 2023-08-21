package org.ruisnow.ruisnow.support.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 为简单起见，先关闭CSRF保护
            .csrf(csrf -> csrf.ignoringRequestMatchers("/**"))
            .securityMatcher("/portal/**")
            .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
            .formLogin(form ->
                form
                    .successHandler(new LoginSuccessHandler())
                    .failureHandler(new LoginFailureHandler())
                    .loginPage("/loginHint"));
        return http.build();
    }
}
