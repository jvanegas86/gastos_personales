package com.gestiongastos.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestBody;

import com.gestiongastos.models.RequestBodyCategoria;
import com.gestiongastos.models.RequestBodyModel;
import com.gestiongastos.models.Usuario;

public interface UsuarioService {
    public Usuario save(Usuario usuario);
    
	public Optional<Usuario> getById(Long id);

    public void AsociarCategoriasAUsuario(RequestBodyCategoria reqBody);

    public void AsociarCategoriaSubcatAUsuario(RequestBodyModel requestBody);

    public void AsociarCategoriaAUsuario(Long idUsuario, UUID idCategoria);

    public void AsociarSubategoriaAUsuario(RequestBodyModel request);
}
