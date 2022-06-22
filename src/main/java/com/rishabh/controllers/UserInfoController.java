package com.rishabh.controllers;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@EnableResourceServer
public class UserInfoController {

    @RolesAllowed({"ROLE_ADMINs"})
    @GetMapping ("/userInfoContext")
    public Map<String, Object> extractPrincipal(Principal principal) {
        OAuth2Authentication auth2Authentication = (OAuth2Authentication) principal;
        return new HashMap<>() {{
            put("user", auth2Authentication.getName());
            put("roles", auth2Authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        }};
    }
}
