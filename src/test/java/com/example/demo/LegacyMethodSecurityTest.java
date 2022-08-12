package com.example.demo;

import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("legacyMethodSecurity")
class LegacyMethodSecurityTest extends AbstractMethodSecurityTest {
}
