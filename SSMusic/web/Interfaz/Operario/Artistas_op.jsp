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
        <%@include file="Navegacion_op.jsp" %>
        <!-- container section start -->
        <section id="container" class="">
            <%@include file="Modal_op.jsp" %>
            <!--main content start-->   
            <section id="main-content">
                <section class="wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header"><i class="fa fa-laptop"></i> Lista de Artistas</h3>
                            <ol class="breadcrumb">
                                <li><i class="fa fa-home"></i><a href="Estudiante.jsp">Inicio</a></li>
                                <li><i class="fa fa-laptop"></i>Artistas</li>  
                            </ol>             
                        </div>
                    </div> 
                    <div class="row">                    
                        <div class="col-lg-12">
                            <section class="panel">
                                <form action="" method="post" id="data">
                                                         
                                    <div id="table-responsive">
                                        <table id="table_Artistas" class="table table-striped table-advance table-hover" >
                                            <thead>
                                                <tr>                                            
                                                    <th></th>
                                                    <th>Poster</th>
                                                    <th>Banda o Artista</th>
                                                    <th>Fecha de Registro</th>
                                                    <th>Acciones</th>
                                                </tr>
                                            </thead>
                                            <tfoot>
                                                <tr>
                                                    <th></th>
                                                    <th>Poster</th>
                                                    <th>Banda o Artista</th>
                                                    <th>Fecha de Registro</th>
                                                    <th>Acciones</th>
                                                </tr>
                                            </tfoot>
                                            <tbody id="employee_data" >
                                            </tbody>
                                        </table>
                                    </div>
                                </form>
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
            <script src="../../js/DataTables/Artistas.js" type="text/javascript"></script>
    </body>
</html>
