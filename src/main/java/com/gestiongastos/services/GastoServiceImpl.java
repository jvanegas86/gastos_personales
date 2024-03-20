package com.gestiongastos.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestiongastos.models.Categoria;
import com.gestiongastos.models.CategoriaSubcategoria;
import com.gestiongastos.models.CategoriaSubcategoriaPK;
import com.gestiongastos.models.Gasto;
import com.gestiongastos.models.GastoDTO;
import com.gestiongastos.models.Subcategoria;
import com.gestiongastos.models.Usuario;
import com.gestiongastos.models.UsuarioCategoria;
import com.gestiongastos.models.UsuarioCategoriaPK;
import com.gestiongastos.repository.GastoRepositorio;

@Service
public class GastoServiceImpl implements GastoService{
	
    @Autowired
	private GastoRepositorio gastoRepository;

    @Autowired
	private UsuarioService usuarioService;

    @Autowired
    private CategoriaService categoriaService;
   
    @Autowired
    private SubcategoriaService subcategoriaService;    

    @Autowired
    private CategoriaSubcategoriaService categoriaSubcategoriaService;

    @Override
    public Gasto save(Gasto gasto) {
        return gastoRepository.save(gasto);
    }

    @Override
    public List<Categoria> getListCatxUsr(Long documento) {
        Usuario usuario = usuarioService.getById(documento).get();
        List<UsuarioCategoria> listaUsrCat = usuario.getUsuarioCategoria();
        List<Categoria> listaCategxusuario = new ArrayList<>();
        Categoria categoria;
        if(listaUsrCat!=null){
            for(UsuarioCategoria cat:listaUsrCat){
                categoria=categoriaService.getById(cat.getId().getIdCategoria()).get();
                if(cat!=null){
                    listaCategxusuario.add(categoria);
                }
            }
        }
        return listaCategxusuario;
    }

    @Override
    public List<CategoriaSubcategoria> findCategoriaSubCategoriasById(UUID idCategoria) {
       return gastoRepository.findCategoriaSubCategoriasById(idCategoria);
    }

    @Override
    public Gasto crearGasto(GastoDTO gastoDTO) {
        UUID idCategoria = gastoDTO.getIdCategoria();
		UUID idSubcategoria = gastoDTO.getIdSubcategoria();
        Long documento =  gastoDTO.getDocumento();

        Usuario u = usuarioService.getById(documento).get();
            
		Categoria cat = categoriaService.getById(idCategoria).get();
        UsuarioCategoriaPK usrCatPK = new UsuarioCategoriaPK();
        usrCatPK.setDocumento(u.getDocumento());
        usrCatPK.setIdCategoria(gastoDTO.getIdCategoria());
        //1. Se crea usuariocategoria y se le asocia al usuario
        UsuarioCategoria usrcat = new UsuarioCategoria(u, cat);
        usrcat.setId(usrCatPK);
        u.getUsuarioCategoria().add(usrcat);
        usuarioService.save(u);
        //2. Se crea categoriaSubcategoria
        Subcategoria subcat = subcategoriaService.getById(idSubcategoria).get();
        CategoriaSubcategoriaPK cspk = new CategoriaSubcategoriaPK();
        cspk.setDocumento(u.getDocumento()); 
        cspk.setIdCategoria(idCategoria);
        cspk.setIdSubcategoria(idSubcategoria);
        CategoriaSubcategoria cat_subcat = new CategoriaSubcategoria();
        //CategoriaSubcategoria categoriaSubcategoria = new CategoriaSubcategoria();
        cat_subcat.setId(cspk);
        cat_subcat.setSubcategoria(subcat);
        cat_subcat.setUsuarioCategoria(usrcat);
        categoriaSubcategoriaService.save(cat_subcat);
        //3. Crear gasto
        Gasto gasto = new Gasto();
        gasto.setCategoriaSubcategoria(cat_subcat);
        gasto.setFecha(new Date());
        gasto.setMonto(gastoDTO.getMonto());
        gasto.setDescripcion(gastoDTO.getDescripcion());
        return save(gasto);
    }    
}
