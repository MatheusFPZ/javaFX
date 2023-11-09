package com.example.caixamercado;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1366, 768);
        stage.setTitle("Caixa mercado top");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {


        // Chamar a função para buscar todos os produtos
//produtosDAO.buscarTodosProdutos();
        //produtosDAO.BuscarProduto(2);
        //produtosDAO.RemoverProduto(1);
        launch();
    }
}