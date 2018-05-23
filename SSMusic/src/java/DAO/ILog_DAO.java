/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Log;
import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author Softcaribbean-DEV2
 */
public interface ILog_DAO {
    public boolean setLog(Log log);
    public List<Log> getLog();
}
