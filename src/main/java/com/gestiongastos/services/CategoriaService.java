package com.gestiongastos.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import com.gestiongastos.models.Categoria;

public interface CategoriaService {
    public Categoria save(Categoria categoria);
	public Optional<Categoria> getById(UUID id);
	public List<Categoria> listarCategorias();
	//public List<Categoria> getListCategoriaxUsuario(Long identificacion);

}
