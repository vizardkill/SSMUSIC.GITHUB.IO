/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Empresa;
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
public class DAO_EmpresaNGTest {

    public DAO_EmpresaNGTest() {
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
     * Test of setEmpresa method, of class DAO_Empresa.
     */
    @Test
    public void testRegistrarEmpresaTrue() {
        System.out.println("Test de Registrar Empresa True");
        Empresa emp = new Empresa();
        emp.setId_emp(1);
        emp.setId_emp_ma(1);
        emp.setNom_emp("Youtube");
        emp.setNIT_emp("1234");
        emp.setNom_encargado("Santiago Robledo");
        emp.setDoc_encargado("102657788");
        emp.setTel_encargado("2658995");
        emp.setCor_encargado("snroble@gmail.com");
        emp.setTipo_operacion("Reproduccion");
        emp.setValor_operacion(2);
        emp.setFecha_registro("18/04/2018");

        DAO_Empresa instance = new DAO_Empresa();
        boolean expResult = true;
        boolean result = instance.setEmpresa(emp);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testRegistrarEmpresaFalse() {
         System.out.println("Test de Registrar Empresa False");
        Empresa emp = new Empresa();
        emp.setId_emp(1);
        emp.setId_emp_ma(2);
        emp.setNom_emp("iTunes");
        emp.setNIT_emp("1234");
        emp.setNom_encargado("Santiago Robledo");
        emp.setDoc_encargado("102657788");
        emp.setTel_encargado("2658995");
        emp.setCor_encargado("snroble@gmail.com");
        emp.setTipo_operacion("Reproduccion");
        emp.setValor_operacion(4);
        emp.setFecha_registro("18/04/2018");

        DAO_Empresa instance = new DAO_Empresa();
        boolean expResult = true;
        boolean result = instance.setEmpresa(emp);
        assertEquals(result, expResult);
    }

    @Test
    public void DeleteEmpresaTrue() {
        System.out.println("Test de DeleteEmpresa True");
        Empresa emp = new Empresa();
        emp.setId_emp(1);
        DAO_Empresa instance = new DAO_Empresa();
        boolean expResult = true;
        boolean result = instance.deleteEmpresa(emp);
        assertEquals(expResult, result);
    }

    @Test
    public void DeleteEmpresaFalse() {
        System.out.println("Test de DeleteEmpresa False");
        Empresa emp = new Empresa();
        emp.setId_emp(-98);
        DAO_Empresa instance = new DAO_Empresa();
        boolean expResult = true;
        boolean result = instance.deleteEmpresa(emp);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateEmpresa method, of class controller_emp.
     */
    @Test
    public void testUpdateEmpresaFalse() {
        System.out.println("Test de Actualizar Empresa False");
        Empresa emp = new Empresa();

        emp.setId_emp(2);
        emp.setId_emp_ma(1);
        emp.setNIT_emp("45233");
        emp.setNom_emp("Youtube");
        emp.setNom_encargado("Santiago Robledo");
        emp.setDoc_encargado("102657788");
        emp.setTel_encargado("2658995");
        emp.setCor_encargado("snroble@gmail.com");
        emp.setTipo_operacion("Reproduccion");
        emp.setValor_operacion(2);
        emp.setFecha_registro("18/04/2018");

        DAO_Empresa instance = new DAO_Empresa();
        boolean expResult = true;
        boolean result = instance.updateEmpresa(emp);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateEmpresaTrue() {
        System.out.println("Test de Actualizar Empresa True");
        Empresa emp = new Empresa();

        emp.setId_emp(2);
        emp.setId_emp_ma(1);
        emp.setNIT_emp("45233");
        emp.setNom_emp("Youtube");
        emp.setNom_encargado("Santiago Robledo");
        emp.setDoc_encargado("102657788");
        emp.setTel_encargado("2658995");
        emp.setCor_encargado("snroble@gmail.com");
        emp.setTipo_operacion("Reproduccion");
        emp.setValor_operacion(4);
        emp.setFecha_registro("18/04/2018");

        DAO_Empresa instance = new DAO_Empresa();
        boolean expResult = true;
        boolean result = instance.updateEmpresa(emp);
        assertEquals(expResult, result);
    }

}
