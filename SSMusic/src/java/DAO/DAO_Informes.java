/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.DBUtil;
import Modelo.Informes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author SNT
 */
public class DAO_Informes implements IInformes_DAO{
    
    /**
     * Informe de Operaciones
     * @return 
     */
    @Override
    public ArrayList<Informes> getInformeOperaciones() {
        Connection co;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT *FROM OPERACIONES";

        ArrayList<Informes> ListInforme = new ArrayList();

        try {
            co = DBUtil.getConexion();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Informes u = new Informes();
                u.setID_EMP(rs.getInt("ID_EMP"));
                u.setEMP(rs.getString("EMP"));
                u.setID_ART(rs.getInt("ID_ART"));
                u.setNOM_ART(rs.getString("NOM_ART"));
                u.setTOTAL_OPERACIONES(rs.getLong("TOTAL_OPERACIONES"));
                ListInforme.add(u);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Informes, método getInformeOperaciones");
        }
        return ListInforme;
    }
    
    /**
     * Ventas Totales por artista
     * @return 
     */
    @Override
    public ArrayList<Informes> getInformeVentasTArtista() {
        Connection co;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT *FROM VENTAS_ARTISTAS";

        ArrayList<Informes> ListInforme = new ArrayList();

        try {
            co = DBUtil.getConexion();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Informes u = new Informes();
                u.setNOM_ART(rs.getString("NOM_ART"));
                u.setEMP(rs.getString("EMP"));
                u.setTOTAL_VENTAS(rs.getLong("TOTAL_VENTAS"));
                ListInforme.add(u);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Informes, método getInformeVentasTArtista");
        }
        return ListInforme;
    }
    
    /**
     * ventas totales por empresa
     * @return 
     */
    @Override
    public ArrayList<Informes> getInformeVentasTEmpresa() {
        Connection co;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT *FROM VENTAS_TOTALES_EMPRESAS";

        ArrayList<Informes> ListInforme = new ArrayList();

        try {
            co = DBUtil.getConexion();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Informes u = new Informes();
                u.setEMP(rs.getString("EMP"));
                u.setTOTAL_VENTAS(rs.getLong("TOTAL_VENTAS"));
                u.setTOTAL_OPERACIONES(rs.getLong("TOTAL_OPERACIONES"));
                ListInforme.add(u);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Informes, método getInformeVentasTEmpresa");
        }
        return ListInforme;
    }
    /**
     * ventas por empresa
     * @return 
     */
    
    @Override
    public ArrayList<Informes> getInformeVentasEmpresa() {
        Connection co;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT *FROM VENTAS_EMPRESAS";

        ArrayList<Informes> ListInforme = new ArrayList();

        try {
            co = DBUtil.getConexion();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Informes u = new Informes();
                u.setEMP(rs.getString("EMP"));
                u.setVALOR_VENTA(rs.getLong("VALOR_VENTA"));
                u.setFECHA_DE_VENTA(rs.getString("FECHA_DE_VENTA"));
                ListInforme.add(u);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Informes, método getInformeVentasEmpresa");
        }
        return ListInforme;
    }
    
}
