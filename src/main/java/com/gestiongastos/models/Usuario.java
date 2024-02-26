package com.gestiongastos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	private String email;
	private String nombre;
	private String apellido;
	//private String password;
	private String telefono;
	@ManyToOne
	@JoinColumn(name = "codperfil")
	private Perfil perfil;

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Usuario(String nombre, String apellido, String email, String telefono,
			Perfil perfil) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		//this.password = password;
		this.telefono = telefono;
		this.perfil = perfil;
	}

	public Usuario() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/*public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}*/

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
