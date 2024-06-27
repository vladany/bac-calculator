package com.bac.calculator.BAC.calculator.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    public String authenticateUser(String username, String password) {
        // Authentifizieren des Benutzers
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        // Setzen des Authentifizierungsobjekts im SecurityContext
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Laden der Benutzerinformationen
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

        // Optionale zusätzliche Logik, wie das Aufzeichnen des Logins oder das Generieren eines Tokens

        return "Login successful for user: " + userDetails.getUsername();
    }
}