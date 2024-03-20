 package com.gestiongastos.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestiongastos.models.Categoria;
import com.gestiongastos.models.Usuario;
import com.gestiongastos.repository.CategoriaRepositorio;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	/*@Autowired
	private UsuarioService usuarioService;*/

	@Autowired
	private CategoriaRepositorio categoriaRepository;

	@Override
	public Categoria save(Categoria categoria){
		//Perfil perfil = new Perfil();
        return categoriaRepository.save(categoria);
    }

	@Override
	public Optional<Categoria> getById(UUID id) {
		return categoriaRepository.findById(id);
	}

	/*@Override
	public List<Categoria> getListCategoriaxUsuario(Long identificacion) {
		return categoriaRepository.findByUserDocument(identificacion);
	}*/
	

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
