package com.estagiei.app.controllers.web;

import com.estagiei.app.models.Usuario;
import com.estagiei.app.repositories.UsuarioRepository;
import com.estagiei.app.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AuthService authService;

    @GetMapping("")
    String perfil(Model model) {
        Optional<Usuario> usuario = usuarioRepository.findById(authService.userLoggedIn().getId());

        model.addAttribute("usuarios", usuario.get());

        return "pages/perfil";
    }
}
