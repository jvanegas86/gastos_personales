package com.gestiongastos.services;

import java.util.UUID;

import com.gestiongastos.models.Ingreso;

public interface IngresoService {
    public Ingreso crearIngreso(UUID idUsuario,UUID idTipoIngreso, Double valor);
}
