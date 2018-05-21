/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author SNT
 */
public class Informes {
    private int ID_EMP;
    private String EMP;
    private int ID_ART;
    private String NOM_ART;
    private long TOTAL_OPERACIONES;
    private long TOTAL_VENTAS;
    private long VALOR_VENTA;
    private String FECHA_DE_VENTA;
    private long CANTIDAD;
    private String FECHA_INICIAL;
    private String FECHA_FINAL;

    public String getFecha_inicial() {
        return FECHA_INICIAL;
    }

    public void setFecha_inicial(String fecha_inicial) {
        this.FECHA_INICIAL = fecha_inicial;
    }

    public String getFecha_final() {
        return FECHA_FINAL;
    }

    public void setFecha_final(String fecha_final) {
        this.FECHA_FINAL = fecha_final;
    }

    public long getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(long CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    
    public Informes(){
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

    public int getID_ART() {
        return ID_ART;
    }

    public void setID_ART(int ID_ART) {
        this.ID_ART = ID_ART;
    }

    public String getNOM_ART() {
        return NOM_ART;
    }

    public void setNOM_ART(String NOM_ART) {
        this.NOM_ART = NOM_ART;
    }

    public long getTOTAL_OPERACIONES() {
        return TOTAL_OPERACIONES;
    }

    public void setTOTAL_OPERACIONES(long TOTAL_OPERACIONES) {
        this.TOTAL_OPERACIONES = TOTAL_OPERACIONES;
    }

    public long getTOTAL_VENTAS() {
        return TOTAL_VENTAS;
    }

    public void setTOTAL_VENTAS(long TOTAL_VENTAS) {
        this.TOTAL_VENTAS = TOTAL_VENTAS;
    }

    public long getVALOR_VENTA() {
        return VALOR_VENTA;
    }

    public void setVALOR_VENTA(long VALOR_VENTA) {
        this.VALOR_VENTA = VALOR_VENTA;
    }

    public String getFECHA_DE_VENTA() {
        return FECHA_DE_VENTA;
    }

    public void setFECHA_DE_VENTA(String FECHA_DE_VENTA) {
        this.FECHA_DE_VENTA = FECHA_DE_VENTA;
    }

    public Informes(int ID_EMP, String EMP, int ID_ART, String NOM_ART, long TOTAL_OPERACIONES, long TOTAL_VENTAS, long VALOR_VENTA, String FECHA_DE_VENTA, long CANTIDAD, String FECHA_INICIAL, String FECHA_FINAL) {
        this.ID_EMP = ID_EMP;
        this.EMP = EMP;
        this.ID_ART = ID_ART;
        this.NOM_ART = NOM_ART;
        this.TOTAL_OPERACIONES = TOTAL_OPERACIONES;
        this.TOTAL_VENTAS = TOTAL_VENTAS;
        this.VALOR_VENTA = VALOR_VENTA;
        this.FECHA_DE_VENTA = FECHA_DE_VENTA;
        this.CANTIDAD = CANTIDAD;
        this.FECHA_INICIAL = FECHA_INICIAL;
        this.FECHA_FINAL = FECHA_FINAL;
    }
    
}
