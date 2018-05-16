<%-- 
    Document   : info_artistas
    Created on : 20/04/2018, 07:57:00 AM
    Author     : Softcaribbean-DEV2
--%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="shortcut icon" href="../../favicon.ico">
  
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <script src="../../js/Map.js" type="text/javascript"></script>
  <script src="../../js/fosforito_core_groupimage.js" type="text/javascript"></script>
  <script src="js/Infor_artistas.js" type="text/javascript"></script>
 
  <title>Artistas</title>
  
  <style>
  img.img-circle{
                  width: 100px;
                  height: 100px;
                  display: block;
                  margin: 0 auto 0 auto;

              }

              img:active{
                  background-color: rgb(153, 255, 153);

              }
              img:hover{
                  opacity:0.5;


              }

              hr {
                  width: 90%;
                  border-color: grey;
              }
              </style>
              
</head>

<body>
    <%@include file="Navegacion.jsp" %>
        <!-- container section start -->
        <section id="container" class="">
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">            
                    <!--overview start-->
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header"><i class="fa fa-laptop"></i> Zona de Administración</h3>
                            <ol class="breadcrumb">
                                <li><i class="fa fa-home"></i><a href="Interfaz.jsp">Inicio</a></li>
                                <li><i class="fa fa-laptop"></i>Información</li>						  	
                            </ol>
                        </div>
                    </div> 
                    <h1 style="text-align:center;">Artistas</h1>
 
  
  <div class="col-md-6">

</div>
<div class="col-md-6">
    
  
</div>
                    <hr>
  <GroupImage id="grupo_labor" classcontainer="container" classrow="row" containerrow="col-md-12" containerimg="col-md-3"maxcolumn="4">
    <objectGroup src="src" title="NOM_ARTISTA" trigger="abrirY">

    </objectGroup>
  </GroupImage>
                    <button id="listar" onclick="ServletArtista()">Mostrar Archivo</button>
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

