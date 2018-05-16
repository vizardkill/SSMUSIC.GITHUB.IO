<%-- 
    Document   : Modal
    Created on : 23/10/2017, 05:00:53 PM
    Author     : clan-
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--Modal para el Registro de Materias-->                        
<script src="js/gestion.js" type="text/javascript"></script>
<script src="js/gestion_operarios.js" type="text/javascript"></script>
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="Modal_RegistrarEmp" >
    <div class="modal-dialog modal-lg" role="document">
       
            <div class="modal-content">
                <div class="modal-header">
                    <div class="form_top">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h2>Registro de <span>Empresa</span></h2>
                    </div> 
                </div>
                <div class="modal-body" >
                    <div class="container-fluid" >
                         <p id="mensaje_Remp" style="color: #ff0000">${sessionScope['ErrorRegistroEmp']}</p>
                         <div class="col-sm-12">
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="NIT_EMPRESA_D">Nit: </label>
                                 <input name="NIT_EMPRESA_D" id='NIT_EMPRESA_D' required autofocus type='text' placeholder="Nit" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="NOM_EMPRESA_D">Nombre: </label>
                                 <input name="NOM_EMPRESA_D" id='NOM_EMPRESA_D' required autofocus type='text' placeholder="Nombre Empresa" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="NOM_ENCARGADO_D">Nombre Encargado: </label>
                                 <input name="NOM_ENCARGADO_D" id='NOM_ENCARGADO_D' required autofocus type='text' placeholder="Nombre Encargado" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="DOC_ENCARGADO_D">Documento Encargado: </label>
                                 <input name="DOC_ENCARGADO_D" id='DOC_ENCARGADO_D' required autofocus type='text' placeholder="Documento Encargado" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="TEL_ENCARGADO_D">Telefono: </label>
                                 <input name="TEL_ENCARGADO_D" id='TEL_ENCARGADO_D' required autofocus type='text' placeholder="Telefono Encargado" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="COR_ENCARGADO_D">Correo: </label>
                                 <input name="COR_ENCARGADO_D" id='COR_ENCARGADO_D' required autofocus type='text' placeholder="Correo Encargado" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="TIPO_OPERACION_D">Tipo Operacion </label>
                                 <input name="TIPO_OPERACION_D" id='TIPO_OPERACION_D' required autofocus type='text' placeholder="Tipo de Operacion" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="VALOR_OPERACION_D">Valor Operacion </label>
                                 <input name="VALOR_OPERACION_D" id='VALOR_OPERACION_D' required autofocus type='text' placeholder="Valor Operacion" class="form-control"/>
                             </div>
                    </div>
                         </div>
                </div>
                <div class="modal-footer">
                    <button id="RegistroEmpresa" onclick="GuardarEmpresa();" class="btn btn-default" name="RegistroEmpresa">Registrar</button>
                    <button id="btn_emp_close" type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                </div>
            </div>
        
    </div>
</div>
    <!--Modal Registro Artista -->                     
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="Modal_RegistrarArt" >
    <div class="modal-dialog modal-lg" role="document">
        
            <div class="modal-content">
                <div class="modal-header">
                    <div class="form_top">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h2>Registro de <span>Artista</span></h2>
                    </div> 
                </div>
                <div class="modal-body" >
                    <div class="container-fluid" >
                         <p id="mensaje_Rart" style="color: #ff0000">${sessionScope['ErrorRegistroArt']}</p>
                         <div class="container">
                         <div class="col-sm-2">
                                     <label for="ID_ARTISTA">Empresa: </label>
                             <select id="select_empresas" class="form-control">
                                 <option value="">Seleccione</option>
                             </select>
                                     </div>
                             
                             </div>
                         <div class="col-sm-12">
                             
                                 
                                 
                            
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="NOM_ARTISTA">Nombre Artista: </label>
                                 <input name="NOM_ARTISTA" id='NOM_ARTISTA' required autofocus type='text'placeholder="Nombre Artista" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="NOM_REPRESENTANTE">Nombre Representante: </label>
                                 <input name="NOM_REPRESENTANTE" id='NOM_REPRESENTANTE' required autofocus type='text' placeholder="Nombre Representante" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="DOC_REPRESENTANTE">Documento Representante: </label>
                                 <input name="DOC_REPRESENTANTE" id='DOC_REPRESENTANTE' required autofocus type='text' placeholder="Documento Representante" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="TEL_REPRESENTANTE">Telefono Representante: </label>
                                 <input name="TEL_REPRESENTANTE" id='TEL_REPRESENTANTE' required autofocus type='text' placeholder="Telefono Representante" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="COR_REPRESENTANTE">Correo Representante: </label>
                                 <input name="COR_REPRESENTANTE" id='COR_REPRESENTANTE' required autofocus type='text' placeholder="Correo Representante" class="form-control"/>
                             </div>
                             <div class="col-sm-9">
                                 <br/>
                                 <label for="Img_art">Imagen Artista: </label>
                                 <input id="Img_art" type="file">
                             </div>
                             </div>
                         </div>
                </div>
                <div class="modal-footer">
                    <button id="RegistroArtista" onclick="GuardarArtista();" class="btn btn-default" name="RegistroArtista">Registrar</button>
                    <button id="btn_art_close" type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                </div>
            </div>
        
    </div>
