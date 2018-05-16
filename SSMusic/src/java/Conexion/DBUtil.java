package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtil {

    private static Connection conexion = null;

    public static Connection getConexion() {
      try {
            //  Carga el driver de la base de datos
            Class.forName("oracle.jdbc.OracleDriver");
            String nombreUsuario = "user_ssmusic";
            String password = "1234";
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            conexion = DriverManager.getConnection(url, nombreUsuario, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Exception: " + ex.getMessage());
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }

}
