package com.gestiongastos.logic;

import java.util.List;

import com.gestiongastos.models.Usuario;

public interface ControlUsuarioInterface {

	public List<Usuario> obtenerUsuarios(List<Usuario> usuarios);

	public boolean actualizarUsuario(Usuario usuario);

	public boolean eliminarUsuario(int id_usuario);

}
