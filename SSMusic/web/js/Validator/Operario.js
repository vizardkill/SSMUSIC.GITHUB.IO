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
            APELLIDO2: {
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
            CORREO: {
                validators: {
                    emailAddress: {
                        message: 'Por favor introduce un correo electronico valido'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un numero telefonico'
                    }
                }       
            },
            TELEFONO: {
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
            DIRECCION:{
                 validators: {
                    notEmpty: {
                        message: 'Por favor introduce una direccion'
                    },
                    stringLength: {
                        min: 8,
                        message: 'Por introduce una Direccion de minimo 8 caracteres'
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
                    if (result.result === true) {
                        $('#table_Operarios').DataTable().ajax.reload();
                        $('#Error_ReOpe').text('Operario Registrado con exito');
                        document.getElementById("Reg_Operarios").reset();
                    } else {
                        $('#Error_ReOpe').text('Hubo problemas con el Registro');
                    }
                    setTimeout(function () {
                        $('#Error_ReOpe').text('');
                        $('#Modal_RegistrarOp').modal('hide');
                    }, 2000);
                }, 'json');
            });

});



