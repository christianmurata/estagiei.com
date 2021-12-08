package com.estagiei.app.validators;

import com.estagiei.app.forms.UsuarioForm;
import com.estagiei.app.models.Usuario;
import com.estagiei.app.repositories.UsuarioRepository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Optional;

public class UsuarioValidator {
    private UsuarioForm usuarioForm;
    private BindingResult bindingResult;
    private UsuarioRepository usuarioRepository;

    public boolean passwordsValidator() {
        if(!usuarioForm.getSenha().equals(usuarioForm.getConfirma_senha())) {
            bindingResult.addError(new FieldError(
                    "usuarioForm",
                    "senha",
                    null,
                    false,
                    null,
                    null,
                    "As senhas não conferem"
            ));

            bindingResult.addError(new FieldError(
                    "usuarioForm",
                    "confirma_senha",
                    null,
                    false,
                    null,
                    null,
                    "As senhas não conferem"
            ));

            return false;
        }

        return true;
    }

    public boolean emailValidator() {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioForm.getEmail());

        if(usuario.isPresent()) {
            bindingResult.addError(new FieldError(
                    "usuarioForm",
                    "email",
                    usuarioForm.getEmail(),
                    false,
                    null,
                    null,
                    "Este email já foi utilizado por outro usuário"
            ));

            return false;
        }

        return true;
    }

    public boolean cpfValidator() {
        Optional<Usuario> usuario = usuarioRepository.findByCpf(usuarioForm.getCpf());

        if(usuario.isPresent()) {
            bindingResult.addError(new FieldError(
                "usuarioForm",
                "cpf",
                null,
                false,
                null,
                null,
                "Este CPF já foi utilizado por outro usuário"
            ));

            return false;
        }

        return true;
    }

    public static final class Builder {
        private UsuarioForm usuarioForm;
        private BindingResult bindingResult;
        private UsuarioRepository usuarioRepository;

        private Builder() {}

        public static Builder create() {
            return new Builder();
        }

        public Builder withUsuarioForm(UsuarioForm usuarioForm) {
            this.usuarioForm = usuarioForm;
            return this;
        }

        public Builder withBindingResult(BindingResult bindingResult) {
            this.bindingResult = bindingResult;
            return this;
        }

        public Builder withUsuarioRepository(UsuarioRepository usuarioRepository) {
            this.usuarioRepository = usuarioRepository;
            return this;
        }

        public UsuarioValidator build() {
            UsuarioValidator usuarioValidator = new UsuarioValidator();
            usuarioValidator.bindingResult = this.bindingResult;
            usuarioValidator.usuarioForm = this.usuarioForm;
            usuarioValidator.usuarioRepository = this.usuarioRepository;
            return usuarioValidator;
        }
    }
}
