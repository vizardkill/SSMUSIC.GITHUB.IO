$(document).ready(function () {
    $('#Reg_Empresa').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            NIT_EMPRESA_D: {
                validators: {
                    stringLength: {
                        min: 3,
                        max: 8,
                        message: 'Por introduce un NIT de minimo 3 caracteres y maximo 8'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un NIT'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: 'El NIT no puede contener valores alfabeticos'
                    }
                }
            },

            NOM_EMPRESA_D: {
                validators: {
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: 'El nombre debe ser de un minimo de 3 caracteres y maximo 20'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un nombre'
                    },
                    regexp: {
                        regexp: /^[a-z\s]+$/i,
                        message: 'El nombre no puede contener caracteres especiales ni numeros'
                    }
                }
            },
            NOM_ENCARGADO_D: {
                validators: {
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: 'El nombre debe ser de un minimo de 3 caracteres y maximo 20'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un nombre'
                    },
                    regexp: {
                        regexp: /^[a-z\s]+$/i,
                        message: 'El nombre no puede contener caracteres especiales ni numeros'
                    }
                }
            },
            DOC_ENCARGADO_D: {
                validators: {
                    stringLength: {
                        min: 10,
                        max: 15,
                        message: 'El documento debe ser de un minimo de 8 caracteres y maximo 15'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un documento valido'
                    }
                }
            },
            TEL_ENCARGADO_D: {
                validators: {
                    stringLength: {
                        min: 7,
                        max: 12,
                        message: 'Por favor introduce un numero telefonico de un minimo de 7 caracteres y maximo 12'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un numero telefonico'
                    }
                }
            },
            COR_ENCARGADO_D: {
                validators: {
                    emailAddress: {
                        message: 'Por favor introduce un correo electronico valido'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un numero telefonico'
                    }
                }
            },
            TIPO_OPERACION_D: {
                validators: {
                    notEmpty: {
                        message: 'Por favor introduce un tipo de operacion'
                    }
                }
            },
            VALOR_OPERACION_D: {
                validators: {
                    notEmpty: {
                        message: 'Por favor introduce un monto $'
                    }
                }
            }
        }
    })

            .on('success.form.bv', function (e) {
                $('#success_message').slideDown({opacity: "show"}, "slow"); // Do something ...
                $('#Reg_Empresa').data('bootstrapValidator').resetForm();




                // Prevent form submission
                e.preventDefault();
                // Get the form instance
                var $form = $(e.target);

                // Get the BootstrapValidator instance
                var bv = $form.data('bootstrapValidator');

                // Use Ajax to submit form data
                $.post($form.attr('action'), $form.serialize(), function (result) {
                    if (result) {
                        $('#table_Empresas').DataTable().ajax.reload();
                        $('#Error_ReEmp').text('Empresa registrada con Exito');
                    } else {
                         $('#Error_ReEmp').text('Hubo problemas con el Registro');                      
                    }  
                    setTimeout(function () {
                        $('#Modal_RegistrarEmp').modal('hide');
                    }, 2000);
                    /*if (result) {
                     $('#Error_ReEmp').text('Empresa Registrada con exito');
                     } else {
                     $('#Error_ReEmp').text('Hubo un problema');  
                     }*/

                }, 'json');
            });

});

