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
            <%@include  file="Navegacion_op.jsp" %>
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
                                        <p>Hello I’m Jenifer Smith, a leading expert in interactive and creative design.</p>
                                        <p>@jenifersmith</p>
                                        <h6>
                                            <span><i class="icon_clock_alt"></i>11:05 AM</span>
                                            <span><i class="icon_calendar"></i>25.10.13</span>
                                            <span><i class="icon_pin_alt"></i>NY</span>
                                        </h6>
                                    </div>
                                    <div class="col-lg-2 col-sm-6 follow-info weather-category">
                                        <ul>
                                            <li class="active">

                                                <i class="fa fa-comments fa-2x"> </i><br>

                                                Contrary to popular belief, Lorem Ipsum is not simply
                                            </li>

                                        </ul>
                                    </div>
                                    <div class="col-lg-2 col-sm-6 follow-info weather-category">
                                        <ul>
                                            <li class="active">

                                                <i class="fa fa-bell fa-2x"> </i><br>

                                                Contrary to popular belief, Lorem Ipsum is not simply 
                                            </li>

                                        </ul>
                                    </div>
                                    <div class="col-lg-2 col-sm-6 follow-info weather-category">
                                        <ul>
                                            <li class="active">

                                                <i class="fa fa-tachometer fa-2x"> </i><br>

                                                Contrary to popular belief, Lorem Ipsum is not simply
                                            </li>

                                        </ul>
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
                                        <li class="">
                                            <a data-toggle="tab" href="#edit-profile">
                                                <i class="icon-envelope"></i>
                                                Editar Perfil
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
                                                    Hello I’m Jenifer Smith, a leading expert in interactive and creative design specializing in the mobile medium. My graduation from Massey University with a Bachelor of Design majoring in visual communication.
                                                </div>
                                                <div class="panel-body bio-graph-info">
                                                    <h1>Bio Graph</h1>
                                                    <div class="row">
                                                        <div class="bio-row">
                                                            <p><span>First Name </span>: ${sessionScope['NOMBRES']} </p>
                                                        </div>
                                                        <div class="bio-row">
                                                            <p><span>Last Name </span>: ${sessionScope['APELLIDO1']} ${sessionScope['APELLIDO2']}</p>
                                                        </div>                                              
                                                        <div class="bio-row">
                                                            <p><span>Birthday</span>: 27 August 1987</p>
                                                        </div>
                                                        <div class="bio-row">
                                                            <p><span>Country </span>: United</p>
                                                        </div>
                                                        <div class="bio-row">
                                                            <p><span>Occupation </span>: ${sessionScope['ID_USUARIO']}</p>
                                                        </div>
                                                        <div class="bio-row">
                                                            <p><span>Email </span>: ${sessionScope['CORREO']}</p>
                                                        </div>
                                                        <div class="bio-row">
                                                            <p><span>Mobile </span>: ${sessionScope['TELEFONO']}</p>
                                                        </div>
                                                        <div class="bio-row">
                                                            <p><span>Phone </span>:  ${sessionScope['TELEFONO']}</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </section>
                                            <section>
                                                <div class="row">                                              
                                                </div>
                                            </section>
                                        </div>
                                        <!-- edit-profile -->
                                        <div id="edit-profile" class="tab-pane">
                                            <section class="panel">                                          
                                                <div class="panel-body bio-graph-info">
                                                    <h1> Informacion del Perfil</h1>
                                                    <form class="form-horizontal" role="form">                                                  
                                                        <div class="form-group">
                                                            <label class="col-lg-2 control-label">Primer Nombre</label>
                                                            <div class="col-lg-6">
                                                                <input type="text" class="form-control" id="f-name" placeholder=" ">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-lg-2 control-label">Segundo Nombre</label>
                                                            <div class="col-lg-6">
                                                                <input type="text" class="form-control" id="l-name" placeholder=" ">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-lg-2 control-label">Acerca de mi</label>
                                                            <div class="col-lg-10">
                                                                <textarea name="" id="" class="form-control" cols="30" rows="5"></textarea>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-lg-2 control-label">Region</label>
                                                            <div class="col-lg-6">
                                                                <input type="text" class="form-control" id="c-name" placeholder=" ">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-lg-2 control-label">Cumpleaños</label>
                                                            <div class="col-lg-6">
                                                                <input type="text" class="form-control" id="b-day" placeholder=" ">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-lg-2 control-label">Ocupacion</label>
                                                            <div class="col-lg-6">
                                                                <input type="text" class="form-control" id="occupation" placeholder=" ">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-lg-2 control-label">Email</label>
                                                            <div class="col-lg-6">
                                                                <input type="text" class="form-control" id="email" placeholder=" ">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-lg-2 control-label">Celular</label>
                                                            <div class="col-lg-6">
                                                                <input type="text" class="form-control" id="mobile" placeholder=" ">
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-lg-2 control-label">Sitio Web</label>
                                                            <div class="col-lg-6">
                                                                <input type="text" class="form-control" id="url" placeholder="http://www.demowebsite.com ">
                                                            </div>
                                                        </div>

                                                        <div class="form-group">
                                                            <div class="col-lg-offset-2 col-lg-10">
                                                                <button type="submit" class="btn btn-primary">Guardar</button>
                                                                <button type="button" class="btn btn-danger">Cancelar</button>
                                                            </div>
                                                        </div>
                                                    </form>
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



