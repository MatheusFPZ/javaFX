package config;
import java.sql.*;

public class database {
    public static Connection conectar() {
        try {
            // Carregar o driver JDBC para o SQLite
            Class.forName("org.sqlite.JDBC");

            // Estabelecer a conexão com o banco de dados

            return DriverManager.getConnection("jdbc:sqlite:base.db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null; // Retornar null em caso de falha na conexão
        }
    }

    public static void fecharConexao(Connection conexao, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

