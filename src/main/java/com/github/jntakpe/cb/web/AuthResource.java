package com.github.jntakpe.cb.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Exposition de la ressource relative à l'authentification d'un utilisateur
 *
 * @author jntakpe
 */
@RestController
@RequestMapping("/auth")
public class AuthResource {

    @RequestMapping(method = RequestMethod.GET)
    public Authentication currentAuth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