</div>                         

<div class="modal fade" id="ModalEliminar" role="dialog">
    <div class="modal-dialog"> 
        <!-- Modal content-->
        <form method="post" action="../../Registros">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h2 style="text-align: center"><span>Eliminar a <div id="Estudiante"></div></span></h2>
                </div>
                <div class="modal-body" style="background-color: #31B1E5">
                    <h4 style="text-align: center; color: #ffffff">¿Esta seguro que desea eliminar el usuario?</h4>

                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-default" name="Delete_Es" style="background-color: #d43f3a; color: white;">Aceptar</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                </div>
            </div>
        </form>
        <!--End -->
    </div>
</div>

<!--Modal Registro Operario-->
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="Modal_RegistrarOp" >
    <div class="modal-dialog modal-lg" role="document">
       
            <div class="modal-content">
                <div class="modal-header">
                    <div class="form_top">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h2>Registro de <span>Operario</span></h2>
                    </div> 
                </div>
                <div class="modal-body" >
                    <div class="container-fluid" >
                         <p id="mensaje_Rope" style="color: #ff0000">${sessionScope['ErrorRegistroEmp']}</p>
                         <div class="col-sm-12">
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="USERNAME">Usuario: </label>
                                 <input name="USERNAME" id='USERNAME' required autofocus type='text' placeholder="Usuario" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="PASS">Contraseña: </label>
                                 <input name="PASS" id='PASS' required autofocus type='text'placeholder="Contraseña" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="NOMBRES">Nombres: </label>
                                 <input name="NOMBRES" id='NOMBRES' required autofocus type='text' placeholder="Nombres" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="APELLIDO1">Primer Apellido: </label>
                                 <input name="APELLIDO1" id='APELLIDO1' required autofocus type='text' placeholder="Primer Apellido " class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="APELLIDO2">Segundo Apellido: </label>
                                 <input name="APELLIDO2" id='APELLIDO2' required autofocus type='text' placeholder="Segundo Apellido" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="DOCUMENTO">Documento: </label>
                                 <input name="DOCUMENTO" id='DOCUMENTO' required autofocus type='text' placeholder="Documento" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="CORREO">Email: </label>
                                 <input name="CORREO" id='CORREO' required autofocus type='text' placeholder="Email" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="TELEFONO">Telefono: </label>
                                 <input name="TELEFONO" id='TELEFONO' required autofocus type='text' placeholder="Telefono" class="form-control"/>
                             </div>
                             <div class="col-sm-6">
                                 <br/>
                                 <label for="DIRECCION">Direccion: </label>
                                 <input name="DIRECCION" id='DIRECCION' required autofocus type='text' placeholder="Direccion" class="form-control"/>
                             </div>
                    </div>
                         </div>
                </div>
                <div class="modal-footer">
                    <button id="RegistroOperario" onclick="RegistrarUsuario();" class="btn btn-default" name="RegistroOperario">Registrar</button>
                    <button id="btn_ope_close" type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                </div>
            </div>
        
    </div>
</div>

