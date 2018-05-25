<%-- 
    Document   : Perfil
    Created on : 14/10/2017, 03:36:56 PM
    Author     : clan-
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="es">
    <head>
        <link rel="shortcut icon" href="../../favicon.ico">
        <title>PoliNotes - Perfil</title>
    </head>
    <!-- container section start -->
    <body>
        <section id="container" class="">
            <%@include  file="Navegacion.jsp" %>
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header"><i class="fa fa-user-md"></i> Perfil</h3>
                            <ol class="breadcrumb">
                                <li><i class="fa fa-home"></i><a href="Maestro.jsp">Inicio</a></li>
                                <li><i class="icon_documents_alt"></i>Sesion</li>
                                <li><i class="fa fa-user-md"></i>Perfil</li>
                            </ol>
                        </div>
                    </div>
                    <div class="row">
                        <!-- profile-widget -->
                        <div class="col-lg-12">
                            <div class="profile-widget profile-widget-info">
                                <div class="panel-body">
                                    <div class="col-lg-2 col-sm-2">
                                        <h4>${sessionScope['NOMBRES']} ${sessionScope['APELLIDO1']}</h4>               
                                        <div class="follow-ava">
                                            <img src="../../img/profile-widget-avatar.jpg" alt="">
                                        </div>
                                        <h6>${sessionScope['TIPO_PERFIL']}</h6>
                                    </div>
                                    <div class="col-lg-4 col-sm-4 follow-info">
                                        <p>Operador de la plataforma PoliMusic</p>
                                        <p>@Operador</p>
                                        <h6>
                                            <span><i class="icon_clock_alt"></i>--:-- --</span>
                                            <span><i class="icon_calendar"></i>dd.mm.yyyy</span>
                                            <span><i class="icon_pin_alt"></i>COL</span>
                                        </h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- page start-->
                    <div class="row">
                        <div class="col-lg-12">
                            <section class="panel">
                                <header class="panel-heading tab-bg-info">
                                    <ul class="nav nav-tabs">

                                        <li>
                                            <a data-toggle="tab" href="#profile">
                                                <i class="icon-user"></i>
                                                Perfil
                                            </a>
                                        </li>
                                    </ul>
                                </header>
                                <div class="panel-body">
                                    <div class="tab-content">

                                        <!-- profile -->
                                        <div id="profile" class="tab-pane">
                                            <section class="panel">
                                                <div class="bio-graph-heading">
                                                    Empleado de la empresa PoliMusic </div>
                                                <div class="panel-body bio-graph-info">
                                                    <h1>Biografia</h1>
                                                    <div class="row">
                                                        <div class="bio-row">
                                                            <p><span>Nombres </span>: ${sessionScope['NOMBRES']} </p>
                                                        </div>
                                                        <div class="bio-row">
                                                            <p><span>Apellidos </span>: ${sessionScope['APELLIDO1']} ${sessionScope['APELLIDO2']}</p>
                                                        </div>                                              
                                                        <div class="bio-row">
                                                            <p><span>Fecha de Nacimiento</span>: dd MM YYYY</p>
                                                        </div>
                                                        <div class="bio-row">
                                                            <p><span>Pais </span>: Colombia</p>
                                                        </div>
                                                        <div class="bio-row">
                                                            <p><span>Ocupacion </span>: ${sessionScope['ID_USUARIO']}</p>
                                                        </div>
                                                        <div class="bio-row">
                                                            <p><span>Email </span>: ${sessionScope['CORREO']}</p>
                                                        </div>
                                                        <div class="bio-row">
                                                            <p><span>Telefono </span>: ${sessionScope['TELEFONO']}</p>
                                                        </div>
                                                        <div class="bio-row">
                                                            <p><span>Celular </span>:  ${sessionScope['TELEFONO']}</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </section>
                                            <section>
                                                <div class="row">                                              
                                                </div>
                                            </section>
                                        </div>
                                    </div>
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
        </section>
    </body>
</html>



