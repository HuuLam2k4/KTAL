package com.poly.websitegaminggear;

import com.poly.websitegaminggear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class AuthConfig {
//    @Autowired
//    private UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailManager() {
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        User user = null;
//        userDetailsManager.createUser(
//                User.builder()
//                        .username(user.getUsername())
//                        .password(bCryptPasswordEncoder().encode(user.getPassword()))
//                        .roles("USER")
//                        .build()
//        );
//        userDetailsManager.createUser(
//                User.builder()
//                        .username(user.getUsername())
//                        .password(bCryptPasswordEncoder().encode(user.getPassword()))
//                        .roles("ADMIN")
//                        .build()
//        );
//        userDetailsManager.createUser(
//                User.builder()
//                        .username(user.getUsername())
//                        .password(bCryptPasswordEncoder().encode(user.getPassword()))
//                        .roles("GUEST")
//                        .build()
//        );
//        return userDetailsManager;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(c -> c.disable())
                .cors(c -> c.disable())
                .authorizeHttpRequests(r -> r
                        .anyRequest().permitAll()
                )
                .exceptionHandling(e ->
                        e.accessDeniedPage("/auth/access/denied")
                )
                .formLogin(f ->
                        f
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/user/index", true)
                                .failureForwardUrl("/login/failed")
                                .usernameParameter("username")
                                .passwordParameter("password")
                ).rememberMe(r ->
                        r.rememberMeParameter("remember")
                )
//                .logout(l ->
//                        l
//                                .logoutUrl("auth/logout")
//                                .logoutSuccessUrl("auth/logoff/success")
//                )
                .build();
    }
}
