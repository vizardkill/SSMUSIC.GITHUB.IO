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

        <title>S&SMusic - Gestión</title>
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
                            <h3 class="page-header"><i class="fa fa-laptop"></i> Gestion de Ventas</h3>
                            <ol class="breadcrumb">
                                <li><i class="fa fa-home"></i><a href="Estudiante.jsp">Inicio</a></li>
                                <li><i class="fa fa-laptop"></i> Gestion de Ventas</li>  
                            </ol>             
                        </div>
                    </div> 
                    <div class="row">                    
                        <div class="col-lg-12">
                            <section class="panel">
                                <form action="" method="get" id="data">
                                    <header class="panel-heading">
                                        Tipo de Gestión: <select class="simple">
                                            <option>Operaciones</option>
                                            <option>Ventas</option>
                                        </select>
                                        <button type="button" class="btn btn-xs btn-success BTN_Accion" onclick="ListarArtistaPorEmpresa();" role="button" data-toggle="modal" data-target="#Modal_Venta" data-id="1" data-accion="Registrar Venta">Registrar Venta</button>
                                    </header>                      
                                    <div id="table-responsive">
                                        <table id="table_Empresas" class="table table-striped table-advance table-hover">
                                            <thead>
                                                <tr>                                            
                                                    <th></th>
                                                    <th>ID Empresa</th>
                                                    <th>Empresa</th>
                                                    <th>ID Artista</th>
                                                    <th>Artista</th>
                                                    <th>Cantidad de Operaciones</th>
                                                </tr>
                                            </thead>
                                            <tfoot>
                                                <tr>
                                                    <th></th>
                                                    <th>ID Empresa</th>
                                                    <th>Empresa</th>
                                                    <th>ID Artista</th>
                                                    <th>Artista</th>
                                                    <th>Cantidad de Operaciones</th>
                                                </tr>
                                            </tfoot>
                                            <tbody id="employee_data">

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
    </body>
</html>
