package com.example.demo.security.config;

import com.example.demo.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * This class was meant to extend WebSecurityConfigurerAdapter, but it was replaced by SecurityFilterChain
 * Any request that goes through the endpoint must permit everything
 * ANy other request need to be authenticated
 * Redirect user to the Spring Built-in Login Form
 *
 * @link https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html
 *
 */
@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {

    private final AppUserService appUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((request) -> {
                    try {
                        request.requestMatchers("/api/v*/registration/**").permitAll() // not considered
                                .anyRequest()
                                .authenticated()
                                .and()
                                .formLogin();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                })
                .authenticationProvider(authenticationProvider());
        return http.build();
    }

    /**
     * Method processes the Authentication request for the @authenticationProvider
     * @object DaoAuthenticationProvider fetches the user details (username)
     * @return an authenticated object to the successful authentication
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(appUserService);
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        return provider;
    }
}
