$(function () {
    //Objeto Persona
    let persona;
    let rodado;
    let lugar;

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
            nombre, apellido, dni
        }).done(function (data) {
            //Si termina con status 200
            //Si nos devolvio los datos de la persona
            if(data.idPersona > 0){
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

    function mostrarError(num){
        if(num == 404){
            toastr.error('Página no Encontrada', 'Error 404');  
        }     
        else if(num == 500){
            toastr.error('Problema Interno del Servidor', 'Error 500');  
        }
        else {
            toastr.error('Se ha detectado un Error Inesperado', 'Error');  
        }     
    }
});