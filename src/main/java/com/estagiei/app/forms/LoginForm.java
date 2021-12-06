package com.estagiei.app.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class LoginForm {
    @Email(message = "Email inválido")
    @NotEmpty(message = "O email não deve ser vazio")
    private String email;

    @NotEmpty(message = "A senha não deve ser vazia")
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
