package com.estagiei.app.repositories;

import com.estagiei.app.models.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    List<Vaga> findAllByEmpresaId(Long empresaId);
}