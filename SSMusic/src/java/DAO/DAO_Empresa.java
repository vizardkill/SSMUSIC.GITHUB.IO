/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.DBUtil;
import Controladores.controller_log;
import Modelo.Artista;
import Modelo.Empresa;
import Modelo.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author clan-
 */
public class DAO_Empresa implements IEmpresa_DAO {

    @Override
    public boolean setEmpresa(Empresa emp) {
        Connection con;
        String sql = "INSERT INTO EMPRESA_DIFUSORA"
                + "("
                + "ID_EMPRESA_D, "
                + "ID_EMAYOR, "
                + "NIT_EMPRESA_D, "
                + "NOM_EMPRESA_D, "
                + "NOM_ENCARGADO_D, "
                + "DOC_ENCARGADO_D, "
                + "TEL_ENCARGADO_D, "
                + "COR_ENCARGADO_D, "
                + "TIPO_OPERACION_D, "
                + "VALOR_OPERACION_D, "
                + "FECHA_REGISTRO_D"
                + ") "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = DBUtil.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, 1);
                ps.setInt(2, emp.getId_emp_ma());
                ps.setString(3, emp.getNIT_emp());
                ps.setString(4, emp.getNom_emp());
                ps.setString(5, emp.getNom_encargado());
                ps.setString(6, emp.getDoc_encargado());
                ps.setString(7, emp.getTel_encargado());
                ps.setString(8, emp.getCor_encargado());
                ps.setString(9, emp.getTipo_operacion());
                ps.setDouble(10, emp.getValor_operacion());
                ps.setString(11, emp.getFecha_registro());
                ps.executeUpdate();
                ps.close();
            }
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error: Clase DAO_Empresa, método registrar" + ex);
            return false;
        }

        return true;
    }

    @Override
    public ArrayList<Empresa> getEmpresa() {
        Connection co;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM EMPRESA_DIFUSORA ORDER BY NOM_EMPRESA_D";

        ArrayList<Empresa> listaEmpresa = new ArrayList();

        try {
            co = DBUtil.getConexion();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Empresa u = new Empresa();
                u.setId_emp(rs.getInt("ID_EMPRESA_D"));
                u.setId_emp_ma(rs.getInt("ID_EMAYOR"));
                u.setNIT_emp(rs.getString("NIT_EMPRESA_D"));
                u.setNom_emp(rs.getString("NOM_EMPRESA_D"));
                u.setNom_encargado(rs.getString("NOM_ENCARGADO_D"));
                u.setDoc_encargado(rs.getString("DOC_ENCARGADO_D"));
                u.setTel_encargado(rs.getString("TEL_ENCARGADO_D"));
                u.setCor_encargado(rs.getString("COR_ENCARGADO_D"));
                u.setTipo_operacion(rs.getString("TIPO_OPERACION_D"));
                u.setValor_operacion(rs.getDouble("VALOR_OPERACION_D"));
                u.setFecha_registro(rs.getString("FECHA_REGISTRO_D"));
                listaEmpresa.add(u);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Empresa, método obtener");
        }
        return listaEmpresa;
    }

    @Override
    public boolean deleteEmpresa(Empresa emp) {
        Connection con;

        String sql = "DELETE FROM EMPRESA_DIFUSORA WHERE ID_EMPRESA_D = ?";

        try {
            con = DBUtil.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, emp.getId_emp());
                ps.executeUpdate();
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Empresa, método eliminar");
            return false;
        }
        return true;
    }

    @Override
    public boolean updateEmpresa(Empresa emp) {
        Connection con;
        String sql = "UPDATE INTO EMPRESA_DIFUSORA SET "
                + "NIT_EMPRESA_D = ?, "
                + "NOM_EMPRESA_D = ?, "
                + "NOM_ENCARGADO_D = ?, "
                + "DOC_ENCARGADO_D = ?, "
                + "TEL_ENCARGADO_D = ?, "
                + "COR_ENCARGADO_D = ?, "
                + "TIPO_OPERACION_D = ?, "
                + "VALOR_OPERACION_D = ? "
                + "WHERE ID_EMPRESA_D = ?";
        try {
            con = DBUtil.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, emp.getNIT_emp());
                ps.setString(2, emp.getNom_emp());
                ps.setString(3, emp.getNom_encargado());
                ps.setString(4, emp.getDoc_encargado());
                ps.setString(5, emp.getTel_encargado());
                ps.setString(6, emp.getCor_encargado());
                ps.setString(7, emp.getTipo_operacion());
                ps.setDouble(8, emp.getValor_operacion());
                ps.setInt(9, emp.getId_emp());

                ps.executeUpdate();
                ps.close();
            }
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error: Clase DAO_Empresa, método registrar" + ex);
            return false;
        }

        return true;
    }
}
