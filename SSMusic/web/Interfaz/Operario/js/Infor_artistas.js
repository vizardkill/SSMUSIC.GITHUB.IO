/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var grupo_labor = new GroupImage('grupo_labor');
                        
    var xMLHttpRequest = new XMLHttpRequest();
            function ServletArtista() {
               
                xMLHttpRequest.open("Get", "../../Artista", true);
                xMLHttpRequest.onreadystatechange = listarArtistas;
                xMLHttpRequest.send(null);
                
            }
            
            function listarArtistas(){
                  if (xMLHttpRequest.readyState == 4 && xMLHttpRequest.status == 200) {
                       var resp = eval('(' + xMLHttpRequest.responseText + ')');
                       console.log(resp);
                       
                       grupo_labor.create();
                        grupo_labor.show(resp.respuesta);
                         
                          
                          
                      }
                   
                  
            }
            
  

  function abrirY(obj) {
    console.log(obj);
  }  
            
function myfunction(){
    
}

  var Token = function (){

};
  Token.NullPointer=function(obj,nameAtt){
  	try{

  		eval('var data = obj.'+nameAtt);
  		if(data==undefined){
  			return '';
  		}
  		return data;
  	}catch(e){
  		return '';
  	}


  };
