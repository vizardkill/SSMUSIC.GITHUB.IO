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
                            <button type="button" class="btn btn-xs btn-success BTN_Accion" onclick="ListarArtistaPorEmpresa();" role="button" data-toggle="modal" data-target="#Modal_Venta" data-id="1" data-accion="Registrar Venta">Registrar Operación</button>
                            <button type="button" class="btn btn-xs btn-primary BTN_Accion" role="button" data-toggle="modal" data-target="#Modal_Regalias" data-id="1" data-accion="Generar Regalia">Generar Regalia </button>

                        </div>
                    </div> 
                    <div class="row">                    
                        <div class="col-lg-12">
                            <section class="panel">
                                <form action="" method="get" id="data">
                                    <header class="panel-heading">
                                        Tipo de Gestión: <select id="gestion" class="input-sm" onchange="return mostrarSelect()">
                                            <option value="">Ninguno</option>
                                            <option value="ventas">Ventas</option>
                                            <option value="informes">Informes</option>
                                        </select>
                                        <label id="tipo_informe" style="visibility: hidden"> Tipo de Informe: </label> <select class="input-sm" id="informe" style="visibility: hidden" class="simple" onchange="return mostrarInforme()">
                                            <option value="">Ninguno</option>
                                            <option value="Total_Operaciones">Total de Operaciones</option>
                                            <option value="VentasTotalxEmpresa">Ventas por Empresa</option>
                                            <option value="VentasEmpresa">Total de Ventas por Empresa</option> 
                                            <option value="VentasArtista">Artistas con mas Ventas</option>
                                            <option>Artistas con Premios</option>
                                        </select>
                                    </header>
                                    <div class="container">
                                        <div class="col-md-2 col-md-offset-5"><span id="no_hay">Por favor Seleccione una Opcion</span></div>
                                    </div>
                                    <div id="table" class="container-fluid"> 
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
            <script src="js/Serialize_Tables.js" type="text/javascript"></script>
            
            <script src="../../js/Validator/Venta.js" type="text/javascript"></script>
    </body>
</html>
