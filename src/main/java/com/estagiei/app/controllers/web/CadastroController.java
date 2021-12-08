package com.estagiei.app.controllers.web;

import com.estagiei.app.repositories.UsuarioRepository;
import com.estagiei.app.services.RestClientService;
import com.estagiei.app.forms.UsuarioForm;
import com.estagiei.app.models.Nivel;
import com.estagiei.app.models.Usuario;
import com.estagiei.app.validators.UsuarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {
    @Autowired
    RestClientService<Usuario> restClientService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("")
    public String cadastro(UsuarioForm usuarioForm) {
        return "pages/cadastro";
    }

    @GetMapping("/empresa")
    public String empresa() {
        return "pages/empresa";
    }

    @PostMapping("")
    public String usuario(@Valid UsuarioForm usuarioForm,
                          BindingResult bindingResult,
                          Model model) {
        if(bindingResult.hasErrors()) return "pages/cadastro";

        Nivel nivel = new Nivel((short) 1);
        String pass = new BCryptPasswordEncoder(10).encode(usuarioForm.getSenha());

        UsuarioValidator validator = UsuarioValidator.Builder.create()
                .withUsuarioForm(usuarioForm)
                .withBindingResult(bindingResult)
                .withUsuarioRepository(usuarioRepository)
                .build();

        if(!validator.cpfValidator()
               || !validator.emailValidator()
               || !validator.passwordsValidator())
            return "pages/cadastro";

        Usuario newUsuario = new Usuario();
        newUsuario.setCpf(usuarioForm.getCpf());
        newUsuario.setNome(usuarioForm.getNome());
        newUsuario.setEmail(usuarioForm.getEmail());
        newUsuario.setSenha(pass);
        newUsuario.setNivel(nivel);

        Usuario usuarioResponse = restClientService.api()
                .uri("/usuarios")
                .model(Usuario.class)
                .postRequest(newUsuario);

        return "redirect:/dashboard";
    }
}