 package com.gestiongastos.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestiongastos.models.Subcategoria;
import com.gestiongastos.repository.SubcategoriaRepositorio;

@Service
public class SubcategoriaServiceImpl implements SubcategoriaService{

	@Autowired
	private SubcategoriaRepositorio subcategoriaRepository;

	@Override
	public Subcategoria save(Subcategoria subcategoria){
        return subcategoriaRepository.save(subcategoria);
    }

	@Override
	public Optional<Subcategoria> getById(UUID id) {
		return subcategoriaRepository.findById(id);
	}
}
