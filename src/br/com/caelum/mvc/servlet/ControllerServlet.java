package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String parametro = request.getParameter("logica");// Pega o parâmetro que contém a logica
		String nomeDaClasse = "br.com.caelum.mvc.logica." + parametro;// Faz o caminho para a classe
		try {
			Class classe = Class.forName(nomeDaClasse);// Transforma o caminho em classe

			Logica logica = (Logica) classe.newInstance();// Instancia a classe
			String pagina = logica.executa(request, response);// Executa a lógica e retorna a página para redirecionar

			request.getRequestDispatcher(pagina).forward(request, response);// Redireciona para a pagina retornada

		} catch(Exception e) {
			throw new ServletException(
					"A lógica da negócios causou uma exceção", e);
		}

	}

}
