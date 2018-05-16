/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.controller_user;
import Modelo.Usuario;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Softcaribbean-DEV2
 */
@WebServlet(name = "Ingreso", urlPatterns = {"/Ingreso"})
public class Ingreso extends HttpServlet {

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
            out.println("<title>Servlet Ingreso</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Ingreso at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession(true);
        String nick = request.getParameter("nick");
        String pass = request.getParameter("password");
        System.out.println("Nick: " + nick);
        System.out.println("pass: " + pass);
        response.setContentType("text/html");
        String user_logged = processLogin(nick, pass, session);
        
        response.getWriter().write(user_logged);
    }

    public String processLogin(String nick, String pass, HttpSession session) {
        com.google.gson.JsonObject json = new JsonObject();
        Usuario user = new Usuario();
        Usuario resultado;
        user.setUsername(nick);
        user.setPass(pass);
        JsonArray array = new JsonArray();
        controller_user udao = new controller_user();
        resultado = udao.getOneUser(user);
        JsonObject item = new JsonObject();
        item.addProperty("ID_USUARIO", resultado.getId());
        session.setAttribute("ID_USUARIO", resultado.getId());
        item.addProperty("TIPO_PERFIL", resultado.getTipo_perfil());
        item.addProperty("USERNAME", resultado.getUsername());
        item.addProperty("PASS", resultado.getPass());
        item.addProperty("NOMBRES", resultado.getNombres());
        item.addProperty("APELLIDO1", resultado.getApellido1());
        item.addProperty("APELLIDO2", resultado.getApellido2());
        item.addProperty("DOCUMENTO", resultado.getDocumento());
        item.addProperty("CORREO", resultado.getCorreo());
        item.addProperty("TELEFONO", resultado.getTelefono());
        item.addProperty("DIRECCION", resultado.getDireccion());
        item.addProperty("ID_EMPRESA_U", resultado.getFecha_registro());
        array.add(item);

        session.setAttribute("ID_USUARIO", resultado.getId());
        session.setAttribute("TIPO_PERFIL", resultado.getTipo_perfil());
        session.setAttribute("USERNAME", resultado.getUsername());
        session.setAttribute("PASS", resultado.getPass());
        session.setAttribute("NOMBRES", resultado.getNombres());
        session.setAttribute("APELLIDO1", resultado.getApellido1());
        session.setAttribute("APELLIDO2", resultado.getApellido2());
        session.setAttribute("DOCUMENTO", resultado.getDocumento());
        session.setAttribute("CORREO", resultado.getCorreo());
        session.setAttribute("TELEFONO", resultado.getTelefono());
        session.setAttribute("DIRECCION", resultado.getDireccion());
        session.setAttribute("ID_EMPRESA_U", resultado.getFecha_registro());
        json.add("respuesta", array);
        return json.toString();
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
        processRequest(request, response);
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
