package jdbc.basic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;


import jdbc.basic.factory.ConnectionFactory;
import jdbc.basic.modelo.Contato;

public class ContatoDao {

    // a conexão com o banco de dados
    private Connection connection;

    //Constructor para ContatoDao
    public ContatoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Contato contato) {
        String sql = "insert into contatos " +
                "(nome,email,endereco,dataNascimento)" +
                " values (?,?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1,contato.getNome());
            stmt.setString(2,contato.getEmail());
            stmt.setString(3,contato.getEndereco());
            stmt.setDate(4, new Date(
                    contato.getDataNascimento().getTimeInMillis()));

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Contato> getLista() {
        try {
            List<Contato> contatos = new ArrayList<Contato>();
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from contatos"); // Prepara um statemente de sql a ser executado
            ResultSet rs = stmt.executeQuery(); //Executa a query e armazeda o resultado em uma variável do tipo
            									//Result Set, essa variável é percorrida com o metodo next e contem
            while (rs.next()) {					//todos os resultados da querry de busca sql. 
                // criando o objeto Contato     //ResultSet é utilizado quando a operação de sql tem um valor de retorno
                Contato contato = new Contato();//O metodo next retorna falso após percorrer todos os objetos retornados
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));

                // montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);

                // adicionando o objeto à lista
                contatos.add(contato);
            }
            rs.close();
            stmt.close();
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Contato contato) {
        String sql = "update contatos set nome=?, email=?, endereco=?," +
                "dataNascimento=? where id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento()
                    .getTimeInMillis()));
            stmt.setLong(5, contato.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Contato contato) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete " +
                    "from contatos where id=?");
            stmt.setLong(1, contato.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
