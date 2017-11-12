package br.com.caelum.agenda.teste;

import br.com.caelum.agenda.dao.ContatoDao;

public class TestaRemove {

	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		
		dao.remove(5);
		
		System.out.println("Contato Removido");
		

	}

}
