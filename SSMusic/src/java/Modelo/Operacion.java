/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Softcaribbean-DEV2
 */
public class Operacion {
    private int ID_EMP; 
    private String EMP;
    private String NOM_ART;
    private int ID_VENTAS;
    private int ID_ARTISTA_VE; 
    private int CANTIDAD_OPERACIONES; 
    private long VALOR_VENTA;
    private String FECHA_VENTA;
    

    public Operacion() {
    }

    public Operacion(int ID_EMP, String EMP, String NOM_ART, int ID_VENTAS, int ID_ARTISTA_VE, int CANTIDAD_OPERACIONES, long VALOR_VENTA, String FECHA_VENTA) {
        this.ID_EMP = ID_EMP;
        this.EMP = EMP;
        this.NOM_ART = NOM_ART;
        this.ID_VENTAS = ID_VENTAS;
        this.ID_ARTISTA_VE = ID_ARTISTA_VE;
        this.CANTIDAD_OPERACIONES = CANTIDAD_OPERACIONES;
        this.VALOR_VENTA = VALOR_VENTA;
        this.FECHA_VENTA = FECHA_VENTA;
    }

    public int getID_EMP() {
        return ID_EMP;
    }

    public void setID_EMP(int ID_EMP) {
        this.ID_EMP = ID_EMP;
    }

    public String getEMP() {
        return EMP;
    }

    public void setEMP(String EMP) {
        this.EMP = EMP;
    }

    public String getNOM_ART() {
        return NOM_ART;
    }

    public void setNOM_ART(String NOM_ART) {
        this.NOM_ART = NOM_ART;
    }

    public int getID_VENTAS() {
        return ID_VENTAS;
    }

    public void setID_VENTAS(int ID_VENTAS) {
        this.ID_VENTAS = ID_VENTAS;
    }

    public int getID_ARTISTA_VE() {
        return ID_ARTISTA_VE;
    }

    public void setID_ARTISTA_VE(int ID_ARTISTA_VE) {
        this.ID_ARTISTA_VE = ID_ARTISTA_VE;
    }

    public int getCANTIDAD_OPERACIONES() {
        return CANTIDAD_OPERACIONES;
    }

    public void setCANTIDAD_OPERACIONES(int CANTIDAD_OPERACIONES) {
        this.CANTIDAD_OPERACIONES = CANTIDAD_OPERACIONES;
    }

    public long getVALOR_VENTA() {
        return VALOR_VENTA;
    }

    public void setVALOR_VENTA(long VALOR_VENTA) {
        this.VALOR_VENTA = VALOR_VENTA;
    }

    public String getFECHA_VENTA() {
        return FECHA_VENTA;
    }

    public void setFECHA_VENTA(String FECHA_VENTA) {
        this.FECHA_VENTA = FECHA_VENTA;
    }

    @Override
    public String toString() {
        return "Operacion{" + "ID_EMP=" + ID_EMP + ", EMP=" + EMP + ", NOM_ART=" + NOM_ART + ", ID_VENTAS=" + ID_VENTAS + ", ID_ARTISTA_VE=" + ID_ARTISTA_VE + ", CANTIDAD_OPERACIONES=" + CANTIDAD_OPERACIONES + ", VALOR_VENTA=" + VALOR_VENTA + ", FECHA_VENTA=" + FECHA_VENTA + '}';
    }
    
    

}
