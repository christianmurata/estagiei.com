package com.estagiei.app.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "permissoes")
public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String permissao;

    @ManyToMany (mappedBy = "permissoes")
    private Collection<Nivel> niveis;

    public Permissao() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public Collection<Nivel> getNiveis() {
        return niveis;
    }

    public void setNiveis(Collection<Nivel> niveis) {
        this.niveis = niveis;
    }
}
