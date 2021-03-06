/* 
 * Este Script sirve para manipular los datos de la tabla
 * @author Santiago Cardona Saldarriaga
 * @version 28/03/2018
 * @see https://datatables.net/
 */
$(document).ready(function () {
    var table = $('#table_Operarios').DataTable({
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
            url: "../../Datos?peticion=data_ope",
            dataSrc: "Operarios"
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
            {data: "DOCUMENTO"},
            {data: "USERNAME"},
            {data: "TIPO_PERFIL"},
            {data: "FECHA_REGISTRO"},
            {data: "acciones"}
        ],
        order: [[1, 'asc']],
        dom: 'frtlip'
    });
    $('#table_Operarios tbody').on('click', 'td.details-control', function () {
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
            row.child(table_OperariosFormat(row.data())).show();
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
        if (confirm("Desea eliminar al usuario?")) {
            var data = table.row($(this).parents('tr')).data();
            data = data.Id;
            $.post("../../Datos?peticion=EliminarOperario", {Id: data}, function (result) {
                if (result) {
                    $('#table_Operarios').DataTable().ajax.reload();
                    alert("El usuario fue eliminado con exito!");
                } else {
                    alert("El usuario no pudo ser eliminado");
                    $('#table_Operarios').DataTable().ajax.reload();
                }
            }, 'json');

        } else {
            alert("presiono cancelar");
        }
    });
});
function table_OperariosFormat(d) {
    // `d` is the original data object for the row
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
            '<tr>' +
            '<td><b>Fecha de Registro:</b></td>' +
            '<td>' + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>Nombre del Encargado:</b></td>' +
            '<td>'  + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>Documento del Encargo:</b></td>' +
            '<td>'  + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td><b>Telefono del Encargado:</b></td>' +
            '<td>'  + '</td>' +
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

