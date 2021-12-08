package com.estagiei.app.controllers.web;

import com.estagiei.app.forms.LoginForm;
import com.estagiei.app.models.Usuario;
import com.estagiei.app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.expression.Fields;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("")
    public String login(LoginForm loginForm) {
        return "pages/login";
    }

    @PostMapping("")
    public String auth(@Valid LoginForm loginForm,
                       BindingResult bindingResult,
                       Model model) {
        if(bindingResult.hasErrors()) return "pages/login";

        Optional<Usuario> usuario = usuarioRepository.findByEmail(loginForm.getEmail());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

        if(usuario.isEmpty()) {
            bindingResult.addError(new FieldError(
                    "loginForm",
                    "email",
                    loginForm.getEmail(),
                    false,
                    null,
                    null,
                    "Email não encontrado"
            ));

            return "pages/login";
        }

        if(!encoder.matches(loginForm.getSenha(), usuario.get().getSenha())) {
            bindingResult.addError(new FieldError(
                    "loginForm",
                    "senha",
                    loginForm.getSenha(),
                    false,
                    null,
                    null,
                    "Senha incorreta"
            ));

            return "pages/login";
        }

        return "redirect:/dashboard";
    }
}