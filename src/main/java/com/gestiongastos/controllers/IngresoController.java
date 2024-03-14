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
import com.gestiongastos.services.IngresoService;

@RestController
@RequestMapping("/ingreso")
public class IngresoController {

    @Autowired
	private IngresoService ingresoService;

    @PostMapping("/crearIngreso")
	public ResponseEntity<Ingreso> crearIngreso(@RequestBody Map<String,UUID> requestBody, @RequestParam(name="identificacion", required=true)Long idUsuario, @RequestParam(name="valor", required=true)Double valor) 
    {
        Long id = idUsuario;
        UUID idTipoIngreso = requestBody.get("idTipoIngreso");
		ingresoService.crearIngreso(id,idTipoIngreso, valor);
        return ResponseEntity.ok().build();
	}

}
