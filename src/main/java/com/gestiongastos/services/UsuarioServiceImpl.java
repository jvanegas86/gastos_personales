 package com.gestiongastos.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestiongastos.models.Usuario;
import com.gestiongastos.models.UsuarioCategoria;
import com.gestiongastos.models.UsuarioCategoriaPK;
import com.gestiongastos.models.Categoria;
import com.gestiongastos.models.Perfil;
import com.gestiongastos.repository.UsuarioRepositorio;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepositorio usuarioRepository;

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private CategoriaService categoriaService;

	public Usuario save(Usuario usuario){
		Perfil perfil = new Perfil();
		perfil = perfilService.obtenerPerfil(1).get();
		usuario.setPerfil(perfil);
        return usuarioRepository.save(usuario);
    }

	@Override
	public Optional<Usuario> getById(Long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public void AsociarCategoriaAUsuario(Long idUsuario, UUID idCategoria) {
		Usuario 	usuario 	= getById(idUsuario).get();
		Categoria 	categoria 	= categoriaService.getById(idCategoria).get();

		UsuarioCategoriaPK usuarioCatPK = new UsuarioCategoriaPK();
		usuarioCatPK.setDocumento(idUsuario);
		usuarioCatPK.setIdCategoria(idCategoria);
		UsuarioCategoria usuarioCategoria = new UsuarioCategoria(usuario, categoria);
		usuarioCategoria.setId(usuarioCatPK);
		usuario.getUsuarioCategoria().add(usuarioCategoria);
        usuarioRepository.save(usuario);
	}

}
