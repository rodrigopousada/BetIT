package com.betit.betit.controllers;

import com.betit.betit.model.UsuarioEntity;
import com.betit.betit.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioEntity> cadastrarUsuario(@RequestBody UsuarioEntity usuario){
        return ResponseEntity.ok(usuarioService.cadastrarUsuario(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> buscarUsuarioPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioEntity>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }
}
