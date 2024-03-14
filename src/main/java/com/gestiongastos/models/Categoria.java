package com.gestiongastos.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private UUID numCategoria;
    private String NombCategoria;
    private String descripcion;
    
    public UUID getNumCategoria() {
        return numCategoria;
    }
    public void setNumCategoria(UUID numCategoria) {
        this.numCategoria = numCategoria;
    }
    public String getNombCategoria() {
        return NombCategoria;
    }
    public void setNombCategoria(String nombCategoria) {
        NombCategoria = nombCategoria;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
