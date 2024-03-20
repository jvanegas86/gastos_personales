package com.gestiongastos.models;

import java.util.UUID;

public class IngresoDTO {
    private Long identificacion;
    private UUID idTipoIngreso;
    private Double valor;
    
    public IngresoDTO() {
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public UUID getIdTipoIngreso() {
        return idTipoIngreso;
    }

    public void setIdTipoIngreso(UUID idTipoIngreso) {
        this.idTipoIngreso = idTipoIngreso;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
