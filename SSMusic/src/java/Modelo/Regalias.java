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
public class Regalias {

    private int id_reg;
    private int id_art;
    private int id_emp;
    private String tipo_reg;
    private String fecha_ini;
    private String fecha_fin;
    private int total_operaciones;
    private String fecha_actual;
    private int condicion_reg;
    private String nom_condicion;

    public int getCondicion_reg() {
        return condicion_reg;
    }

    public void setCondicion_reg(int condicion_reg) {
        this.condicion_reg = condicion_reg;
    }

    public String getNom_condicion() {
        return nom_condicion;
    }

    public void setNom_condicion(String nom_condicion) {
        this.nom_condicion = nom_condicion;
    }
    
    

    public String getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(String fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

    public int getId_emp() {
        return id_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public int getTotal_operaciones() {
        return total_operaciones;
    }

    public void setTotal_operaciones(int total_operaciones) {
        this.total_operaciones = total_operaciones;
    }

    public String getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getId_reg() {
        return id_reg;
    }

    public void setId_reg(int id_reg) {
        this.id_reg = id_reg;
    }

    public int getId_art() {
        return id_art;
    }

    public void setId_art(int id_art) {
        this.id_art = id_art;
    }

    public String getTipo_reg() {
        return tipo_reg;
    }

    public void setTipo_reg(String tipo_reg) {
        this.tipo_reg = tipo_reg;
    }

    public Regalias(int id_reg, int id_art, int id_emp, String tipo_reg, String fecha_ini, String fecha_fin, int total_operaciones, String fecha_actual) {
        this.id_reg = id_reg;
        this.id_art = id_art;
        this.id_emp = id_emp;
        this.tipo_reg = tipo_reg;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
        this.total_operaciones = total_operaciones;
        this.fecha_actual = fecha_actual;
    }

   
  
    

    
    
    
    public Regalias() {
    }
    
}
