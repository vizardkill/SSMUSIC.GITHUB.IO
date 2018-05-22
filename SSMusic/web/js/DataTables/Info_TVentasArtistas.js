
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
            {data: "VENTA_FECHA"}
        ],
        order: [[1, 'asc']],
        dom: '<"toolbar">Brtip',
        buttons: [
            {
                extend: 'excelHtml5',
                text: '<i class="fa fa-file-excel"></i>',
                titleAttr: 'Excel',
                className: 'btn btn-success btn-sm m-5 width-140 assets-select-btn export-print',
                action: function (e, dt, node, config) {
                    alert("llego aki");


                    $.fn.DataTable.ext.buttons.excelHtml5.action.call(this, e, dt, node, config);
                }
            }
        ]
    });

    $("div.toolbar").html('<div id="date_filter" class="col-md-6">' +
            '<span id="date-label-from" class="date-label">Fecha Inicial: </span> <input class="input-sm date_range_filter date" type="text" id="datepicker_from" />' +
            '<span id="date-label-to" class="date-label"> Fecha Final: <input class="input-sm date_range_filter date" type="text" id="datepicker_to" />' +
            '</div>');

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
        buttonImage: "../../img/Calendar.png",
        buttonImageOnly: false,
        onSelect: function (date) {
            minDateFilter = new Date(date).getTime();
            table.draw();
        }
    }).keyup(function () {
        minDateFilter = new Date(this.value).getTime();
        table.draw();
    });

    $("#datepicker_to").datepicker({
        showOn: "button",
        buttonImage: "../../img/Calendar.png",
        buttonImageOnly: false,
        onSelect: function (date) {
            maxDateFilter = new Date(date).getTime();
            table.draw();
        }
    }).keyup(function () {
        maxDateFilter = new Date(this.value).getTime();
        table.draw();
    });

    $(".date-picker").on("change", function () {
        var id = $(this).attr("id");
        var val = $("label[for='" + id + "']").text();
        $("#msg").text(val + " changed");
    });


    $.fn.dataTableExt.afnFiltering.push(
            function (oSettings, aData, iDataIndex) {
                var iFini = document.getElementById('datepicker_from').value;
                var iFfin = document.getElementById('datepicker_to').value;
                var iStartDateCol = 4;
                var iEndDateCol = 4;

                iFini = iFini.substring(6, 10) + iFini.substring(3, 5) + iFini.substring(0, 2);
                iFfin = iFfin.substring(6, 10) + iFfin.substring(3, 5) + iFfin.substring(0, 2);

                var datofini = aData[iStartDateCol].substring(6, 10) + aData[iStartDateCol].substring(3, 5) + aData[iStartDateCol].substring(0, 2);
                var datoffin = aData[iEndDateCol].substring(6, 10) + aData[iEndDateCol].substring(3, 5) + aData[iEndDateCol].substring(0, 2);

                if (iFini === "" && iFfin === "")
                {
                    return true;
                } else if (iFini <= datofini && iFfin === "")
                {
                    return true;
                } else if (iFfin >= datoffin && iFini === "")
                {
                    return true;
                } else if (iFini <= datofini && iFfin >= datoffin)
                {
                    return true;
                }
                return false;
            }
    );
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






