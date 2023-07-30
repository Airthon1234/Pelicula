$(document).on("click", "#btnagregar", function(){
    $("#txtnomdirector").val("");
    $("#txtapellido").val("");
    $("#hddidregistrodirector").val("0");
	
    $("#modaldirector").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "registrardirector",
        contentType: "application/json",
        data: JSON.stringify({
            iddirector: $("#hddidregistrodirector").val(),
            nombredirector: $("#txtnomdirector").val(),
            apellidodirector: $("#txtapellido").val(),
        }),
        success: function(resultado){
            alert(resultado.mensaje);
            listardirector();
        }
    });
    $("#modaldirector").modal("hide");
});



function listardirector() {
  $.ajax({
    type: "GET",
    url: "listarDirectors",
    dataType: "JSON",
    success: function(resultado) {
      $("#tbldirector > tbody").html("");
      $.each(resultado, function(index, value) {
        $("#tbldirector > tbody").append(
          "<tr>" +
          "<td>" + value.iddirector + "</td>" +
          "<td>" + value.nombredirector + "</td>" +
          "<td>" + value.apellidodirector + "</td>" +
          "<td>" +
          "<button type='button' class='btn btn-success btnactualizardirector'" +
          " data-iddirector='" + value.iddirector + "'" +
          " data-nombredirector='" + value.nombredirector + "'" +
          " data-apellidodirector='" + value.apellidodirector + "'" + 
          "><i class='fas fa-pen'></i></button>"+
          "</td>" +
          "<td>" +
          "<button type='button' class='btn btn-danger btneliminariddirector'" +
          " data-iddirector='" + value.iddirector + "'" +
          "><i class='fas fa-trash'></i></button>" +
          "</td>" +
          "<tr>"
        );
      });
    }
  });
}


$(document).on("click", ".btnactualizardirector", function(){
	$("#txtnomdirector").val($(this).attr("data-nombredirector"));
    $("#txtapellido").val($(this).attr("data-apellidodirector"));
    $("#hddidregistrodirector").val($(this).attr("data-iddirector"));
    
    $("#modaldirector").modal("show");
});


$(document).on("click", ".btneliminariddirector", function(){
	$("#hddideliminardirector").val("");
	$("#hddideliminardirector").val($(this).attr("data-iddirector"));
	$("#mensajeeliminar").text("¿Seguro de Eliminar el "+
								$(this).attr("data-iddirector")+"?");
	
	$("#modalEliminarDirector").modal("show");
})


$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "eliminarDirector",
		data: JSON.stringify({
			iddirector: $("#hddideliminardirector").val()
		}),
		success: function(resultado){
					alert(resultado.mensaje);
					listardirector();
			}
	});
	
	$("#modalEliminarDirector").modal("hide");
})

