package com.betit.betit.services;

import com.betit.betit.model.GrupoEntity;
import com.betit.betit.model.UsuarioEntity;
import com.betit.betit.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public GrupoEntity criarGrupo(String nome, UsuarioEntity admin) {
      GrupoEntity grupo = new GrupoEntity();
      grupo.setNome(nome);
      grupo.setAdmin(admin);
      return grupoRepository.save(grupo);
    };

    public GrupoEntity buscarPorId(Long id){
        return grupoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));
        }

        public List<GrupoEntity> buscarTodos(){
        return grupoRepository.findAll();
        }

        public void deletarGrupo(Long id){
        grupoRepository.deleteById(id);
        }
}
