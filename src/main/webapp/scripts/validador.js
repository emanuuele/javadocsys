/**
 * validação de formulário
 */
function validar(){
	let nome = frmIndex.nome.value
	let doenca = frmIndex.doenca.value
	let estado = frmIndex.estado.value
	
	if (nome===""){
		alert("Preencha o campo nome")
		frmIndex.nome.focus
		return false}
	else if (doenca===""){
		alert("Preencha o campo doenca")
		frmIndex.doenca.focus
		return false
	}
	else if (estado===""){
		alert("Preencha o campo estado")
		frmIndex.estado.focus
		return false
	} else{
		document.forms["frmIndex"].submit()
	}
}
function validar2(){
	let nomemed = frmMed.nomemed.value
	let preco = frmMed.preco.value
	let qtd = frmMed.qtd.value
	
	if (nomemed===""){
		alert("Preencha o campo nome do medicamento")
		frmMed.nomemed.focus
		return false}
	else if (preco===""){
		alert("Preencha o campo preço")
		frmMed.preco.focus
		return false
	}
	else if (qtd===""){
		alert("Preencha o campo estoque")
		frmMed.qtd.focus
		return false
	} else{
		document.forms["frmMed"].submit()
	}
}
function validar3(){
	let nomemed = frmReceita.nomemed.value
	let nome = frmReceita.nome.value
	let descricao = frmReceita.descricao.value
	
	if (nomemed===""){
		alert("Preencha o campo nome do medicamento")
		frmReceita.nomemed.focus
		return false}
	else if (nome===""){
		alert("Preencha o campo nome do paciente")
		frmReceita.nome.focus
		return false
	}
	else if (descricao===""){
		alert("Preencha o campo pescrição")
		frmReceita.qtd.focus
		return false
	} else{
		document.forms["frmReceita"].submit()
	}
}