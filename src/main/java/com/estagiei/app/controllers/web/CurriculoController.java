package com.estagiei.app.controllers.web;

import com.estagiei.app.forms.CurriculoForm;
import com.estagiei.app.models.*;
import com.estagiei.app.repositories.*;
import com.estagiei.app.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/curriculo")
public class CurriculoController {
    @Autowired
    AuthService authService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CurriculoRepository curriculoRepository;

    @Autowired
    FormacaoRepository formacaoRepository;

    @Autowired
    ExperienciaRepository experienciaRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping("")
    public String curriculo(CurriculoForm curriculoForm) {
        return "pages/curriculo";
    }

    @PostMapping("")
    public String salvar(@Valid CurriculoForm curriculoForm,
                         BindingResult bindingResult,
                         HttpServletRequest request) {
        if(bindingResult.hasErrors()) return "pages/curriculo";

        Usuario usuario = authService.userLoggedIn();
        Curriculo curriculo = curriculoRepository.save(new Curriculo(
                curriculoForm.getApresentacao()
        ));

        // add formacao
        Formacao formacao = new Formacao();
        formacao.setFormacao(curriculoForm.getFormacao());
        formacao.setInicio(curriculoForm.getFormacaoInicio());
        formacao.setTipoFormacao(curriculoForm.getTipoFormacao());
        formacao.setFim(curriculoForm.getFormacaoFim());
        formacao.setIntituicao(curriculoForm.getInstituicao());
        formacao.setCurriculo(curriculo);

        formacaoRepository.save(formacao);

        // add experiencia
        Experiencia experiencia = new Experiencia();
        experiencia.setExperiencia(curriculoForm.getExperiencia());
        experiencia.setTipoExperiencia(curriculoForm.getTipoExperiencia());
        experiencia.setEmpresa(curriculoForm.getEmpresa());
        experiencia.setInicio(curriculoForm.getExpInicio());
        experiencia.setFim(curriculoForm.getExpFim());
        experiencia.setCurriculo(curriculo);

        experienciaRepository.save(experiencia);

        // add endereco
        Endereco endereco = new Endereco();
        endereco.setBairro(curriculoForm.getBairro());
        endereco.setCep(curriculoForm.getCep());
        endereco.setCidade(curriculoForm.getCidade());
        endereco.setComplemento(curriculoForm.getComplemento());
        endereco.setNumero(curriculoForm.getNumero());
        endereco.setEstado(curriculoForm.getEstado());
        endereco.setRua(curriculoForm.getRua());

        // add os dados ao usuario
        usuario.setEndereco(enderecoRepository.save(endereco));
        usuario.setCurriculo(curriculo);

        usuarioRepository.save(usuario);

        return "redirect:/perfil?sucesso";
    }
}
