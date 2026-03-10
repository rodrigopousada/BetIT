package com.betit.betit.services;

import com.betit.betit.model.ApostaEntity;
import com.betit.betit.model.PalpiteEntity;
import com.betit.betit.model.UsuarioEntity;
import com.betit.betit.repository.ApostaRepository;
import com.betit.betit.repository.PalpiteRepository;
import com.betit.betit.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.processing.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PalpiteService {

    @Autowired
    private PalpiteRepository palpiteRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ApostaRepository apostaRepository;

    @Transactional
    public PalpiteEntity criarPalpite(Long UsuarioId, Long ApostaId, BigDecimal valor) {

        UsuarioEntity usuario = usuarioRepository.findById(UsuarioId)
                .orElseThrow(()-> new RuntimeException("Usuario não encontrado"));

        if( usuario.getSaldoFicticio().compareTo(valor) < 0 ){
            throw new RuntimeException("Saldo insuficiente");

        }

        ApostaEntity aposta = apostaRepository.findById(ApostaId)
                .orElseThrow(()-> new RuntimeException("Aposta não encontrada"));

        usuario.setSaldoFicticio(usuario.getSaldoFicticio().subtract(valor));
            usuarioRepository.save(usuario);

            PalpiteEntity novoPalpite = new PalpiteEntity();
            novoPalpite.setUsuario(usuario);
            novoPalpite.setAposta(aposta);
            novoPalpite.setValor_apostado(valor);

            return palpiteRepository.save(novoPalpite);
    };
};
