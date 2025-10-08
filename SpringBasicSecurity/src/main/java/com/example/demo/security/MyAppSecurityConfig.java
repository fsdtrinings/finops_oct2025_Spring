package com.example.demo.security;

import java.beans.BeanProperty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyAppSecurityConfig {

	
   @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll()
                .requestMatchers("/admin/**").hasRole("admin")
                .requestMatchers("/employee/**").hasRole("employee")
                .requestMatchers("/hr/**").hasRole("hr")
                .anyRequest().authenticated()
            )
            .httpBasic(httpBasic -> {}); // enable basic authentication
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) 
    {
        UserDetails mike = User.withUsername("mike")
                .password("a")
                .roles("admin", "employee")
                .build();

        UserDetails jenny = User.withUsername("jenny")
                .password("a")
                .roles("admin")
                .build();

        UserDetails neha = User.withUsername("neha")
                .password("a")
                .roles("employee")
                .build();
        
        UserDetails ramesh = User.withUsername("ramesh")
                .password("a")
                .roles("hr")
                .build();
        
        UserDetails amit = User.withUsername("amit")
                .password("a")
                .roles("account")
                .build();
        

        return new InMemoryUserDetailsManager(mike, jenny, neha, ramesh , amit);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    
    	//return new BCryptPasswordEncoder();
    }
}//end class






/*  NoOps , MD5
 * Bcrypt 
 * -->> 
 * 
 * */




