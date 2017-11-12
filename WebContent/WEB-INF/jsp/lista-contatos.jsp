<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset='UTF-8'>
		<title>Lista de contatos</title>
		<link type="text/css" href="css/tarefas.css" rel="stylesheet"/>
	</head>
	<body>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

		<c:import url="cabecalho.jsp" />

		<table border="1">
			<th>NOME</th>
			<th>E-MAIL</th>
			<th>ENDEREÇO</th>
			<th>DATA DE NASCIMENTO</th>
			<!-- Iterando na lista de contatos -->
			<c:forEach var="contato" items="${contatos}">
				<tr>
					<td>${contato.nome}</td>
					<td>	
						<c:choose>
							<c:when test="${not empty contato.email}">
								<a href="mailto:${contato.email}">${contato.email}</a>
							</c:when>
						<c:otherwise>
							E-mail não informado
						</c:otherwise>
						</c:choose>
					</td>
					<td>
						<c:choose>
							<c:when test="${not empty contato.endereco}">
								${contato.endereco}		
							</c:when>
						<c:otherwise>
							Endereço não informado
						</c:otherwise>
						</c:choose>
					</td>
					<!-- formatação da data -->
					<td><fmt:formatDate value="${contato.dataNascimento.time}"
							pattern="dd/MM/yyyy" /></td>
					<td>
						<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
					</td>
					<td>
						<a href="mvc?logica=RedirecionaLogic&id=${contato.id}">Alterar</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<form action="mvc">
			<input type="hidden" name="logica" value="RedirecionaLogic">
			<input type="hidden" name="id" value="">
			<input type="submit" value="Adicionar um Contato">
		</form>
		<c:import url="rodape.jsp" />
		
	</body>
</html>