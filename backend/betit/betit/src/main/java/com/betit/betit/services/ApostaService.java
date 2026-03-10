package com.betit.betit.services;

import com.betit.betit.model.ApostaEntity;
import com.betit.betit.model.GrupoEntity;
import com.betit.betit.repository.ApostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ApostaService {

    @Autowired
    private ApostaRepository apostaRepository;

    public ApostaEntity criarAposta(GrupoEntity grupo, String descricao, BigDecimal odds) {
        ApostaEntity aposta = new ApostaEntity();
        aposta.setDescricao(descricao);
        aposta.setGrupo(grupo);
        aposta.setOddsSim(odds);
        aposta.setStatus("ABERTA");
        return apostaRepository.save(aposta);
    }

    public List<ApostaEntity> listarPorGrupo(Long grupoId) {
        return apostaRepository.findByGrupoId(grupoId);
    }

    public ApostaEntity encerrarAposta(Long id){
        ApostaEntity aposta = apostaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aposta não encontrada"));
        aposta.setStatus("ENCERRADA");
        return apostaRepository.save(aposta);
    }

    public List<ApostaEntity> listarApostas(){
        return apostaRepository.findAll();
    }
}
