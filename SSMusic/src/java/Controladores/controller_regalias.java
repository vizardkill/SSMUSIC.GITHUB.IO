/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DAO_Regalias;
import DAO.IRegalias_DAO;
import Metodos.Calendario;
import Modelo.Empresa;
import Modelo.Regalias;
import java.util.List;

/**
 *
 * @author Softcaribbean-DEV2
 */
public class controller_regalias {

    public boolean setRegalias(Regalias reg) {
        IRegalias_DAO edao = new DAO_Regalias();
        boolean result = edao.setRegalia(reg);
        return result;
    }

    public List<Regalias> getRegalias() {
        IRegalias_DAO edao = new DAO_Regalias();
        List<Regalias> reg = edao.getRegalias();
        return reg;
    }

    public List<Regalias> getParametros() {
        IRegalias_DAO edao = new DAO_Regalias();
        List<Regalias> reg = edao.getParametros();
        return reg;
    }

    public boolean getCandidatosRegalias(Regalias reg) {
        Calendario fechaR = new Calendario();
        String FECHA_REGISTRO = fechaR.Fecha_Registro();
        IRegalias_DAO edao = new DAO_Regalias();
        boolean result = false;

        List<Regalias> regalia = edao.getCandidatosRegalias(reg);
        List<Regalias> parametros = this.getParametros();
        for (Regalias x : regalia) {
            boolean flag = false;
            for (Regalias param : parametros) {

                
                     if (x.getTotal_operaciones() > param.getCondicion_reg() && flag == false) {
                        Regalias newReg = new Regalias();
                        newReg.setId_reg(1);
                        newReg.setId_art(x.getId_art());
                        newReg.setFecha_actual(FECHA_REGISTRO);
                        newReg.setTipo_reg("1");
                        result = this.setRegalias(newReg);
                        flag = true;
                    }

                 
                    if (x.getTotal_operaciones() > param.getCondicion_reg() && flag == false) {
                        Regalias newReg = new Regalias();
                        newReg.setId_reg(0);
                        newReg.setId_art(x.getId_art());
                        newReg.setFecha_actual(FECHA_REGISTRO);
                        newReg.setTipo_reg("2");
                        result = this.setRegalias(newReg);
                        flag=true;

                    }
                    
                   

                

            }

        }
        return result;
    }

}
