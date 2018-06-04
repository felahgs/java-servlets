package jdbc.basic.tests;

import java.util.List;

import jdbc.basic.dao.ContatoDao;
import jdbc.basic.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		
		List<Contato> contatos = dao.getLista();
		
	      for (Contato contato : contatos) {
	          System.out.println("Nome: " + contato.getNome());
	          System.out.println("Email: " + contato.getEmail());
	          System.out.println("Endereço: " + contato.getEndereco());
	          System.out.println("Data de Nascimento: " + 
	                  contato.getDataNascimento().getTime() + "\n");
	      }
	}

}
