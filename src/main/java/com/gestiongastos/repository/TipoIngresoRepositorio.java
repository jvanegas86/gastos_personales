package com.gestiongastos.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gestiongastos.models.TipoIngreso;

@Repository
public interface TipoIngresoRepositorio extends JpaRepository<TipoIngreso, UUID>{
    
}
