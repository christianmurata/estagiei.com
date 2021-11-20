package com.estagiei.app.controllers;

import com.estagiei.app.models.Usuario;
import com.estagiei.app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String index() {
        return "usuarios";
    }

    @PostMapping("/usuarios")
    public Usuario create(@Valid @RequestBody Usuario newUsuario) throws ResponseStatusException {
        return usuarioRepository.save(newUsuario);
    }
}
