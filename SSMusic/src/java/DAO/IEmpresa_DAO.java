/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Empresa;
import Modelo.Log;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clan-
 */
public interface IEmpresa_DAO {

    public boolean setEmpresa(Empresa emp);

    public ArrayList<Empresa> getEmpresa();

    public boolean updateEmpresa(Empresa emp);

    public boolean deleteEmpresa(Empresa emp);
}
