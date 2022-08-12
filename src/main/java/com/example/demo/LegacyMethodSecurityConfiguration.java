package com.example.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Profile("legacyMethodSecurity")
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class LegacyMethodSecurityConfiguration {
}
