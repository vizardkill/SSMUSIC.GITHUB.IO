<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>

<t:if test="${sessionScope['sessionNombre']!=null}">
    <% response.sendRedirect("../../index.html");%>
</t:if>
<!DOCTYPE html>
<!--header start-->
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
<meta name="author" content="GeeksLabs">
<meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">

<link href="../../css/bootstrap.min.css" rel="stylesheet">
<link href="../../css/bootstrap-theme.css" rel="stylesheet">
<link href="../../css/elegant-icons-style.css" rel="stylesheet" />
<link href="../../css/font-awesome.min.css" rel="stylesheet" />
<link href="../../css/interfaz.css" rel="stylesheet">
<link href="../../css/style-responsive.css" rel="stylesheet" />
<link href="../../css/modal.css" rel="stylesheet" type="text/css"/>
<link href="../../css/main.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lato:400,900" rel="stylesheet">
<link href="https://cdn.datatables.net/v/bs4/jszip-2.5.0/dt-1.10.16/af-2.2.2/b-1.5.1/b-colvis-1.5.1/b-flash-1.5.1/b-html5-1.5.1/b-print-1.5.1/cr-1.4.1/fc-3.2.4/fh-3.1.3/kt-2.3.2/r-2.2.1/rg-1.0.2/sc-1.4.4/datatables.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"/>


<header class="header dark-bg">
    <div class="toggle-nav">
        <div class="icon-reorder tooltips" data-original-title="Navegación" data-placement="bottom"><i class="icon_menu"></i></div>
    </div>

    <!--logo start-->
    <a href="Inicio.jsp" class="logo"><span>S&S</span> Music</a>
    <!--logo end-->

    <div class="top-nav notification-row">                
        <!-- notificatoin dropdown start-->
        <ul class="nav pull-right top-menu">
            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="">
                    <span class="profile-ava">
                        <img alt="" src="../../img/avatar1_small.jpg">
                        <span class="username" id="id_usuario">${sessionScope['USERNAME']}</span>
                    </span>
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu extended logout">
                    <div class="log-arrow-up"></div>
                    <li class="eborder-top">
                        <a href="Perfil.jsp"><i class="icon_profile"></i> Mi perfil</a>
                    </li>
                    <li class="eborder-top">
                        <a href="../../Ingreso_Registro/Acceso.jsp" ><i class="icon_key_alt"></i> Salir</a>
                    </li>
                </ul>
            </li>
            <!-- user login dropdown end -->
        </ul>
        <!-- notificatoin dropdown end-->
    </div>

</header>      
<!--sidebar start-->
<aside>
    <div id="sidebar"  class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu">                
            <li class="active">
                <a class="" href="Inicio.jsp">
                    <i class="icon_house_alt"></i>
                    <span>Inicio</span>
                </a>
            </li>
            <li class="sub-menu">
                <a href="javascript:;" class="">
                    <i class="icon_document_alt"></i>
                    <span>Contacto</span>
                    <span class="menu-arrow arrow_carrot-right"></span>
                </a>
                <ul class="sub">
                    <li><a class="" href="">Enviar Correo</a></li>                          
                    <li><a class="" href="">Reportar Problemas</a></li>
                </ul>
            </li>                       
            <li class="sub-menu">
                <a href="javascript:;" class="">
                    <i class="icon_table"></i>
                    <span>Moderación</span>
                    <span class="menu-arrow arrow_carrot-right"></span>
                </a>
                <ul class="sub">   
                    <li><a class="" href="Gestion.jsp">Gestión</a></li>
                    <li><a class="" href="Empresas.jsp">Información Empresas</a></li>
                    <li><a onclick="" class="" href="Artistas.jsp">Información Artistas</a></li>
                    <li><a onclick="" class="" href="Operarios.jsp">Gestión Operarios</a></li>
                </ul>
            </li>
        </ul>
        <!-- sidebar menu end-->
    </div>

</aside>

<!--sidebar end-->
<script src="https://code.jquery.com/jquery-3.3.1.js" type="text/javascript" ></script>
<script src="../../js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="../../js/jquery-ui-1.10.4.min.js" type="text/javascript" ></script>
<script src="../../js/jquery-ui-1.9.2.custom.min.js" type="text/javascript" ></script>
<script src="../../js/bootstrap.min.js" type="text/javascript" ></script>
<script src="../../js/jquery.scrollTo.min.js" type="text/javascript" ></script>
<script src="../../js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="../../js/jquery.customSelect.min.js" type="text/javascript" ></script>
<script src="../../js/scripts.js" type="text/javascript" ></script>    
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js" type="text/javascript" ></script>
<script src="https://cdn.datatables.net/v/bs4/jszip-2.5.0/dt-1.10.16/af-2.2.2/b-1.5.1/b-colvis-1.5.1/b-flash-1.5.1/b-html5-1.5.1/b-print-1.5.1/cr-1.4.1/fc-3.2.4/fh-3.1.3/kt-2.3.2/r-2.2.1/rg-1.0.2/sc-1.4.4/datatables.min.js" type="text/javascript"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>