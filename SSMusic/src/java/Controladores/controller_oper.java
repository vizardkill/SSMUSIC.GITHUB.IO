/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DAO_Operacion;
import DAO.IOperacion_DAO;
import Modelo.Operacion;
import java.util.List;

/**
 *
 * @author clan-
 */
public class controller_oper {

    public controller_oper() {
    }

    public boolean setOperacion(Operacion Operaciones) {
        IOperacion_DAO oper = new DAO_Operacion();
        boolean result = oper.setOperacion(Operaciones);
        return result;

    }

    public List<Operacion> getOperaciones() {
        IOperacion_DAO odao = new DAO_Operacion();
        List<Operacion> loperacion = odao.getOperacion();
        return loperacion;
    }
    
      public List<Operacion> getTotalOperaciones() {
        IOperacion_DAO odao = new DAO_Operacion();
        List<Operacion> loperacion = odao.getTotalOperacion();
        return loperacion;
    }
    
    
    
}
