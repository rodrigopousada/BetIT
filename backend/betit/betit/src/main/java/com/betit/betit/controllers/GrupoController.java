package com.betit.betit.controllers;

import com.betit.betit.model.GrupoEntity;
import com.betit.betit.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping
    public List<GrupoEntity> listarGrupos(){
        return grupoService.buscarTodos();
    }

    @PostMapping
    public ResponseEntity<GrupoEntity> criarGrupo(@RequestBody GrupoEntity grupo){
        return ResponseEntity.ok(grupoService.criarGrupo(grupo.getNome(),grupo.getAdmin()));
    }
}
