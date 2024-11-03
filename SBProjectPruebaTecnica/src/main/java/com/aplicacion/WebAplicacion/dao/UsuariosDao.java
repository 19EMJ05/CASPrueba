package com.aplicacion.WebAplicacion.dao;

import org.springframework.stereotype.Repository;
import com.aplicacion.WebAplicacion.modelo.Usuarios;
import org.springframework.data.repository.CrudRepository;
@Repository
public interface UsuariosDao extends CrudRepository<Usuarios,String>{
 
}

