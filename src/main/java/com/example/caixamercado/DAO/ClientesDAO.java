package com.example.caixamercado.DAO;

import com.example.caixamercado.model.Cliente;
import com.example.caixamercado.model.Produto;
import config.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientesDAO {

    public Cliente procuraCliente(String cpf){
        Connection conexao = database.conectar();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if(conexao !=null){
            try {
                String sql = "SELECT * FROM clientes WHERE cpf=?";
                preparedStatement = conexao.prepareStatement(sql);

                preparedStatement.setString(1, cpf);

                resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    String nome = resultSet.getString("nome");


                    return new Cliente(nome);

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



    public void addCliente(String nome, String cpf){

        Connection conexao = database.conectar();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        if(conexao != null){
            try {
                String sql = "INSERT INTO clientes (nome, cpf) VALUES (?, ?)";
                preparedStatement = conexao.prepareStatement(sql);

                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, cpf);

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                database.fecharConexao(conexao, preparedStatement, resultSet);
            }
        } else {
            System.out.println("Falha na conexão com o banco de dados.");
        }
        }

        public String buscaCliente(String cpf){

            Connection conexao = database.conectar();
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            String nome = "";

            if(conexao != null){
                try {
                    String sql = "SELECT * FROM clientes WHERE CPF = ?";
                    preparedStatement = conexao.prepareStatement(sql);
                    preparedStatement.setString(1, cpf);
                    resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()) {

                        nome = resultSet.getString("nome");
                        System.out.println("Nome do cliente: " + nome);
                    }

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } finally {
                    database.fecharConexao(conexao, preparedStatement, resultSet);
                }
            } else {
                System.out.println("Falha na conexão com o banco de dados.");
            }
            return nome;
        }
}
