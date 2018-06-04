package jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;
import jdbc.factory.ConnectionFactory;


public abstract class TesteConexao {

	public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conex�o aberta!");
        connection.close();
	}

}
