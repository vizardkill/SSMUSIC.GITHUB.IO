var xMLHttpRequest = new XMLHttpRequest();




function GuardarEmpresa() {
    var NIT_EMPRESA_D = document.getElementById("NIT_EMPRESA_D").value;
    var NOM_EMPRESA_D = document.getElementById("NOM_EMPRESA_D").value;
    var NOM_ENCARGADO_D = document.getElementById("NOM_ENCARGADO_D").value;
    var DOC_ENCARGADO_D = document.getElementById("DOC_ENCARGADO_D").value;
    var TEL_ENCARGADO_D = document.getElementById("TEL_ENCARGADO_D").value;
    var COR_ENCARGADO_D = document.getElementById("COR_ENCARGADO_D").value;
    var TIPO_OPERACION_D = document.getElementById("TIPO_OPERACION_D").value;
    var VALOR_OPERACION_D = document.getElementById("VALOR_OPERACION_D").value;

    xMLHttpRequest.open("Post", "../../Registros?NIT_EMPRESA_D=" + NIT_EMPRESA_D + "&NOM_EMPRESA_D=" + NOM_EMPRESA_D + "&NOM_ENCARGADO_D=" + NOM_ENCARGADO_D + "&DOC_ENCARGADO_D=" + DOC_ENCARGADO_D + "&TEL_ENCARGADO_D=" + TEL_ENCARGADO_D + "&COR_ENCARGADO_D=" + COR_ENCARGADO_D + "&TIPO_OPERACION_D=" + TIPO_OPERACION_D + "&VALOR_OPERACION_D=" + VALOR_OPERACION_D + "&ID_USUARIO_LOG=" + id_user + "&RegistroEmpresa=true", true);
    xMLHttpRequest.onreadystatechange = PostGuardarEmpresa;
    xMLHttpRequest.send(null);
}

function PostGuardarEmpresa() {
    if (xMLHttpRequest.readyState == 4 && xMLHttpRequest.status == 200) {
        var resp = eval('(' + xMLHttpRequest.responseText + ')');
        
        if (resp.result === true) {
            document.getElementById("mensaje_Remp").innerHTML = "";
            document.getElementById("mensaje_Remp").innerHTML = "Almacenado con Exito";
            document.getElementById("NIT_EMPRESA_D").value = "";
            document.getElementById("NOM_EMPRESA_D").value = "";
            document.getElementById("NOM_ENCARGADO_D").value = "";
            document.getElementById("DOC_ENCARGADO_D").value = "";
            document.getElementById("TEL_ENCARGADO_D").value = "";
            document.getElementById("COR_ENCARGADO_D").value = "";
            document.getElementById("TIPO_OPERACION_D").value = "";
            document.getElementById("VALOR_OPERACION_D").value = "";

        }
    }
}

function cargarSelectEmpresa(respuesta) {

    var select = document.getElementById("select_empresas");
    for (var i = 0; i < respuesta.length; i++) {
        var obj = respuesta[i];
        var option = document.createElement("option");
        option.setAttribute("value", obj.ID_EMPRESA_D);
        var contenido = document.createTextNode(obj.NOM_EMPRESA_D);
        select.appendChild(option);
        option.appendChild(contenido);
    }
}

function validarEmpresa(){
   var error = document.getElementById("mensaje_Remp");
   var resultado = validarInput("Modal_RegistrarEmp",error);
   if(!resultado){
       GuardarEmpresa();
   }
};

