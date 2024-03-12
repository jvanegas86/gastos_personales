package com.gestiongastos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestiongastos.models.Ingreso;
import com.gestiongastos.repository.IngresoRepositorio;

@Service
public class IngresoServiceImpl implements IngresoService{
	
    @Autowired
	private IngresoRepositorio ingresoRepository;

    @Override
    public Ingreso save(Ingreso ingreso) {
        return ingresoRepository.save(ingreso);
    }

    
}
