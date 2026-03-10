package com.betit.betit;

import com.betit.betit.model.ApostaEntity;
import com.betit.betit.model.GrupoEntity;
import com.betit.betit.model.PalpiteEntity;
import com.betit.betit.model.UsuarioEntity;
import com.betit.betit.repository.ApostaRepository;
import com.betit.betit.repository.GrupoRepository;
import com.betit.betit.repository.PalpiteRepository;
import com.betit.betit.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.logging.SocketHandler;

@SpringBootApplication
public class BetitApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetitApplication.class, args);
	}


}


