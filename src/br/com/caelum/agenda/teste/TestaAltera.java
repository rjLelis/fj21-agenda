package br.com.caelum.agenda.teste;

import java.util.Calendar;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Teste altera");
		contato.setEmail("test@teste.com");
		contato.setEndereco("R. teste");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.altera(contato);
		
		System.out.println("Contato alterado");

	}

}
