package com.gestiongastos.services;

import java.util.Optional;
import java.util.UUID;

import com.gestiongastos.models.Categoria;

public interface CategoriaService {
    
	public Optional<Categoria> getById(UUID id);

}
