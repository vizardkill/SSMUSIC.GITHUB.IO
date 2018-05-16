$(document).ready(function () {
    $('#Reg_Artistas').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            NOM_ARTISTA: {
                validators: {
                    stringLength: {
                        min: 3,
                        max: 8,
                        message: 'Por introduce un nombre de minimo 3 caracteres y maximo 8'
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
            NOM_REPRESENTANTE: {
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
            DOC_REPRESENTANTE: {
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
            TEL_REPRESENTANTE: {
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
            COR_REPRESENTANTE: {
                validators: {
                    emailAddress: {
                        message: 'Por favor introduce un correo electronico valido'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un numero telefonico'
                    }
                }
            },

            select_empresas: {
                validators: {
                    notEmpty: {
                        message: 'Por favor selecciona una empresa'
                    }
                }
            },

            Img_art: {
                validators: {
                    file: {
                        extension: 'jpg',
                        type: 'image/jpeg',
                        message: 'Por favor sube una imagen en formato JPG'
                    }
                }

            }
        }
    })

            .on('success.form.bv', function (e) {
                $('#success_message').slideDown({opacity: "show"}, "slow"); // Do something ...
                $('#Reg_Artistas').data('bootstrapValidator').resetForm();

                // Prevent form submission
                e.preventDefault();

                // Get the form instance
                var $form = $(e.target);
                formData = new FormData();
                params = $form.serializeArray();
                files = $form.find('[name="Img_art"]')[0].files;

                $.each(files, function (i, file) {
                    // Prefix the name of uploaded files with "uploadedFiles-"
                    // Of course, you can change it to any string
                    formData.append('Img_art-' + i, file);
                });

                $.each(params, function (i, val) {
                    formData.append(val.name, val.value);
                });

                // Get the BootstrapValidator instance
                var bv = $form.data('bootstrapValidator');

                // Use Ajax to submit form data
                $.ajax({
                    url: $form.attr('action'),
                    data: formData,
                    cache: false,
                    contentType: false,
                    processData: false,
                    type: 'POST',
                    success: function (result) {
                        if (result) {
                            $('#table_Artistas').DataTable().ajax.reload();
                            $('#Error_ReArt').text('Artista registrado con Exito');
                        } else {
                            $('#Error_ReArt').text('Hubo problemas con el Registro');
                        }
                        setTimeout(function () {
                            $('#Modal_RegistrarArt').modal('hide');
                        }, 2000);
                    }
                });
            });
});

