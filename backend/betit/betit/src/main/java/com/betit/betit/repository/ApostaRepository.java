package com.betit.betit.repository;
import com.betit.betit.model.ApostaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApostaRepository extends JpaRepository<ApostaEntity, Long> {
    List<ApostaEntity> findByGrupoId(Long grupoId);
}
