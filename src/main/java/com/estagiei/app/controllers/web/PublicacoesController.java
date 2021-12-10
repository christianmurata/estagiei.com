package com.estagiei.app.controllers.web;

import com.estagiei.app.models.Usuario;
import com.estagiei.app.models.Vaga;
import com.estagiei.app.repositories.VagaRepository;
import com.estagiei.app.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/publicacoes")
public class PublicacoesController {
    @Autowired
    AuthService authService;

    @Autowired
    VagaRepository vagaRepository;

    @GetMapping("")
    public String publicacoes(Model model) {
        Usuario usuario = authService.userLoggedIn();
        List<Vaga> vagas = vagaRepository.findAllByEmpresaId(usuario.getEmpresa().getId());

        model.addAttribute("vagas", vagas);

        return "pages/publicacoes";
    }
}
