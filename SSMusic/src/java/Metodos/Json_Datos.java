/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Controladores.controller_art;
import Controladores.controller_emp;
import Controladores.controller_infor;
import Controladores.controller_oper;
import Controladores.controller_regalias;
import Controladores.controller_user;
import Modelo.Empresa;
import Modelo.Informes;
import Modelo.Operacion;
import Modelo.Regalias;
import Modelo.Usuario;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clan-
 */
public class Json_Datos {

    public Json_Datos() {
    }

    public String jsonEmpresas() {
        controller_emp empresas = new controller_emp();
        List<Empresa> listEmp = empresas.getEmpresas();
        com.google.gson.JsonObject json = new JsonObject();

        JsonArray array = new JsonArray();
        for (Empresa x : listEmp) {
            JsonObject item = new JsonObject();
            //Datos de la Tabla
            item.addProperty("Id", x.getId_emp());
            item.addProperty("NIT_Empresa", x.getNIT_emp());
            item.addProperty("Nom_Empresa", x.getNom_emp());
            item.addProperty("Tipo_operacion", x.getTipo_operacion());
            item.addProperty("Valor_operacion", x.getValor_operacion());
            item.addProperty("acciones", ""
                    + "<div class='btn-group'>"
                    + "<button type='button' id='" + x.getId_emp() + "' style='width:40px; height:34px' title='Modificar Registro' class='btn btn-xs btn-primary' data-toggle='modal' data-target='#Modal_RegistrarEmp' data-id='1' data-accion='Observacion'> <i class='icon_pencil-edit'></i></button> "
                    + "<button type='button' id='" + x.getId_emp() + "' style='width:40px; height:34px' title='Eliminar Registro' class='btn btn-xs btn-danger btn_delete' name='btn_delete'><i class='icon_trash'></i></button>"
                    + "</div>");
            //Datos adicionales
            item.addProperty("DOC_ENCARGADO_D", x.getDoc_encargado());
            item.addProperty("NOM_ENCARGADO_D", x.getNom_encargado());
            item.addProperty("TEL_ENCARGADO_D", x.getTel_encargado());
            item.addProperty("COR_ENCARGADO_D", x.getCor_encargado());
            item.addProperty("FECHA_REGISTRO_D", x.getFecha_registro());
            array.add(item);

        }
        json.add("Empresas", array);
        return json.toString();
    }

    public String jsonArtistas() {
        com.google.gson.JsonObject json = new JsonObject();
        ArrayList<Modelo.Artista> list;

        controller_art adao = new controller_art();

        JsonArray array = new JsonArray();

        list = adao.getUsers();
        for (Modelo.Artista resultado : list) {

            JsonObject item = new JsonObject();

            item.addProperty("Id", resultado.getId());
            item.addProperty("img_artista", "<img src='" + resultado.getSrc() + "' class='img-responsive img-circle' style='height:30px; width:30px'>");
            item.addProperty("FECHA_REGISTRO_ART", resultado.getFecha_registro_art());
            item.addProperty("acciones", ""
                    + "<div class='btn-group'>"
                    + "<button type='button' id='" + resultado.getId() + "' style='width:40px; height:34px' title='Modificar Registro' class='btn btn-xs btn-primary' data-toggle='modal' data-target='#Modal_RegistrarEmp' data-id='1' data-accion='Observacion'> <i class='icon_pencil-edit'></i></button> "
                    + "<button type='button' id='" + resultado.getId() + "' style='width:40px; height:34px' title='Eliminar Registro' class='btn btn-xs btn-danger btn_delete' name='btn_delete'><i class='icon_trash'></i></button>"
                    + "</div>");
            resultado.getSrc();

            item.addProperty("NOM_ARTISTA", resultado.getNombre_art());
            item.addProperty("NOM_REPRESENTANTE", resultado.getNom_representante());
            item.addProperty("DOC_REPRESENTANTE", resultado.getDoc_representante());
            item.addProperty("TEL_REPRESENTANTE", resultado.getTel_representante());
            item.addProperty("COR_REPRESENTANTE", resultado.getCor_representante());
            item.addProperty("ID_EMPRESA_D_ART", resultado.getId_empresa_d_art());
            item.addProperty("src", resultado.getSrc());
            array.add(item);
        }
        json.add("Artistas", array);
        return json.toString();
    }

    public String jsonOperarios() {
        controller_user cuser = new controller_user();
        com.google.gson.JsonObject json = new JsonObject();
        List<Usuario> list = cuser.getUsers();

        JsonArray array = new JsonArray();
        for (Usuario x : list) {
            JsonObject item = new JsonObject();
            if (x.getTipo_perfil().equals("Oper")) {
                item.addProperty("Id", x.getId());
                item.addProperty("DOCUMENTO", x.getDocumento());
                item.addProperty("USERNAME", x.getUsername());
                item.addProperty("TIPO_PERFIL", x.getTipo_perfil());
                item.addProperty("FECHA_REGISTRO", x.getFecha_registro());
                item.addProperty("acciones", ""
                        + "<div class='btn-group'>"
                        + "<button type='button' id='" + x.getId() + "' style='width:40px; height:34px' title='Eliminar Registro' class='btn btn-xs btn-danger btn_delete' name='btn_delete'><i class='icon_trash'></i></button>"
                        + "</div>");
                array.add(item);
            }

        }
        json.add("Operarios", array);
        return json.toString();
    }
    
