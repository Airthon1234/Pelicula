$(document).on("click", "#btnagregar", function(){
	$("#txtnompelicula").val("");
	$("#txtduracion").val("");
	$("#txtsipnosis").val("");
	$("#hddidregistropelicula").val("0");
	
	$("#cbodirector").empty();
	$.ajax({
		type: "GET",
		url: "/directores/listarDirectors",
		dataType: "json",
		success: function(resultado){
			if(resultado.length > 0){
				$.each(resultado, function(index, value){
					$("#cbodirector").append(
						`<option value="${value.iddirector}">
							${value.nombredirector}</option>`
					);
				})
			}
		}
	});
	
	
	$("#cbogenero").empty();
	$.ajax({
		type: "GET",
		url: "/genero/listarGeneros",
		dataType: "json",
		success: function(resultado){
			if(resultado.length > 0){
				$.each(resultado, function(index, value){
					$("#cbogenero").append(
						`<option value="${value.idgenero}">
							${value.nombregenero}</option>`
					);
				})
			}
		}
	});
	
	$("#modalpelicula").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "registrarpelicula",
		contentType: "application/json",
		data: JSON.stringify({
			idpelicula: $("#hddidregistropelicula").val(),
			titulopelicula: $("#txtnompelicula").val(),
			duracion: $("#txtduracion").val(),
			sinopsis: $("#txtsipnosis").val(),
			iddirector: $("#cbodirector").val(),
			idgenero: $("#cbogenero").val(),
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			listarpeli();
		}
	});
	$("#modalpelicula").modal("hide");
});


function listarpeli(){
	$.ajax({
		type: "GET",
		url: "listarPelicula",
		dataType: "JSON",
		success: function(resultado){
		$("#tblpelicula > tbody").html("");
		$.each(resultado,function(index, value){
			$("#tblpelicula > tbody").append(
				"<tr>" +
				"<td>" + value.idpelicula + "</td>" +
				"<td>" + value.titulopelicula + "</td>" +
				"<td>" + value.duracion + "</td>" +
				"<td>" + value.sinopsis + "</td>" +
				"<td>" + value.directores.nombredirector + "</td>" +
				"<td>" + value.generos.nombregenero + "</td>" +
				"<td>" +
				"<button type='button' class='btn btn-success btnactualizarpelicula'" +
				" data-idpelicula='" + value.idpelicula + "'" +
				" data-titulopelicula='" + value.titulopelicula + "'" +
				" data-duracion='" + value.duracion + "'" +
				" data-iddirector='" + value.directores.nombredirector + "'" +
				" data-idgenero='" + value.generos.nombregenero + "'" +
				"><i class='fas fa-pen'></i></button>"+
				"</td>" +
				"<td>" +
				"<button type='button' class='btn btn-danger btneliminaridpelicula'" +
				" data-idpelicula='" + value.idpelicula + "'" +
				"><i class='fas fa-trash'></i></button>" +
				"</td>" +
				"</tr>"
			);
		});
		}
	});
}