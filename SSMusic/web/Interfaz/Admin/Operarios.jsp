<%-- 
    Document   : Operarios
    Created on : 30/04/2018, 08:59:59 AM
    Author     : Softcaribbean-DEV2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Navegacion.jsp" %>
        <section id="container" class="">
             <%@include file="Modal.jsp" %>
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">            
                    <!--overview start-->
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header"><i class="fa fa-laptop"></i> Administración de Operarios</h3>
                            <ol class="breadcrumb">
                                <li><i class="fa fa-home"></i><a href="Interfaz.jsp">Inicio</a></li>
                                <li><i class="fa fa-laptop"></i>Información</li>						  	
                            </ol>
                        </div>
                    </div> 
                     <div class="row">                    
                        <div class="col-lg-12">
                            <section class="panel">
                                <form action="" method="post" id="data">
                                    <header class="panel-heading">
                                        Tipo de Gestión: 
                                        <button type="button" class="btn btn-xs btn-success BTN_Accion" role="button" data-toggle="modal" data-target="#Modal_RegistrarOp" data-id="1" data-accion="Registrar Empresa">Registrar Operario</button>
                                       
                                    </header>                      
                                    
                                </form>
                            </section>
                        </div>
                    </div>
                    <h1 style="text-align:center;">Operarios</h1>
 
  
  <div class="col-md-6">

</div>
<div class="col-md-6">
    
  
</div>
</section>
                <div class="text-right">
                    <div class="credits">    
                        <a href="http://www.politecnicojic.edu.co/">Politécnico Colombiano Jaime Isaza Cadavid</a> desarrollado por <a href="">Santiago Cardona & Santiago Arbelaez</a>
                    </div>
                </div>
            </section>
            <!--main content end-->
        </section>
    </body>
</html>
