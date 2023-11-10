package com.example.caixamercado;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import com.example.caixamercado.model.Produto;
import com.example.caixamercado.DAO.ProdutosDAO;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField cod_barras_text;

    @FXML
    private VBox funcoes;

    @FXML
    private Label lbl_cod_interno;

    @FXML
    private Label lbl_subtotal;

    @FXML
    private Label lbl_troco;

    @FXML
    private Label lbl_valor_total_item;

    @FXML
    private Label lbl_valor_total_rece;

    @FXML
    private Label lbl_valor_unit;

    @FXML
    private Pane panel_cod_barras;

    @FXML
    private Pane panel_cod_interno;

    @FXML
    private Pane panel_desconhecido;

    @FXML
    private Pane panel_subtotal;

    @FXML
    private Pane panel_total_item;

    @FXML
    private Pane panel_total_recebido;

    @FXML
    private Pane panel_troco;

    @FXML
    private Pane panel_valor_unit;



    @FXML
    private TextField titulo_table;
    @FXML
    private ImageView img_view;

    @FXML
    private TableView<Produto> table;
    @FXML
    private TableColumn<Produto, Integer> table_n_item;

    @FXML
    private TableColumn<Produto, Integer> table_codigo;

    @FXML
    private TableColumn<Produto, String> table_descricao;

    @FXML
    private TableColumn<Produto, Double> table_valor_unit;
    @FXML
    private TableColumn<Produto, Integer> table_quantidade;

    @FXML
    private TableColumn<Produto, Double> table_total;

    ObservableList<Produto> list  = FXCollections.observableArrayList();
    private int contador = 1;
    double subtotal = 0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cod_barras_text.setOnAction(event -> preencherTabela());
        panel_cod_barras.setStyle("-fx-background-radius: 5; -fx-background-color: orange;");
        panel_subtotal.setStyle("-fx-background-radius: 5; -fx-background-color: orange;");
        panel_total_item.setStyle("-fx-background-radius: 5; -fx-background-color: orange;");
        panel_total_recebido.setStyle("-fx-background-radius: 5; -fx-background-color: orange;");
        panel_troco.setStyle("-fx-background-radius: 5; -fx-background-color: orange;");
        panel_valor_unit.setStyle("-fx-background-radius: 5; -fx-background-color: orange;");
        panel_cod_interno.setStyle("-fx-background-radius: 5; -fx-background-color: orange;");
        funcoes.setStyle("-fx-background-radius: 5; -fx-background-color: orange;");
        panel_desconhecido.setStyle("-fx-background-radius: 5; -fx-background-color: orange;");
        cod_barras_text.setStyle("-fx-background-color: white;");
        titulo_table.setStyle("-fx-background-color: orange;");
        Image image = new Image("file:/home/linux/Downloads/3549578.jpg");
        img_view.setImage(image);

        //ACOES BANCO DADOS



    }
    public void  preencherTabela() {
        int quantidade = 1;
//        if (!quantidade_text.getText().isEmpty()) {
//            quantidade = Integer.parseInt(quantidade_text.getText());
//        }


        String idProdutoParaBuscar1 = cod_barras_text.getText();
        int i = Integer.valueOf(idProdutoParaBuscar1);
        System.out.println(idProdutoParaBuscar1);


        ProdutosDAO produtosDAO = new ProdutosDAO();
        int idProdutoParaBuscar = 1;
        Produto produtoEncontrado = produtosDAO.BuscarProduto(i);


//        if (produtoEncontrado != null) {
//
//            System.out.println("ID: " + produtoEncontrado.getCodigo() +
//                    ", Nome: " + produtoEncontrado.getDescricao() +
//                    ", Preço: " + produtoEncontrado.getValorUnitario());
//        }


        if (produtoEncontrado != null) {
            //list.clear();
            list.add(produtoEncontrado);

            double total = quantidade*produtoEncontrado.getValorUnitario();
           subtotal = total+ subtotal;


            produtoEncontrado.setQuantidade(quantidade);
            produtoEncontrado.setSubtotal(total);
            produtoEncontrado.setContador(contador++);
        }

            table.setItems(list);
            table_n_item.setCellValueFactory(cellData -> cellData.getValue().contadorProperty().asObject());
            table_codigo.setCellValueFactory(cellData -> cellData.getValue().codigoProperty().asObject());
        table_descricao.setCellValueFactory(cellData -> cellData.getValue().descricaoProperty());
        table_valor_unit.setCellValueFactory(cellData -> cellData.getValue().valorUnitarioProperty().asObject());
        table_quantidade.setCellValueFactory(cellData -> cellData.getValue().quantidadeProperty().asObject());
        table_total.setCellValueFactory(cellData -> cellData.getValue().subtotalProperty().asObject());
        lbl_subtotal.setText(String.valueOf(subtotal));
        lbl_valor_unit.setText(String.valueOf(produtoEncontrado.getValorUnitario()));
        lbl_valor_total_item.setText(String.valueOf(produtoEncontrado.getSubtotal()));
        cod_barras_text.clear();
    }
    }
