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
@Table(name="historicoproductos")
public class HistoricoProductos implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmovimiento;
    @Column(name = "idproducto")
    private String idproductos;
    private String tipomovimiento; 
    private String idusuario;
    private String fechamov;
}
