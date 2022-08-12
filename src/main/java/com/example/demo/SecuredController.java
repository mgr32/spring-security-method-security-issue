package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class SecuredController {

    @GetMapping(path = "/helloGuest")
    @RolesAllowed("GUEST")
    public String helloGuest() {
        return "GUEST";
    }

    @GetMapping(path = "/helloRoleGuest")
    @RolesAllowed("ROLE_GUEST")
    public String helloRoleGuest() {
        return "ROLE_GUEST";
    }


}
