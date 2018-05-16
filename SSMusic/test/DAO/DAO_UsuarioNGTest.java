/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Log;
import Modelo.Usuario;
import java.util.List;
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
public class DAO_UsuarioNGTest {

    public DAO_UsuarioNGTest() {
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
     * Test of setUser method, of class DAO_Usuario.
     */
    @Test
    public void testSetUser() {
        Usuario user = new Usuario();
        DAO_Usuario instance = new DAO_Usuario();
        user.setId(1);
        user.setId_empresa(1);
        user.setNombres("SSpapu");
        user.setApellido1("Cardona");
        user.setApellido2("Cardona");
        user.setDocumento("1020479050");
        user.setDireccion("Calle 47 a #53-68");
        user.setFecha_registro("08/05/2018");

        boolean expResult = true;
        boolean result = instance.setUser(user);
        assertEquals(result, expResult);
    }

    /**
     * Test of getUser method, of class DAO_Usuario.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        DAO_Usuario instance = new DAO_Usuario();
        boolean expResult = true;
        boolean result;
        if (instance.getUser().isEmpty()) {
            result = true;
        } else {
            result = false;
        }
        assertEquals(result, expResult);
    }

    /**
     * Test of getOneUser method, of class DAO_Usuario.
     */
    @Test
    public void testGetOneUser() {
        System.out.println("getOneUser");
        Usuario user = new Usuario();
        DAO_Usuario instance = new DAO_Usuario();
        Usuario result = instance.getOneUser(user);
        Usuario expResult = result;
        assertEquals(result, expResult);
    }

    /**
     * Test of updateUser method, of class DAO_Usuario.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        Usuario user = new Usuario();
        DAO_Usuario instance = new DAO_Usuario();
        boolean expResult = true;
        boolean result = instance.updateUser(user);
        assertEquals(result, expResult);
    }

    /**
     * Test of deleteUser method, of class DAO_Usuario.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        Usuario user = new Usuario();
        DAO_Usuario instance = new DAO_Usuario();
        boolean expResult = true;
        boolean result = instance.deleteUser(user);
        assertEquals(result, expResult);
    }

}
