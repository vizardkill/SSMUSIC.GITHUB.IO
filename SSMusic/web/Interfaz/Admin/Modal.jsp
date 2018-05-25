<%-- 
    Document   : Modal
    Created on : 23/10/2017, 05:00:53 PM
    Author     : clan-
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<script src="js/gestion.js" type="text/javascript"></script>
<link href="../../css/interfaz.css" rel="stylesheet" type="text/css"/>



<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="Modal_RegistrarEmp" >
    <div class="modal-dialog modal-lg" role="document">


        <div class="modal-content">
            <form id="Reg_Empresa" class="form form-inline" action="../../Registros?peticion=Reg_Empresa" >

                <div class="modal-header">
                    <div class="form_top">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h2>Registro de <span>Empresa</span></h2>
                    </div> 
                </div>

                <div class="modal-body" >
                    <div class="container-fluid">
                        <span id="Error_ReEmp" name="Error_ReEmp" style="color: #ff0000"></span>

                        <div class="col-md-12">
                            <div class="form-group col-md-6">
                                <label for="NIT_EMPRESA_D" class="control-label">Nit: </label>
                                <input name="NIT_EMPRESA_D" id='NIT_EMPRESA_D' type='text' placeholder="Nit" class="form-control input"/>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="NOM_EMPRESA_D" class="control-label">Nombre: </label>
                                <input name="NOM_EMPRESA_D" id='NOM_EMPRESA_D' type='text' placeholder="Nombre Empresa" class="form-control input"/>
                            </div>
                        </div>

                        <div class="col-md-12">
                            <div class="form-group col-sm-6">
                                <label for="NOM_ENCARGADO_D" class="control-label">Nombre Encargado: </label>
                                <input name="NOM_ENCARGADO_D" id='NOM_ENCARGADO_D'  type='text' placeholder="Nombre Encargado" class="form-control input"/>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="DOC_ENCARGADO_D" class="control-label">Documento Encargado: </label>
                                <input name="DOC_ENCARGADO_D" id='DOC_ENCARGADO_D'  type='text' placeholder="Documento Encargado" class="form-control input"/>
                            </div>
                        </div>

                        <div class="col-md-12">
                            <div class="form-group col-sm-6">
                                <label for="TEL_ENCARGADO_D" class="control-label">Telefono: </label>
                                <input name="TEL_ENCARGADO_D" id='TEL_ENCARGADO_D' type='text' placeholder="Telefono Encargado" class="form-control input"/>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="COR_ENCARGADO_D" class="control-label">Correo: </label>
                                <input name="COR_ENCARGADO_D" id='COR_ENCARGADO_D' type='text' placeholder="Correo Encargado" class="form-control input"/>
                            </div>
                        </div>

                        <div class="col-md-12">
                            <div class="form-group col-sm-6">
                                <label for="TIPO_OPERACION_D" class="control-label">Tipo Operacion </label>
                                <input name="TIPO_OPERACION_D" id='TIPO_OPERACION_D' type='text' placeholder="Tipo de Operacion" class="form-control input"/>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="VALOR_OPERACION_D" class="control-label">Valor Operacion </label>
                                <input name="VALOR_OPERACION_D" id='VALOR_OPERACION_D' type='text' placeholder="Valor Operacion" class="form-control input"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button id="RegistroEmpresa" type="submit" class="btn btn-default" name="RegistroEmpresa">Registrar</button>
                    <button id="btn_emp_close" type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                </div>
            </form>
        </div>

    </div>
