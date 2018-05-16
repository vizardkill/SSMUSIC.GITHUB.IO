

var GroupImage = function(id){
  this.id=id;
  this.stack=new fosforito.Map();
};
GroupImage.prototype.create=function(){
  this.init();
  this.createContainer();
};
GroupImage.prototype.init=function(){
  var root = document.getElementById(this.id);
  this.classcontainer = root.getAttribute("classcontainer");
  this.classrow       =root.getAttribute("classrow");
  this.containerrow   =root.getAttribute("containerrow");
  this.maxcolumn=       root.getAttribute("maxcolumn");
  this.containerimg= root.getAttribute("containerimg");
  this.initBody();
  root.innerHTML = '';

};

GroupImage.prototype.initBody = function () {
    try {

        var root = document.getElementById(this.id);
        var tagGroup = root.childNodes[1];

        this.src = tagGroup.getAttribute("src");
        this.title = tagGroup.getAttribute("title");
        this.trigger = tagGroup.getAttribute("trigger");


    } catch (e) {
        console.log('initHead->' + e.message);
    }
};

GroupImage.prototype.createContainer=function(){
  try{
     var root = document.getElementById(this.id);
      var container = document.createElement("div");

      container.setAttribute("class",this.classcontainer);
        container.setAttribute("id",this.id+'_container');

      root.appendChild(container);
  }catch(e){
    console.log(e.message);
  }
};


GroupImage.prototype.show=function(array){
  try{
    var container = document.getElementById(this.id+'_container');
    var longitud = array.length;
    var countcol = 1;

   for (var index = 0; index < longitud; index++) {
     if (countcol === 1) {

       var containerRow=this.createContainerRow();
       containerRow.appendChild(this.createColumn(array[index]));

       var row = this.createRow(containerRow);
       container.appendChild(row);
       countcol++;
     } else {
       if (countcol > this.maxcolumn) {
         countcol = 1;
         var containerRow=this.createContainerRow();
         containerRow.appendChild(this.createColumn(array[index]));

         var row = this.createRow(containerRow);
         container.appendChild(row);
         countcol++;
       } else {
         containerRow.appendChild(this.createColumn(array[index]));
         countcol++;
       }
     }
   }
 } catch (e) {
   console.log('show->' + e.message);
 }


};
GroupImage.prototype.createRow=function(containerRow){
  try{
      var row = document.createElement("div");
      row.setAttribute("class",this.classrow);
      row.appendChild(containerRow);
  }catch(e){
    console.log(e.message);
  }
  return row;
};

GroupImage.prototype.createContainerRow=function(){
  try{

      var containerrow = document.createElement("div");
      containerrow.setAttribute("class",this.containerrow);


  }catch(e){
    console.log(e.message);
  }
  return containerrow;
};
GroupImage.prototype.createColumn=function(obj){
  try{

     var idkey = Math.floor(Math.random() * 1000000) + '';
      var column = document.createElement("div");
      column.setAttribute("class",this.containerimg);
      this.stack.put(idkey,obj);
      var a = document.createElement("a");
      a.setAttribute("style","cursor:pointer;");
      a.setAttribute("title",eval('obj.'+this.title));
      a.setAttribute("href","javaScript:"+this.id+".event('"+idkey+"')");


        var img = document.createElement("img");

        //eval("img.setAttribute('src','data:text/javascript;base64,'+Token.NullPointer(obj,'" + this.src + "'));");
        img.setAttribute("src",eval('obj.'+this.src));
        img.setAttribute("class","img-circle img-responsive");
        img.setAttribute("id",idkey);
        a.appendChild(img);
        column.appendChild(a);

  }catch(e){
    console.log(e.message);
  }
  return column;
};

GroupImage.prototype.Empty = function () {
    try {
        var cont = document.getElementById("grupo_labor_container");
        while (cont.firstChild) {
            cont.removeChild(cont.firstChild);
        }
    } catch (e) {
        console.log(e.message);
    }
};

GroupImage.prototype.event=function(key){
     var obj = this.stack.get(key);
     var funcion= eval(this.trigger+'(obj)');
     funcion;

};
