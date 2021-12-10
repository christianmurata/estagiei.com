package com.estagiei.app.controllers.web;

import com.estagiei.app.models.Seletivo;
import com.estagiei.app.models.Usuario;
import com.estagiei.app.models.Vaga;
import com.estagiei.app.repositories.SeletivoRepository;
import com.estagiei.app.repositories.UsuarioRepository;
import com.estagiei.app.repositories.VagaRepository;
import com.estagiei.app.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class VagasController {
    @Autowired
    AuthService authService;

    @Autowired
    VagaRepository vagaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/vagas")
    public String vagas(Model model) {
        model.addAttribute("vagas", vagaRepository.findAll());

        return "pages/vagas";
    }

    @GetMapping("/vagas/{id}")
    public String detalhe(@PathVariable("id") Optional<Vaga> vaga, Model model) {
        if(vaga.isEmpty())
            return "redirect:/vagas";

        model.addAttribute("vagas", vaga.get());

        return "pages/detalhes";
    }

    @PostMapping("/vagas/{id}")
    public String cadidatar(@PathVariable("id") Optional<Vaga> vaga, Model model) {
        if(vaga.isEmpty())
            return "redirect:/vagas";

        Vaga vagaSelected = vaga.get();
        Usuario usuario = authService.userLoggedIn();
        Seletivo seletivo = vagaSelected.getSeletivo();

        usuario.getSeletivos().add(seletivo);
        usuarioRepository.save(usuario);

        return "redirect:/vagas?sucesso";
    }
}