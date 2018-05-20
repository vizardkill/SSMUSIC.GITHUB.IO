/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Operacion;
import java.util.List;

/**
 *
 * @author Softcaribbean-DEV2
 */
public interface IOperacion_DAO {
    public boolean setOperacion(Operacion Operaciones);
    public List<Operacion> getOperacion();
    public List<Operacion> getTotalOperacion();
    
}
