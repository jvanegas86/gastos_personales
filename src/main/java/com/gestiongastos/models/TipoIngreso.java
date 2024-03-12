package com.gestiongastos.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_ingreso")
public class TipoIngreso {
    @Id
    private UUID idTipoIngreso;
    private String nombTipoIngreso;

    public UUID getIdTipoIngreso() {
        return idTipoIngreso;
    }
    public void setIdTipoIngreso(UUID idTipoIngreso) {
        this.idTipoIngreso = idTipoIngreso;
    }
    public String getNombTipoIngreso() {
        return nombTipoIngreso;
    }
    public void setNombTipoIngreso(String nombTipoIngreso) {
        this.nombTipoIngreso = nombTipoIngreso;
    }    
}
