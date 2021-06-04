$(function () {
    //Objeto Persona
    let persona;
    let rodado;
    let lugar_salida;
    let lugar_destino;

    let permiso_tipo;
    let permiso_fecha;

    let motivo_desc;
    let motivo_vacaciones;
    let motivo_dias;

    //Form 1
    $("#form-1-persona").on("submit", (function (event) {
        event.preventDefault();
        //Activa el spinner
        $("#form-1-continue").addClass("d-none");
        $("#form-1-spinner").removeClass("d-none");

        //Prepara el Formulario
        var $form = $(this),
            nombre = $form.find("input[name='nombre']").val(),
            apellido = $form.find("input[name='apellido']").val(),
            dni = $form.find("input[name='dni']").val(),
            url = $form.attr("action");

        //Envia Petición a Servidor
        $.post(url, {
            nombre,
            apellido,
            dni
        }).done(function (data) {
            //Si termina con status 200
            //Si nos devolvio los datos de la persona
            if (data.idPersona > 0) {
                //Todo Ok
                toastr.success('Persona cargada Exitosamente', 'Carga Correcta');
                //Guardamos la persona en la variable global
                persona = data;
                //Desactivamos Persona Tab (Ver si vale la pena desactivarlo)
                //$("#persona-tab").addClass("disabled");
                //Activamos Rodado Tab
                $("#rodado-tab").removeClass("disabled");
                //Abrimos el segundo tab
                $("#rodado-tab").trigger("click");

                //Ocultamos la info general
                $("#info-general").fadeOut();
                //Actualizamos la info de persona y la mostramos
                $("#info-name").text(persona.nombre);
                $("#info-dni").text(persona.dni);
                $("#info-persona").removeClass("d-none");
            }
            console.log(persona);
        }).fail(function (error) {
            //Si existe algun error
            console.log(error);
            mostrarError(error.status);
        }).always(() => {
            //Cambia los iconos del boton 1 
            $("#form-1-continue").removeClass("d-none");
            $("#form-1-spinner").addClass("d-none");
        });
    }));

    //Form 2
    $("#form-2-rodado-1").on("submit", (function (event) {
        event.preventDefault();
        let tipoRodado = 0;
        let tipoRodadoText = "";
        $("input[name='rodadoRadios[]']").each(function () {
            if ($(this).prop("checked") == true) {
                tipoRodado = $(this).val();
                tipoRodadoText = $(this).next('label').text();
            }
        });
        if (tipoRodado != 2) {
            //Abrimos el tercer  tab
            $("#lugar-tab").trigger("click");

            //Desactivamos Persona Tab (Ver si vale la pena desactivarlo)
            //$("#rodado-tab").addClass("disabled");

        } else {
            //Sino muestra el formulario de carga de Rodado
            $("#rodado-first").fadeOut();
            setTimeout(() => {
                $("#rodado-second").fadeIn();
            }, 500);
        }
        //Actualizamos la info de rodado y la mostramos
        $("#info-rodado-type").text(tipoRodadoText);
        $("#info-rodado").removeClass("d-none");
    }));

    //Form 3
    $("#form-2-rodado-2").on("submit", (function (event) {
        event.preventDefault();
        //Activa el spinner
        $("#form-2-continue").addClass("d-none");
        $("#form-2-spinner").removeClass("d-none");

        //Prepara el Formulario
        var $form = $(this),
            dominio = $form.find("input[name='dominio']").val(),
            vehiculo = $form.find("input[name='vehiculo']").val(),
            url = $form.attr("action");

        //Envia Petición a Servidor
        $.post(url, {
            dominio,
            vehiculo
        }).done(function (data) {
            //Si termina con status 200
            //Si nos devolvio los datos de la rodado
            if (data.idRodado > 0) {
                //Todo Ok
                toastr.success('Rodado cargado Exitosamente', 'Carga Correcta');
                //Guardamos el rodado en la variable global
                rodado = data;
                //Abrimos el tercer tab
                $("#lugar-tab").trigger("click");

                $("#info-rodado-dominio").text(rodado.dominio);
                $("#info-rodado-vehiculo").text(rodado.vehiculo);
                $("#info-rodado-2").removeClass("d-none");
            }
            console.log(rodado);
        }).fail(function (error) {
            //Si existe algun error
            console.log(error);
            mostrarError(error.status);
        }).always(() => {
            //Cambia los iconos del boton 1 
            $("#form-2-continue").removeClass("d-none");
            $("#form-2-spinner").addClass("d-none");
        });
    }));

    //Form 4
    $("#form-3-lugar").on("submit", (function (event) {
        event.preventDefault();
        //Activa el spinner
        $("#form-3-continue").addClass("d-none");
        $("#form-3-spinner").removeClass("d-none");
        let lugarSalidaText = $("#lugar-salida option:selected").text();
        let lugarDestinoText = $("#lugar-destino option:selected").text();

        if ($("#lugar-salida").val() != undefined && $("#lugar-destino").val() != undefined) {
            lugar_salida = $("#lugar-salida").val();
            lugar_destino = $("#lugar-destino").val();

            $("#info-lugar-salida").text(lugarSalidaText);
            $("#info-lugar-destino").text(lugarDestinoText);
            $("#info-lugar").removeClass("d-none");

            toastr.success('Lugares de Salida y Destino cargados Exitosamente', 'Carga Correcta');

            //Abrimos el tercer tab
            $("#motivo-tab").trigger("click");

        } else {
            toastr.error('Por favor Completa todos los datos', 'Datos Incompletos');
        }

        $("#form-3-continue").removeClass("d-none");
        $("#form-3-spinner").addClass("d-none");

    }));

    //Form 5
    $("#form-4-motivo").on("submit", (function (event) {
        event.preventDefault();
        //Activa el spinner
        $("#form-4-continue").addClass("d-none");
        $("#form-4-spinner").removeClass("d-none");

        let permisoMotivoText = $("#motivo-permiso option:selected").text();

        if ($("#motivo-permiso").val() != undefined) {

            $("#info-motivo-permiso").text(permisoMotivoText);
            $("#info-motivo").removeClass("d-none");

            $("#motivo-1").fadeOut();
            if ($("#motivo-permiso").val() == "1") {
                permiso_tipo = 1;
                setTimeout(() => {
                    $("#motivo-2").fadeIn();
                }, 500);
            }

            if ($("#motivo-permiso").val() == "2") {
                permiso_tipo = 2;
                setTimeout(() => {
                    $("#motivo-3").fadeIn();
                }, 500);
            }

        } else {
            toastr.error('Por favor Completa todos los datos', 'Datos Incompletos');
        }

        $("#form-4-continue").removeClass("d-none");
        $("#form-4-spinner").addClass("d-none");
    }));

    //Form 6
    $("#form-5-motivo-especial").on("submit", (function (event) {
        event.preventDefault();
        //Activa el spinner
        $("#form-5-continue").addClass("d-none");
        $("#form-5-spinner").removeClass("d-none");

        if ($("#motivo-permiso-descripcion").val() != undefined) {

            toastr.success('Motivo cargado Exitosamente', 'Carga Correcta');
            motivo_desc = $("#motivo-permiso-descripcion").val();
            $("#fecha-tab").trigger("click");

        } else {
            toastr.error('Por favor Completa todos los datos', 'Datos Incompletos');
        }

        $("#form-5-continue").removeClass("d-none");
        $("#form-5-spinner").addClass("d-none");
    }));

    //Form 7
    $("#form-5-motivo-temporario").on("submit", (function (event) {
        event.preventDefault();
        //Activa el spinner
        $("#form-5-continue").addClass("d-none");
        $("#form-5-spinner").removeClass("d-none");

        motivo_vacaciones = $("#motivo-vacaciones").prop("checked");
        motivo_dias = $("#motivo-cant-dias").val();
        console.log(motivo_dias);

        toastr.success('Motivos cargados Exitosamente', 'Carga Correcta');

        //Abrimos ultimo tab
        $("#fecha-tab").trigger("click");

        $("#form-5-continue").removeClass("d-none");
        $("#form-5-spinner").addClass("d-none");
    }));

    //Ultimo Form
    $("#form-6-fecha").on("submit", (function (event) {
        event.preventDefault();
        //Activa el spinner
        $("#form-6-continue").addClass("d-none");
        $("#form-6-spinner").removeClass("d-none");

        permiso_fecha = $("#permiso-fecha").val();
        console.log(persona);
        console.log(rodado);
        console.log(lugar_salida);
        console.log(lugar_destino);

        console.log(permiso_tipo);
        console.log(permiso_fecha);

        console.log(motivo_desc);
        console.log(motivo_vacaciones);
        console.log(motivo_dias);


        var $form = $(this),
            url = $form.attr("action");

        //Envia Petición a Servidor
        $.post(url, {
            persona: persona,
            rodado: rodado,
            lugar_salida: lugar_salida,
            lugar_destino: lugar_destino,
            permiso_tipo: permiso_tipo,
            permiso_fecha: permiso_fecha,
            motivo_desc: motivo_desc,
            motivo_vacaciones: motivo_vacaciones,
            motivo_dias: motivo_dias
        }).done(function (data) {
            //Si termina con status 200
            console.log(data);
        }).fail(function (error) {
            //Si existe algun error
            console.log(error);
            mostrarError(error.status);
        }).always(() => {
            //Cambia los iconos del boton 1 
            $("#form-6-continue").removeClass("d-none");
            $("#form-6-spinner").addClass("d-none");
        });
     
    }));


    function mostrarError(num) {
        if (num == 404) {
            toastr.error('Página no Encontrada', 'Error 404');
        } else if (num == 500) {
            toastr.error('Problema Interno del Servidor', 'Error 500');
        } else {
            toastr.error('Se ha detectado un Error Inesperado', 'Error');
        }
    }

    $('.input-group.date').datepicker({
        format: "yyyy-mm-dd",
        language: "es"
    });

});