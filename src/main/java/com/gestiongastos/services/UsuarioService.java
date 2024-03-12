package com.gestiongastos.services;

import java.util.Optional;
import java.util.UUID;

import com.gestiongastos.models.Usuario;

public interface UsuarioService {
    public Usuario save(Usuario usuario);
    
	public Optional<Usuario> getById(UUID id);
}
