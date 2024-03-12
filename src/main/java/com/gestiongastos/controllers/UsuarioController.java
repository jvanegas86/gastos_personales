package com.gestiongastos.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import com.gestiongastos.models.Usuario;
import com.gestiongastos.services.UsuarioServiceImpl;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

//@Controller
@RestController
@RequestMapping("/api/var")
public class UsuarioController {
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	
	/*@PostMapping("/crearUsuario")
	public void crearUsuario(Map<String, Object> modelo) {
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		modelo.put("usuario", usuario);
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);
		String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
		usuario.setPassword(hash);
		usuarioService.guardarUsuario(usuario);
	}*/

	@PostMapping("/crearUsuario")
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		usuario.setNombre(usuario.getNombre());
		usuario.setApellido(usuario.getApellido());
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);
		String hash = argon2.hash(10, 65536, 1, usuario.getClave());
		usuario.setDocumento(usuario.getDocumento());
		usuario.setClave(hash);
		usuario.setTelefono(usuario.getTelefono());
		return usuarioService.save(usuario);
	}

	/*@GetMapping(value = "usuario/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable int id) {

		try {
			Usuario usuario = usuarioService.obtenerUsuario(id);
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(value = "usuarios")
	public List<Usuario> getUsuarios() {

		return usuarioService.listarUsuarios();
	}

	
	@DeleteMapping(value = "usuario/{id}")
	public void borrarUsuario(@PathVariable int id) {
		usuarioService.eliminarUsuario(id);
	}*/

}