</div>
<!--Modal update Empresa --> 
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="Modal_updateEmp" >
    <div class="modal-dialog modal-lg" role="document">


        <div class="modal-content">
            <form id="Reg_Empresa" class="form form-inline" action="" >

                <div class="modal-header">
                    <div class="form_top">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h2>Actualizacion de <span>Empresa</span></h2>
                    </div> 
                </div>

                <div class="modal-body" >
                    <div class="container-fluid">
                        <span id="Error_ReEmp" name="Error_upEmp" style="color: #ff0000"></span>

                        <div class="col-md-12">
                            <div class="form-group col-md-6">
                                <label for="NIT_EMPRESA_D_UP" class="control-label">Nit: </label>
                                <input name="NIT_EMPRESA_D_UP" id='NIT_EMPRESA_D_UP' type='text' placeholder="Nit" class="form-control input"/>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="NOM_EMPRESA_D_UP" class="control-label">Nombre: </label>
                                <input name="NOM_EMPRESA_D_UP" id='NOM_EMPRESA_D_UP' type='text' placeholder="Nombre Empresa" class="form-control input"/>
                            </div>
                        </div>

                        <div class="col-md-12">
                            <div class="form-group col-sm-6">
                                <label for="NOM_ENCARGADO_D_UP" class="control-label">Nombre Encargado: </label>
                                <input name="NOM_ENCARGADO_D_UP" id='NOM_ENCARGADO_D_UP'  type='text' placeholder="Nombre Encargado" class="form-control input"/>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="DOC_ENCARGADO_D_UP" class="control-label">Documento Encargado: </label>
                                <input name="DOC_ENCARGADO_D_UP" id='DOC_ENCARGADO_D_UP'  type='text' placeholder="Documento Encargado" class="form-control input"/>
                            </div>
                        </div>

                        <div class="col-md-12">
                            <div class="form-group col-sm-6">
                                <label for="TEL_ENCARGADO_D_UP" class="control-label">Telefono: </label>
                                <input name="TEL_ENCARGADO_D_UP" id='TEL_ENCARGADO_D_UP' type='text' placeholder="Telefono Encargado" class="form-control input"/>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="COR_ENCARGADO_D_UP" class="control-label">Correo: </label>
                                <input name="COR_ENCARGADO_D_UP" id='COR_ENCARGADO_D_UP' type='text' placeholder="Correo Encargado" class="form-control input"/>
                            </div>
                        </div>

                        <div class="col-md-12">
                            <div class="form-group col-sm-6">
                                <label for="TIPO_OPERACION_D_UP" class="control-label">Tipo Operacion </label>
                                <input name="TIPO_OPERACION_D_UP" id='TIPO_OPERACION_D_UP' type='text' placeholder="Tipo de Operacion" class="form-control input"/>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="VALOR_OPERACION_D_UP" class="control-label">Valor Operacion </label>
                                <input name="VALOR_OPERACION_D_UP" id='VALOR_OPERACION_D_UP' type='text' placeholder="Valor Operacion" class="form-control input"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button id="UpdateEmpresa" type="submit" class="btn btn-default" name="RegistroEmpresa">Actualizar</button>
                    <button id="btn_emp_close" type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                </div>
            </form>
        </div>

    </div>
</div>
<!--Modal Registro Artista -->                     
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="Modal_RegistrarArt" >
    <div class="modal-dialog modal-lg" role="document">


        <div class="modal-content">
            <form class="form form-inline" action="../../Registros?peticion=Reg_Artista" id="Reg_Artistas" enctype="multipart/form-data">
                <div class="modal-header">
                    <div class="form_top">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h2>Registro de <span>Artista</span></h2>
                    </div> 
                </div>


                <div class="modal-body" >
                    <div class="container-fluid">
                        <span id="Error_ReArt" name="Error_ReArt" style="color: #ff0000"></span>

                        <div class="col-sm-12">    
                            <div class="form-group col-md-6">
                                <label for="ID_ARTISTA" class="control-label">Empresa: </label>
                                <select id="select_empresas" name="select_empresas" class="form-control input select" >
                                    <option value=" ">Seleccione una empresa</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-6">  
                                <label for="NOM_ARTISTA" class="control-label">Nombre Artista: </label>
                                <input name="NOM_ARTISTA" id='NOM_ARTISTA' type='text' placeholder="Nombre Artista" class="form-control input"/>      
                            </div>
                        </div>

                        <div class="col-md-12">
                            <div class="form-group col-sm-6">       
                                <label for="NOM_REPRESENTANTE" class="control-label">Nombre Representante: </label>
                                <input name="NOM_REPRESENTANTE" id='NOM_REPRESENTANTE' type='text' placeholder="Nombre Representante" class="form-control input"/>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="DOC_REPRESENTANTE" class="control-label">Documento Representante: </label>
                                <input name="DOC_REPRESENTANTE" id='DOC_REPRESENTANTE' type='text' placeholder="Documento Representante" class="form-control input"/>
                            </div>
                        </div>

                        <div class="col-md-12">
                            <div class="form-group col-sm-6">
                                <label for="TEL_REPRESENTANTE" class="control-label">Telefono Representante: </label>
                                <input name="TEL_REPRESENTANTE" id='TEL_REPRESENTANTE' type='text' placeholder="Telefono Representante" class="form-control input"/>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="COR_REPRESENTANTE" class="control-label">Correo Representante: </label>
                                <input name="COR_REPRESENTANTE" id='COR_REPRESENTANTE' type='text' placeholder="Correo Representante" class="form-control input"/>
                            </div>
                        </div>

                        <div class="col-md-12">
                            <div class="form-group col-md-6">
                                <label for="Img_art" class="control-label">Imagen Artista: </label>
                                <input id="Img_art" name="Img_art" type="file" class="fileinput-button" multiple>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button id="RegistroArtista" type="submit" class="btn btn-default" name="RegistroArtista">Registrar</button>
                        <button id="btn_art_close" type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                    </div>
                </div>
            </form>  
        </div> 

    </div>
