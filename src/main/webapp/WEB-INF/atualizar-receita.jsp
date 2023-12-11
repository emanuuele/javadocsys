<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem-vindo ao Cadastro de Pacientes</title>
    </head>
    <body>
        <div><h1>Criamos esse sistema para você se organizar melhor com suas consultas</h1></div>
            <div class = "container">
                <h1 class = "cabecalho_form">Dados da receita</h1>
            </div>
        <div><p>Atualizando receita</p></div>
            <section id="form-paciente" class = "pady-3">
            <form action="PacienteServlet" method="POST">
                <div class = "campos-form"> 
                    <label for = "nome">Nome</label>
                    <input type = "text" name ="nome" id = "nome" value ="${receita.nome}">
                    <input type="hidden" name="id" value ="${receita.id}">
                </div>
                <div class = "campos-form"> 
                    <label for = "doenca">Medicamento</label>
                    <input type = "text" name ="doenca" id = "doenca" value="${receita.doenca}">
                </div>
                <div class = "campos-form"> 
                    <label for = "estado">Estado</label>
                    <input type = "text" name ="estado" id = "estado" value="${receita.estado}">
                </div>
                <button type = "submit">Cadastrar</button>
            </form>
                </section>
            </body>
</html>