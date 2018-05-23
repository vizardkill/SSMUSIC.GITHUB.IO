/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.DBUtil;
import Modelo.Log;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
                ps.setString(4, log.getFecha_log());

                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error: Clase DAO_Log, método SETlOG");
            return false;
        }
        return true;

    }
    
    @Override
    public List<Log> getLog() {
        Connection co;
        Statement stm ;
        ResultSet rs;

        String sql = "SELECT USUARIO.USERNAME,\n" +
"        LOG.TIPO_DE_GESTION,\n" +
"        LOG.FECHA_LOG\n" +
"        FROM LOG\n" +
"        INNER JOIN USUARIO ON ID_USUARIO_LOG = ID_USUARIO";

        List<Log> listaLog = new ArrayList<>();

        try {
            co = DBUtil.getConexion();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Log u = new Log();
                u.setUsername(rs.getString("USERNAME"));
                u.setTipo_de_gestion(rs.getString("TIPO_DE_GESTION"));
                u.setFecha_log(rs.getString("FECHA_LOG"));
                listaLog.add(u);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Log, método getLog");
        }

        return listaLog;
    }
}
