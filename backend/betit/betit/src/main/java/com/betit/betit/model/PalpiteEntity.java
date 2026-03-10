package com.betit.betit.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "palpites")
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class PalpiteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

   @ManyToOne
   @JoinColumn(name = "aposta_id")
   private ApostaEntity aposta;

   @Column(name = "valor_apostado")
    private BigDecimal valor_apostado;

   private String escolha; // Sim, Não

   @Column(name = "status_palpite")
    private String status_palpite; // Pendente, ganhou, perdeu

}
