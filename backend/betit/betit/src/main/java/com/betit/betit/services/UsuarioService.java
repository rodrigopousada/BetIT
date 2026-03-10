package com.betit.betit.services;

import com.betit.betit.model.GrupoEntity;
import com.betit.betit.model.UsuarioEntity;
import com.betit.betit.repository.GrupoRepository;
import com.betit.betit.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jdk.jfr.TransitionTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private GrupoRepository grupoRepository;

    @Transactional
    public UsuarioEntity cadastrarUsuario(UsuarioEntity usuario) {
        UsuarioEntity usuarioCadastrado = usuarioRepository.save(usuario);


                //Aqui cria e procura o grupo geral
            GrupoEntity grupoGeral = grupoRepository.findByNome("Geral")
                    .orElseThrow(() -> new RuntimeException("Grupo Geral não encontrado!"));

            usuarioCadastrado.getGrupos().add(grupoGeral);

            return usuarioRepository.save(usuarioCadastrado);
    }

    public UsuarioEntity buscarPorId(Long Id){
        return usuarioRepository.findById(Id)
                    .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

   public List<UsuarioEntity> listarUsuarios(){
        return usuarioRepository.findAll();
    }

}
