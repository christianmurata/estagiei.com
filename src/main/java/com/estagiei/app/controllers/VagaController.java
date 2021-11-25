package com.estagiei.app.controllers;

import com.estagiei.app.exceptions.NotFoundException;
import com.estagiei.app.models.Empresa;
import com.estagiei.app.models.Vaga;
import com.estagiei.app.repositories.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class VagaController {
    @Autowired
    VagaRepository vagaRepository;

    @GetMapping("/empresas/{empresa}/vagas")
    public List<Vaga> index(@PathVariable("empresa") Optional<Empresa> empresa)
            throws NotFoundException {
        if(empresa.isEmpty())
            throw new NotFoundException("Empresa não encontrada");

        return vagaRepository.findAllByEmpresaId(empresa.get().getId());
    }

    @PostMapping("/empresas/{empresa}/vagas")
    public Vaga create (@PathVariable("empresa") Optional<Empresa> empresa,
                        @RequestBody @Valid Vaga newVaga)
            throws NotFoundException {
        if(empresa.isEmpty())
            throw new NotFoundException("Empresa não encontrada");

        newVaga.setEmpresa(empresa.get());

        return vagaRepository.save(newVaga);
    }
}
