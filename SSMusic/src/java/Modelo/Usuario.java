/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.SimpleDateFormat;

/**
 *
 * @author scardonas
 */
public class Usuario {

    private int id;
    private int id_empresa;
    private String tipo_perfil;
    private String username;
    private String pass;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String correo;
    private String telefono;
    private String direccion;
    private String documento;
    private String fecha_registro;

    public Usuario() {
    }

    public Usuario(int id,int id_empresa, String tipo_perfil, String username, String pass, String nombres, String apellido1, String apellido2, String correo, String telefono, String direccion, String documento, String fecha_registro) {
        this.id = id;
        this.tipo_perfil = tipo_perfil;
        this.username = username;
        this.pass = pass;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.documento = documento;
        this.fecha_registro = fecha_registro;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_perfil() {
        return tipo_perfil;
    }

    public void setTipo_perfil(String tipo_perfil) {
        this.tipo_perfil = tipo_perfil;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", tipo_perfil=" + tipo_perfil + ", username=" + username + ", pass=" + pass + ", nombres=" + nombres + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", correo=" + correo + ", telefono=" + telefono + ", direccion=" + direccion + ", documento=" + documento + ", fecha_registro=" + fecha_registro + '}';
    }

    
}
