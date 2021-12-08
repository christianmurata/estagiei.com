package com.estagiei.app.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "niveis")
public class Nivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(nullable = false)
    private String descricao;

    @ManyToMany
    @JoinTable(
        name = "niveis_permissoes",
        joinColumns = @JoinColumn(name = "nivel_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "permissao_id", referencedColumnName = "id")
    )
    private Collection<Permissao> permissoes;

    public Nivel() {}

    public Nivel(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Collection<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
}
