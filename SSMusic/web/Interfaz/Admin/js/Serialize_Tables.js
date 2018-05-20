function mostrarArtista() {
    var selectBox = document.getElementById('Tables');
    var userInput = selectBox.options[selectBox.selectedIndex].value;
    if (userInput !== '') {
        document.getElementById('no_hay').style.visibility = 'hidden';
        document.getElementById('table').style.visibility = 'visible';

        TablasArtista();
    }
    if (userInput === '') {
        document.getElementById('table').style.visibility = 'hidden';
        document.getElementById('no_hay').style.visibility = 'visible';
    }
}
function TablasArtista() {
    $.post("Table_Artistas.jsp", $("#data").serialize(), function (data) {
        $("#table").html(data);
    });
}


//
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
    if (userInput !== '') {
        document.getElementById('no_hay').style.visibility = 'hidden';
        document.getElementById('tipo_informe').style.visibility = 'visible';
        document.getElementById('informe').style.visibility = 'visible';
        document.getElementById('table').style.visibility = 'visible';
        TablaTotalVentasxDiufusion();
    }
    if (userInput === '') {
        document.getElementById('tipo_informe').style.visibility = 'hidden';
        document.getElementById('informe').style.visibility = 'hidden';
        document.getElementById('table').style.visibility = 'hidden';
        document.getElementById('no_hay').style.visibility = 'visible';
    }
}
function TablaTotalVentasxDiufusion() {
    $.post("Table_Operaciones.jsp", $("#data").serialize(), function (data) {
        $("#table").html(data);
    });
}

