
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
                                        Mostrar: <select id="cbx_GananciaEmpresa" class="input-sm" onchange="return mostrarSelectGananciaEmpresa()">
                                            <option value="">Ninguno</option>
                                            <option value="Table_VentasTxEmpresa">Ganancias Totales</option>
                                            <option value="Table_VentasxEmpresa">Ganancias Parciales</option>
                                        </select>
                                    </header>
                                    <div class="container">
                                        <div class="col-md-2 col-md-offset-5"><span id="no_hay">Por favor Seleccione una Opcion</span></div>
                                    </div>
                                    <div id="table_gananciaEmpresa" class="container-fluid"> 
                                    </div>
                                </form>
                            </section>
                        </div>
                    </div>
                    <!-- page end-->
                </section>
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
