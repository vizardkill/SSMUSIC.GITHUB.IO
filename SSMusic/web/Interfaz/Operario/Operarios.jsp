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

        <title>S&SMusic - Operarios</title>
    </head>
    <body>
        <%@include file="Navegacion.jsp" %>
        <!-- container section start -->

        <%@include file="Modal.jsp" %>
        <!--main content start-->   
        <section id="main-content">
            <section class="wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h3 class="page-header"><i class="fa fa-laptop"></i> Lista de Operarios</h3>
                        <ol class="breadcrumb">
                            <li><i class="fa fa-home"></i><a href="Inicio.jsp">Inicio</a></li>
                            <li><i class="fa fa-laptop"></i>Operarios</li>  
                        </ol>             
                    </div>
                </div> 
                <div class="row">                    
                    <div class="col-lg-12">
                        <section class="panel">
                            <header class="panel-heading">
                            </header>                      
                            <div id="table-responsive">
                                <table id="table_Operarios" class="table table-striped table-advance table-hover" >
                                    <thead>
                                        <tr>                                            
                                            <th></th>
                                            <th>Documento</th>
                                            <th>Usuario</th>
                                            <th>Tipo de Perfil</th>
                                            <th>Fecha de Registro</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th></th>
                                            <th>Documento</th>
                                            <th>Usuario</th>
                                            <th>Tipo de Perfil</th>
                                            <th>Fecha de Registro</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </tfoot>
                                    <tbody id="employee_data" >
                                    </tbody>
                                </table>
                            </div>
                        </section>
                    </div>
                </div>
                <!-- page end-->
            </section>
        </section>
        <!--main content end-->
        <div class="text-right">
            <div class="credits">    
                <a href="http://www.politecnicojic.edu.co/">Politécnico Colombiano Jaime Isaza Cadavid</a> desarrollado por <a href="">Santiago Cardona & Santiago Arbelaez</a>
            </div>
        </div>
        <script src="../../js/DataTables/Operarios.js" type="text/javascript"></script>
        <script src="../../js/Validator/Operario.js" type="text/javascript"></script>
    </body>
</html>
