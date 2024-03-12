package com.gestiongastos.services;

import java.util.Optional;
import java.util.UUID;

import com.gestiongastos.models.TipoIngreso;

public interface TipoIngresoService {
    public Optional<TipoIngreso> getById(UUID id);
}
