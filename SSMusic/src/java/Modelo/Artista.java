/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author scardonas
 */
public class Artista {
    private int id;
    private String nombre_art; 
    private String nom_representante;
    private String doc_representante;
    private String tel_representante;
    private String cor_representante;
    private int id_empresa_d_art;
    private String fecha_registro_art;
    private String src;


    public Artista(int id, String nombre_art, String nom_representante, String doc_representante, String tel_representante, String cor_representante, int id_empresa_d_art, String fecha_registro_art, String src) {
        this.id = id;
        this.nombre_art = nombre_art;
        this.nom_representante = nom_representante;
        this.doc_representante = doc_representante;
        this.tel_representante = tel_representante;
        this.cor_representante = cor_representante;
        this.id_empresa_d_art = id_empresa_d_art;
        this.fecha_registro_art = fecha_registro_art;
        this.src = src;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getId_empresa_d_art() {
        return id_empresa_d_art;
    }

    public void setId_empresa_d_art(int id_empresa_d_art) {
        this.id_empresa_d_art = id_empresa_d_art;
    }

    public String getFecha_registro_art() {
        return fecha_registro_art;
    }

    public void setFecha_registro_art(String fecha_registro_art) {
        this.fecha_registro_art = fecha_registro_art;
    }

    public Artista() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_art() {
        return nombre_art;
    }

    public void setNombre_art(String nombre_art) {
        this.nombre_art = nombre_art;
    }

    public String getNom_representante() {
        return nom_representante;
    }

    public void setNom_representante(String nom_representante) {
        this.nom_representante = nom_representante;
    }

    public String getDoc_representante() {
        return doc_representante;
    }

    public void setDoc_representante(String doc_representante) {
        this.doc_representante = doc_representante;
    }

    public String getTel_representante() {
        return tel_representante;
    }

    public void setTel_representante(String tel_representante) {
        this.tel_representante = tel_representante;
    }

    public String getCor_representante() {
        return cor_representante;
    }

    public void setCor_representante(String cor_representante) {
        this.cor_representante = cor_representante;
    }

    @Override
    public String toString() {
        return "Artista{" + "id=" + id + ", nombre_art=" + nombre_art + ", nom_representante=" + nom_representante + ", doc_representante=" + doc_representante + ", tel_representante=" + tel_representante + ", cor_representante=" + cor_representante + '}';
    }
    
}
