package com.gestiongastos.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gestiongastos.models.Perfil;
import com.gestiongastos.services.PerfilServiceImpl;

//@Controller
@RestController
@RequestMapping("/perfiles")
public class PerfilController {

	@Autowired
	private PerfilServiceImpl perfilService;

    @GetMapping("/{idPerfil}")
	public ResponseEntity<Perfil> getById(@PathVariable("idPerfil") int idPerfil) {
		return perfilService.obtenerPerfil(idPerfil).map(perfil -> new ResponseEntity<>(perfil, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}

