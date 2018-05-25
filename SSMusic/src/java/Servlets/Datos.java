/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.controller_art;
import Controladores.controller_emp;
import Controladores.controller_oper;
import Controladores.controller_user;
import Metodos.Json_Datos;
import Modelo.Artista;
import Modelo.Empresa;
import Modelo.Informes;
import Modelo.Usuario;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author clan-
 */
public class Datos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Datos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Datos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        
        String peticion = request.getParameter("peticion");
        
        HttpSession session = request.getSession(true);
        
        Json_Datos data = new Json_Datos();
        String perfil = session.getAttribute("TIPO_PERFIL").toString();
        if (peticion.equals("data_art")) {
            response.getWriter().write(data.jsonArtistas(perfil));
        }
        if (peticion.equals("data_emp")) {
            response.getWriter().write(data.jsonEmpresas(perfil));
        }
        if (peticion.equals("data_ope")) {
            response.getWriter().write(data.jsonOperarios(perfil));
        }
        if (peticion.equals("data_Informe")) {
            String tipo = request.getParameter("tipo");
            response.getWriter().write(data.jsonInforme(tipo));
        }
        if (peticion.equals("data_logs")) {
            response.getWriter().write(data.jsonLog());
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String peticion = request.getParameter("peticion");
        if (peticion.equals("EliminarEmpresa")) {
            controller_emp cemp = new controller_emp();
            Empresa emp = new Empresa();
            System.out.println("Id empresa: " + request.getParameter("Id"));
            emp.setId_emp(Integer.parseInt(request.getParameter("Id")));
            boolean result = cemp.deleteEmpresa(emp);

            com.google.gson.JsonObject json = new JsonObject();
            JsonObject item = new JsonObject();
            item.addProperty("result", result);
            json.add("result", item);
            response.getWriter().write(json.toString());
        }
        if (peticion.equals("EliminarArtista")) {
            controller_art cart = new controller_art();
            Artista art = new Artista();
            System.out.println(request.getParameter("Id"));
            art.setId(Integer.parseInt(request.getParameter("Id")));
            boolean result = cart.deleteUser(art);

            com.google.gson.JsonObject json = new JsonObject();
            JsonObject item = new JsonObject();
            item.addProperty("result", result);
            json.add("result", item);
            response.getWriter().write(json.toString());
        }

        if (peticion.equals("EliminarOperario")) {
            controller_user coper = new controller_user();
            Usuario u = new Usuario();
            u.setId(Integer.parseInt(request.getParameter("Id")));
            boolean result = coper.deleteUser(u);
            
            com.google.gson.JsonObject json = new JsonObject();
            JsonObject item = new JsonObject();
            item.addProperty("result", result);
            json.add("result", item);
            response.getWriter().write(json.toString());
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
