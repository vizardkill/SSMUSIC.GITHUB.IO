/**
 * Map representation of the object in JavaScript , developed by Softcaribbean SA
 * Author John Diaz Martinez
 *
 *
 */
var fosforito = fosforito || {};



fosforito.Map = function (){
	this.stack=new Array();
	this.key=new Array();
}
fosforito.Map.prototype.filter = function(fun,array,obj) {
    'use strict';
    var res = [];
    if (array === void 0 || array === null) {
    	alert('arreglo a filtrar esta nulo o vacio');
    	return res;
    }

    var t = Object(array);
    var len = t.length >>> 0;
    if (typeof fun !== 'function') {
    	alert('no es una funcion la especificacion de filtro');
    	return res;

    }


    var thisArg = arguments.length >= 2 ? arguments[1] : void 0;
    for (var i = 0; i < len; i++) {
      if (i in t) {
        var val = t[i];
        if (fun.call(thisArg, val, obj,i, t)) {
          res.push(val);
        }
      }
    }

    return res;
  };

  fosforito.Map.prototype.isParent=function(obj,objFind){

		var idKeyFind=objFind.key;
		var idKey=obj.key;

		if(idKey==undefined){
			alert('La key no esta definida');
			return false;
		}
		if(idKey==idKeyFind ){
			return true
		}
		return false;
	};
   /**
    * Retorna un array con las Key del Map
    * @returns {Array}
    */
   fosforito.Map.prototype.keySet=function(){
       return this.key;
   }
  /**
   * Metodo que agrega un objeto a la pila
   * @param key
   * @param obj
   */
  fosforito.Map.prototype.put=function(key,obj){
	  var objStack = new Object();
	  objStack.key=key;
	  objStack.obj=obj;
	  var arrayResultado = this.filter(this.isParent,this.stack,objStack);
	  if(arrayResultado!=null && arrayResultado.length>0){
		  var ob = arrayResultado[0];
		  objStack.id=ob.id;
		  this.stack[ob.id]=objStack;
	  }else{
		  objStack.id=this.stack.length;
		  this.stack.push(objStack);
                  this.key.push(key);
	  }
	};
	/**
	 * Metodo que retorna un objeto por la clave
	 * @param key
	 * @returns
	 */
	fosforito.Map.prototype.get=function(key){

		var objStack = new Object();
		objStack.key=key;
		var ob = null;
		try{
			var arrayResultado = this.filter(this.isParent,this.stack,objStack);
			if(arrayResultado!=null && arrayResultado.length>0){
			  ob = arrayResultado[0].obj;
			}
		}catch (e) {
			alert('get:'+e.message);
		}
		return ob;
	};

	fosforito.Map.prototype.remove=function(key){

		var objStack = new Object();
		objStack.key=key;
		var val=-1;
		try{
			var arrayResultado = this.filter(this.isParent,this.stack,objStack);
			if(arrayResultado!=null && arrayResultado.length>0){
			  this.stack.splice( arrayResultado[0].id, 1 );
                          this.key.splice( arrayResultado[0].id, 1 );
			  val=0;
			}
			this.reindex();
		}catch (e) {
			alert('remove:'+e.message);
		}
		return val;
	};
	/**
	 * Reindexa las key al eliminar un elemento
	 */
	fosforito.Map.prototype.reindex=function(){

		try{
			for(id=0;id<this.stack.length;id++){
				this.stack[id].id=id;
			}

		}catch (e) {
			alert('reindex:'+e.message);
		}

	};
	/**
	 * Retorna el Map con objetos tipo Map
	 * @returns {Array}
	 */
	fosforito.Map.prototype.getAllStack=function(){
		return this.stack;
	};


	/**
	 * Retorna el contenido de los objetos del Map,Returns the contents of the objects of Map
	 * @returns {Array}
	 */
	fosforito.Map.prototype.getAll=function(){
		var lista = new Array();
		for(id=0;id<this.stack.length;id++){
			lista.push(this.stack[id].obj);
		}
		return lista;
	};

	fosforito.Map.prototype.size=function(){
		return this.stack.length;
	};

	fosforito.Map.prototype.remote=function(){
		return this.nameremote;
	};

	fosforito.Map.prototype.setRemote=function(nameremote){
		this.nameremote=nameremote;
	};
var Map = fosforito.Map;		
