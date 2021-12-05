package com.estagiei.app.controllers.api;

import com.estagiei.app.models.Usuario;
import com.estagiei.app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("")
    public String index() {
        return "usuarios";
    }

    @PostMapping("")
    public Usuario create(@Valid @RequestBody Usuario newUsuario) throws ResponseStatusException {
        return usuarioRepository.save(newUsuario);
    }
}
