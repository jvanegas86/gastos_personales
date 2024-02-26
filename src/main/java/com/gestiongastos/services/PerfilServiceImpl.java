package com.gestiongastos.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestiongastos.models.Perfil;
import com.gestiongastos.repository.PerfilRepositorio;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PerfilServiceImpl implements PerfilService{

    @Autowired
	private PerfilRepositorio perfilRepository;
    
    @Override
	public Optional<Perfil> obtenerPerfil(Integer id) {
		return perfilRepository.findById(id);
	}
}
