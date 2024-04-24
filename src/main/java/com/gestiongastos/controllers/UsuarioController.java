package com.gestiongastos.controllers;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestiongastos.models.Gasto;
import com.gestiongastos.models.Ingreso;
import com.gestiongastos.models.RequestBodyCategoria;
import com.gestiongastos.models.Usuario;
import com.gestiongastos.services.UsuarioService;
import com.gestiongastos.services.UsuarioServiceImpl;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

//@Controller
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
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

	@PostMapping("/asociar-categoria")
	public ResponseEntity<Void> AsociarCategoriaAUsuario(@RequestBody Map<String, UUID> requestBody,@RequestParam(name="identificacion", required=true)Long idUsuario) {
		Long id = idUsuario;
        UUID idCategoria = requestBody.get("idCategoria");
		usuarioService.AsociarCategoriaAUsuario(id, idCategoria);		
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/usuario/{documento}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable Long documento) {
		try {
			Usuario usuario = usuarioService.getById(documento).get();
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(value = "/listarusuarios")
	public List<Usuario> getUsuarios() {

		return usuarioService.listarUsuarios();
	}

    @GetMapping(value = "/listaringresos/{documento}")
	public List<Ingreso> getIngresosXUsuario(@PathVariable Long documento) {
		return usuarioService.listarIngresosXUsuario(documento);
	}
	@GetMapping(value = "/listargasatos/{documento}")
	public List<Gasto> getGastosXUsuario(@PathVariable Long documento) {
		return usuarioService.listarGastosXUsuario(documento);
	}
	/*
	@DeleteMapping(value = "usuario/{id}")
	public void borrarUsuario(@PathVariable int id) {
		usuarioService.eliminarUsuario(id);
	}*/

}

