package jdbc.basic.tests;

import java.util.Calendar;

import jdbc.basic.dao.ContatoDao;
import jdbc.basic.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {
       // pronto para gravar
       Contato contato = new Contato();
       contato.setNome("Arerdk");
       contato.setEmail("use42r@mail.com.br");
       contato.setEndereco("R. Grã Nico 333");
       contato.setDataNascimento(Calendar.getInstance());

       // grave nessa conexão!!!
       ContatoDao dao = new ContatoDao();

       // método elegante
       dao.adiciona(contato);

       System.out.println("Inserido contato \"" + contato.getNome() + ' ' + contato.getEmail() + "\"");
	}

}
