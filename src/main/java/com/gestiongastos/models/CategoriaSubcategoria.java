package com.gestiongastos.models;
import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria_subcategoria")
public class CategoriaSubcategoria implements Serializable{

	private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CategoriaSubcategoriaPK id;

    @ManyToOne
    @JoinColumn(name = "id_subcategoria", insertable = false, updatable = false)
    private Subcategoria subcategoria;
    @ManyToOne
    @JoinColumn(name = "id_usuario",  referencedColumnName = "id_usuario",insertable = false, updatable = false)
    @JoinColumn(name = "id_categoria",referencedColumnName = "id_categoria", insertable = false, updatable = false)
    private UsuarioCategoria usuarioCategoria;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    public CategoriaSubcategoriaPK getId() {
        return id;
    }

    public void setId(CategoriaSubcategoriaPK id) {
        this.id = id;
    }

    public Subcategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    public UsuarioCategoria getUsuarioCategoria() {
        return usuarioCategoria;
    }

    public void setUsuarioCategoria(UsuarioCategoria usuarioCategoria) {
        this.usuarioCategoria = usuarioCategoria;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    
}