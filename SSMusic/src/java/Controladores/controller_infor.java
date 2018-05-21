/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DAO_Informes;
import DAO.IInformes_DAO;
import Modelo.Informes;
import java.util.List;

/**
 *
 * @author SNT
 */
public class controller_infor {
     public controller_infor() {
    }

     public List<Informes> getInformeOperaciones() {
        IInformes_DAO edao = new DAO_Informes();
        List<Informes> emps = edao.getInformeOperaciones();
        return emps;
    }
     
     public List<Informes> getInformeVentasTArtista() {
        IInformes_DAO edao = new DAO_Informes();
        List<Informes> emps = edao.getInformeVentasTArtista();
        return emps;
    }
     public List<Informes> getInformeVentasTEmpresa() {
        IInformes_DAO edao = new DAO_Informes();
        List<Informes> emps = edao.getInformeVentasTEmpresa();
        return emps;
    }
     public List<Informes> getInformeVentasEmpresa() {
        IInformes_DAO edao = new DAO_Informes();
        List<Informes> emps = edao.getInformeVentasEmpresa();
        return emps;
    }
      public List<Informes> getInformeVentasArtistasRangoFecha(Informes info) {
        IInformes_DAO edao = new DAO_Informes();
        List<Informes> emps = edao.getInformeVentasArtistasRangoFecha(info);
        return emps;
    }
}
