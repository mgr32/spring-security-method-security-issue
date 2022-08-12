package com.example.demo;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class SecuredController {

    @GetMapping(path = "/rolesAllowed_GUEST")
    @RolesAllowed("GUEST")
    public String rolesAllowed_GUEST() {
        return "GUEST";
    }

    @GetMapping(path = "/rolesAllowed_ROLE_GUEST")
    @RolesAllowed("ROLE_GUEST")
    public String rolesAllowed_ROLE_GUEST() {
        return "ROLE_GUEST";
    }

}
