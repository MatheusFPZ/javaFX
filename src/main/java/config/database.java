package config;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;

public class database {
    public static Connection conectar() {
        try {
            Class.forName("org.sqlite.JDBC");


            return DriverManager.getConnection("jdbc:sqlite::resource:base.db");
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

