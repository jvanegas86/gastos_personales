 package com.gestiongastos.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gestiongastos.models.Usuario;
import com.gestiongastos.models.UsuarioCategoria;
import com.gestiongastos.models.UsuarioCategoriaPK;
import com.gestiongastos.models.Categoria;
import com.gestiongastos.models.CategoriaSubcategoria;
import com.gestiongastos.models.CategoriaSubcategoriaPK;
import com.gestiongastos.models.Perfil;
import com.gestiongastos.models.RequestBodyCategoria;
import com.gestiongastos.models.RequestBodyModel;
import com.gestiongastos.models.Subcategoria;
import com.gestiongastos.repository.UsuarioRepositorio;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepositorio usuarioRepository;

	@Autowired
	private PerfilService perfilService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private SubcategoriaService subcategoriaService;

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

	@Override
	public void AsociarSubategoriaAUsuario(@RequestBody RequestBodyModel requestBody) {
		
	}

	@Override 
	public void AsociarCategoriaSubcatAUsuario(@RequestBody RequestBodyModel requestBody){//(Long idUsuario, UUID idCategoria, UUID idSubcategoria) {
		UUID idCategoria 	= requestBody.getIdCAtegoria();
        UUID[] idsSubcategorias 		= requestBody.getIdSubcategorias();
		Long idUsuario 		= requestBody.getDocumento();	 
		//Asociar usuario-categoria
		Usuario 		usuario 		= getById(idUsuario).get();
		Categoria 		categoria 		= categoriaService.getById(idCategoria).get();
		UsuarioCategoriaPK usuarioCatPK = new UsuarioCategoriaPK();
		usuarioCatPK.setDocumento(idUsuario);
		usuarioCatPK.setIdCategoria(idCategoria);
		UsuarioCategoria usuarioCategoria = new UsuarioCategoria(usuario, categoria);
		usuarioCategoria.setId(usuarioCatPK);
		usuario.getUsuarioCategoria().add(usuarioCategoria);
		usuarioRepository.save(usuario);
		
		//por cada idsubcategoria traer la subcat
		List<CategoriaSubcategoria> listCategSubcat = new LinkedList<>();
		Usuario usr = getById(idUsuario).get();
		for(int i=0; i<idsSubcategorias.length; i++){
			CategoriaSubcategoria catsubcat = new CategoriaSubcategoria();
			Subcategoria subcategoria 	= subcategoriaService.getById(idsSubcategorias[i]).get();
			//Crear asociación con subcategoria
			CategoriaSubcategoriaPK catSubcatPK = new CategoriaSubcategoriaPK();
			catSubcatPK.setDocumento(idUsuario);
			catSubcatPK.setIdCategoria(idCategoria);
			catSubcatPK.setIdSubcategoria(idsSubcategorias[i]);
			catsubcat.setId(catSubcatPK);
			catsubcat.setUsuarioCategoria(usuarioCategoria);
			catsubcat.setSubcategoria(subcategoria);	
			listCategSubcat.add(catsubcat);		
		}
		usuarioCategoria.setCategoriaSubcategoria(listCategSubcat);
		//update usuarioCategoria
	}

	@Override
	public void AsociarCategoriasAUsuario(RequestBodyCategoria reqBody) {
		Usuario 	usuario 	= getById(reqBody.getDocumento()).get();
		List<UsuarioCategoria> lstUsuarioCategoria = new LinkedList<>();
		UUID[] idCategorias = reqBody.getIdsCAtegorias();
		//Se busca cada categoría
		for(int i=0; i<idCategorias.length;i++){
			Categoria 	categoria 	= categoriaService.getById(idCategorias[i]).get();
			UsuarioCategoriaPK usuarioCatPK = new UsuarioCategoriaPK();
			usuarioCatPK.setDocumento(reqBody.getDocumento());
			usuarioCatPK.setIdCategoria(idCategorias[i]);
			UsuarioCategoria usuarioCategoria = new UsuarioCategoria(usuario, categoria);
			usuarioCategoria.setId(usuarioCatPK);
			lstUsuarioCategoria.add(usuarioCategoria);
		}
		usuario.getUsuarioCategoria().addAll(lstUsuarioCategoria);
        usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}
}
