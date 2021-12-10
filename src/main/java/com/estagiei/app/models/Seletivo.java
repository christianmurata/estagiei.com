package com.estagiei.app.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "seletivos")
public class Seletivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "vaga_id", referencedColumnName = "id")
    private Vaga vaga;

    @ManyToMany(mappedBy = "seletivos", fetch = FetchType.EAGER)
    private Set<Usuario> usuarios;

    public Seletivo() {}

    public Seletivo(Vaga vaga) {
        this.vaga = vaga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
