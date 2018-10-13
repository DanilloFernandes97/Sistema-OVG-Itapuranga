package conexao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {

    private static Connection connection;
    // ***      

    public static Connection getConexao() throws ClassNotFoundException, SQLException, IOException {

        if (Conexao.connection == null) {
            new Conexao().preparaConexao();
        }

        return Conexao.connection;

    }
    
    private void preparaConexao() throws ClassNotFoundException, SQLException, IOException {

        // Carrega o driver(arquivo JAR) do banco de dados na memória.
        Class.forName("com.mysql.jdbc.Driver");

        String lUrl = null;
        String lUser = null;
        String lSenha = null;

        Properties proterties = new Properties();
        try {
           
            proterties.load(new FileInputStream("Sistema OVG\\config.properties"));

            lUrl = proterties.getProperty("database");
            lUser = proterties.getProperty("dbuser");
            lSenha = proterties.getProperty("dbpassword");

            Conexao.connection = DriverManager.getConnection(lUrl, lUser, lSenha);

            // Para "CRUD" o commit é executado automaticamente, mas para select não
            // então liga o auto commit para não ficar transação aberta no banco.
            Conexao.connection.setAutoCommit(true);

        } finally {
            proterties = null;
        }
    }

    private void carregaDados(String url, String user, String senha) throws IOException {

    }

}
