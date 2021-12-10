package com.estagiei.app.controllers.api;

import com.estagiei.app.exceptions.NotFoundException;
import com.estagiei.app.models.Empresa;
import com.estagiei.app.models.Seletivo;
import com.estagiei.app.models.Vaga;
import com.estagiei.app.repositories.SeletivoRepository;
import com.estagiei.app.repositories.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empresas")
public class VagaController {
    @Autowired
    VagaRepository vagaRepository;

    @Autowired
    SeletivoRepository seletivoRepository;

    @GetMapping("/{empresa}/vagas")
    public List<Vaga> index(@PathVariable("empresa") Optional<Empresa> empresa)
            throws NotFoundException {
        verifyEmpresa(empresa);

        return vagaRepository.findAllByEmpresaId(empresa.get().getId());
    }

    @GetMapping("/{empresa}/vagas/{id}")
    public Vaga detail(@PathVariable("empresa") Optional<Empresa> empresa,
                       @PathVariable("id") Optional <Vaga> vaga)
            throws NotFoundException {
        verifyEmpresa(empresa);
        verifyVaga(vaga);

        return vaga.get();
    }

    @PostMapping("/{empresa}/vagas")
    public Vaga create (@PathVariable("empresa") Optional<Empresa> empresa,
                        @RequestBody @Valid Vaga newVaga)
            throws NotFoundException {
        verifyEmpresa(empresa);

        newVaga.setEmpresa(empresa.get());

        Vaga vaga = vagaRepository.saveAndFlush(newVaga);
        Seletivo seletivo = seletivoRepository.saveAndFlush(new Seletivo(vaga));

        return vaga;
    }

    public void verifyEmpresa(Optional<Empresa> empresa) throws NotFoundException {
        if(empresa.isEmpty())
            throw new NotFoundException("Empresa não encontrada");
    }

    public void verifyVaga(Optional<Vaga> vaga) throws NotFoundException {
        if(vaga.isEmpty())
            throw new NotFoundException("Vaga não encontrada");
    }
}
