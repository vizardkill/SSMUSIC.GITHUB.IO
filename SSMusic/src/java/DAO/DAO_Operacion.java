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
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Softcaribbean-DEV2
 */
public class DAO_Operacion implements IOperacion_DAO {
    
    
    @Override
    public boolean setOperacion(Operacion Op){
       boolean result = true;
       Connection con = null;
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
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, 1);
            ps.setInt(2, Op.getID_ARTISTA_VE());
            ps.setInt(3, Op.getCANTIDAD_OPERACIONES());
            ps.setLong(4, Op.getVALOR_VENTA());
            ps.setString(5, Op.getFECHA_VENTA());
            ps.executeQuery();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error: Clase DAO_Artista, método registrar");
            ex.printStackTrace();
            result = false;
        }
       
        return result;
    };
    
    public ArrayList<Operacion> getOperaciones(){
        ArrayList list = new ArrayList();
        
        
     return list;   
    };
    
}
