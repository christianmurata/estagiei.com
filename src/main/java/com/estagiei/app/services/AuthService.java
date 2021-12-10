package com.estagiei.app.services;

import com.estagiei.app.models.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class AuthService {
    Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private AuthenticationManager authManager;

    public void createSession(HttpServletRequest request, String email, String senha) {
        UsernamePasswordAuthenticationToken authReq =
                new UsernamePasswordAuthenticationToken(email, senha);

        Authentication auth = authManager.authenticate(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();
        HttpSession session = request.getSession(true);

        sc.setAuthentication(auth);
        session.setAttribute("SPRING_SECURITY_CONTEXT", sc);

        logger.info("Session criada para o usuario: " + email);
    }

    public Usuario userLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return (Usuario) authentication.getPrincipal();
    }
}
