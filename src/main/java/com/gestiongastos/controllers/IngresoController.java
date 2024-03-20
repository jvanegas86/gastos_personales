package com.gestiongastos.controllers;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestiongastos.models.Ingreso;
import com.gestiongastos.models.IngresoDTO;
import com.gestiongastos.services.IngresoService;

@RestController
@RequestMapping("/ingreso")
public class IngresoController {

    @Autowired
	private IngresoService ingresoService;

    @PostMapping("/crearIngreso")
	public ResponseEntity<Ingreso> crearIngreso(@RequestBody IngresoDTO ingresoDTO) 
    {
        Long id = ingresoDTO.getIdentificacion();
        UUID idTipoIngreso = ingresoDTO.getIdTipoIngreso();
        Double valor = ingresoDTO.getValor();
		ingresoService.crearIngreso(id,idTipoIngreso, valor);
        return ResponseEntity.ok().build();
	}
}
