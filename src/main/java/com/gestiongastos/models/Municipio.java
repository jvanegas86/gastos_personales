package com.gestiongastos.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "municipio")
public class Municipio {
	@Id
    private Integer codiMunicipio;
	private String nombMunicipio;

	public Integer getCodimunicipio() {
		return codiMunicipio;
	}

	public void setCodimunicipio(Integer codiMunicipio) {
		this.codiMunicipio = codiMunicipio;
	}

	public String getNombmunicipio() {
		return nombMunicipio;
	}

	public void setNombmunicipio(String nombMunicipio) {
		this.nombMunicipio = nombMunicipio;
	}
}
