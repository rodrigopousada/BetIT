package com.betit.betit.controllers;

import com.betit.betit.model.PalpiteEntity;
import com.betit.betit.services.PalpiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/palpites")
public class PalpiteController {

    @Autowired
    private PalpiteService palpiteService;


    @PostMapping("/apostar")
    public ResponseEntity <PalpiteEntity> criarPalpite(@RequestParam Long usuarioId,
                                                      @RequestParam Long apostaId,
                                                     @RequestParam BigDecimal valor) {
        PalpiteEntity palpite = palpiteService
                .criarPalpite(usuarioId, apostaId, valor);
        return ResponseEntity.ok(palpite);
    }
}
