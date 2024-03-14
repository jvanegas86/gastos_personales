package com.gestiongastos.services;

import java.util.UUID;

import com.gestiongastos.models.Ingreso;

public interface IngresoService {
    public Ingreso crearIngreso(Long idUsuario,UUID idTipoIngreso, Double valor);
}
