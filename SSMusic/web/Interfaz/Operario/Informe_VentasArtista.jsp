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

        <title>S&SMusic - Ganancias Artistas</title>
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
                            <h3 class="page-header"><i class="fa fa-laptop"></i> Ganancias de Artistas</h3>
                            <ol class="breadcrumb">
                                <li><i class="fa fa-home"></i><a href="Estudiante.jsp">Inicio</a></li>
                                <li><i class="fa fa-laptop"></i>Ganancias Artistas</li>  
                            </ol>             
                        </div>
                    </div> 
                    <div class="row">                    
                        <div class="col-lg-12">
                            <section class="panel">
                                <header class="panel-heading">
                                     <button type="button" class="btn btn-xs btn-primary" onclick="ListarArtistaPorEmpresa();" role="button" data-toggle="modal" data-target="#Modal_Venta" data-id="1" data-accion="Registrar Venta">Registrar Venta</button>
                                </header>
                                <br>
                                <div class="col-md-6"><span><i class="fa fa-calendar-check"></i>Seleccione una Fecha para Buscar:</span></div>
                                <br>
                                <br><br>
                                <div id="table-responsive">
                                    <table id="table_VentasArtistas" class="table table-striped table-advance table-hover">
                                        <thead>
                                            <tr>                                            
                                                <th></th>
                                                <th>Artista</th>
                                                <th>Empresa</th>
                                                <th>Total de Venta</th>
                                                <th>Fecha de Venta</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th></th>
                                                <th>Artista</th>
                                                <th>Empresa</th>
                                                <th>Total de Venta</th>
                                                <th>Fecha de Venta</th>
                                            </tr>
                                        </tfoot>
                                        <tbody id="employee_data"> </tbody>
                                    </table>
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
            <script src="../../js/DataTables/Info_TVentasArtistas.js" type="text/javascript"></script>
            <script src="../../js/Validator/Venta.js" type="text/javascript"></script>
    </body>
</html>










