<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link type="text/css" href="css/jquery.css" rel="stylesheet" />
		<link type="text/css" href="css/tarefas.css" rel="stylesheet"/>
	    <script type="text/javascript" src="js/jquery.js"></script>
	    <script type="text/javascript" src="js/jquery-ui.js"></script>
		<title>Alterar o contato</title>
	</head>
	<body>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

		<c:import url="cabecalho.jsp"/>
		<h1>Altere os dados do contato</h1>
		<form action="mvc">
				<label for="nome">Nome</label>
				<input type="text" name="nome" value='${contato.nome}'/><br/>

				<label for="email">E-mail</label>
				<input type="text" name="email" value='${contato.email}'/><br/>

				<label for="endereco">Endereço</label>
				<input type="text" name="endereco" value='${contato.endereco}'/><br/>

				<label for="dataNascimento">Data de nascimento</label>
				<input type="text" name='dataNascimento' value=<fmt:formatDate value='${contato.dataNascimento.time}' pattern='dd/MM/yyyy'/> >
				<br/>

				<input type="hidden" name="id" value="${contato.id}">
				<input type="hidden" name="logica" value="AlterarContatoLogic">
				<input type="submit" value="Alterar">
		</form>
		<c:import url="rodape.jsp"/>

	</body>
</html>
