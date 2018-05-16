/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DAO_Log;
import DAO.ILog_DAO;
import Modelo.Log;

/**
 *
 * @author Softcaribbean-DEV2
 */
public class controller_log {

    public controller_log() {
    }
    
    public boolean registerLog(Log log){
        ILog_DAO udao = new DAO_Log();
        boolean result = udao.setLog(log);
        return result;
    }
}
