<%-- 
    Document   : Materias_Ma
    Created on : 2/11/2017, 04:43:32 PM
    Author     : clan-
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <script src="js/gestion.js" type="text/javascript"></script>
        <link rel="shortcut icon" href="../../favicon.ico">

        <title>S&SMusic - Empresas</title>
    </head>
    <body>
        <%@include file="Navegacion.jsp" %>
        <!-- container section start -->
        <section id="container" class="">
            <%@include file="Modal.jsp" %>
            <!--main content start-->   
            <section id="main-content">
                <section class="wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header"><i class="fa fa-laptop"></i>Gestión de Artistas</h3>
                            <ol class="breadcrumb">
                                <li><i class="fa fa-home"></i><a href="Estudiante.jsp">Inicio</a></li>
                                <li><i class="fa fa-laptop"></i>Artistas</li>  
                            </ol>     
                            <button type="button" class="btn btn-xs btn-primary BTN_Accion" role="button" onclick="ListarEmpresas();" data-toggle="modal" data-target="#Modal_RegistrarArt" data-id="2" data-accion="Registrar Artista">Registrar Artista</button>
                            <button type="button" class="btn btn-xs btn-primary BTN_Accion" role="button" data-toggle="modal" data-target="#Modal_Regalias" data-id="1" data-accion="Generar Regalia">Generar Premios </button>

                        </div>
                    </div> 
                    <div class="row">                    
                        <div class="col-lg-12">
                            <section class="panel">
                                <header class="panel-heading">
                                    Mostrar: <select id="cbx_Artista" class="input-sm" onchange="return mostrarSelectArtistas()">
                                        <option value="">Ninguno</option>
                                        <option value="Table_Artistas">Artistas Registrados</option>
                                        <option value="Table_ArtistasPremios">Artistas Premiados</option>
                                        <option value="Table_TOperaciones">Total de Operaciones</option>
                                    </select>
                                </header>                      
                                <div class="container">
                                    <div class="col-md-2 col-md-offset-5"><span id="no_hay">Por favor Seleccione una Opcion</span></div>
                                </div>
                                <div id="table" class="container-fluid"> 
                                </div>
                            </section>
                        </div>
                    </div>
                    <!-- page end-->
                </section>
            </section>
            <!--main content end-->
            </section>
            <div class="text-right">
                <div class="credits">    
                    <a href="http://www.politecnicojic.edu.co/">Politécnico Colombiano Jaime Isaza Cadavid</a> desarrollado por <a href="">Santiago Cardona & Santiago Arbelaez</a>
                </div>
            </div>
            <script src="js/Serialize_Tables.js" type="text/javascript"></script>
            <script src="../../js/Validator/Artista.js" type="text/javascript"></script>
        
    </body>
</html>
