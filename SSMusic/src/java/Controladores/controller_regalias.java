/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DAO_Regalias;
import DAO.IRegalias_DAO;
import Metodos.Calendario;
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
        Regalias discos = new Regalias();
        boolean result = false;

        List<Regalias> regalia = edao.getCandidatosRegalias(reg);
        System.out.println(regalia);
        List<Regalias> parametros = this.getParametros();
        for (Regalias regaliaparam : parametros) {
            if (regaliaparam.getNom_condicion().equals("ORO")) {
                discos.setId_param_oro(regaliaparam.getId_reg());
                discos.setCondicion_oro(regaliaparam.getCondicion_reg());
            } else if (regaliaparam.getNom_condicion().equals("PLATINO")) {
                discos.setId_param_platino(regaliaparam.getId_reg());
                discos.setCondicion_platino(regaliaparam.getCondicion_reg());
            }
        }
        for (Regalias x : regalia) {
           
            IRegalias_DAO rdao = new DAO_Regalias();
            if (x.getTotal_operaciones() > discos.getCondicion_platino()) {
                Regalias newReg = new Regalias();

                newReg.setId_art(x.getId_art());
                newReg.setFecha_actual(FECHA_REGISTRO);
                newReg.setId_reg(discos.getId_param_platino());
                result = rdao.setRegalia(newReg);
                System.out.println("platino devuelve: " + result);

            } else {
                if (x.getTotal_operaciones() > discos.getCondicion_oro()) {
                    Regalias newReg = new Regalias();

                    newReg.setId_art(x.getId_art());
                    newReg.setFecha_actual(FECHA_REGISTRO);
                    newReg.setId_reg(discos.getId_param_oro());
                    result = rdao.setRegalia(newReg);
                    System.out.println("oro devuelve: " + result);
                }
            }

        }
        return result;
    }

}
