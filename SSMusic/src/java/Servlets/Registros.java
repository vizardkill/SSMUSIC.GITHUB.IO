/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.controller_art;
import Controladores.controller_emp;
import Controladores.controller_log;
import Controladores.controller_user;
import Metodos.Calendario;
import Modelo.Artista;
import Modelo.Empresa;
import Modelo.Log;
import Modelo.Usuario;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author clan-
 */
@WebServlet(name = "Registros", urlPatterns = {"/Registros"})
@MultipartConfig
public class Registros extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registros</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registros at " + request.getContextPath() + "</h1>");
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
        if (peticion.equals("Reg_Empresa")) {
            response.getWriter().write(RegistroEmpresa(request, response));
        }
        if (request.getParameter("RegistroEmpresa") != null) {
            response.setContentType("text/html");
            response.getWriter().write(RegistroEmpresa(request, response));
        }
        if (peticion.equals("Reg_Artista")) {
            response.getWriter().write(RegistroArtista(request, response));
        }
        if (peticion.equals("listarEmpresa")) {
            response.setContentType("text/html");
            response.getWriter().write(listarEmpresas(request, response));
        }
        if (peticion.equals("Reg_Operario")) {
            response.setContentType("text/html");
            response.getWriter().write(RegistroOperario(request, response));
        }

    }

    public String RegistroEmpresa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        com.google.gson.JsonObject json = new JsonObject();
        JsonObject item = new JsonObject();
        try {

            Calendario fechaR = new Calendario();
            String FECHA_REGISTRO = fechaR.Fecha_Registro();

            Log log = new Log();
            Empresa emp = new Empresa();
            emp.setId_emp(1);
            emp.setId_emp_ma(1);
            emp.setNIT_emp(request.getParameter("NIT_EMPRESA_D"));
            emp.setNom_emp(request.getParameter("NOM_EMPRESA_D"));
            emp.setNom_encargado(request.getParameter("NOM_ENCARGADO_D"));
            emp.setDoc_encargado(request.getParameter("DOC_ENCARGADO_D"));
            emp.setTel_encargado(request.getParameter("TEL_ENCARGADO_D"));
            emp.setCor_encargado(request.getParameter("COR_ENCARGADO_D"));
            emp.setTipo_operacion(request.getParameter("TIPO_OPERACION_D"));
            emp.setValor_operacion(Double.parseDouble(request.getParameter("VALOR_OPERACION_D")));
            emp.setFecha_registro(FECHA_REGISTRO);

            //Datos log
            int id_user = (Integer) session.getAttribute("ID_USUARIO");
            log.setId_usuario_log(id_user);

            controller_emp edao = new controller_emp();
            controller_log logdao = new controller_log();
            boolean result = edao.registerEmpresa(emp);
            if (result) {
                logdao.registerLog(log);
            }
            item.addProperty("result", result);

        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        return item.toString();
    }

    public String RegistroArtista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        JsonObject item = new JsonObject();
        try {
            Calendario fechaR = new Calendario();
            String FECHA_REGISTRO = fechaR.Fecha_Registro();
            Log log = new Log();
            Artista art = new Artista();
            art.setId(1);
            art.setNombre_art(request.getParameter("NOM_ARTISTA"));
            art.setNom_representante(request.getParameter("NOM_REPRESENTANTE"));
            art.setDoc_representante(request.getParameter("DOC_REPRESENTANTE"));
            art.setTel_representante(request.getParameter("TEL_REPRESENTANTE"));
            art.setCor_representante(request.getParameter("COR_REPRESENTANTE"));
            art.setId_empresa_d_art(Integer.parseInt(request.getParameter("select_empresas")));
            String img_art = FileUpload(request, response);
            art.setSrc(img_art);
            art.setFecha_registro_art(FECHA_REGISTRO);

            int id_user = (Integer) session.getAttribute("ID_USUARIO");
            log.setId_usuario_log(id_user);

            controller_art adao = new controller_art();
            boolean result = adao.registerArt(art);

            controller_log logdao = new controller_log();
            if (result) {
                logdao.registerLog(log);
            }
            item.addProperty("result", result);

        } catch (IOException | NumberFormatException | ServletException e) {
            System.out.println(e);
        }
        return item.toString();
    }

    ;
    
    public String listarEmpresas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("entro al servlet");
        com.google.gson.JsonObject json = new JsonObject();
        JsonArray array = new JsonArray();
        List<Modelo.Empresa> resultado;

        try {

            controller_emp edao = new controller_emp();

            resultado = edao.getEmpresas();
            for (Empresa result : resultado) {
                JsonObject item = new JsonObject();
                item.addProperty("ID_EMPRESA_D", result.getId_emp());
                item.addProperty("ID_EMAYOR", result.getId_emp_ma());
                item.addProperty("NIT_EMPRESA_D", result.getNIT_emp());
                item.addProperty("NOM_EMPRESA_D", result.getNom_emp());
                item.addProperty("NOM_ENCARGADO_D", result.getNom_encargado());
                item.addProperty("DOC_ENCARGADO_D", result.getDoc_encargado());
                item.addProperty("TEL_ENCARGADO_D", result.getTel_encargado());
                item.addProperty("COR_ENCARGADO_D", result.getCor_encargado());
                item.addProperty("TIPO_OPERACION_D", result.getTipo_operacion());
                item.addProperty("VALOR_OPERACION_D", result.getValor_operacion());
                item.addProperty("FECHA_REGISTRO_D", result.getFecha_registro());
                array.add(item);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return array.toString();
    }

    
    public String RegistroOperario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        JsonObject item = new JsonObject();
        try {

            Calendario fechaR = new Calendario();
            String FECHA_REGISTRO = fechaR.Fecha_Registro();
            System.out.println("fecha en servlet: " + FECHA_REGISTRO);

            Log log = new Log();
            Usuario user = new Usuario();
            user.setId(1);
            user.setId_empresa(2);
            user.setTipo_perfil("Oper");
            user.setUsername(request.getParameter("USERNAME"));
            user.setPass(request.getParameter("PASS"));
            user.setNombres(request.getParameter("NOMBRES"));
            user.setApellido1(request.getParameter("APELLIDO1"));
            user.setApellido2(request.getParameter("APELLIDO2"));
            user.setDocumento(request.getParameter("DOCUMENTO"));
            user.setCorreo(request.getParameter("CORREO"));
            user.setTelefono(request.getParameter("TELEFONO"));
            user.setDireccion(request.getParameter("DIRECCION"));
            user.setFecha_registro(FECHA_REGISTRO);

            int id_user = (Integer) session.getAttribute("ID_USUARIO");
            log.setId_usuario_log(id_user);

            controller_user edao = new controller_user();
            boolean result = edao.registerUser(user);
            controller_log logdao = new controller_log();
            if (result) {
                logdao.registerLog(log);
            }

            item.addProperty("result", result);

        } catch (Exception e) {
            System.out.println(e);
        }
        return item.toString();
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

    private final static Logger LOGGER
            = Logger.getLogger(Registros.class.getCanonicalName());

    protected String FileUpload(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Create path components to save the file
        String ruta = "D:\\Documents\\NetBeansProjects\\HTML\\SSMusic\\web\\img\\Icons_art\\";
        final String path = ruta;
        final Part filePart = request.getPart("Img_art-0");
        final String fileName = getFileName(filePart);
        String SRC = "../../img/Icons_art/" + fileName;
        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();

        try {
            out = new FileOutputStream(new File(path + File.separator
                    + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            writer.println("New file " + fileName + " created at " + path);
            LOGGER.log(Level.INFO, "File {0} being uploaded to {1}",
                    new Object[]{fileName, path});
        } catch (FileNotFoundException fne) {
            writer.println("You either did not specify a file to upload or are "
                    + "trying to upload a file to a protected or nonexistent "
                    + "location.");
            writer.println("<br/> ERROR: " + fne.getMessage());
            LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
                    new Object[]{fne.getMessage()});
            return SRC = "../../img/male.png";
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
        return SRC;
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
