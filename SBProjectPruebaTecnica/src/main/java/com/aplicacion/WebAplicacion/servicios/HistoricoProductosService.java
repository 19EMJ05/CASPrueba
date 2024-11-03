
package com.aplicacion.WebAplicacion.servicios;
import com.aplicacion.WebAplicacion.dao.HistoricoProductosDao;
import com.aplicacion.WebAplicacion.modelo.HistoricoProductos;
import com.aplicacion.WebAplicacion.modelo.Productos;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HistoricoProductosService {
    @Autowired
    private HistoricoProductosDao HistoricoProductosDao;
    
    public void hisProSave(HistoricoProductos  historicoProductos){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        historicoProductos.setFechamov(formattedDateTime);
        HistoricoProductosDao.save(historicoProductos);
        
    }
    @Transactional(readOnly=true)
    public List<HistoricoProductos> ListHis() {
        return (List<HistoricoProductos>) HistoricoProductosDao.findAll();
    }
    
    
    
    
}
