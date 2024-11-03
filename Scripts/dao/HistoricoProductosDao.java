
package com.aplicacion.WebAplicacion.dao;


import com.aplicacion.WebAplicacion.modelo.HistoricoProductos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HistoricoProductosDao extends CrudRepository<HistoricoProductos,Long>{
}
