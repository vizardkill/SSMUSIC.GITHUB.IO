var xMLHttpRequest = new XMLHttpRequest();
var id_user = document.getElementById("iduser").innerHTML;
            function RegistrarUsuario() {
               
               var USERNAME = document.getElementById("USERNAME").value;
               var PASS = document.getElementById("PASS").value;
               var NOMBRES= document.getElementById("NOMBRES").value;
               var APELLIDO1 = document.getElementById("APELLIDO1").value;
               var APELLIDO2 = document.getElementById("APELLIDO2").value;
               var DOCUMENTO = document.getElementById("DOCUMENTO").value;
               var CORREO = document.getElementById("CORREO").value;
               var TELEFONO = document.getElementById("TELEFONO").value;
               var DIRECCION = document.getElementById("DIRECCION").value;
                xMLHttpRequest.open("Post", "../../Registros?USERNAME="+USERNAME+"&PASS="+PASS+"&NOMBRES="+NOMBRES+"&APELLIDO1="+APELLIDO1+"&APELLIDO2="+APELLIDO2+"&DOCUMENTO="+DOCUMENTO+"&CORREO="+CORREO+"&TELEFONO="+TELEFONO+"&ID_USUARIO_LOG="+id_user+"&DIRECCION="+DIRECCION+"&RegistroOperario=true", true);
                xMLHttpRequest.onreadystatechange = PostRegistrarUsuario;
                xMLHttpRequest.send(null);
                
            }
            
            function PostRegistrarUsuario(){
                  if (xMLHttpRequest.readyState == 4 && xMLHttpRequest.status == 200) {
                       var resp = eval('(' + xMLHttpRequest.responseText + ')');
                       console.log(resp);
                       if(resp.result === true){
                           document.getElementById("mensaje_Rope").innerHTML="Almacenado con Exito";
                           var USERNAME = document.getElementById("USERNAME").value="";
                            document.getElementById("PASS").value="";
                            document.getElementById("NOMBRES").value="";
                            document.getElementById("APELLIDO1").value="";
                            document.getElementById("APELLIDO2").value="";
                            document.getElementById("DOCUMENTO").value="";
                            document.getElementById("CORREO").value="";
                            document.getElementById("TELEFONO").value="";
                            document.getElementById("DIRECCION").value="";
                       }
                     }
                   
                  
            }

