<html>
	<head>
		<title>Bem vindo</title>
		<link type='text/css' href='css/tarefas.css' rel='stylesheet'/>
	</head>
	<body>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
		
		<%-- comentário em JSP aqui: nossa primeira página JSP --%>
		
		<c:import url='cabecalho.jsp'/>
		
		<%
			String mensagem = "Bem vindo ao sistema de agenda do FJ-21!";
		%>
		
		<% out.println(mensagem); %>
		
		<br />
		
		<%
			String desenvolvido = "Desenvolvido por Renato Lélis"; 
		%>
		
		<%= desenvolvido %>
		
		<br />
		
		<%
			System.out.println("Tudo foi executado!");
		%>
		
		
		<form action="mvc">
			<input type="hidden" name="logica" value="ListaContatosLogic">
			<input type="submit" value="Entrar">
		</form>

		<c:import url='rodape.jsp'/>
	</body>
</html>