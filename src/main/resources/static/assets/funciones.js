function eliminar(id) {
	swal({
		title: "Esta seguro que desea eliminar?",
		text: "Una vez eliminado, no podrá recuperar este usuario!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	}).then((OK) => {
		if (OK) {
			$.ajax({
				type: "DELETE",
				url: "/admin/users/" + id,
				contentType: "application/json",
				dataType: 'json',
				success: function (resp) {
					console.log(resp);
				}
			});
			swal("¡Ok! ¡Usuario eliminado!", {
				icon: "success",
			}).then((ok) => {
				if (ok) {
					location.href = "users";
				}
			});
		} else {
			swal("¡Ok! Usuario sin eliminar!");
		}
	});
}