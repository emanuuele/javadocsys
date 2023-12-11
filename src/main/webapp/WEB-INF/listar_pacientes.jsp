<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Paciente"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<Paciente>lista = (ArrayList<Paciente>)request.getAttribute("listar_pacientes");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Pacientes</title>
    </head>
    <body>
        <table>
            <thead>
            <tr>
	            <td>Id</td>
                <td>Nome</td>
                <td>Doença</td>
                <td>Estado</td>
                <td>Ação</td>
            </tr>
            </thead>
           <c:forEach var="paciente" items="${Lista}">
            	<tr>
                    <td>${listar_pacientes.id}</td>
                    <td>${listar_pacientes.nome}</td>
                    <td>${listar_pacientes.doenca}</td>
                    <td>${listar_pacientes.estado}</td>
                    <td><a href="acao?editar&id=${listar_pacientes.id}">Editar</a> - <a href="acao?remover&id=${listar_pacientes.id}">Remover</a></td>
                </tr>
            </c:forEach> 
            <tbody>
            </tbody>
        </table>
    </body>
</html>