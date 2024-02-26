package com.gestiongastos.services;

import java.util.Optional;

import com.gestiongastos.models.Perfil;

public interface PerfilService {
    public Optional<Perfil> obtenerPerfil(Integer id);
}
