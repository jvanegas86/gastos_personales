package com.gestiongastos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestiongastos.models.Gasto;
import com.gestiongastos.models.Ingreso;
import com.gestiongastos.models.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    
    @Query(value = "SELECT i FROM Ingreso i WHERE i.usuario.documento = :documento")
    List<Ingreso> listarIngresosXUsuario(@Param("documento") Long documento);

    @Query(value = "SELECT g FROM Gasto g WHERE g.categoriaSubcategoria.usuarioCategoria.usuario.documento = :documento")
    List<Gasto> listarGastosXUsuario(@Param("documento") Long documento);
}
