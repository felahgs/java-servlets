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
       contato.setEndereco("R. Gr� Nico 333");
       contato.setDataNascimento(Calendar.getInstance());

       // grave nessa conex�o!!!
       ContatoDao dao = new ContatoDao();

       // m�todo elegante
       dao.adiciona(contato);

       System.out.println("Inserido contato \"" + contato.getNome() + ' ' + contato.getEmail() + "\"");
	}

}
