package com.aplicacion.WebAplicacion.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;
@Data
@Entity
@Table(name="productos")
public class Productos implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Column(name = "nomproducto")
    private String nomproducto;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private Long idproducto;
    private String cantidad;
    private String estatus;        
}


