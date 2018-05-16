/* 
 * Este Script sirve para manipular los datos de la tabla
 * @author Santiago Cardona Saldarriaga
 * @version 28/03/2018
 * @see https://datatables.net/
 */
$(document).ready(function () {
    var table = $('#table_Empresas').DataTable({
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
            url: "../../Datos?peticion=data_emp",
            dataSrc: "Empresas"
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
            {data: "NIT_Empresa"},
            {data: "Nom_Empresa"},
            {data: "Tipo_operacion"},
            {
                data: "Valor_operacion",
                render: $.fn.dataTable.render.number(',', '.', 0, '$')
            },
            {data: "acciones"}
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
    $('#table_Empresas tbody').on('click', 'td.details-control', function () {
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
            row.child(Empresasformat(row.data())).show();
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
    $(document).on('click', '.btn_delete', function () {
        var id = $(this).attr('id');
        var row = $(this).parent().parent();
        var nombre = $(this).parents("tr").find("td")[1].innerHTML;
        $('#Estudiante').html(nombre);
    });
});
function Empresasformat(d) {
    // `d` is the original data object for the row
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
            '<tr>' +
            '<td><b>Fecha de Registro:</b></td>' +
            '<td>' + d.FECHA_REGISTRO_D + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>Nombre del Encargado:</b></td>' +
            '<td>' + d.NOM_ENCARGADO_D + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>Documento del Encargo:</b></td>' +
            '<td>' + d.DOC_ENCARGADO_D + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>Telefono del Encargado:</b></td>' +
            '<td>' + d.TEL_ENCARGADO_D + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>Correo del Encargado:</b></td>' +
            '<td>' + d.COR_ENCARGADO_D + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>Informacion Adicional:</b></td>' +
            '<td>Descripcion de la empresa...</td>' +
            '</tr>' +
            '</table>';
}
