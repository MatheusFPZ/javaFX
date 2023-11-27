package com.example.caixamercado.DAO;

import com.example.caixamercado.model.Produto;
import config.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutosDAO {
    public void BuscarTodosProdutos() {
        Connection conexao = database.conectar();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (conexao != null) {
            try {
                // Criar a instrução SQL para buscar todos os produtos
                String sql = "SELECT * FROM produtos";
                preparedStatement = conexao.prepareStatement(sql);

                // Executar a consulta
                resultSet = preparedStatement.executeQuery();

                // Processar os resultados
                while (resultSet.next()) {
                    int codigo = resultSet.getInt("codigo");
                    String descricao = resultSet.getString("descricao");
                    double valor_unitario = resultSet.getDouble("valor_unitario");

                    System.out.println("codigo: " + codigo + ", descricao: " + descricao + ", valor unitario: " + valor_unitario);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Fechar recursos
                database.fecharConexao(conexao, preparedStatement, resultSet);
            }
        } else {
            System.out.println("Falha na conexão com o banco de dados.");
        }
    }


    public Produto BuscarProduto(int idProduto){
        Connection conexao = database.conectar();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if(conexao !=null){
            try {
                String sql = "SELECT * FROM produtos WHERE codigo=?";
                preparedStatement = conexao.prepareStatement(sql);

                preparedStatement.setInt(1, idProduto);

                resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    String descricao = resultSet.getString("descricao");
                    double valorUnitario = resultSet.getDouble("valor_unitario");
                    int categoria = resultSet.getInt("categoria");

                    return new Produto(idProduto, descricao, valorUnitario, categoria, 0,0);
                    //System.out.println("codigo:"+idProduto+",descricao: "+ descricao+", valor: "+ valor_unitario);
                }else {
                    System.out.println("nao encontrado");
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                database.fecharConexao(conexao, preparedStatement, resultSet);
            }
        } else {
            System.out.println("Falha na conexão com o banco de dados.");
        }
        return null;
    }


    public void RemoverProduto(int idProduto){

        Connection conexao = database.conectar();
        PreparedStatement preparedStatement = null;



        if(conexao!=null){
            try {
                String sql = "DELETE FROM produtos WHERE codigo =?";
                preparedStatement= conexao.prepareStatement(sql);

                preparedStatement.setInt(1, idProduto);
                int linhasAfetadas = preparedStatement.executeUpdate();

                if(linhasAfetadas>0){
                    System.out.println("removido com sucesso");
                }else{
                    System.out.println("erro");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }




}


