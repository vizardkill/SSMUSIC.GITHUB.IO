/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Controladores.controller_art;
import Controladores.controller_emp;
import Controladores.controller_oper;
import Controladores.controller_user;
import Modelo.Empresa;
import Modelo.Operacion;
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

    public String jsonOperaciones(String tipo) {
        controller_oper coper = new controller_oper();
        com.google.gson.JsonObject json = new JsonObject();

        if (tipo.equals("total_operaciones")) {
            List<Operacion> list = coper.getTotalOperaciones();
            JsonArray array = new JsonArray();
            for (Operacion x : list) {
                JsonObject item = new JsonObject();
                item.addProperty("ID_EMP", x.getID_EMP());
                item.addProperty("EMP", x.getEMP());
                item.addProperty("ID_ART", x.getID_ARTISTA_VE());
                item.addProperty("NOM_ART", x.getNOM_ART());
                item.addProperty("TOTAL_OPERACIONES", x.getCANTIDAD_OPERACIONES());
                array.add(item);
            }
            json.add("Total_Operaciones", array);
            return json.toString();
        }

        if (tipo.equals("operaciones")) {
            List<Operacion> list = coper.getOperaciones();
            JsonArray array = new JsonArray();
            for (Operacion x : list) {
                JsonObject item = new JsonObject();
                item.addProperty("Id", x.getID_VENTAS());
                item.addProperty("ID_ARTISTA_VE", x.getID_ARTISTA_VE());
                item.addProperty("CANTIDAD_OPERACIONES", x.getCANTIDAD_OPERACIONES());
                item.addProperty("VALOR_VENTA", x.getVALOR_VENTA());
                item.addProperty("FECHA_VENTA", x.getFECHA_VENTA());
                array.add(item);
            }
            json.add("Operaciones", array);
            return json.toString();
        }
        return "null";
    }

}
