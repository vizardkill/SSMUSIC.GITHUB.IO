/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Regalias;
import java.util.ArrayList;

/**
 *
 * @author Softcaribbean-DEV2
 */
public interface IRegalias_DAO {
    public boolean setRegalia(Regalias reg);
    public ArrayList<Regalias> getRegalias();
    public ArrayList<Regalias> getCandidatosRegalias(Regalias reg);
    public ArrayList<Regalias> getParametros();
}
