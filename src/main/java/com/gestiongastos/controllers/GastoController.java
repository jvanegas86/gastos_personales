package com.gestiongastos.controllers;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.gestiongastos.models.Categoria;
import com.gestiongastos.models.CategoriaSubcategoria;
import com.gestiongastos.models.Gasto;
import com.gestiongastos.models.GastoDTO;
import com.gestiongastos.services.GastoService;

@RestController
@RequestMapping("/gasto")
public class GastoController {

    @Autowired
	private GastoService gastoService;

   @PostMapping("/getcategoriasusuario")
    public List<Categoria> getListCategoriaxUsuario(@RequestBody Map<String,Long> requestBody) {
        Long identificacion = requestBody.get("identificacion"); 
        return gastoService.getListCatxUsr(identificacion); 
    }
    @PostMapping("/getcatsubcat")
    public List<CategoriaSubcategoria> getListCatSubcat(@RequestBody Map<String,UUID> requestBody) {
        UUID idCategoria = requestBody.get("idCategoria"); 
        return gastoService.findCategoriaSubCategoriasById(idCategoria); 
    }

    @PostMapping("/creargasto")
	public Gasto crearGasto(@RequestBody GastoDTO gastoDTO) {
		return gastoService.crearGasto(gastoDTO);
	}
}
