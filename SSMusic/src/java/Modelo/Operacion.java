/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Softcaribbean-DEV2
 */
public class Operacion {
    private Integer ID_VENTAS;
    private Integer ID_ARTISTA_VE; 
    private Integer CANTIDAD_OPERACIONES; 
    private Long VALOR_VENTA;
    private String FECHA_VENTA;
    
    
    public Operacion(Integer ID_VENTAS, Integer ID_ARTISTA_VE, Integer CANTIDAD_OPERACIONES, Long VALOR_VENTA, String FECHA_VENTA) {
        this.ID_VENTAS = ID_VENTAS;
        this.ID_ARTISTA_VE = ID_ARTISTA_VE;
        this.CANTIDAD_OPERACIONES = CANTIDAD_OPERACIONES;
        this.VALOR_VENTA = VALOR_VENTA;
        this.FECHA_VENTA = FECHA_VENTA;
    }

    public Integer getID_VENTAS() {
        return ID_VENTAS;
    }

    public void setID_VENTAS(Integer ID_VENTAS) {
        this.ID_VENTAS = ID_VENTAS;
    }

    public Integer getID_ARTISTA_VE() {
        return ID_ARTISTA_VE;
    }

    public void setID_ARTISTA_VE(Integer ID_ARTISTA_VE) {
        this.ID_ARTISTA_VE = ID_ARTISTA_VE;
    }

    public Integer getCANTIDAD_OPERACIONES() {
        return CANTIDAD_OPERACIONES;
    }

    public void setCANTIDAD_OPERACIONES(Integer CANTIDAD_OPERACIONES) {
        this.CANTIDAD_OPERACIONES = CANTIDAD_OPERACIONES;
    }

    public Long getVALOR_VENTA() {
        return VALOR_VENTA;
    }

    public void setVALOR_VENTA(Long VALOR_VENTA) {
        this.VALOR_VENTA = VALOR_VENTA;
    }

    public String getFECHA_VENTA() {
        return FECHA_VENTA;
    }

    public void setFECHA_VENTA(String FECHA_VENTA) {
        this.FECHA_VENTA = FECHA_VENTA;
    }
    
    
}
