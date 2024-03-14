package com.gestiongastos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestiongastos.models.Gasto;
import com.gestiongastos.repository.GastoRepositorio;

@Service
public class GastoServiceImpl implements GastoService{
	
    @Autowired
	private GastoRepositorio gastoRepository;

    @Override
    public Gasto save(Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    
}
