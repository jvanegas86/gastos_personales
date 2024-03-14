package com.gestiongastos.models;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Long documento;
	private String nombre;
	private String apellido;
	private String clave;
	private String telefono;

	@ManyToOne
	@JoinColumn(name = "perfil")
	private Perfil perfil;

	@ManyToOne
	@JoinColumn(name = "municipio")
	private Municipio municipio;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Ingreso> ingresos;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<UsuarioCategoria> usuarioCategoria;

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Usuario(String nombre, String apellido, Long documento, String clave, String telefono,
			Perfil perfil) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.clave = clave;
		this.telefono = telefono;
		this.perfil = perfil;
	}

	public Usuario() {
		super();
	}

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
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

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Ingreso> getIngresos() {
		return ingresos;
	}

	public void setIngresos(List<Ingreso> ingresos) {
		this.ingresos = ingresos;
	}

	public List<UsuarioCategoria> getUsuarioCategoria() {
		return usuarioCategoria;
	}

	public void setUsuarioCategoria(List<UsuarioCategoria> usuarioCategoria) {
		this.usuarioCategoria = usuarioCategoria;
	}
	

}