</div>

<!--Modal Registro Operario-->
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="Modal_RegistrarOp" >
    <div class="modal-dialog modal-lg" role="document">


        <div class="modal-content">
            <form class="form form-inline" action="../../Registros?peticion=Reg_Operarios" id="Reg_Operarios" method="POST">
                <div class="modal-header">
                    <div class="form_top">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h2>Registro de <span>Operario</span></h2>
                    </div> 
                </div>
                <div class="modal-body" >
                    <span id="Error_ReOpe" style="color: #ff0000"></span>
                    <div class="container-fluid">

                        <div class="col-md-12">
                            <div class="form-group col-md-6">
                                <label for="USERNAME" class="control-label">Usuario: </label>
                                <input name="USERNAME" id='USERNAME' type='text' placeholder="Usuario" class="form-control input"/>
                            </div>

                            <div class="form-group col-md-6">
                                <label for="PASS" class="control-label">Contraseña: </label>
                                <input name="PASS" id='PASS' type='text' placeholder="Contraseña" class="form-control input"/>
                            </div>
                        </div>

                        <div class="col-md-12">
                            <div class="form-group col-md-6">
                                <label for="DOCUMENTO" class="control-label">Documento: </label>
                                <input name="DOCUMENTO" id='DOCUMENTO' type='text' placeholder="Documento" class="form-control input"/>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="NOMBRES" class="control-label">Nombres: </label>
                                <input name="NOMBRES" id='NOMBRES' type='text' placeholder="Nombres" class="form-control input"/>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group col-md-6">
                                <label for="APELLIDO1" class="control-label">Primer Apellido: </label>
                                <input name="APELLIDO1" id='APELLIDO1' type="text" placeholder="Primer Apellido " class="form-control input"/>
                            </div>   
                            <div class="form-group col-md-6">
                                <label for="APELLIDO2" class="control-label" >Segundo Apellido: </label>
                                <input name="APELLIDO2" id='APELLIDO1' style="width: 220.5px;" type="text" placeholder="Segundo Apellido " class="form-control input"/>
                            </div>   
                        </div>

                        <div class="col-md-12">
                            <div class="form-group col-md-6">
                                <label for="CORREO" class="control-label">Email: </label>
                                <input name="CORREO" id='CORREO' type='text' style="width: 220.5px;" placeholder="Email" class="form-control input"/>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="TELEFONO" class="control-label">Telefono: </label>
                                <input name="TELEFONO" id='TELEFONO' type='text' style="width: 220.5px;" placeholder="Telefono" class="form-control input"/>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group col-md-8">
                                <label for="DIRECCION" class="control-label">Direccion: </label>
                                <input name="DIRECCION" id='DIRECCION' type='text' style="width: 465px;" placeholder="Direccion" class="form-control input"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button id="RegistroOperario" type="submit" class="btn btn-default" name="RegistroOperario">Registrar</button>
                    <button id="btn_ope_close" type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                </div>
            </form>
        </div>

    </div>
