package com.estagiei.app.forms;

import com.estagiei.app.enums.TipoExperiencia;
import com.estagiei.app.enums.TipoFormacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CurriculoForm {
    @NotEmpty(message = "")
    private String apresentacao;

    @NotEmpty(message = "")
    private String rua;

    @NotEmpty(message = "")
    private String numero;

    @NotEmpty(message = "")
    private String bairro;

    private String complemento;

    @NotEmpty(message = "")
    private String cidade;

    @NotEmpty(message = "")
    private String estado;

    @NotEmpty(message = "")
    private String cep;

    @NotEmpty(message = "")
    private String formacao;

    @NotEmpty(message = "")
    private String instituicao;

    @NotNull(message = "")
    private TipoFormacao tipoFormacao;

    @NotNull(message = "")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date formacaoInicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date formacaoFim;

    @NotEmpty(message = "")
    private String experiencia;

    @NotEmpty(message = "")
    private String empresa;

    @NotNull(message = "")
    private TipoExperiencia tipoExperiencia;

    @NotNull(message = "")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expInicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expFim;

    public String getApresentacao() {
        return apresentacao;
    }

    public void setApresentacao(String apresentacao) {
        this.apresentacao = apresentacao;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public TipoFormacao getTipoFormacao() {
        return tipoFormacao;
    }

    public void setTipoFormacao(TipoFormacao tipoFormacao) {
        this.tipoFormacao = tipoFormacao;
    }

    public Date getFormacaoInicio() {
        return formacaoInicio;
    }

    public void setFormacaoInicio(Date formacaoInicio) {
        this.formacaoInicio = formacaoInicio;
    }

    public Date getFormacaoFim() {
        return formacaoFim;
    }

    public void setFormacaoFim(Date formacaoFim) {
        this.formacaoFim = formacaoFim;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public TipoExperiencia getTipoExperiencia() {
        return tipoExperiencia;
    }

    public void setTipoExperiencia(TipoExperiencia tipoExperiencia) {
        this.tipoExperiencia = tipoExperiencia;
    }

    public Date getExpInicio() {
        return expInicio;
    }

    public void setExpInicio(Date expInicio) {
        this.expInicio = expInicio;
    }

    public Date getExpFim() {
        return expFim;
    }

    public void setExpFim(Date expFim) {
        this.expFim = expFim;
    }
}
