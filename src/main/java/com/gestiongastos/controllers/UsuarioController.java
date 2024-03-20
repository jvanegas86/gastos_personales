package com.gestiongastos.controllers;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestiongastos.models.RequestBodyCategoria;
import com.gestiongastos.models.Usuario;
import com.gestiongastos.services.UsuarioServiceImpl;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

//@Controller
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
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
	/*@PostMapping("/asociar-categoria")
	public ResponseEntity<Void> AsociarCategoriaAUsuario(@RequestBody RequestBodyCategoria requestBodyCat) {
		Long id = requestBodyCat.getDocumento();
		UUID[] idsCategorias = requestBodyCat.getIdsCAtegorias();
		usuarioService.AsociarCategoriasAUsuario(requestBodyCat);		
		return ResponseEntity.ok().build();
	}*/
	@PostMapping("/asociar-categoria")
	public ResponseEntity<Void> AsociarCategoriaAUsuario(@RequestBody Map<String, UUID> requestBody,@RequestParam(name="identificacion", required=true)Long idUsuario) {
		Long id = idUsuario;
        UUID idCategoria = requestBody.get("idCategoria");
		usuarioService.AsociarCategoriaAUsuario(id, idCategoria);		
		return ResponseEntity.ok().build();
	}
	/*@PostMapping("/asociar-categoria-subcategoria")
	public ResponseEntity<Void> AsociarCategoriaSubcatAUsuario(@RequestBody Map<String, UUID> requestBody,@RequestParam(name="identificacion", required=true)Long idUsuario) {
		Long id = idUsuario;
        UUID idCategoria = requestBody.get("idCategoria");
		UUID idSubcategoria = requestBody.get("idSubcategoria");
		usuarioService.AsociarCategoriaSubcatAUsuario(id, idCategoria, idSubcategoria);		
		return ResponseEntity.ok().build();
	}*/

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

