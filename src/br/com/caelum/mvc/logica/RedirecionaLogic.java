package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirecionaLogic implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String id = req.getParameter("id");
		
		if(id.isEmpty()) {
			return "/WEB-INF/jsp/adiciona-contato.jsp";
		} else {
			return "mvc?logica=PesquisaContatos";
		}
		
	}

}
