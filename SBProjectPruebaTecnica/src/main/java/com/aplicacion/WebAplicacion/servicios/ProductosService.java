package com.aplicacion.WebAplicacion.servicios;

import com.aplicacion.WebAplicacion.modelo.Productos;
import java.util.List;


public interface ProductosService {
    
    public List<Productos> ListProductos();
    public void salvar(Productos productos);
    public void borrar(Productos productos);
    public Productos buscar(Productos productos);
    public void dismP(Productos productos);
    public void aumP(Productos productos);
    
    
}
