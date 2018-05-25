/* 
 * Este Script sirve para manipular los datos de la tabla
 * @author Santiago Cardona Saldarriaga
 * @version 28/03/2018
 * @see https://datatables.net/
 */
$(document).ready(function () {
    $('#table_TOperaciones').dataTable().fnDestroy();
    var table = $('#table_TOperaciones').DataTable({
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
            url: "../../Datos?peticion=data_Informe&tipo=TOperaciones",
            dataSrc: "TOperaciones"
        },
        select: "single",
        columns: [
            {data: "ID_EMP"},
            {data: "EMP"},
            {data: "ID_ART"},
            {data: "NOM_ART"},
            {data: "TOTAL_OPERACIONES"}
        ],
        order: [[1, 'asc']],
        dom: 'frtlip'
    });
});

