package com.estagiei.app.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "curriculos")
public class Curriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String apresentacao;

    @OneToOne(mappedBy = "curriculo")
    private Usuario usuario;

    @OneToMany(
            mappedBy = "curriculo",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    Set<Formacao> formacoes;

    @OneToMany(
            mappedBy = "curriculo",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    Set<Experiencia> experiencias;

    public Curriculo() {}

    public Curriculo(String apresentacao) {
        this.apresentacao = apresentacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApresentacao() {
        return apresentacao;
    }

    public void setApresentacao(String apresentacao) {
        this.apresentacao = apresentacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Formacao> getFormacoes() {
        return formacoes;
    }

    public void setFormacoes(Set<Formacao> formacoes) {
        this.formacoes = formacoes;
    }

    public Set<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(Set<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }
}
