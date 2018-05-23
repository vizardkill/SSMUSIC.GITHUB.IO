function mostrarSelectArtistas() {
    var selectBox = document.getElementById('cbx_Artista');
    var userInput = selectBox.options[selectBox.selectedIndex].value;
    if (userInput === 'Table_Artistas') {
        document.getElementById('no_hay').style.visibility = 'hidden';
        document.getElementById('table').style.visibility = 'visible';
        Table_Artista();
    }
    if (userInput === 'Table_TOperaciones') {
        document.getElementById('no_hay').style.visibility = 'hidden';
        document.getElementById('table').style.visibility = 'visible';
        TablaTotalOperaciones();
    }
    if (userInput === '') {
        document.getElementById('no_hay').style.visibility = 'visible';
        document.getElementById('table').style.visibility = 'hidden';
    }
}

function mostrarSelectGananciaEmpresa() {
    var selectBox = document.getElementById('cbx_GananciaEmpresa');
    var userInput = selectBox.options[selectBox.selectedIndex].value;
    if (userInput === 'Table_VentasxEmpresa') {
        document.getElementById('no_hay').style.visibility = 'hidden';
        document.getElementById('table_gananciaEmpresa').style.visibility = 'visible';
        VentasxEmpresa();
    }
    if (userInput === 'Table_VentasTxEmpresa') {
        document.getElementById('no_hay').style.visibility = 'hidden';
        document.getElementById('table_gananciaEmpresa').style.visibility = 'visible';
        VentasTotalxEmpresa();
    }
    if (userInput === '') {
        document.getElementById('no_hay').style.visibility = 'visible';
        document.getElementById('table_gananciaEmpresa').style.visibility = 'hidden';
    }


}
function TablaTotalOperaciones() {
    $('#table_VentasArtistas').dataTable().fnDestroy();
    $("#table").empty();
    $.post("Table_TOperaciones.jsp", $("#data").serialize(), function (data) {
        $("#table").html(data);
    });
}

function VentasTotalxEmpresa() {
    $("#table_gananciaEmpresa").empty();
    $.post("Table_VentasTxEmpresa.jsp", $("#data").serialize(), function (data) {
        $("#table_gananciaEmpresa").html(data);
    });
}

function VentasxEmpresa() {
    $("#table_gananciaEmpresa").empty();
    $.post("Table_VentasxEmpresa.jsp", $("#data").serialize(), function (data) {
        $("#table_gananciaEmpresa").html(data);
    });
}

function VentasxArtista() {
    $("#table").empty();
    $.post("Table_VentasArtistas.jsp", $("#data").serialize(), function (data) {
        $("#table").html(data);
    });
}


function Table_Artista() {
    $("#table").empty();
    $.post("Table_Artistas.jsp", $("#data").serialize(), function (data) {
        $("#table").html(data);
    });
}
