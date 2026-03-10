package com.betit.betit.controllers;

import com.betit.betit.model.ApostaEntity;
import com.betit.betit.repository.ApostaRepository;
import com.betit.betit.services.ApostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/apostas")
public class ApostaController {

    @Autowired
    private ApostaRepository apostaRepository;

    @Autowired
    private ApostaService apostaService;


    @GetMapping("/grupos/{grupoId}")
    public List<ApostaEntity> listarPorGrupo(@PathVariable Long grupoId) {
        return apostaService.listarPorGrupo(grupoId);
    }

    @GetMapping
    public List<ApostaEntity> listarApostas(){

        return apostaService.listarApostas();
    }

}
