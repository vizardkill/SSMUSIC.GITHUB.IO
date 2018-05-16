/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Artista;
import Modelo.Log;
import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author clan-
 */
public class DAO_ArtistaNGTest {

    public DAO_ArtistaNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of setArtista method, of class DAO_Artista.
     */
    @Test
    public void testSetArtistaTrue() {
        System.out.println("setArtista");
        Artista art = new Artista();
        art.setId(0);
        art.setNombre_art("SSPapu");
        art.setNom_representante("Fabio Italino");
        art.setDoc_representante("1020479050");
        art.setTel_representante("3024209853");
        art.setCor_representante("cardona0496@gamil.com");
        art.setId_empresa_d_art(57);
        art.setFecha_registro_art("18/04/2018");
        DAO_Artista instance = new DAO_Artista();
        boolean expResult = true;
        boolean result = instance.setArtista(art);
        assertEquals(result, expResult);
    }

    /**
     * Test of getArtistas method, of class DAO_Artista.
     */
    @Test
    public void testGetArtistas() {
        System.out.println("getArtistas");
        DAO_Artista instance = new DAO_Artista();
        ArrayList<Artista> listaArtista = instance.getArtistas();
        boolean result;
        if (listaArtista.isEmpty()) {
            result = false;
        } else {
            result = true;
        }
        boolean expResult = true;
        assertEquals(result, expResult);
    }

    /**
     * Test of deleteArtista method, of class DAO_Artista.
     */
    @Test
    public void testDeleteArtista() {
        System.out.println("deleteArtista");
        Artista art = new Artista();
        art.setId(1);
        DAO_Artista instance = new DAO_Artista();
        boolean expResult = true;
        boolean result = instance.deleteArtista(art);
        assertEquals(result, expResult);
    }

    /**
     * Test of updateArtista method, of class DAO_Artista.
     */
    @Test
    public void testUpdateArtista() {
        System.out.println("updateArtista");
        Artista art = new Artista();
        art.setId(0);
        art.setNombre_art("NUEVO ");
        art.setNom_representante("NUEVO");
        art.setDoc_representante("1020479050");
        art.setTel_representante("3024209853");
        art.setCor_representante("NUEVO@gamil.com");
        art.setId_empresa_d_art(1);
        art.setFecha_registro_art("18/04/2018");
        DAO_Artista instance = new DAO_Artista();
        boolean expResult = true;
        boolean result = instance.updateArtista(art);
        assertEquals(result, expResult);
    }

}
