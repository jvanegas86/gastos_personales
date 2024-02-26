package com.gestiongastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestiongastos.models.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

}
