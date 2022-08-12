package com.example.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Profile("newMethodSecurity")
@EnableMethodSecurity(jsr250Enabled = true)
public class NewMethodSecurityConfiguration {
}
