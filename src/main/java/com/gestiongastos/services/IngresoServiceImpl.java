package com.gestiongastos.services;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestiongastos.models.Ingreso;
import com.gestiongastos.models.TipoIngreso;
import com.gestiongastos.models.Usuario;
import com.gestiongastos.repository.IngresoRepositorio;

@Service
public class IngresoServiceImpl implements IngresoService{
	
    @Autowired
	private IngresoRepositorio ingresoRepository;

    @Autowired
	private UsuarioService usuarioService;

    @Autowired
	private TipoIngresoService tipoIngresoService;

    @Override
    public Ingreso crearIngreso(UUID idUsuario, UUID idTipoIngreso, Double valor) {
        Usuario 	usuario 	    = usuarioService.getById(idUsuario).get();
		TipoIngreso	tipoIngreso 	= tipoIngresoService.getById(idTipoIngreso).get();
		Ingreso ingreso = new Ingreso();
        ingreso.setFecha(new Date());
        ingreso.setUsuario(usuario);
		ingreso.setTipoIngreso(tipoIngreso);
        ingreso.setValor(valor);
        return ingresoRepository.save(ingreso);
    }

    
}
