/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.DBUtil;
import Modelo.Log;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Softcaribbean-DEV2
 */
public class DAO_Log implements ILog_DAO {

    @Override
    public boolean setLog(Log log) {
        Connection con;
        
        String sql = "INSERT INTO LOG"
                + "("
                + "ID_LOG, "
                + "ID_USUARIO_LOG, "
                + "TIPO_DE_GESTION, "
                + "FECHA_LOG"
                + ") "
                + "VALUES(?,?,?,?)";
        try {
            con = DBUtil.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, 1);
                ps.setInt(2, log.getId_usuario_log());
                ps.setString(3, log.getTipo_de_gestion());
                ps.setString(4, "05/03/2018");

                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error: Clase DAO_Empresa, método registrar");
            return false;
        }
        return true;

    }
}
