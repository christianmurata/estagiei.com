package com.estagiei.app.repositories;

import com.estagiei.app.models.Formacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormacaoRepository extends JpaRepository<Formacao, Long> {
}