package com.aplicacion.WebAplicacion;

import lombok.extern.slf4j.Slf4j;
import com.aplicacion.WebAplicacion.dao.ProductosDao;
import com.aplicacion.WebAplicacion.dao.UsuariosDao;
import com.aplicacion.WebAplicacion.modelo.HistoricoProductos;
import com.aplicacion.WebAplicacion.modelo.Productos;
import com.aplicacion.WebAplicacion.modelo.Usuarios;
import com.aplicacion.WebAplicacion.servicios.HistoricoProductosService;
import com.aplicacion.WebAplicacion.servicios.ProductosService;
import com.aplicacion.WebAplicacion.servicios.UsuariosService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorRest {

    @Autowired
    private UsuariosService usuarios;

    @Autowired()
    private ProductosService productosService;
    @Autowired()
    private  HistoricoProductosService historicoProductosService;
    
    
    @ModelAttribute
    public void addGlobalAttributes(Model model) {
        String rol = usuarios.getrole();
        System.out.println(rol);
        model.addAttribute("rol", rol);
    }

    @GetMapping("/")
    public String home(Model model) {
        return "/Plantillas/menu"; // nombre de tu vista Thymeleaf
    }

    @GetMapping("/Historico")
    public String historico(Model model) {
        List<HistoricoProductos> vhistoricoProductos=historicoProductosService.ListHis();
         model.addAttribute("vhistoricoProductos", vhistoricoProductos);
        return "Historico";
    }
     @PostMapping("/historicoFiltar")
    public String historicoFiltar(Model model,String filtro) {
        List<HistoricoProductos> vhistoricoProductos=historicoProductosService.ListHis();
         model.addAttribute("vhistoricoProductos", vhistoricoProductos);
         model.addAttribute("filtro", filtro);
        return "Historico";
    }
// ingresar -------------------------------------------------------------

    @GetMapping("/IngresarProductos")
    public String ingresarProductos(Productos productos) {
        productos.setCantidad("0");
        productos.setEstatus("1");
        return "IngresarProductos";
    }

    @PostMapping("/iSPSalvar")
    public String iSPSalvar(Productos productos) {
        productosService.salvar(productos);
        return "redirect:/IngresarProductos";
    }

// sacar------------------------------------------------------------------
    @GetMapping("/SalidaProductos")
    public String salidaProductos(Model model, Productos productos) {
        List<Productos> vProductos = productosService.ListProductos();
        model.addAttribute("vProductos", vProductos);
        return "SalidaProductos";
    }

    @GetMapping("/iSPSacar/{idproducto}")
    public String iSPSacar(Productos productos) {
        productosService.borrar(productos);
        return "redirect:/SalidaProductos";
    }
    // ----------AltaProductos-----------------------------------------------------

    @GetMapping("/AltaProductos")
    public String altaProductos(Model model, Productos productos) {
        List<Productos> vProductos = productosService.ListProductos();
        model.addAttribute("vProductos", vProductos);
        return "AltaProductos";
    }

    @GetMapping("/aLupdate/{idproducto}")
    public String aLupdate(Productos productos) {
        productos = productosService.buscar(productos);
        productos.setEstatus("1");
        productosService.salvar(productos);
        return "redirect:/AltaProductos";
    }
// --------------------BajaProductos--------------------------------------------

    @GetMapping("/BajaProductos")
    public String bajaProductos(Model model, Productos productos) {
        List<Productos> vProductos = productosService.ListProductos();
        model.addAttribute("vProductos", vProductos);
        return "BajaProductos";
    }

    @GetMapping("/bLupdate/{idproducto}")
    public String bLupdate(Productos productos) {
        productos = productosService.buscar(productos);
        productos.setEstatus("0");
        productosService.salvar(productos);
        return "redirect:/BajaProductos";
    }
// -----------------------------------------------------------------------------

    @GetMapping("/AumetarP")
    public String aumetarP(Model model, Productos productos) {
        List<Productos> vProductos = productosService.ListProductos();
        model.addAttribute("vProductos", vProductos);

        return "AumetarP";
    }

    @PostMapping("/aumP")
    public String aumP(Model model, Productos productos) {
        String cantidad = productos.getCantidad();

        productos = productosService.buscar(productos);
        int resultado = (Integer.parseInt(cantidad)
                + Integer.parseInt(productos.getCantidad()));

        productos.setCantidad(String.valueOf(resultado));
        productosService.aumP(productos);
        return "redirect:/AumetarP";

    }
// --------------------------DisminuirP-----------------------------------------

    @GetMapping("/DisminuirP")
    public String disminuirP(Model model, Productos productos) {
        List<Productos> vProductos = productosService.ListProductos();
        model.addAttribute("vProductos", vProductos);
        return "DisminuirP";
    }

    @PostMapping("/disP")
    public String disP(Model model, Productos productos) {
        String cantidad = productos.getCantidad();
        productos = productosService.buscar(productos);
        int resultado = Integer.parseInt(productos.getCantidad())
                -(Integer.parseInt(cantidad));

        productos.setCantidad(String.valueOf(resultado));
        productosService.dismP(productos);
        return "redirect:/DisminuirP";
    }
// -----------------------------------------------------------------------------

    @GetMapping("/VerInventario")
    public String verInventario(Model model) {
        List<Productos> vProductos = productosService.ListProductos();
        model.addAttribute("vProductos", vProductos);
        return "VerInventario";

    }

}
