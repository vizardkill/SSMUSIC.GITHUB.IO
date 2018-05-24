$(document).ready(function () {
    $('#Reg_Operarios').bootstrapValidator({
        feedbackIcons: {
            valid: 'fa fa-check',
            invalid: 'fa fa-times',
            validating: 'fa fa-refresh'
        },
        fields: {
            USERNAME: {
                validators: {
                    stringLength: {
                        min: 3,
                        max: 8,
                        message: 'Por introduce un nombre de usuario, de minimo 3 caracteres y maximo 8'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un nombre'
                    },
                    regexp: {
                        regexp: /^[a-z\s]+$/i,
                        message: 'El nombre de usuario no puede contener caracteres especiales ni numeros'
                    }
                }
            },

            PASS: {
                validators: {
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: 'La contraseña debe ser de un minimo de 3 caracteres y maximo 20'
                    },
                    notEmpty: {
                        message: 'Por favor introduce una contraseña'
                    }
                }
            },
            NOMBRES: {
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
            APELLIDO1: {
                validators: {
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: 'El apellido debe ser de un minimo de 3 caracteres y maximo 20'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un apellido'
                    },
                    regexp: {
                        regexp: /^[a-z\s]+$/i,
                        message: 'El nombre no puede contener caracteres especiales ni numeros'
                    }
                }
            },
            DOCUMENTO: {
                validators: {
                    stringLength: {
                        min: 10,
                        max: 15,
                        message: 'El documento debe ser de un minimo de 8 caracteres y maximo 15'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un numero de documento'
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
                $('#Reg_Operarios').data('bootstrapValidator').resetForm();




                // Prevent form submission
                e.preventDefault();
                // Get the form instance
                var $form = $(e.target);

                // Get the BootstrapValidator instance
                var bv = $form.data('bootstrapValidator');

                // Use Ajax to submit form data
                $.post($form.attr('action'), $form.serialize(), function (result) {
                    var json = $.parseJSON(result);
                    if (json.result === true) {
                        $('#table_Operarios').DataTable().ajax.reload();
                        $('#ErrorRegistroOp').text('Operario Registrado con exito');
                         document.getElementById("Modal_RegistrarOp").reset();
                    } else {
                        $('#ErrorRegistroOp').text('Hubo problemas con el Registro');
                    }
                    setTimeout(function () {
                        $('#Modal_RegistrarOp').modal('hide');
                    }, 2000);
                }, 'json');
            });

});



