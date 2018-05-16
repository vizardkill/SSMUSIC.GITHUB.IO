/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author clan-
 */
public class Empresa {
    private int id_emp;
    private int id_emp_ma;
    private String NIT_emp;
    private String nom_emp;
    private String nom_encargado;
    private String doc_encargado;
    private String tel_encargado;
    private String cor_encargado;
    private String tipo_operacion;
    private double valor_operacion;
    private String fecha_registro;

    public Empresa() {
    }

    public Empresa(int id_emp, int id_emp_ma, String NIT_emp, String nom_emp, String nom_encargado, String doc_encargado, String tel_encargado, String cor_encargado, String tipo_operacion, double valor_operacion, String fecha_registro) {
        this.id_emp = id_emp;
        this.id_emp_ma = id_emp_ma;
        this.NIT_emp = NIT_emp;
        this.nom_emp = nom_emp;
        this.nom_encargado = nom_encargado;
        this.doc_encargado = doc_encargado;
        this.tel_encargado = tel_encargado;
        this.cor_encargado = cor_encargado;
        this.tipo_operacion = tipo_operacion;
        this.valor_operacion = valor_operacion;
        this.fecha_registro = fecha_registro;
    }

    public int getId_emp() {
        return id_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public int getId_emp_ma() {
        return id_emp_ma;
    }

    public void setId_emp_ma(int id_emp_ma) {
        this.id_emp_ma = id_emp_ma;
    }

    public String getNIT_emp() {
        return NIT_emp;
    }

    public void setNIT_emp(String NIT_emp) {
        this.NIT_emp = NIT_emp;
    }

    public String getNom_emp() {
        return nom_emp;
    }

    public void setNom_emp(String nom_emp) {
        this.nom_emp = nom_emp;
    }

    public String getNom_encargado() {
        return nom_encargado;
    }

    public void setNom_encargado(String nom_encargado) {
        this.nom_encargado = nom_encargado;
    }

    public String getDoc_encargado() {
        return doc_encargado;
    }

    public void setDoc_encargado(String doc_encargado) {
        this.doc_encargado = doc_encargado;
    }

    public String getTel_encargado() {
        return tel_encargado;
    }

    public void setTel_encargado(String tel_encargado) {
        this.tel_encargado = tel_encargado;
    }

    public String getCor_encargado() {
        return cor_encargado;
    }

    public void setCor_encargado(String cor_encargado) {
        this.cor_encargado = cor_encargado;
    }

    public String getTipo_operacion() {
        return tipo_operacion;
    }

    public void setTipo_operacion(String tipo_operacion) {
        this.tipo_operacion = tipo_operacion;
    }

    public double getValor_operacion() {
        return valor_operacion;
    }

    public void setValor_operacion(double valor_operacion) {
        this.valor_operacion = valor_operacion;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public String toString() {
        return "Empresa{" + "id_emp=" + id_emp + ", id_emp_ma=" + id_emp_ma + ", NIT_emp=" + NIT_emp + ", nom_emp=" + nom_emp + ", nom_encargado=" + nom_encargado + ", doc_encargado=" + doc_encargado + ", tel_encargado=" + tel_encargado + ", cor_encargado=" + cor_encargado + ", tipo_operacion=" + tipo_operacion + ", valor_operacion=" + valor_operacion + ", fecha_registro=" + fecha_registro + '}';
    }
    
    
    
    
}
