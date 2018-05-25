
$(document).ready(function () {
    $('#table_VentasArtistas').dataTable().fnDestroy();
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

    $("div.toolbar").html('<div id="date_filter" class="col-md-6">' +
            '<span id="date-label-from" class="date-label">Fecha Inicial: </span> <input style="width: 25%" class="input-sm date_range_filter date" type="text" id="datepicker_from" />' +
            '<span id="date-label-to" class="date-label"> Fecha Final: <input style="width: 25%" class="input-sm date_range_filter date" type="text" id="datepicker_to" />' +
            '</div>');

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

    $.ajaxSetup({
        cache: false
    });

    if ($.fn.DataTable.isDataTable("#table_VentasArtistas")) {


        $.fn.dataTableExt.afnFiltering.push(
                function (oSettings, aData, iDataIndex) {
                    var iFini;
                    var iFfin;
                    if (document.getElementById('datepicker_from') !== null && document.getElementById('datepicker_to') !== null) {
                        iFini = document.getElementById('datepicker_from').value;
                        iFfin = document.getElementById('datepicker_to').value;
                    }

                    var iStartDateCol = 4;
                    var iEndDateCol = 4;

                    if (document.getElementById('datepicker_from') === 'undefined' || document.getElementById('datepicker_to') === 'undefined') {
                        return false;
                    }

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
    }
});



// Date range filter






