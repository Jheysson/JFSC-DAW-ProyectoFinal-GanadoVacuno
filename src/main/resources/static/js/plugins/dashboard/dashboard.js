var ctx = document.getElementById('myChart');
		var myChart = new Chart(ctx,
				{
					type : 'horizontalBar',
					data : {
						labels : [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo',
								'Junio' ],
						datasets : [ {
							label : 'Produccion de leche',
							data : [ 200, 190, 300, 270, 265, 350 ],
							backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 206, 86, 0.2)',
									'rgba(75, 192, 192, 0.2)',
									'rgba(153, 102, 255, 0.2)',
									'rgba(255, 159, 64, 0.2)' ],
							borderColor : [ 'rgba(255, 99, 132, 1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255, 206, 86, 1)',
									'rgba(75, 192, 192, 1)',
									'rgba(153, 102, 255, 1)',
									'rgba(255, 159, 64, 1)' ],
							borderWidth : 1
						} ]
					},
					options : {
						scales : {
							yAxes : [ {
								ticks : {
									beginAtZero : true
								}
							} ]
						}
					}
				});
				
var ctx = document.getElementById('myChart1');
		var myChart = new Chart(ctx,
				{
					type : 'doughnut',
					data : {
						labels : [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo',
								'Junio' ],
						datasets : [ {
							label : 'Produccion de leche',
							data : [ 200, 190, 300, 270, 265, 350 ],
							backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
									'rgba(54, 162, 235, 0.2)',
									'rgba(255, 206, 86, 0.2)',
									'rgba(75, 192, 192, 0.2)',
									'rgba(153, 102, 255, 0.2)',
									'rgba(255, 159, 64, 0.2)' ],
							borderColor : [ 'rgba(255, 99, 132, 1)',
									'rgba(54, 162, 235, 1)',
									'rgba(255, 206, 86, 1)',
									'rgba(75, 192, 192, 1)',
									'rgba(153, 102, 255, 1)',
									'rgba(255, 159, 64, 1)' ],
							borderWidth : 1
						} ]
					}
				});