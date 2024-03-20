package com.gestiongastos.models;

import java.util.UUID;

public class RequestBodyCategoria {
    private Long documento;
    private UUID[] idsCAtegorias;
    public Long getDocumento() {
        return documento;
    }
    public void setDocumento(Long documento) {
        this.documento = documento;
    }
    public UUID[] getIdsCAtegorias() {
        return idsCAtegorias;
    }
    public void setIdsCAtegorias(UUID[] idsCAtegorias) {
        this.idsCAtegorias = idsCAtegorias;
    }
}
