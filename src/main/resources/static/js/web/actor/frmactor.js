$(document).on("click", "#btnagregar", function(){
	$("#txtnomactor").val("");
	$("#txtapellido").val("");
	$("#hddidregistroactor").val("0");
	
	$("#modalactor").modal("show");
})

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "registraractor",
		contentType: "application/json",
		data: JSON.stringify({
			idactor: $("#hddidregistroactor").val(),
			nombreactor: $("#txtnomactor").val(),
			apellidoactor: $("#txtapellido").val(),
		}),
		success: function(resultado){
				alert(resultado.mensaje);
				listaractor();
		}
	});
	$("#modalactor").modal("hide");
});

function listaractor(){
	$.ajax({
		type: "GET",
		url: "listarActores",
		dataType: "JSON",
		success: function(resultado){
		$("#tblactor > tbody").html("");
		$.each(resultado, function(index, value){
			$("#tblactor > tbody").append(
				"<tr>" +
				"<td>" + value.idactor + "</td>" +
				"<td>" + value.nombreactor + "</td>" +
				"<td>" + value.apellidoactor + "</td>" +
				"<td>" +
				"<button type='button' class='btn btn-success btnactualizaractor'" +
				" data-idactor='" + value.idactor + "'" +
				" data-nombreactor='" + value.nombreactor + "'" +
				" data-apellidoactor='" + value.apellidoactor + "'" +
				"><i class='fas fa-pen'></i></button>" +
				"</td>" +
				"<td>" +
				"<button type='button' class='btn btn-danger btneliminaridactor'" +
				" data-idactor='" + value.idactor + "'" +
				"><i class='fas fa-trash'></i></button>" +
				"</td>" +
				"</tr>"
			);
		});
		}
	});
}



$(document).on("click", ".btnactualizaractor", function(){
	$("#txtnomactor").val($(this).attr("data-nombreactor"));
	$("#txtapellido").val($(this).attr("data-apellidoactor"));
	$("#hddidregistroactor").val($(this).attr("data-idactor"));
	
	$("#modalactor").modal("show");
});


$(document).on("click", ".btneliminaridactor", function(){
	$("#hddideliminaractor").val("");
	$("#hddideliminaractor").val($(this).attr("data-idactor"));
	$("#mensajeeliminar").text("Seguro de Eliminar el "+
								$(this).attr("data-idactor")+"?");
	
	$("#modalEliminarActor").modal("show");
});


$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "eliminaractor",
		data: JSON.stringify({
			idactor: $("#hddideliminaractor").val()
		}),
		success: function(resultado){
				alert(resultado.mensaje);
				listaractor();
		}
	});
	
	$("#modalEliminarActor").modal("hide");
})