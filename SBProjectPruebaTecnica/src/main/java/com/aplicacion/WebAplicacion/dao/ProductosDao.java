package com.aplicacion.WebAplicacion.dao;

import com.aplicacion.WebAplicacion.modelo.Productos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductosDao extends CrudRepository<Productos,Long>{
    
}
