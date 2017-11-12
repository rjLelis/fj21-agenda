<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Adicionar um contato</title>
		<link type="text/css" href="css/jquery.css" rel="stylesheet"/>
		<link type="text/css" href="css/tarefas.css" rel="stylesheet"/>
	    <script type="text/javascript" src="js/jquery.js"></script>
	    <script type="text/javascript" src="js/jquery-ui.js"></script>

	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		<h1>Digite os dados do contato</h1>
		<hr>
		<form action="mvc">
				<label for="nome">Nome</label>
				<input type="text" name="nome" placeholder='Digite seu nome'/><br/>

				<label for="email">E-mail</label>
				<input type="text" name="email" placeholder='Digite seu E-mail'/><br/>

				<label for="endereco">Endereço</label>
				<input type="text" name="endereco" placeholder='Digite seu Endereço'/><br/>

				<label for="dataNascimeto">Data de nascimento</label>
				<caelum:campoData id="dataNascimento" /><br />

				<input type="hidden" name="logica" value="AdicionaContatoLogic"/>
				<input type="submit" value="Gravar">
		</form>
		<c:import url="rodape.jsp"/>
	</body>
</html>
