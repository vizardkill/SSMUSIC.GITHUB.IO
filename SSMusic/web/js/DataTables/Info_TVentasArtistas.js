var minDateFilter = "";
var maxDateFilter = "";

$(document).ready(function () {
    var table = $('#table_VentasArtistas').DataTable({
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
            url: "../../Datos?peticion=data_Informe&tipo=VentasArtistas",
            dataSrc: "VentasArtistas"
        },
        select: "single",
        columns: [
            {
                className: 'details-control',
                orderable: false,
                data: null,
                defaultContent: '',
                render: function () {
                    return '<i class="fa fa-plus-square" aria-hidden="true"></i>';
                },
                width: '15px'
            },
            {data: "NOM_ART"},
            {data: "EMP"},
            {data: "TOTAL_VENTA"},
            {
                title: "Fecha de Venta",
                data: "VENTA_FECHA",
                type: "date ",
                render: function (value) {
                    if (value === null)
                        return "";
                    return moment(value).format('DD/MM/YYYY');
                }
            }
        ],
        order: [[1, 'asc']],
        dom: 'fBrtip',
        buttons: [
            {
                extend: 'excelHtml5',
                text: '<i class="fa fa-file-excel-o"></i>',
                titleAttr: 'Excel',
                className: 'btn btn-success btn-sm m-5 width-140 assets-select-btn export-print',
                action: function (e, dt, node, config) {
                    alert("llego aki");


                    $.fn.DataTable.ext.buttons.excelHtml5.action.call(this, e, dt, node, config);
                }
            },
            {
                extend: 'csvHtml5',
                text: '<i class="fa fa-file-text-o"></i>',
                titleAttr: 'CSV',
                className: 'btn btn-info btn-sm m-5 width-140 assets-select-btn export-print',
                action: function (e, dt, node, config) {
                    alert("llego aki");


                    $.fn.DataTable.ext.buttons.csvHtml5.action.call(this, e, dt, node, config);
                }
            }
        ]
    });
    $('#table_VentasArtistas tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var tdi = tr.find('i.fa');
        var row = table.row(tr);
        if (row.child.isShown()) {
// This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
            tdi.first().removeClass('fa-minus-square');
            tdi.first().addClass('fa-plus-square');
        } else {
// Open this row
            row.child(table_VentasArtistasFormat(row.data())).show();
            tr.addClass('shown');
            tdi.first().removeClass('fa-plus-square');
            tdi.first().addClass('fa-minus-square');
        }
    });
    table.on('user-select', function (e, dt, type, cell, originalEvent) {
        if ($(cell.node()).hasClass('details-control')) {
            e.preventDefault();
        }
    });


    $("#datepicker_from").datepicker({
        showOn: "button",
        buttonImage: "images/calendar.gif",
        buttonImageOnly: false,
        onSelect: function (date) {
            var minDateFilter = new Date(date).getTime();
            table.fnDraw();
        }
    }).keyup(function () {
        var minDateFilter = new Date(this.value).getTime();
        table.fnDraw();
    });

    $("#datepicker_to").datepicker({
        showOn: "button",
        buttonImage: "images/calendar.gif",
        buttonImageOnly: false,
        onSelect: function (date) {
            var maxDateFilter = new Date(date).getTime();
            table.fnDraw();
        }
    }).keyup(function () {
        var maxDateFilter = new Date(this.value).getTime();
        table.fnDraw();
    });

});
function table_VentasArtistasFormat(d) {
    // `d` is the original data object for the row
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
            '<tr>' +
            '<td><b>Fecha de Registro:</b></td>' +
            '<td>' + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>Nombre del Encargado:</b></td>' +
            '<td>' + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>Documento del Encargo:</b></td>' +
            '<td>' + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>Telefono del Encargado:</b></td>' +
            '<td>' + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>Correo del Encargado:</b></td>' +
            '<td>' + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>Informacion Adicional:</b></td>' +
            '<td>Descripcion de la empresa...</td>' +
            '</tr>' +
            '</table>';
}


// Date range filter


$.fn.dataTableExt.afnFiltering.push(
        function (oSettings, aData, iDataIndex) {
            if (typeof aData._date === 'undefined') {
                aData._date = new Date(aData[0]).getTime();
            }

            if (minDateFilter && !isNaN(minDateFilter)) {
                if (aData._date < minDateFilter) {
                    return false;
                }
            }

            if (maxDateFilter && !isNaN(maxDateFilter)) {
                if (aData._date > maxDateFilter) {
                    return false;
                }
            }

            return true;
        }
);



