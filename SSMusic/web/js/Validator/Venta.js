$(document).ready(function () {
    $('#Re_Venta').bootstrapValidator({
        feedbackIcons: {
            valid: 'fa fa-check',
            invalid: 'fa fa-times',
            validating: 'fa fa-refresh'
        },
        fields: {
            CANTIDAD_OPERACIONES: {
                validators: {
                    notEmpty: {
                        message: 'Por favor introduce un NIT'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: 'Especifica un valor numerico'
                    }
                }
            }
        }
    })

            .on('success.form.bv', function (e) {
                $('#success_message').slideDown({opacity: "show"}, "slow"); // Do something ...
                $('#Re_Venta').data('bootstrapValidator').resetForm();




                // Prevent form submission
                e.preventDefault();
                // Get the form instance
                var $form = $(e.target);

                // Get the BootstrapValidator instance
                var bv = $form.data('bootstrapValidator');

                // Use Ajax to submit form data
                $.post($form.attr('action'), $form.serialize(), function (result) {
                    if (result.result === true) {
                        // $('#table_Empresas').DataTable().ajax.reload();
                        document.getElementById("Re_Venta").reset();
                        $('#Error_Venta').text('Venta registrada con exito');
                        $('#table_VentasTxEmpresa').DataTable().ajax.reload();
                        $('#table_VentasxEmpresa').DataTable().ajax.reload();
                        $('#table_VentasxEmpresa').DataTable().ajax.reload();
                        $('#table_VentasArtistas').DataTable().ajax.reload();
                    } else {
                        $('#Error_Venta').text('Hubo problemas con el Registro');
                    }
                    setTimeout(function () {
                        document.getElementById("Error_Venta").innerHTML = "";
                        $('#Modal_Venta').modal('hide');
                    }, 2000);
                    /*if (result) {
                     $('#Error_ReEmp').text('Empresa Registrada con exito');
                     } else {
                     $('#Error_ReEmp').text('Hubo un problema');  
                     }*/

                }, 'json');
            });

});

