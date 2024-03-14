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

import com.gestiongastos.models.Gasto;
import com.gestiongastos.models.Ingreso;
import com.gestiongastos.models.TipoIngreso;
import com.gestiongastos.models.Usuario;
import com.gestiongastos.services.GastoServiceImpl;
import com.gestiongastos.services.IngresoServiceImpl;
import com.gestiongastos.services.UsuarioServiceImpl;
import com.gestiongastos.services.TipoIngresoServiceImpl;

@RestController
@RequestMapping("/gasto")
public class GastoController {

    @Autowired
	private GastoServiceImpl gastoService;

    /*@Autowired
	private UsuarioServiceImpl usuarioService;*/

    @Autowired
	private TipoIngresoServiceImpl tipoIngresoService;

    /*@PostMapping("/crearGasto")
	public Gasto crearGasto(@RequestBody Gasto gasto, @RequestParam("idCategoriaSubcategoria") UUID id) {

        //Se escoge la categoría en la vista de usuario,Buscar el registro en categoría subcategoria según el usuariocategoria, si no existe esta relación se crea
        //Se escoge la subcategoria asociada al gasto, si no existe se crea
        //Se escoge la empresa y se crea el objeto categoriaSubcategoria, luego se le setea al objeto gasto y se graba
        Usuario usr = usuarioService.getById((UUID)id).get();
        gasto.setUsuario(usr);
        //Buscar el tipo de ingreso por id
        TipoIngreso tipoIngreso = tipoIngresoService.getById((UUID)idTipoIngreso).get();
        ingreso.setTipoIngreso(tipoIngreso);
		return ingresoService.save(ingreso);
	}*/

}