function validarInput(pad, lbl_error) {
    document.getElementById("mensaje_Remp").innerHTML = "";
    console.log(pad);
    var valido = false;
    var mensaje = "";
    try {
        expr_email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

        var padre = document.getElementById(pad);
        console.log(padre);
        var inputs = padre.getElementsByTagName("input");
        var selects = padre.getElementsByTagName("select");
        if (inputs != undefined && inputs.length > 0) {
            for (id = 0; id < inputs.length; id++) {


                var required = inputs[id].getAttribute('required');
                var nombre_campo = inputs[id].getAttribute('name');
                var minlength = inputs[id].getAttribute('minlength');
                var pattern = inputs[id].getAttribute('pattern');
                var val = inputs[id].value;
                if (required != null) {
                    if (val.trim() == '') {
                        mensaje = mensaje + 'El campo ' + nombre_campo + ' es obligatorio <br>';
                        valido = true;
                    }
                }
                if (pattern != null) {
                    if (pattern == 'email') {
                        if (!expr_email.test(val)) {
                            mensaje = mensaje + 'El campo ' + nombre_campo + ' no contiene un email valido  <br>';
                            valido = true;
                        }
                    } else {
                        pattern = new RegExp(pattern);
                        if (!pattern.test(val)) {
                            mensaje = mensaje + 'El campo ' + nombre_campo + ' no parece valido   <br>';
                            valido = true;
                        }
                    }
                }
                if (minlength != null) {
                    if (val.length < minlength) {
                        mensaje = mensaje + 'El campo ' + nombre_campo + ' debe contener al menos ' + minlength + ' <br>';
                        valido = true;
                    }
                }

            }
        }
        if (selects != undefined && selects.length > 0) {
            for (id = 0; id < selects.length; id++) {
                var nombre_campo = selects[id].getAttribute('name');
                var required = selects[id].getAttribute('required');
                if (required != null) {
                    var val = selects[id].selectedIndex;
                    if (val == 0) {
                        mensaje = mensaje + 'Seleccione ' + nombre_campo + ' es obligatorio   <br>';
                        valido = true;
                    }
                }
            }
        }
        if (valido) {
             document.getElementById("mensaje_Remp").innerHTML = mensaje;
            console.log(mensaje);
        }
        return valido;
    } catch (e) {
        console.error(e, e.stack);
    }
}

function GuardarArtista() {
    var select = document.getElementById("select_empresas");
    var selectedOption = select.options[select.selectedIndex];
    var SRC = "../../img/male.png";
    var NOM_ARTISTA = document.getElementById("NOM_ARTISTA").value;
    var NOM_REPRESENTANTE = document.getElementById("NOM_REPRESENTANTE").value;
    var DOC_REPRESENTANTE = document.getElementById("DOC_REPRESENTANTE").value;
    var TEL_REPRESENTANTE = document.getElementById("TEL_REPRESENTANTE").value;
    var COR_REPRESENTANTE = document.getElementById("COR_REPRESENTANTE").value;
    
    if(document.getElementById("Img_art").value !==""){
        var SRC = document.getElementById("Img_art").files[0].name;
        SRC = "../../img/Icons_art/"+SRC;
    }
    
    
    

    xMLHttpRequest.open("Post", "../../Registros?NOM_ARTISTA=" + NOM_ARTISTA + "&NOM_REPRESENTANTE=" + NOM_REPRESENTANTE + "&DOC_REPRESENTANTE=" + DOC_REPRESENTANTE + "&TEL_REPRESENTANTE=" + TEL_REPRESENTANTE + "&COR_REPRESENTANTE=" + COR_REPRESENTANTE + "&ID_USUARIO_LOG=" + id_user +"&SRC="+SRC+ "&RegistroArtista=true&ID_EMPRESA_D_ART=" + selectedOption.value, true);
    xMLHttpRequest.onreadystatechange = PostGuardarArtista;
    xMLHttpRequest.send(null);

}

function PostGuardarArtista() {
    if (xMLHttpRequest.readyState == 4 && xMLHttpRequest.status == 200) {
        var resp = eval('(' + xMLHttpRequest.responseText + ')');
        
        if (resp.result === true) {
            document.getElementById("select_empresas").value = "";
            document.getElementById("mensaje_Rart").innerHTML = "Almacenado con Exito";
            document.getElementById("NOM_ARTISTA").value = "";
            document.getElementById("NOM_REPRESENTANTE").value = "";
            document.getElementById("DOC_REPRESENTANTE").value = "";
            document.getElementById("TEL_REPRESENTANTE").value = "";
            document.getElementById("COR_REPRESENTANTE").value = "";
        }
    }
}

function ListarEmpresa() {
    xMLHttpRequest.open("Post", "../../Registros?peticion=listarEmpresa", true);
    xMLHttpRequest.onreadystatechange = PostListarEmpresa;
    xMLHttpRequest.send(null);

}

