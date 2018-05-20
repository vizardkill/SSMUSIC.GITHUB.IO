/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.DBUtil;
import Modelo.Operacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Softcaribbean-DEV2
 */
public class DAO_Operacion implements IOperacion_DAO {

    @Override
    public boolean setOperacion(Operacion Op) {
        Connection con;
        String sql = "INSERT INTO VENTAS"
                + "("
                + "ID_VENTAS, "
                + "ID_ARTISTA_VE, "
                + "CANTIDAD_OPERACIONES, "
                + "VALOR_VENTA, "
                + "FECHA_VENTA "
                + ") "
                + "VALUES(?,?,?,?,?)";

        try {
            con = DBUtil.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, 1);
                ps.setInt(2, Op.getID_ARTISTA_VE());
                ps.setInt(3, Op.getCANTIDAD_OPERACIONES());
                ps.setLong(4, Op.getVALOR_VENTA());
                ps.setString(5, Op.getFECHA_VENTA());
                ps.executeQuery();
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error: Clase DAO_Operacion, método registrar: " + ex);
            return false;
        }
        return true;
    }

    @Override
    public List<Operacion> getOperacion() {
        Connection co;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM VENTAS ORDER BY CANTIDAD_OPERACIONES";

        ArrayList<Operacion> listaEmpresa = new ArrayList();

        try {
            co = DBUtil.getConexion();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Operacion o = new Operacion();
                o.setID_VENTAS(rs.getInt("ID_VENTAS"));
                o.setID_ARTISTA_VE(rs.getInt("ID_ARTISTA_VE"));
                o.setCANTIDAD_OPERACIONES(rs.getInt("CANTIDAD_OPERACIONES"));
                o.setVALOR_VENTA(rs.getLong("VALOR_VENTA"));
                o.setFECHA_VENTA(rs.getString("FECHA_VENTA"));
                listaEmpresa.add(o);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Empresa, método obtener");
        }
        return listaEmpresa;
    }

}
