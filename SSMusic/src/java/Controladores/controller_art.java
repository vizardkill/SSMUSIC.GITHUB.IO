/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DAO_Artista;
import DAO.IArtista_DAO;
import Modelo.Artista;
import java.util.ArrayList;

/**
 *
 * @author scardonas
 */
public class controller_art {

    public controller_art() {
    }

    public boolean registerArt(Artista art) {
        IArtista_DAO adao = new DAO_Artista();
        boolean result = adao.setArtista(art);
        return result;
    }

    public void updateUser(Artista art) {
        IArtista_DAO adao = new DAO_Artista();
        adao.updateArtista(art);
    }

    public void deleteUser(Artista art) {
        IArtista_DAO adao = new DAO_Artista();
        adao.deleteArtista(art);
    }

    public ArrayList<Artista> getUsers() {
        ArrayList<Artista> arts = new ArrayList<>();
        IArtista_DAO adao = new DAO_Artista();
        arts = adao.getArtistas();
        return arts;
    }
}
