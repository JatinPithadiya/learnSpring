package com.learn.rest.webservices.restful_web_services.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        //All request should be authenticated
        http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
        
        //if a request is not authonticated a web page is shown
        http.httpBasic(withDefaults());

        //csrf disable
        http.csrf().disable();

        return http.build();
    }
}
