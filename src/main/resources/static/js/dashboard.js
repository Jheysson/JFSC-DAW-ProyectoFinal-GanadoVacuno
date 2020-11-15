	<!-- OBTENER EL TOTAL DE LECHE PRODUCCIDA -->
	$(document).ready(function() {
		var total = new Array();
		$.getJSON('http://localhost:8080/leche/total', function(data) {
			$.each(data, function(key, val) {
				total.push(val.total);
				document.getElementById('cont1').innerHTML = total;
			})
		});
	});
	<!-- OBTENER EL TOTAL DE LECHE PRODUCCIDA FIN-->
	
	<!-- OBTENER EL TOTAL DE REGISTROS -->
	$(document).ready(function() {
		$.getJSON('http://localhost:8080/TotaldeRegistros', function(data) {
				document.getElementById('cont4').innerHTML = data.length;
		});
	});
	<!-- OBTENER EL TOTAL DE REGISTROS FIN -->
	
	<!-- OBTENER EL TOTAL DE REGISTROS MACHO -->
	$(document).ready(function() {
		$.getJSON('http://localhost:8080/TotaldeRegistrosMacho', function(data) {
				document.getElementById('idRegistroMacho').innerHTML = data.length;
		});
	});
	<!-- OBTENER EL TOTAL DE REGISTROS MACHO FIN -->
	
	<!-- OBTENER EL TOTAL DE REGISTROS HEMBRA -->
	$(document).ready(function() {
		$.getJSON('http://localhost:8080/TotaldeRegistrosHembra', function(data) {
				document.getElementById('idRegistroHembra').innerHTML = data.length;
		});
	});
	<!-- OBTENER EL TOTAL DE REGISTROS HEMBRA FIN -->