package com.gestiongastos.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfiles")
public class Perfil implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codperfil;
	private String nombmperfil;
	//private String privilegio;

	public Perfil(int codPerfil, String nombPerfil, String privilegio) {
		this.codperfil = codPerfil;
		this.nombmperfil = nombPerfil;
		//this.privilegio = privilegio;
	}

	public Perfil() {
		super();
	}

	public int getCodPerfil() {
		return codperfil;
	}

	public void setCodPerfil(int codPerfil) {
		this.codperfil = codPerfil;
	}

	public String getNombmPerfil() {
		return nombmperfil;
	}

	public void setNombmPerfil(String nombre) {
		this.nombmperfil = nombre;
	}

	/*public String getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(String privilegio) {
		this.privilegio = privilegio;
	}*/

}