function PostListarEmpresa() {
    if (xMLHttpRequest.readyState == 4 && xMLHttpRequest.status == 200) {
        var resp = eval('(' + xMLHttpRequest.responseText + ')');
        cargarSelectEmpresa(resp);
    }
}


function ListarArtista(id) {
    
    
    xMLHttpRequest.open("Post", "../../Registros?ID_EMPRESA_D="+id+"&peticion=listarArt", true);
    xMLHttpRequest.onreadystatechange = PostListarArtista;
    xMLHttpRequest.send(null);

}

function PostListarArtista() {
    if (xMLHttpRequest.readyState == 4 && xMLHttpRequest.status == 200) {
        var resp = eval('(' + xMLHttpRequest.responseText + ')');
        
        var select = document.getElementById("select_artista_venta");
        cargarSelectArtistaVenta(resp,select);
        
    }
}

function ListarArtistaPorEmpresa() {
    xMLHttpRequest.open("Post", "../../Registros?peticion=listarEmpresa", true);
    xMLHttpRequest.onreadystatechange = PostListarArtistaPorEmpresa;
    xMLHttpRequest.send(null);

}

function PostListarArtistaPorEmpresa() {
    if (xMLHttpRequest.readyState == 4 && xMLHttpRequest.status == 200) {
        var resp = eval('(' + xMLHttpRequest.responseText + ')');
        
        var select = document.getElementById("select_empresas_venta");
        cargarSelectEmpresaVenta(resp,select);
    }
}

function cargarSelectEmpresaVenta(respuesta, select) {

    document.getElementById("select_empresas_venta").length=1;
    for (var i = 0; i < respuesta.length; i++) {
        var obj = respuesta[i];
        var option = document.createElement("option");
        option.setAttribute("value", obj.ID_EMPRESA_D);
        option.setAttribute("valor", obj.VALOR_OPERACION_D);
        var contenido = document.createTextNode(obj.NOM_EMPRESA_D);
        select.appendChild(option);
        option.appendChild(contenido);
    }

}
function cargarSelectArtistaVenta(respuesta, select) {

    document.getElementById("select_artista_venta").length=1;
    for (var i = 0; i < respuesta.length; i++) {
        var obj = respuesta[i];
        var option = document.createElement("option");
        option.setAttribute("value", obj.ID_ARTISTA);
        var contenido = document.createTextNode(obj.NOM_ARTISTA);
        select.appendChild(option);
        option.appendChild(contenido);
    }

}

function cargarSelectArtistaPorEmpresa(respuesta) {
    ListarArtista(respuesta.value);
 }

function operacionventa(){
    var select = document.getElementById("select_empresas_venta");
    var selectedOption = select.options[select.selectedIndex];
    
    
    var valor_venta = selectedOption.getAttribute("valor");
    var cantidad = document.getElementById("CANTIDAD_OPERACIONES").value;
    var total = valor_venta * cantidad;
    document.getElementById("VALOR_VENTA").value=total;
    
}

function generarInformeRangoFecha() {
    var date_start = document.getElementById("datepicker_from").value;
    console.log(date_start);
    var date_end = document.getElementById("datepicker_to").value;
    console.log(date_end);
    xMLHttpRequest.open("Get", "../../Datos?date_start="+date_start+"&date_end="+date_end+"&peticion=informeArtistasPorFecha", true);
    xMLHttpRequest.onreadystatechange = PostgenerarInformeRangoFecha;
    xMLHttpRequest.send(null);

}

function PostgenerarInformeRangoFecha() {
    if (xMLHttpRequest.readyState == 4 && xMLHttpRequest.status == 200) {
        var resp = eval('(' + xMLHttpRequest.responseText + ')');
        console.log(resp);
    }
}
function generarReg() {
    
    xMLHttpRequest.open("Post", "../../Registros?peticion=generar", true);
    xMLHttpRequest.onreadystatechange = PostgenerarRegalias;
    xMLHttpRequest.send(null);

}

function PostgenerarRegalias() {
    if (xMLHttpRequest.readyState == 4 && xMLHttpRequest.status == 200) {
        var resp = eval('(' + xMLHttpRequest.responseText + ')');
        
        console.log(resp);
    }
}

