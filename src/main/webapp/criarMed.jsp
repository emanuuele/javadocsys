<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Medicamentos</title>
        
    </head>
    <body>
        <div><h1>Criamos esse sistema para vocÃª se organizar melhor com suas consultas</h1>
        </div>
        <div class = "container">
            <h2>Dados dos medicamentos</h2>
        </div>
        <div> <p>Por favor, preencha os dados do medicamento</p> </div>
        <section id="form-paciente" class="pady-3" >
        	<c:if test="${medicamento != null}">
				<form action="controllerMedicamento" method="post" name="frmMed">
	        </c:if>
	        <c:if test="${medicamento == null}">
				<form action="controllerMedicamento" method="post" name="frmMed">
	        </c:if>
            <div class="campos-form">
                <label for = "nomemed">Nome do medicamento</label>
                <input type="text" name="nomemed" id="nomemed" >
            </div>
            	<label for="preco">Preço</label>
                <input type="number" name="preco" step="0.010">
            <div>
                <label for="qtd">Estoque</label>
                <input type="number" name="qtd" id ="qtd">
                
            </div>
            <button><c:if test="${medicamento == null}">Salvar</c:if><c:if test="${medicamento != null}">Editar</c:if></button> 
        </form>
        
        </section>
    </body>
</html>
