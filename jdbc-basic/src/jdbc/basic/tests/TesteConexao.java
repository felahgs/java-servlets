package jdbc.basic.tests;

import java.sql.Connection;
import java.sql.SQLException;
import jdbc.basic.factory.ConnectionFactory;


public abstract class TesteConexao {

	public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
	}

}
