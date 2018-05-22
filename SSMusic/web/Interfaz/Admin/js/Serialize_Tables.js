function mostrarSelect() {
    var selectBox = document.getElementById('gestion');
    var userInput = selectBox.options[selectBox.selectedIndex].value;
    if (userInput === 'informes') {
        document.getElementById('tipo_informe').style.visibility = 'visible';
        document.getElementById('informe').style.visibility = 'visible';
    }
    if (userInput !== 'informes') {
        document.getElementById('tipo_informe').style.visibility = 'hidden';
        document.getElementById('informe').style.visibility = 'hidden';
    }
}
function mostrarInforme() {
    var selectBox = document.getElementById('informe');
    var userInput = selectBox.options[selectBox.selectedIndex].value;
    if (userInput === 'Total_Operaciones') {
        document.getElementById('no_hay').style.visibility = 'hidden';
        document.getElementById('tipo_informe').style.visibility = 'visible';
        document.getElementById('informe').style.visibility = 'visible';
        document.getElementById('table').style.visibility = 'visible';
        TablaTotalOperaciones();
    }
    if (userInput === 'VentasTotalxEmpresa') {
        document.getElementById('no_hay').style.visibility = 'hidden';
        document.getElementById('tipo_informe').style.visibility = 'visible';
        document.getElementById('informe').style.visibility = 'visible';
        document.getElementById('table').style.visibility = 'visible';
        VentasTotalxEmpresa();
    }
    if (userInput === 'VentasEmpresa') {
        document.getElementById('no_hay').style.visibility = 'hidden';
        document.getElementById('tipo_informe').style.visibility = 'visible';
        document.getElementById('informe').style.visibility = 'visible';
        document.getElementById('table').style.visibility = 'visible';
        VentasxEmpresa();
    }
    if (userInput === 'VentasArtista') {
        document.getElementById('no_hay').style.visibility = 'hidden';
        document.getElementById('tipo_informe').style.visibility = 'visible';
        document.getElementById('informe').style.visibility = 'visible';
        document.getElementById('table').style.visibility = 'visible';
        VentasxArtista();
    }
    if (userInput === '') {
        document.getElementById('tipo_informe').style.visibility = 'hidden';
        document.getElementById('informe').style.visibility = 'hidden';
        document.getElementById('table').style.visibility = 'hidden';
        document.getElementById('no_hay').style.visibility = 'visible';
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
     $('#table_VentasArtistas').dataTable().fnDestroy();
    $("#table").empty();
    $.post("Table_VentasTotalxEmpresa.jsp", $("#data").serialize(), function (data) {
        $("#table").html(data);
    });
}

function VentasxEmpresa() {
     $('#table_VentasArtistas').dataTable().fnDestroy();
    $("#table").empty();
    $.post("Table_VentasxEmpresa.jsp", $("#data").serialize(), function (data) {
        $("#table").html(data);
    });
}

function VentasxArtista() {
    $("#table").empty();
    $.post("Table_VentasArtistas.jsp", $("#data").serialize(), function (data) {
        $("#table").html(data);
    });
}