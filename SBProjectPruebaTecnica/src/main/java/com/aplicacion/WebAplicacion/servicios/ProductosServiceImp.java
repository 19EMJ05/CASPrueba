
package com.aplicacion.WebAplicacion.servicios;
import com.aplicacion.WebAplicacion.dao.ProductosDao;
import com.aplicacion.WebAplicacion.modelo.HistoricoProductos;
import com.aplicacion.WebAplicacion.modelo.Productos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductosServiceImp implements ProductosService {
    @Autowired
    private ProductosDao productosDao;
    @Autowired
    private HistoricoProductosService hisProService;
    @Autowired
    private UsuariosService usuService;
    
    
    HistoricoProductos historicoProductos;
    
    @Transactional(readOnly=true)
    public List<Productos> ListProductos() {
        return (List<Productos>) productosDao.findAll();
    }
    @Transactional
    public void salvar(Productos productos) {
        productosDao.save(productos);
    }
    @Transactional
    public void aumP(Productos productos) {
        productosDao.save(productos);
        System.out.println(productos);
        HistoricoProductos historicoProductos =new HistoricoProductos();
        historicoProductos.setIdproductos(productos.getIdproducto().toString());
        historicoProductos.setIdusuario(usuService.getUser());
        historicoProductos.setTipomovimiento("Entrada");
        hisProService.hisProSave(historicoProductos);
        
    }
    @Transactional
    public void dismP(Productos productos) {
        productosDao.save(productos);
        HistoricoProductos historicoProductos =new HistoricoProductos();
        historicoProductos.setIdproductos(productos.getIdproducto().toString());
        historicoProductos.setIdusuario(usuService.getUser());
        historicoProductos.setTipomovimiento("Salida");
        hisProService.hisProSave(historicoProductos);
    }
    @Transactional
    public void borrar(Productos productos) {
        productosDao.delete(productos);
    }
    @Transactional(readOnly=true)
    public Productos buscar(Productos productos) {
        return productosDao.findById(productos.getIdproducto()).orElse(null);
    }
    
    
    
    
}
