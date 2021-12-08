package com.estagiei.app.forms;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UsuarioForm {
    @NotEmpty(message = "O nome não deve ser vazio")
    private String nome;

    @CPF(message = "CPF inválido")
    private String cpf;

    @Email(message = "Email inválido")
    @NotEmpty(message = "O email não deve ser vazio")
    private String email;

    @NotEmpty(message = "A senha não deve ser vazia")
    private String senha;

    @NotEmpty(message = "A confirmação de senha não deve ser vazia")
    private String confirma_senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

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

    public String getConfirma_senha() {
        return confirma_senha;
    }

    public void setConfirma_senha(String confirma_senha) {
        this.confirma_senha = confirma_senha;
    }
}
