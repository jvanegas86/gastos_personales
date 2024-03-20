package com.gestiongastos.models;

import java.util.UUID;

public class RequestBodyModel {
    private Long documento;
    private UUID idCAtegoria;
    private UUID[] idSubcategorias;

    
    public UUID getIdCAtegoria() {
        return idCAtegoria;
    }
    public void setIdCAtegoria(UUID idCAtegoria) {
        this.idCAtegoria = idCAtegoria;
    }
    public UUID[] getIdSubcategorias() {
        return idSubcategorias;
    }
    public void setIdSubcategorias(UUID[] idSubcategorias) {
        this.idSubcategorias = idSubcategorias;
    }
    public Long getDocumento() {
        return documento;
    }
    public void setDocumento(Long documento) {
        this.documento = documento;
    }
}
