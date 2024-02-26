package com.gestiongastos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestiongastos.models.Usuario;
import com.gestiongastos.services.UsuarioServiceImpl;

@RestController
public class LoginController {

	@Autowired
	UsuarioServiceImpl usuarioService;

	/*@PostMapping(value = "login")
	public String verificarUsuario(@RequestBody Usuario user) {
		if (usuarioService.verificarUsuario(user.getEmail(), user.getPassword())) {
			return "OK";
		} else {
			return "FAIL";
		}
	}*/

}
