package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class CommonSecurityConfiguration {

    public static final UserDetails USER_GUEST = User.builder().username("guest").password("{noop}guest").roles("GUEST").build();

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(USER_GUEST);
    }
}