    public String jsonInformePorFecha(String tipo, Informes informe){
        controller_infor info = new controller_infor();
        com.google.gson.JsonObject json = new JsonObject();
        
        if (tipo.equals("informeArtistasPorFecha")) {
            List<Informes> list = info.getInformeVentasArtistasRangoFecha(informe);
            JsonArray array = new JsonArray();
            for (Informes x : list) {
                JsonObject item = new JsonObject();
                item.addProperty("NOM_ART", x.getNOM_ART());
                item.addProperty("EMP", x.getEMP());
                item.addProperty("FECHA_DE_VENTA", x.getFECHA_DE_VENTA());
                item.addProperty("VALOR_VENTA", x.getVALOR_VENTA());
                array.add(item);
            }
            json.add("InformePorFecha", array);
            System.out.println("Json informe: "+json.toString());
            return json.toString();

        }
        return null;
    }

    public String jsonInforme(String tipo) {
        controller_infor info = new controller_infor();
        controller_regalias reg = new controller_regalias();
        com.google.gson.JsonObject json = new JsonObject();
        if (tipo.equals("TOperaciones")) {
            List<Informes> list = info.getInformeOperaciones();
            JsonArray array = new JsonArray();
            for (Informes x : list) {
                JsonObject item = new JsonObject();
                item.addProperty("ID_EMP", x.getID_EMP());
                item.addProperty("EMP", x.getEMP());
                item.addProperty("ID_ART", x.getID_ART());
                item.addProperty("NOM_ART", x.getNOM_ART());
                item.addProperty("TOTAL_OPERACIONES", x.getTOTAL_OPERACIONES());
                array.add(item);
            }
            json.add("TOperaciones", array);
            return json.toString();

        }
        
        if (tipo.equals("informeFecha")) {
            Informes infos = new Informes();
            infos.setFecha_inicial("20/05/2018");
            infos.setFecha_final("22/05/2018");
            List<Informes> list = info.getInformeVentasArtistasRangoFecha(infos);
            JsonArray array = new JsonArray();
            for (Informes x : list) {
                JsonObject item = new JsonObject();
                item.addProperty("NOM_ART", x.getNOM_ART());
                item.addProperty("EMP", x.getEMP());
                item.addProperty("FECHA_DE_VENTA", x.getFECHA_DE_VENTA());
                item.addProperty("VALOR_VENTA", x.getVALOR_VENTA());
                array.add(item);
            }
            json.add("TOperaciones", array);
            System.out.println("Json informe: "+json.toString());
            return json.toString();

        }

        if (tipo.equals("TVentasxEmpresa")) {
            List<Informes> list = info.getInformeVentasTEmpresa();
            JsonArray array = new JsonArray();
            for (Informes x : list) {
                JsonObject item = new JsonObject();
                item.addProperty("EMP", x.getEMP());
                item.addProperty("TOTAL_VENTAS", x.getTOTAL_VENTAS());
                item.addProperty("TOTAL_OPERACIONES", x.getTOTAL_OPERACIONES());
                array.add(item);
            }
            json.add("TVentasxEmpresa", array);
            return json.toString();
        }

        if (tipo.equals("VentasxEmpresa")) {
            List<Informes> list = info.getInformeVentasEmpresa();
            JsonArray array = new JsonArray();
            for (Informes x : list) {
                JsonObject item = new JsonObject();
                item.addProperty("EMP", x.getEMP());
                item.addProperty("VALOR_VENTA", x.getVALOR_VENTA());
                item.addProperty("FECHA_DE_VENTA", x.getFECHA_DE_VENTA());
                array.add(item);
            }
            json.add("VentasxEmpresa", array);
            return json.toString();
        }

        if (tipo.equals("VentasArtistas")) {
            List<Informes> list = info.getInformeVentasTArtista();
            JsonArray array = new JsonArray();
            for (Informes x : list) {
                JsonObject item = new JsonObject();
                item.addProperty("NOM_ART", x.getNOM_ART());
                item.addProperty("EMP", x.getEMP());
                item.addProperty("TOTAL_VENTA", x.getTOTAL_VENTAS());
                item.addProperty("VENTA_FECHA", x.getFECHA_DE_VENTA());
                array.add(item);
            }
            json.add("VentasArtistas", array);
            return json.toString();
        }
        
        if (tipo.equals("ArtistasConDisco")) {
            List<Regalias> list = reg.getArtistasConRegalias();
            JsonArray array = new JsonArray();
            for (Regalias x : list) {
                JsonObject item = new JsonObject();
                item.addProperty("ID_ARTISTA_REG", x.getId_art());
                item.addProperty("NOM_ARTISTA", x.getNom_art());
                item.addProperty("TIPO_DE_REGALIA", x.getId_reg());
                item.addProperty("NOM_TREG", x.getNom_condicion());
                item.addProperty("FECHA_REGALIA", x.getFecha_actual());
                array.add(item);
            }
            json.add("ArtistasPremiados", array);
            return json.toString();
        }

        return "null";
    }

}
