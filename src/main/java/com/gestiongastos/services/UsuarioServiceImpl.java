 package com.gestiongastos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gestiongastos.models.Usuario;
import com.gestiongastos.models.Perfil;
import com.gestiongastos.repository.UsuarioRepositorio;

@Service
public class UsuarioServiceImpl {

	@Autowired
	private UsuarioRepositorio usuarioRepository;

	@Autowired
	private PerfilService perfilService;

	public Usuario save(Usuario usuario){
		//Consulta un perfil y lo asigna al usuario
		Perfil perfil = new Perfil();
		perfil = perfilService.obtenerPerfil(1).get();
		usuario.setPerfil(perfil);
        return usuarioRepository.save(usuario);
    }


	public Usuario obtenerUsuario(Integer id) {

		return usuarioRepository.findById(id).get();
	}

	/*public void guardarUsuario(Usuario usuario) {
		UsuarioAdministrador usuario_especifico;
		usuario_especifico = new UsuarioAdministrador(usuario);
		if (usuario_especifico.actualizarUsuario(usuario)) {
			usuarioRepository.save(usuario);
		}

	}

	public List<Usuario> listarUsuarios() {

		List<Usuario> usuarios = usuarioRepository.findAll();
		// UsuarioAdministrador usuario_especifico = new UsuarioAdministrador();

		return usuarios;
	}

	public Usuario obtenerUsuario(Integer id) {

		return usuarioRepository.findById(id).get();
	}

	public void eliminarUsuario(Integer id) {
		usuarioRepository.deleteById(id);
	}

	public boolean verificarUsuario(String correo, String password) {

		if (UsuarioAbstract.verificarUsuario(listarUsuarios(), correo, password)) {
			return true;
		}

		return false;

	}*/

}
