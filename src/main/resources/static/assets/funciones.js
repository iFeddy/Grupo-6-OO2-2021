function eliminar(id) {
	swal({
		title: "Esta seguro que decea eliminar?",
		text: "Una vez eliminado, no podrá recuperar este usuario!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url:"admin/delete_user/"+id,
					success:function (resp){
						console.log(resp);
					}
				});
				swal("¡Ok! ¡Usuario eliminado!", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="users";
					}
				});
			} else {
				swal("¡Ok! Usuario sin eliminar!");
			}
		});

}