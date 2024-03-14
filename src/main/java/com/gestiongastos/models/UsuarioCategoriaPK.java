package com.gestiongastos.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UsuarioCategoriaPK implements Serializable{
    private static final long serialVersionUID = 1L;

    
    @Column(name = "documento")
    private Long documento;

    @Column(name = "id_categoria")
    private UUID idCategoria;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public UUID getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(UUID idCategoria) {
        this.idCategoria = idCategoria;
    }
}
