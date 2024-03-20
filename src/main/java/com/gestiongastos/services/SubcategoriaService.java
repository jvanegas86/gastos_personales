package com.gestiongastos.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import com.gestiongastos.models.Categoria;
import com.gestiongastos.models.Subcategoria;

public interface SubcategoriaService {
    public Subcategoria save(Subcategoria categoria);
	public Optional<Subcategoria> getById(UUID id);
	//public List<Categoria> getListCategoriaxUsuario(Long identificacion);

}
