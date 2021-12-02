package com.estagiei.app.controllers;

import com.estagiei.app.exceptions.NotFoundException;
import com.estagiei.app.models.Empresa;
import com.estagiei.app.models.Endereco;
import com.estagiei.app.repositories.EmpresaRepository;
import com.estagiei.app.repositories.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class EmpresaController {
    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    VagaRepository vagaRepository;

    @GetMapping("/empresas")
    public String index(){
        return "empresas";
    }

    @GetMapping("/empresas/{id}")
    public Empresa details(@PathVariable("id") Optional<Empresa> empresa) throws NotFoundException {
        if(empresa.isEmpty())
            throw new NotFoundException("Empresa não encontrada");

        return empresa.get();
    }

    @PostMapping("/empresas")
    public Empresa create(@Valid @RequestBody Empresa newEmpresa) {
        return empresaRepository.saveAndFlush(newEmpresa);
    }
}
