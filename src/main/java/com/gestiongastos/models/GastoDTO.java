package com.gestiongastos.models;

import java.util.UUID;

public class GastoDTO {
    private Double monto;
    private String descripcion;
    private UUID idCategoria;
    private UUID idSubcategoria;
    private Long documento;

    public GastoDTO() {
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public UUID getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(UUID idCategoria) {
        this.idCategoria = idCategoria;
    }

    public UUID getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(UUID idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }
}
