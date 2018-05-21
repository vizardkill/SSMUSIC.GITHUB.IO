/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.DBUtil;
import Modelo.Regalias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Softcaribbean-DEV2
 */
public class DAO_Regalias implements IRegalias_DAO{
    
    @Override
    public boolean setRegalia(Regalias reg) {
        Connection con;
        String sql = "INSERT INTO REGALIAS"
                + "("
                + "ID_REG, "
                + "ID_ARTISTA_REG, "
                + "VALOR_TOTAL, "
                + "TIPO_DE_REGALIA "
                + ") "
                + "VALUES(?,?,?,?)";

        try {
            con = DBUtil.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                System.out.println("id reg"+reg.getId_reg()+"id art: "+reg.getId_art()+"tipo reg:"+reg.getTipo_reg());
                ps.setInt(1, reg.getId_reg());
                ps.setInt(2,reg.getId_art());
                 ps.setInt(3, 5);
                ps.setString(4, reg.getTipo_reg());
                
                ps.executeUpdate();
                ps.close();
            }
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error: Clase DAO_Regalias, método registrar" + ex);
            return false;
        }

        return true;
    }
    
    @Override
    public ArrayList<Regalias> getRegalias() {
        Connection co;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM REGALIAS";
        ArrayList<Regalias> listaReg = new ArrayList<>();

        try {
            co = DBUtil.getConexion();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Regalias reg = new Regalias();
                reg.setId_art(rs.getInt("ID_REG"));
                reg.setId_art(rs.getInt("ID_ART"));
                reg.setTipo_reg(rs.getString("TIPO_DE_REGALIA"));
                listaReg.add(reg);
            }
            stm.close();
            rs.close();
            co.close();

        } catch (SQLException ex) {
            System.out.println("Error: Clase DAO_Regalias, método obtener");
        }
        return listaReg;
    }
    
     @Override
    public ArrayList<Regalias> getCandidatosRegalias(Regalias reg) {
        Connection co;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT  VENTAS.ID_ARTISTA_VE AS ID_ART,\n" +
"        ARTISTA.ID_EMPRESA_D_ART as ID_EMP,\n" +
"        SUM(VENTAS.CANTIDAD_OPERACIONES) AS TOTAL_OPERACIONES\n" +
"        FROM VENTAS\n" +
"        INNER JOIN ARTISTA ON VENTAS.ID_ARTISTA_VE = ARTISTA.ID_ARTISTA\n" +
"WHERE VENTAS.FECHA_VENTA >= TO_DATE(?,'MM/DD/YYYY')\n" +
"AND VENTAS.FECHA_VENTA <= TO_DATE(?,'MM/DD/YYYY') \n" +
"GROUP BY ID_ARTISTA_VE, ID_EMPRESA_D_ART\n" +
"HAVING COUNT(*) >= 1";

        ArrayList<Regalias> ListInforme = new ArrayList();

        try {
            co = DBUtil.getConexion();
            
            PreparedStatement ps = co.prepareStatement(sql);
            ps.setString(1, reg.getFecha_ini());
            ps.setString(2, reg.getFecha_fin());
            rs = ps.executeQuery();
            while (rs.next()) {
                Regalias u = new Regalias();
                u.setId_emp(rs.getInt("ID_EMP"));
                u.setId_art(rs.getInt("ID_ART"));
                u.setTotal_operaciones(rs.getInt("TOTAL_OPERACIONES"));
                ListInforme.add(u);
            }
            
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Regalias, método getInformeVentasEmpresa: " +e);
        }
        return ListInforme;
    }
    
    @Override
    public ArrayList<Regalias> getParametros() {
        Connection co;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM TIPO_REGALIA";
        ArrayList<Regalias> listaReg = new ArrayList();

        try {
            co = DBUtil.getConexion();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Regalias reg = new Regalias();
               reg.setCondicion_reg(rs.getInt("CONDICION_REG"));
               reg.setNom_condicion(rs.getString("NOM_TREG"));
                listaReg.add(reg);
            }
            stm.close();
            rs.close();
            co.close();

        } catch (SQLException ex) {
            System.out.println("Error: Clase DAO_Regalias, método getParametros");
        }
        return listaReg;
    }
    
}
