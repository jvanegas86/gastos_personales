package com.gestiongastos.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.gestiongastos.models.Gasto;
import com.gestiongastos.models.Ingreso;
import com.gestiongastos.models.RequestBodyCategoria;
import com.gestiongastos.models.RequestBodyModel;
import com.gestiongastos.models.Usuario;

public interface UsuarioService {
    public Usuario save(Usuario usuario);
    
	public Optional<Usuario> getById(Long id);

    public List<Usuario> listarUsuarios();

    public void AsociarCategoriasAUsuario(RequestBodyCategoria reqBody);

    public void AsociarCategoriaSubcatAUsuario(RequestBodyModel requestBody);

    public void AsociarCategoriaAUsuario(Long idUsuario, UUID idCategoria);

    public void AsociarSubategoriaAUsuario(RequestBodyModel request);

    public List<Ingreso> listarIngresosXUsuario(Long usuario);

    public List<Gasto> listarGastosXUsuario(Long usuario);
}
