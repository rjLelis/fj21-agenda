package br.com.caelum.agenda.teste;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class TestaPesquisa {

	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		Contato contato = dao.pesquisa(4);
		
		System.out.println("Nome: " + contato.getNome());
		System.out.println("Email: " + contato.getEmail());
		System.out.println("Endereço: " + contato.getEndereco());
		System.out.println("Data de nascimento: " + contato.getDataNascimento().getTime());

	}

}
