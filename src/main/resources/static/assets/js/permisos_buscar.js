$(function () {
    let persona;

    //Form 1
    $("#form-1-persona").on("submit", (function (event) {
        event.preventDefault();
        //Activa el spinner
        $("#form-1-continue").addClass("d-none");
        $("#form-1-spinner").removeClass("d-none");
        $("#buscarListado").fadeOut();

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
                persona = data;
                $("#buscarListado").fadeIn();
                $("#buscarListadoLinks").html('<center id="buscarPermisosLoading"><div class="spinner-border text-secondary w-full mt-5" role="status"><span class="sr-only">Loading...</span></div><br/><small class="text-muted mb-5">Cargando Permisos...</small></center>')
                $.ajax({
                    url: "/permisos/userlist",
                    type: "POST",
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    data: JSON.stringify(persona),
                }).done(function (result) {
                    $("#buscarListadoLinks").html("");
                    $("#buscarPermisosLoading").fadeOut();
                    if (result.length == 0) {
                        $("#buscarListadoLinks").html("<center><small class='text-muted'>No Se Encontraron Resultados</small></center>");
                    } else {
                        result.forEach(element => {
                            let permiso = jQuery.parseJSON(element);
                            console.log(permiso);
                            $("#buscarListadoLinks").append(permisosLinks(permiso.idPermiso, permiso.persona.nombre, permiso.persona.apellido, permiso.persona.dni, permiso.rodado, permiso.fecha));
                        });
                    }
                });
            } else {
                $("#buscarError").fadeIn();
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

    function mostrarError(num) {
        if (num == 404) {
            toastr.error('Página no Encontrada', 'Error 404');
        } else if (num == 500) {
            toastr.error('Problema Interno del Servidor', 'Error 500');
        } else {
            toastr.error('Se ha detectado un Error Inesperado', 'Error');
        }
    }

    $("#buscarModal").on("hidden.bs.modal", function () {
        // put your default event here
        $("#buscarListado").fadeOut();
    });

    function permisosLinks(id, nombre, apellido, dni, rodado, fecha) {
        let tipo_permiso = "Permiso Especial";
        if (rodado != null && rodado != undefined) {
            tipo_permiso = "Permiso Temporario";
        }
        return "<a href='/permisos/show/" + id +
            "' class='list-group-item list-group-item-action'><b>" + nombre + " " + apellido +
            "</b> - <b>" + dni + "</b> - " + tipo_permiso + " - Fecha: <b>" + timeConverter(fecha) + "</b> <div class='text-muted float-right'>Ver Permiso</div></a>";
    }

    function timeConverter(UNIX_timestamp) {
        var a = new Date(UNIX_timestamp);
        var months = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
        var year = a.getFullYear();
        var month = a.getMonth();
        var date = a.getDate();
        var time = date + '/' + month + '/' + year;
        return time;
    }

});