/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.DBUtil;
import Controladores.controller_log;
import Metodos.Calendario;
import Modelo.Log;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author scardonas
 */
public class DAO_Usuario implements IUsuario_DAO {

    @Override
    public Boolean setUser(Usuario user) {
        boolean registrar = true;
        
        Connection con = null;
        String sql = "INSERT INTO USUARIO"
                + "("
                + "ID_USUARIO, "
                + "ID_EMPRESA_U, "
                + "TIPO_PERFIL, "
                + "USERNAME, "
                + "PASS, "
                + "NOMBRES, "
                + "APELLIDO1, "
                + "APELLIDO2, "
                + "DOCUMENTO, "
                + "CORREO, "
                + "TELEFONO, "
                + "DIRECCION, "
                + "FECHA_REGISTRO"
                + ") "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            con = DBUtil.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user.getId());
            ps.setInt(2, user.getId_empresa());
            ps.setString(3, user.getTipo_perfil());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPass());
            ps.setString(6, user.getNombres());
            ps.setString(7, user.getApellido1());
            ps.setString(8, user.getApellido2());
            ps.setString(9,user.getDocumento());
            ps.setString(10, user.getCorreo());
            ps.setString(11, user.getTelefono());
            ps.setString(12, user.getDireccion());
            ps.setString(13, user.getFecha_registro());
            System.out.println("Ps: "+ps);
            System.out.println("sql: "+sql);
            ps.executeQuery();
            ps.close();
            con.close();
            
            controller_log ldao=new controller_log();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Usuario, método registrar");
            e.printStackTrace();
            return registrar = false;
        } 
        
        return registrar;
    }

    @Override
    public List<Usuario> getUser() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM USUARIO ORDER BY TIPO_PERFIL";

        List<Usuario> listaUsuario = new ArrayList<Usuario>();

        try {
            co = DBUtil.getConexion();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("ID_PERFIL"));
                u.setTipo_perfil(rs.getString("TIPO_PERFIL"));
                u.setUsername(rs.getString("USERNAME"));
                u.setPass(rs.getString("PASS"));
                u.setNombres(rs.getString("NOMBRES"));
                u.setApellido1(rs.getString("APELLIDO1"));
                u.setApellido2(rs.getString("APELLIDO2"));
                u.setDocumento(rs.getString("DOCUMENTO"));
                u.setCorreo(rs.getString("CORREO"));
                u.setTelefono(rs.getString("TELEFONO"));
                u.setDireccion(rs.getString("DIRECCION"));
                u.setFecha_registro(rs.getString("FECHA_REGISTRO"));
                listaUsuario.add(u);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_USUARIO, método obtener");
            e.printStackTrace();
        }

        return listaUsuario;
    }
    
    @Override
    public Usuario getOneUser(Usuario user) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        System.out.println("LLego al dao: "+ user);
        String sql = "SELECT ID_USUARIO,ID_EMPRESA_U,TIPO_PERFIL,USERNAME,PASS,NOMBRES,APELLIDO1,APELLIDO2,DOCUMENTO,CORREO,TELEFONO,DIRECCION,FECHA_REGISTRO FROM USUARIO WHERE USERNAME=? AND PASS=?";

        Usuario listaUsuario = new Usuario();

        try {
            co = DBUtil.getConexion();
            PreparedStatement ps = co.prepareStatement(sql);
            
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPass());
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("ID_USUARIO"));
                u.setTipo_perfil(rs.getString("TIPO_PERFIL"));
                u.setUsername(rs.getString("USERNAME"));
                u.setPass(rs.getString("PASS"));
                u.setNombres(rs.getString("NOMBRES"));
                u.setApellido1(rs.getString("APELLIDO1"));
                u.setApellido2(rs.getString("APELLIDO2"));
                u.setDocumento(rs.getString("DOCUMENTO"));
                u.setCorreo(rs.getString("CORREO"));
                u.setTelefono(rs.getString("TELEFONO"));
                u.setDireccion(rs.getString("DIRECCION"));
                u.setFecha_registro(rs.getString("FECHA_REGISTRO"));
                listaUsuario = u;
                System.out.println("Objeto u: "+u);
            }
            System.out.println("objeto listaUsuario: "+listaUsuario);
            
            
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_USUARIO, método obtener");
            e.printStackTrace();
        }finally{
           
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                co.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listaUsuario;
    }

    @Override
    public boolean updateUser(Usuario user) {
        boolean actualizar = false;
        Connection con = null;

        String sql = "UPDATE USUARIO SET TIPO_PERFIL = ?, "
                + "PASS = ?, "
                + "NOMBRES = ?, "
                + "APELLIDO1 = ?, "
                + "APELLIDO2 = ?, "
                + "CORREO = ?, "
                + "TELEFONO = ?, "
                + "DIRECCION = ? "
                + "WHERE DOCUMENTO = ?";
        try {
            con = DBUtil.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getTipo_perfil());
            ps.setString(2, user.getPass());
            ps.setString(3, user.getNombres());
            ps.setString(4, user.getApellido1());
            ps.setString(5, user.getApellido2());
            ps.setString(6, user.getCorreo());
            ps.setString(7, user.getTelefono());
            ps.setString(8, user.getDireccion());
            ps.setString(9, user.getDocumento());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_USUARIO, método actualizar");
            e.printStackTrace();
        }
        actualizar = true;
        return actualizar;
    }

    @Override
    public boolean deleteUser(Usuario user) {
        boolean eliminar = false;
        Connection con = null;

        String sql = "DELETE FROM USUARIO WHERE DOCUMENTO = ?";
        
        try {
            con = DBUtil.getConexion();;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getDocumento());
            ps.executeQuery();
            ps.close();
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método eliminar");
            e.printStackTrace();
        }
        return eliminar;

    }

}
