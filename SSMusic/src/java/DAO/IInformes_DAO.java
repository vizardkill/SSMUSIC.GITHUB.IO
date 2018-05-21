/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Empresa;
import Modelo.Informes;
import java.util.ArrayList;

/**
 *
 * @author SNT
 */
public interface IInformes_DAO {
    public ArrayList<Informes> getInformeOperaciones();
    public ArrayList<Informes> getInformeVentasTArtista();
    public ArrayList<Informes> getInformeVentasTEmpresa();
    public ArrayList<Informes> getInformeVentasEmpresa();
    public ArrayList<Informes> getInformeVentasArtistasRangoFecha(Informes info);
}
