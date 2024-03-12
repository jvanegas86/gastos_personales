package com.gestiongastos.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestiongastos.models.TipoIngreso;
import com.gestiongastos.repository.TipoIngresoRepositorio;
import com.gestiongastos.repository.UsuarioRepositorio;

@Service
public class TipoIngresoServiceImpl implements TipoIngresoService{

    @Autowired
	private TipoIngresoRepositorio tipoIngresoRepository;

    @Override
    public Optional<TipoIngreso> getById(UUID id) {
        return tipoIngresoRepository.findById(id);
    }
    
}
