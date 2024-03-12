package com.gestiongastos.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestiongastos.models.Ingreso;
import com.gestiongastos.models.TipoIngreso;
import com.gestiongastos.models.Usuario;
import com.gestiongastos.services.IngresoServiceImpl;
import com.gestiongastos.services.UsuarioServiceImpl;
import com.gestiongastos.services.TipoIngresoServiceImpl;

@RestController
@RequestMapping("/ingreso")
public class IngresoController {

    @Autowired
	private IngresoServiceImpl ingresoService;

    @Autowired
	private UsuarioServiceImpl usuarioService;

    @Autowired
	private TipoIngresoServiceImpl tipoIngresoService;

    @PostMapping("/crearIngreso")
	public Ingreso crearIngreso(@RequestBody Ingreso ingreso, @RequestParam("idUsuario") UUID id, @RequestParam("idTipoIngreso") UUID idTipoIngreso) {

        //Buscar el usuario por id
        Usuario usr = usuarioService.getById((UUID)id).get();
        ingreso.setUsuario(usr);
        //Buscar el tipo de ingreso por id
        TipoIngreso tipoIngreso = tipoIngresoService.getById((UUID)idTipoIngreso).get();
        ingreso.setTipoIngreso(tipoIngreso);
		return ingresoService.save(ingreso);
	}

}