</div>

<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="Modal_Venta" >
    <div class="modal-dialog modal-lg" role="document">


        <div class="modal-content">
            <form class="form form-inline" action="../../Registros?peticion=Reg_Venta" id="Re_Venta">
                <div class="modal-header">
                    <div class="form_top">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h2>Registro de <span>Ventas</span></h2>
                    </div> 
                </div>
                <div class="modal-body" >
                    <span id="Error_Venta" name="Error_Venta" style="color: #ff0000"></span>
                    <div class="container-fluid">
                        <div class="col-sm-12">    
                            <div class="form-group col-md-6">
                                <label class="control-label">Empresa: </label>
                                <select id="select_empresas_venta" onchange="cargarSelectArtistaPorEmpresa(this);" name="select_empresas_venta" class="form-control input select" >
                                    <option valor=" " value=" ">Seleccione una empresa</option>
                                </select>
                            </div>
                            <div class="form-group col-sm-6">  
                                <label class="control-label">Artista: </label>
                                <select id="select_artista_venta" name="select_artista_venta" class="form-control input select" >
                                    <option value=" ">Seleccione un Artista</option>
                                </select>
                            </div>
                        </div>

                        <div class="col-md-12">
                            <div class="form-group col-md-6">
                                <label for="CANTIDAD_OPERACIONES" class="control-label">Cantidad de Operaciones:</label>
                                <input name="CANTIDAD_OPERACIONES" onchange="operacionventa();" id="CANTIDAD_OPERACIONES" type="text" class="form-control input" placeholder="Cantidad de Operaciones"/>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="VALOR_VENTA" class="control-label">Total Venta: </label>
                                <input name="VALOR_VENTA" id="VALOR_VENTA" type="text" class="form-control input" placeholder="$ Monto total" value="" readonly/>
                            </div>
                        </div>                   
                    </div>
                </div>
                <div class="modal-footer">
                    <button id="RegistroVenta" type="submit" class="btn btn-default" name="RegistroVenta">Registrar</button>
                    <button id="btn_ope_close" type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                </div>
            </form>
        </div>

    </div>
</div>

<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="Modal_Regalias" >
    <div class="modal-dialog modal-lg" role="document">


        <div class="modal-content">

            <div class="modal-header">
                <div class="form_top">
                    <button id="btn_close_reg" type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h2>Generar  <span>Recompensas</span></h2>
                </div> 
            </div>
            <div class="modal-body" >
                <label id="Error_Regala" name="Error_Regala" style="color: #ff0000"></label>
                <div class="container-fluid">
                    <div class="date_filter col-sm-12">    
                        <div class="col-md-6"> 
                            <span id="date-label-from" class="date-label">Fecha Inicial: </span> <input class="input-sm date_range_filter date" type="text" id="from" />

                        </div><div class="col-md-6">
                            <span id="date-label-to" class="date-label"> Fecha Final: </span> <input class="input-sm date_range_filter date" type="text" id="to" />
                        </div>

                    </div>

                    <div class="col-md-12">

                    </div>                   
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-xs btn-primary" id="btn" onclick="validatorRegalias();" >Generar Regalias</button>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $("#from").datepicker({
            showOn: "button",
            buttonImage: "../../img/Calendar.png",
            buttonImageOnly: false,
            onSelect: function (date) {
                minDateFilter = new Date(date).getTime();
            }
        });

        $("#to").datepicker({
            showOn: "button",
            buttonImage: "../../img/Calendar.png",
            buttonImageOnly: false,
            onSelect: function (date) {
                maxDateFilter = new Date(date).getTime();
            }
        });

        $(".date-picker").on("change", function () {
            var id = $(this).attr("id");
            var val = $("label[for='" + id + "']").text();
            $("#msg").text(val + " changed");
        });
    });


</script>
