package com.betit.betit.repository;
import com.betit.betit.model.GrupoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GrupoRepository extends JpaRepository<GrupoEntity, Long> {
    Optional<GrupoEntity> findByNome(String nome);
}
