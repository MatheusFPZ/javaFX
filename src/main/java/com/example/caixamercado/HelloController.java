package com.example.caixamercado;

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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import com.example.caixamercado.model.Produto;
import com.example.caixamercado.DAO.ProdutosDAO;
import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

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
    private Pane panel_dinheiro;

    @FXML
    private Pane panel_nome;
    @FXML
    private Pane panel_cpf;
    @FXML
    private Pane panel_cod_interno;

    @FXML
    private Pane panel_desconhecido;

    @FXML
    private Pane panel_pagamento;

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
    private Pane panel_varios;

    @FXML
    private TextField lbl_quantidade;


    @FXML
    private Label valor_alterar_label;
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
    @FXML
    private TextField input_cpf;

    @FXML
    private TextField input_dinheiro;

    @FXML
    private TextField input_nome;

    @FXML
    private Label lbl_codigoInterno;

    @FXML
    private Label lbl_excluir;

    @FXML
    private Label lbl_finalizar;

    @FXML
    private Label lbl_gerar_nota;

    @FXML
    private Label lbl_nova_venda;

    @FXML
    private Label lbl_quantidadeL;

    @FXML
    void imprime_nota(MouseEvent event) {
            imprime_nota();
    }

    @FXML
    void nova_venda(KeyEvent event) {
        if (event.getCode() == KeyCode.F5) {
            preencherTabela();
        }
    }
    @FXML
    void remover_produto(KeyEvent event) {
        if (event.getCode() == KeyCode.F11) {
            removerLinhaSelecionada();
        }
    }

    @FXML
    void finalizar(MouseEvent event) {

            finalizarCompra();

    }
    @FXML
    void removerLinhaSelecionada() {
        ObservableList<Produto> produtosSelecionados, todosProdutos;
        todosProdutos = table.getItems();

        // Obtém a lista de produtos selecionados
        produtosSelecionados = table.getSelectionModel().getSelectedItems();

        // Obtém a posição do primeiro item selecionado
        int posicaoRemocao = todosProdutos.indexOf(produtosSelecionados.get(0));

        // Remove todos os produtos selecionados da tabela
        todosProdutos.removeAll(produtosSelecionados);

        // Recalcula o contador e o subtotal
        int novoContador = recalcularContador();
        double novoSubtotal = recalcularSubtotal();

        // Atualiza os campos na interface gráfica (se necessário)
        //table_n_item.setText(String.valueOf(novoContador));
        lbl_subtotal.setText(String.valueOf(novoSubtotal));

        // Atualiza os contadores dos itens restantes
        for (int i = posicaoRemocao; i < todosProdutos.size(); i++) {
            Produto produto = todosProdutos.get(i);
            produto.setContador(i + 1); // Adapte conforme necessário
        }

        // Atualiza a tabela para refletir as alterações
        table.refresh();
    }


    private int recalcularContador() {
        ObservableList<Produto> produtos = table.getItems();
        int novoContador = 0;

        for (Produto produto : produtos) {
            novoContador += produto.getQuantidade();
        }

        return novoContador;
    }

    private double recalcularSubtotal() {
        ObservableList<Produto> produtos = table.getItems();
        double novoSubtotal = 0;

        for (Produto produto : produtos) {
            novoSubtotal += produto.getQuantidade() * produto.getValorUnitario();
        }

        return novoSubtotal;
    }



    ObservableList<Produto> list  = FXCollections.observableArrayList();
    private int contador = 1;
    double subtotal = 0;
    //int novaQuantidade= 1;
    int quantidade =1;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cod_barras_text.setOnAction(event -> preencherTabela());
        panel_dinheiro.setStyle("-fx-background-radius: 5; -fx-background-color: orange;");
        panel_cpf.setStyle("-fx-background-radius: 5; -fx-background-color: orange;");
        panel_nome.setStyle("-fx-background-radius: 5; -fx-background-color: orange;");
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
        panel_varios.setVisible(true);

        lbl_excluir.setDisable(true);
        lbl_quantidadeL.setDisable(true);
        lbl_finalizar.setDisable(true);
        lbl_codigoInterno.setDisable(true);
lbl_gerar_nota.setDisable(true);


    }

    private void finalizarCompra(){

        panel_varios.setVisible(false);
        panel_pagamento.setVisible(true);
        lbl_nova_venda.setDisable(true);
        lbl_excluir.setDisable(true);
        lbl_quantidadeL.setDisable(true);
        lbl_finalizar.setDisable(true);
        lbl_codigoInterno.setDisable(true);
        lbl_gerar_nota.setDisable(false);

//
//
//
//
//        double total = subtotal;
//
//

    }

    public void imprime_nota(){


        lbl_nova_venda.setDisable(false);

        if (!input_nome.getText().isEmpty()&& !input_dinheiro.getText().isEmpty() && !input_cpf.getText().isEmpty()) {
            System.out.println("////////NOTA FISCAL/////////");
            String nome = input_nome.getText();
            String cpf = input_cpf.getText();
            double dinheiro = Integer.valueOf(input_dinheiro.getText());
            double sub = subtotal;
            double feito = dinheiro-sub;
            lbl_troco.setText(String.valueOf(feito));
            System.out.println("nome: "+ nome+"\ncpf: "+cpf);
            for(Produto produto: list){
                System.out.println("item    |    valor unitario    |      quantidade");
                System.out.println(produto.getDescricao()+"          "+produto.getValorUnitario()+"          "+produto.getQuantidade());
            }
            System.out.println("\ntotal: "+ sub);
            System.out.println("dinheiro: "+ dinheiro);
            System.out.println("__________________");
            System.out.println("troco: "+ feito);

            System.out.println("///////////NOTA FISCAL//////////////");
                input_nome.clear();
                input_cpf.clear();
                input_dinheiro.clear();
        }



    }
    public void  preencherTabela() {

        lbl_valor_unit.setText("0.0");
        lbl_valor_total_item.setText("0.0");
        lbl_subtotal.setText("0.0");
        lbl_troco.setText("0.0");




        panel_pagamento.setVisible(false);
        panel_varios.setVisible(true);

        lbl_nova_venda.setDisable(true);
        lbl_gerar_nota.setDisable(true);
        lbl_excluir.setDisable(false);
        lbl_quantidadeL.setDisable(false);
        lbl_finalizar.setDisable(false);
        lbl_codigoInterno.setDisable(false);

        //lbl_quantidade.setDisable(true);
        panel_cod_barras.setDisable(false);


//        if(novaQuantidade>1){
//            quantidade = novaQuantidade;
//        }else{
//            quantidade =1;
//        }

        if (!lbl_quantidade.getText().isEmpty()) {
            quantidade = Integer.parseInt(lbl_quantidade.getText());

        }


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
        lbl_quantidade.clear();
        quantidade =1;
    }

    public void calculaDesconto(int idProduto){
        if(idProduto ==1){
            System.out.println("teste");
        }

    }

    }

