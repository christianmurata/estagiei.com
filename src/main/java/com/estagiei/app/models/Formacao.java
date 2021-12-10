package com.estagiei.app.models;

import com.estagiei.app.enums.TipoExperiencia;
import com.estagiei.app.enums.TipoFormacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "formacoes")
public class Formacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String formacao;

    @Column(nullable = false)
    private String intituicao;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TipoFormacao tipoFormacao;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fim;

    @ManyToOne
    @JoinColumn(name="curriculo_id", nullable = false)
    private Curriculo curriculo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getIntituicao() {
        return intituicao;
    }

    public void setIntituicao(String intituicao) {
        this.intituicao = intituicao;
    }

    public TipoFormacao getTipoFormacao() {
        return tipoFormacao;
    }

    public void setTipoFormacao(TipoFormacao tipoFormacao) {
        this.tipoFormacao = tipoFormacao;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Curriculo getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }
}
