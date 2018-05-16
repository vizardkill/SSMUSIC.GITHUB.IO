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
public class Log {
    private int id_log;
    private int id_usuario_log;
    private String tipo_de_gestion;
    private String fecha_log;

    public Log() {
    }

    public Log(int id_log, int id_usuario_log, String tipo_de_gestion, String fecha_log) {
        this.id_log = id_log;
        this.id_usuario_log = id_usuario_log;
        this.tipo_de_gestion = tipo_de_gestion;
        this.fecha_log = fecha_log;
    }

    

    public int getId_log() {
        return id_log;
    }

    public void setId_log(int id_log) {
        this.id_log = id_log;
    }

    public int getId_usuario_log() {
        return id_usuario_log;
    }

    public void setId_usuario_log(int id_usuario_log) {
        this.id_usuario_log = id_usuario_log;
    }

    public String getTipo_de_gestion() {
        return tipo_de_gestion;
    }

    public void setTipo_de_gestion(String tipo_de_gestion) {
        this.tipo_de_gestion = tipo_de_gestion;
    }

    public String getFecha_log() {
        return fecha_log;
    }

    public void setFecha_log(String fecha_log) {
        this.fecha_log = fecha_log;
    }
}
