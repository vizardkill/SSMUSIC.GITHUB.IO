/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.DBUtil;
import Modelo.Informes;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
                u.setTOTAL_VENTAS(rs.getLong("TOTAL_VENTA"));
                u.setFECHA_DE_VENTA(rs.getString("VENTA_FECHA"));
                ListInforme.add(u);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Informes, método getInformeVentasTArtista"+e);
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
System.out.println("Entro a ventast empresa");
        String sql = "SELECT * FROM VENTAS_TOTALES_EMPRESAS";

        ArrayList<Informes> ListInforme = new ArrayList();

        try {
            co = DBUtil.getConexion();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Informes u = new Informes();
                u.setEMP(rs.getString("EMP"));
                u.setTOTAL_VENTAS(rs.getLong("TOTAL_VENTAS"));
                u.setTOTAL_OPERACIONES(rs.getLong("CANTIDAD"));
                ListInforme.add(u);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Informes, método getInformeVentasTEmpresa: "+ e);
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
        
        String sql = "SELECT * FROM VENTAS_EMPRESAS";

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
            System.out.println("Error: Clase DAO_Informes, método getInformeVentasEmpresa: " +e);
        }
        return ListInforme;
    }
    
    @Override
    public ArrayList<Informes> getInformeVentasArtistasRangoFecha(Informes info) {
        Connection co;
        Statement stm;
        ResultSet rs;
System.out.println("Valores en dao: "+info.getFecha_inicial()+" ::"+ info.getFecha_final());
        String sql = "SELECT  EMPRESA_DIFUSORA.NOM_EMPRESA_D AS EMP,\n" +
"        ARTISTA.NOM_ARTISTA AS NOM_ART,\n" +
"        VENTAS.VALOR_VENTA AS VALOR_VENTA,\n" +
"        VENTAS.FECHA_VENTA AS FECHA_DE_VENTA\n" +
"\n" +
"        FROM ARTISTA\n" +
"        INNER JOIN VENTAS ON ID_ARTISTA = ID_ARTISTA_VE\n" +
"        INNER JOIN EMPRESA_DIFUSORA ON ID_EMPRESA_D_ART = ID_EMPRESA_D\n" +
"WHERE VENTAS.FECHA_VENTA >= TO_DATE(?,'MM/DD/YYYY')\n" +
"AND VENTAS.FECHA_VENTA <= TO_DATE(?,'MM/DD/YYYY') ORDER BY EMP,VENTAS.VALOR_VENTA DESC";

        ArrayList<Informes> ListInforme = new ArrayList();

        try {
            co = DBUtil.getConexion();
            
            PreparedStatement ps = co.prepareStatement(sql);
            ps.setString(1, info.getFecha_inicial());
            ps.setString(2, info.getFecha_final());
            rs = ps.executeQuery();
            while (rs.next()) {
                Informes u = new Informes();
                u.setNOM_ART(rs.getString("NOM_ART"));
                u.setEMP(rs.getString("EMP"));
                u.setFECHA_DE_VENTA(rs.getString("FECHA_DE_VENTA"));
                u.setVALOR_VENTA(rs.getLong("VALOR_VENTA"));
                ListInforme.add(u);
            }
            
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Informes, método getInformeVentasEmpresa: " +e);
        }
        return ListInforme;
    }
    
}
