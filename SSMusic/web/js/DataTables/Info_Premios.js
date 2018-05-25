
$(document).ready(function () {
    $('#table_premios').dataTable().fnDestroy();
    var table = $('#table_premios').DataTable({
        language: {
            sProcessing: "Procesando...",
            sLengthMenu: "Mostrar _MENU_  Registros",
            sZeroRecords: "No se encontraron resultados",
            sEmptyTable: "Ningún dato disponible en esta tabla",
            sInfo: "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            sInfoEmpty: "Mostrando registros del 0 al 0 de un total de 0 registros",
            sInfoFiltered: "(filtrado de un total de _MAX_ registros)",
            sInfoPostFix: "",
            sSearch: "Buscar:",
            sUrl: "",
            sInfoThousands: ",",
            sLoadingRecords: "Cargando...",
            oPaginate: {
                sFirst: "Primero",
                sLast: "Último",
                sNext: "Siguiente",
                sPrevious: "Anterior"
            },
            oAria: {
                sSortAscending: ": Activar para ordenar la columna de manera ascendente",
                sSortDescending: ": Activar para ordenar la columna de manera descendente"
            }
        },
        ajax: {
            method: "GET",
            url: "../../Datos?peticion=data_Informe&tipo=ArtistasConDisco",
            dataSrc: "ArtistasPremiados"
        },
        select: "single",
        columns: [
            {data: "USERNAME"},
            {data: "NOM_ARTISTA"},
            {data: "NOM_TREG"}, 
            {data: "FECHA_REGALIA"}
        ],
        order: [[1, 'asc']],
        dom: 'fBrtip',
        buttons: [
            {
                extend: 'excelHtml5',
                text: '<i class="fa fa-file-excel"> Generar Informe</i>',
                titleAttr: 'Excel',
                className: 'btn btn-success btn-sm m-5 width-140 assets-select-btn export-print',
                action: function (e, dt, node, config) {
                    alert("llego aki");


                    $.fn.DataTable.ext.buttons.excelHtml5.action.call(this, e, dt, node, config);
                }
            }
        ]
    });

});



// Date range filter







