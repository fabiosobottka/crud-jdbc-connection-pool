function retornaTab(){
  $('[href="#parte1"]').tab('show');
}

function resetaCampo() {	
	document.getElementById("cadastro-entidade").reset();
	document.getElementById("entidadeX").innerText = "";

	retornaTab();
}

function validacaoFormulario(){

	var campo1 = document.getElementById("campoForm1")
	if (campo1.value == "") {
		alert("O campo 1 não foi preenchido, preencha todos os campos!");
		retornaTab();
		return false;
	}

	if(campo1.value != "") {
		window.localStorage.campoForm1 = campo1.value;
	}
	
	var campo2 = document.getElementById("campoForm2");
	if (campo2.value == "") {
		alert("O campo 2 não foi preenchido, preencha todos os campos!");
		retornaTab();
		return false;
	}

	if(campo2.value != "") {
		window.localStorage.campoForm2 = campo2.value;
	}
	
	var campo3 = document.getElementById("campoForm3");
	if (campo3.value == "") {
		alert("O campo 3 não foi preenchido, preencha todos os campos!");
		retornaTab();
		return false;
	}

	if(campo3.value != "") {
		window.localStorage.campoForm3 = campo3.value;
	}
	
	var campo4 = document.getElementById("campoForm4");
	if(campo4.value == "") {
		alert("O campo 4 não foi preenchido, preencha todos os campos!");
		retornaTab();
		return false;
	}

	if (campo4.value != "") {
		window.localStorage.campoForm4 = campo4.value;
	}

	if (document.getElementById("campoForm5").checked) {
		var campo5 = document.getElementById("campoForm5");
		window.localStorage.campoForm5 = campo5.value;
	} else {
		window.localStorage.campoForm5 = "Não selecionado";
	}
	

	if (document.getElementById("radioOption1").checked) {
		var campo6 = "Opção 1";
		window.localStorage.campoForm6 = campo6;
	} else if (document.getElementById("radioOption2").checked) {
		var campo6 = "Opção 2";
		window.localStorage.campoForm6 = campo6;
	} else {
		var campo6 = "Opção 3";
		window.localStorage.campoForm6 = campo6;
	}
	
	var datepicker = document.getElementById("datepicker");
	if (datepicker.value == "") {
		alert("O campo 7 não foi preenchido, preencha todos os campos!");
		retornaTab();
		return false;
	}

	if (datepicker.value != "") {
		window.localStorage.campoForm7 = datepicker.value;
	}

	return true;
	
}

function exibirDados() {
	document.getElementById("pForm1").innerHTML = localStorage.campoForm1;
	document.getElementById("pForm2").innerHTML = localStorage.campoForm2;
	document.getElementById("pForm3").innerHTML = localStorage.campoForm3;
	document.getElementById("pForm4").innerHTML = localStorage.campoForm4;
	document.getElementById("pForm5").innerHTML = localStorage.campoForm5;
	document.getElementById("pForm6").innerHTML = localStorage.campoForm6;
	document.getElementById("pForm7").innerHTML = localStorage.campoForm7;

}



