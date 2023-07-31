$(document).on("click", "#btnagregar", function(){
	$("#txtnomgenero").val("");
	$("#hddidregistrogenero").val("0");
	
	$("#modalgenero").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "registrargenero",
		contentType: "application/json",
		data: JSON.stringify({
			idgenero: $("#hddidregistrogenero").val(),
			nombregenero: $("#txtnomgenero").val(),
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			listargenero();
		}
	});
	
	$("#modalgenero").modal("hide");
})

function listargenero(){
	$.ajax({
		type: "GET",
		url: "listarGeneros",
		dataType: "JSON",
		success: function(resultado) {
		$("#tblgenero > tbody").html("");
		$.each(resultado, function(index, value){
			$("#tblgenero > tbody").append(
				"<tr>" +
				"<td>" + value.idgenero + "</td>" +
				"<td>" + value.nombregenero + "</td>" +
				"<td>" +
				"<button type='button' class='btn btn-success btnactualizargenero'" +
				" data-idgenero='" + value.idgenero + "'" +
				" data-nombregenero='" + value.nombregenero + "'" +
				"><i class='fas fa-pen'></i></button>" +
				"</td>" +
				"<td>" +
				"<button type='button' class='btn btn-danger btneliminaridgenero'" +
				" data-idgenero='" + value.idgenero + "'" +
				"><i class='fas fa-trash'></i></button>" +
				"</td>" +
				"</tr>"
			);
		});
		}
	});
}

$(document).on("click", ".btnactualizargenero", function(){
	$("#txtnomgenero").val($(this).attr("data-nombregenero"));
	$("#hddidregistrogenero").val($(this).attr("data-idgenero"));
	
	$("#modalgenero").modal("show");
});


$(document).on("click", ".btneliminaridgenero", function(){
	$("#hddideliminargenero").val("");
	$("#hddideliminargenero").val($(this).attr("data-idgenero"));
	$("#mensajeeliminar").text("¿Seguro de Eliminar el "+
								$(this).attr("data-idgenero")+"?");
	
	$("#modalEliminarGenero").modal("show");
})


$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "eliminarGenero",
		data: JSON.stringify({
			idgenero: $("#hddideliminargenero").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
				listargenero();
			}
	});
	
	$("#modalEliminarGenero").modal("hide");
})