
function calController() {
	var that = this;

	this.init = function() {

		that.num1 = '';
		that.num2 = '';
		that.pos = 0;
		that.operador = ' ';
		$('#valor-fila1').text('');
		$('#valor-fila2').text('');
		$('#valor-fila3').text('');

		console.log("Inicializando el Controller");
	}

	this.dto = function() {
		console.log(" pos " + that.pos);
		console.log(" num1 " + that.num1);
		console.log(" num2 " + that.num2);
		console.log(" operador " + that.operador);
	}

	this.mostrar = function() {
		console.log("entra a mostrar");

		$('#valor-fila1').text(that.separadordemiles(that.num1) + ' ' + that.operador);
		$('#valor-fila2').text(that.separadordemiles(that.num2));

	}

	this.actualizaValor = function(valor) {


		if (that.pos == 0) {
			if (valor === '.' && that.num1.includes('.'))
				valor = '';
			if (that.num1.length < 10)
				that.num1 = (that.num1 === '') ? valor : that.num1 + valor;
		}

		else {
			if (valor === '.' && that.num2.includes('.'))
				valor = '';
			if (that.num2.length < 10)
				that.num2 = (that.num2 === '') ? valor : that.num2 + valor;
		}

		that.mostrar();
	}

	this.actualizaOperador = function(oper) {
		that.operador = oper;
		that.pos = 1;
		that.mostrar();
	}
	this.modal = function() {
		$('#spinnerModal').modal('toggle')
	}

	this.colocaResultado = function(data) {
		console.log("Entro a colocar resultado "+ data.respuesta)
		$('#valor-fila3').text(data.respuesta);
		//console.log("[" + that.separadordemiles(data.respuesta.toString()) +"]");
		setTimeout(that.modal, 1000);

	}

	this.separadordemiles=function(cadena) {
		
		//cadena = cadena.replace(/[^0-9.]+/g, '');
		var x = cadena.length;
		console.log("cadena "+ cadena + "["+x+"]");
		var sep = "\'";
		var newCadena = "";
		contador = 1;
		while (x >= 0) {
			x--;
			newCadena += cadena.charAt(x);
			if (contador == 3) {
				contador = 0
				newCadena += sep;
			}
			contador++;
		}
		var cadena2 = '';
		x = newCadena.length;
		while (x >= 0) {
			cadena2 += newCadena.charAt(x);
			x--;
		}
		if (cadena2.charAt(0) == sep) {
			cadena2 = cadena2.substring(1, cadena2.length);
		}
		console.log(cadena2);
		return cadena2;

	}
	
	this.back = function() {
		console.log("declick en back " + that.pos);
		that.limpiaResultado();
		if (that.pos == 0)
			that.num1 = that.num1.toString().slice(0, -1);
		else {
			if (that.num2 == '' && that.operador !== ' ') {
				that.pos = 0;
			}
			that.num2 = that.num2.toString().slice(0, -1);

		}
		//that.dto();
		that.mostrar();

	}

	this.peticion = function() {
		var json = {
			"num1": that.num1,
			"num2": that.num2,
			"operacion": that.operador
		};
		console.log("Se comienza con la peticion ajax " + JSON.stringify(json));
		$.ajax({
			type: "POST",
			contentType: 'application/json; charset=utf-8',
			dataType: 'json',
			url: "/api/process",
			cache: false,
			//timeout: 450,
			data: JSON.stringify(json)

		/* 
		}).done(function(data, status, request) {
			 console.log("DONE ");
			 console.log("data " + Object.values(data));
			 console.log("status " + status);
			 console.log("request " + Object.values(request));
			 
			that.colocaResultado(data);
		    
		*/	 
 
		 }).fail(function(data, status, error) {
			 console.log("FAIL");
			 console.log("data " + Object.values(data));
			 console.log("status " + status);
			 console.log("error " + Object.values(error));
			alert('Fallo la conexión');
			 
	
		 }).always(function(data) {
			 console.log("ALWAYS");
			 console.log("data " + Object.values(data));
			 if (data.status == "OK") {
				 console.log("Oh yeah todo bien!! ");
				 console.log("respuesta " + data.respuesta);
				 $('#valor-fila3').text(data.respuesta);
			 }
			 else {
				 console.log("Timmy tiene problemas :( ");
			 }
 
			 that.colocaResultado(data);
			 
		 });
		 
	}
	this.limpiaResultado=function(){
		$('#valor-fila3').text("");
	}
	
	//Funciones de onClick
	$('.numero').click(function(_eventObject) {
		let valor = $(this).text();
		that.actualizaValor(valor);
		
		//that.dto();
	});
	
	
	$('.operador').click(function(_eventObject) {
		let oper = $(this).text();
		that.limpiaResultado();
		that.actualizaOperador(oper);

	});


	$('#borraTodo').click(function() {
		console.log("declick en todo");
		that.init();
	});


	$('#borrar').click(function() {
		that.back();
	});

	$('#igual').click(function(_eventObject) {
		console.log("Entro al igual");
		that.modal();

		that.peticion();

	});

	this.hola = function() {
		console.log("Hola como te va, Controller Init");
	}
}


var calController = new calController();

$(document).ready(function() {

	calController.init();
	calController.hola();




}).keypress(function(evt) {
	console.log(evt.key + " -> " + evt.which);
	var code = (evt.which) ? evt.which : evt.keyCode;

	if (code == 47 || code == 42 || code == 45 || code == 43) { //Operadores 
		calController.actualizaOperador(evt.key);
	} else if (code >= 48 && code <= 57 || code == 46) { // numeros //46 punto.
		calController.actualizaValor(evt.key);
	} else if (code == 13) { // other Enter
		$('#igual').trigger('click');
	}



});



