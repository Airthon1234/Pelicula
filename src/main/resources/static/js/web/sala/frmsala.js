$(document).on("click", "#btnagregar", function(){
	$("#txtnomsala").val("");
	$("#txtcapacidad").val("");
	$("#hddidregistrodirector").val("0");
	
	$("#modalsala").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "registrarsalas",
		contentType: "application/json",
		data: JSON.stringify({
			idsala: $("#hddidregistrodirector").val(),
			nombresala: $("#txtnomsala").val(),
			capacidad: $("#txtcapacidad").val(),
		}),
		success: function(resultado){
				alert(resultado.mensaje);
				listarsala();
		}
	});
	
	$("#modalsala").modal("hide");
});

function listarsala(){
	$.ajax({
		type: "GET",
		url: "listarsalas",
		dataType: "JSON",
		success: function(resultado){
		$("#tblsala > tbody").html("");
		$.each(resultado, function(index, value){
			$("#tblsala > tbody").append(
				"<tr>" +
				"<td>" + value.idsala + "</td>" +
				"<td>" + value.nombresala + "</td>" +
				"<td>" + value.capacidad + "</td>" +
				"<td>" +
				"<button type='button' class='btn btn-success btnactualizarsala'" +
				" data-idsala='" + value.idsala + "'" +
				" data-nombresala='" + value.nombresala + "'" +
				" data-capacidad='" + value.capacidad + "'" +
				"><i class='fas fa-pen'></i></button>" +
				"</td>" +
				"<td>" +
				"<button type='button' class='btn btn-danger btneliminaridsala'" +
				" data-idsala='" + value.idsala + "'" +
				"><i class='fas fa-trash'></i></button>" +
				"</td>" +
				"</tr>"
			);
		});
		}
	});
}


$(document).on("click", ".btnactualizarsala", function(){
	$("#txtnomsala").val($(this).attr("data-nombresala"));
	$("#txtcapacidad").val($(this).attr("data-capacidad"));
	$("#hddidregistrodirector").val($(this).attr("data-idsala"));
	
	$("#modalsala").modal("show");
});


$(document).on("click", ".btneliminaridsala", function(){
	$("#hddideliminarsala").val("");
	$("#hddideliminarsala").val($(this).attr("data-idsala"));
	$("#mensajeeliminar").text("Seguro de Eliminar el "+
								$(this).attr("data-idsala")+"?");
	
	$("#modalEliminarSala").modal("show");
});

$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "eliminarSalas",
		data: JSON.stringify({
			idsala: $("#hddideliminarsala").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			listarsala();
		}
	});
	
	$("#modalEliminarSala").modal("hide");
})