var ctx = document.getElementById('myChart1').getContext('2d');
	var cantidad1 = new Array();
	var mes1 = new Array();
	$.getJSON('http://localhost:8080/leche/mesAndCantidad', function(data) {
		$.each(data, function(key, val) {
			cantidad1.push(val.cantidad);
			mes1.push(val.mes);
		})
	});
	var myChart = new Chart(ctx, {
	    type: 'doughnut',
	    data: {
	        labels: mes1,
	        datasets: [{
	            label: 'Produccion de leche',
	            data: cantidad1,
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(54, 162, 235, 0.2)',
	                'rgba(255, 206, 86, 0.2)',
	                'rgba(75, 192, 192, 0.2)',
	                'rgba(153, 102, 255, 0.2)',
	                'rgba(255, 159, 64, 0.2)',
	                'rgba(139, 0, 0, 0.2)',
	                'rgba(128, 0, 255, 0.2)'
	            ],
	            borderColor: [
	                'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)',
	                'rgba(255, 206, 86, 1)',
	                'rgba(75, 192, 192, 1)',
	                'rgba(153, 102, 255, 1)',
	                'rgba(255, 159, 64, 1)',
	                'rgba(139, 0, 0, 1)',
	                'rgba(128, 0, 255, 1)'
	            ],
	            borderWidth: 1
	        }]
	    }
	});
	<!-- GRAFICO DE DONAS FINALIZA -->
	
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