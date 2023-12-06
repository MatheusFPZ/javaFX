package com.caixamercado;

import com.caixamercado.DAO.ClientesDAO;
import com.caixamercado.DAO.ProdutosDAO;
import com.caixamercado.model.Produto;
import com.caixamercado.model.Venda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField cod_barras_text;

    @FXML
    private VBox funcoes;


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
    private Label lbl_excluir;

    @FXML
    private Label lbl_finalizar;

    @FXML
    private Label lbl_gerar_nota;

    @FXML
    private Label lbl_nova_venda;



    @FXML
    private Label lbl_desconto;

    @FXML
    private Label lbl_cod_cupom;


    @FXML
    private TextField lbl_cupom;

    @FXML
    private Pane panel_cupom;

    @FXML
    private Pane panel_descontos;

    @FXML
    private Button buscarCliente;






    @FXML
    void imprime_nota(MouseEvent event) {

            imprime_nota();
    }

    @FXML
    void nova_venda(KeyEvent event) {
        if (event.getCode() == KeyCode.F5) {
            preencherTabela(0);
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
        subtotal = novoSubtotal;

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
            novoSubtotal += (produto.getQuantidade() * produto.getValorUnitario())-produto.getPercentualDesconto();
        }

        return novoSubtotal;
    }



    ObservableList<Produto> list  = FXCollections.observableArrayList();
    private int contador = 1;
    double subtotal = 0;

    int quantidade =1;

    Venda venda = new Venda();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cod_barras_text.setOnAction(event -> preencherTabela(0));
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
        panel_cupom.setStyle("-fx-background-radius: 5; -fx-background-color: orange;");
        panel_descontos.setStyle("-fx-background-radius: 5; -fx-background-color: orange;");
        funcoes.setStyle("-fx-background-radius: 5; -fx-background-color: orange;");
        panel_desconhecido.setStyle("-fx-background-radius: 5; -fx-background-color: orange;");
        cod_barras_text.setStyle("-fx-background-color: white;");
        titulo_table.setStyle("-fx-background-color: orange;");

        URL imageURL = getClass().getResource("/1.jpg");
        String imagePath = imageURL!= null? imageURL.toExternalForm(): null;
        Image image = new Image(imagePath);

        img_view.setImage(image);
        panel_varios.setVisible(true);
        lbl_cupom.setDisable(true);
        lbl_quantidade.setDisable(true);


        lbl_excluir.setDisable(true);

        lbl_finalizar.setDisable(true);

        lbl_gerar_nota.setDisable(true);

        buscarCliente.setOnAction(event -> {
            System.out.println("Botão buscarCliente foi pressionado!");
            buscar(); // Chame sua função finalizarCompra() ou a lógica desejada aqui
        });


    }

public void buscar(){
    ClientesDAO cliente = new ClientesDAO();

    if(!buscarCliente.isPressed()){
            System.out.println("ENTROUUUUUUUUU");
            String cpf = input_cpf.getText();
            String nome = cliente.buscaCliente(cpf); // Supondo que buscaClienteNome retorne o nome do cliente
            if (nome != null && !nome.isEmpty()) {
                input_nome.setText(nome);
                System.out.println(nome);
            }else{
                cliente.addCliente(input_nome.getText(), input_cpf.getText());
            }
        }
}

    private void finalizarCompra(){

        panel_varios.setVisible(false);
        panel_pagamento.setVisible(true);
        lbl_nova_venda.setDisable(true);
        lbl_excluir.setDisable(true);

        lbl_finalizar.setDisable(true);

        lbl_gerar_nota.setDisable(false);
        panel_desconhecido.setVisible(false);

        if(!lbl_cupom.getText().isEmpty()){

            String label = lbl_cupom.getText();
            if(label.equals(cupom)){
                lbl_cod_cupom.setText(cupom);
                subtotal = (subtotal-(subtotal*0.1));
                lbl_subtotal.setText(String.valueOf(subtotal));
            }
        }



        if(buscarCliente.isPressed()){
            System.out.println("show de bola");
        }
//


    }

    public void imprime_nota() {


        lbl_nova_venda.setDisable(false);





        if(!input_nome.getText().isEmpty()&&Integer.parseInt(input_dinheiro.getText())>=subtotal){
            System.out.println("////////NOTA FISCAL/////////");
            String nome = input_nome.getText();
            String cpf = input_cpf.getText();
            double dinheiro = Integer.parseInt(input_dinheiro.getText());
            double sub = subtotal;
            double feito = dinheiro - sub;
            String numeroFormatado = String.format("%.2f", feito);
            lbl_troco.setText(String.valueOf(numeroFormatado));
            lbl_valor_total_rece.setText(String.valueOf(dinheiro));
            System.out.println("nome: " + nome + "\ncpf: " + cpf);
            for (Produto produto : list) {
                System.out.println("item  |  valor unitario  |    quantidade");
                System.out.println(produto.getDescricao() + "          " + produto.getValorUnitario() + "          " + produto.getQuantidade());
            }
            System.out.println("\ntotal: " + String.format("%.2f", sub));
            System.out.println("dinheiro: " + dinheiro);
            System.out.println("__________________");
            System.out.println("troco: " + String.format("%.2f", feito));

            System.out.println("///////////NOTA FISCAL//////////////");







            input_nome.clear();
            input_cpf.clear();

            input_dinheiro.clear();

            table.getItems().clear();
            list.clear();
            lbl_cod_cupom.setText("");
            preencherTabela(1);
        }

    }

    public void preencherTabela(int imprimiu) {
        lbl_cupom.clear();
        lbl_cupom.setDisable(false);
        lbl_quantidade.setDisable(false);
        lbl_cod_cupom.setText("");
        panel_desconhecido.setVisible(true);
        if(imprimiu==1){
            table.getItems().clear();
            subtotal=0;
            contador=1;
        }

        lbl_valor_unit.setText("0.0");
        lbl_valor_total_item.setText("0.0");
        lbl_subtotal.setText("0.0");

        panel_pagamento.setVisible(false);
        panel_varios.setVisible(true);

        lbl_nova_venda.setDisable(true);
        lbl_gerar_nota.setDisable(true);
        lbl_excluir.setDisable(false);

        lbl_finalizar.setDisable(false);



        panel_cod_barras.setDisable(false);

        if (!lbl_quantidade.getText().isEmpty()) {
            quantidade = Integer.parseInt(lbl_quantidade.getText());

        }


        String idProdutoParaBuscar1 = cod_barras_text.getText();
        int i = Integer.parseInt(idProdutoParaBuscar1);


            ProdutosDAO produtosDAO = new ProdutosDAO();

        Produto produtoEncontrado = produtosDAO.BuscarProduto(i);

        if(imprimiu==1){

            table.getItems().clear();
            list.clear();
        }
        if (produtoEncontrado != null) {
            int categoria =produtoEncontrado.getCategoria();

            double desconto = calculaDesconto(i, produtoEncontrado, quantidade, categoria);



            if(desconto>0){

                String numeroFormatado = String.format("%.2f", desconto);
                lbl_desconto.setText(numeroFormatado);
            }else{
                lbl_desconto.setText("0.0");


            }
            list.add(produtoEncontrado);

            double total = (quantidade*produtoEncontrado.getValorUnitario())-desconto;

            subtotal = total+subtotal;

            double desconto2 = (venda.quantidade(produtoEncontrado.getCodigo(), quantidade));

            if(desconto2>0){
                lbl_desconto.setText(String.valueOf(desconto2));
            }

             produtoEncontrado.setQuantidade(quantidade);
            produtoEncontrado.setTotal(total-desconto2);
            produtoEncontrado.setContador(contador++);
            produtoEncontrado.setSubtotal(subtotal-desconto2);






        }

        lbl_troco.setText("0.0");
        lbl_valor_total_rece.setText("0.0");
            table.setItems(list);


        table_n_item.setCellValueFactory(cellData -> cellData.getValue().contadorProperty().asObject());
        table_codigo.setCellValueFactory(cellData -> cellData.getValue().codigoProperty().asObject());
        table_descricao.setCellValueFactory(cellData -> cellData.getValue().descricaoProperty());
        table_valor_unit.setCellValueFactory(cellData -> cellData.getValue().valorUnitarioProperty().asObject());
        table_quantidade.setCellValueFactory(cellData -> cellData.getValue().quantidadeProperty().asObject());
        table_total.setCellValueFactory(cellData -> cellData.getValue().subtotalProperty().asObject());
        assert produtoEncontrado != null;
        String numeroFormatado = String.format("%.2f", produtoEncontrado.getSubtotal());
        lbl_subtotal.setText(numeroFormatado);
        lbl_valor_unit.setText(String.valueOf(produtoEncontrado.getValorUnitario()));
        lbl_valor_total_item.setText(String.valueOf(produtoEncontrado.getTotal()));
        cod_barras_text.clear();
        lbl_quantidade.clear();
        quantidade =1;
    }

    String cupom = "teste";


    public double calculaDesconto(int idProduto, Produto produto, int quantidade, int categoria) {
        double desconto = 0;
        if (idProduto == 1) {

            double valor = produto.getValorUnitario();


            desconto = (valor * 0.1)*quantidade;
            produto.setPercentualDesconto(desconto);


        }
        if(categoria==1){
            double valor = produto.getValorUnitario();


            desconto = (valor * 0.1)*quantidade;
            produto.setPercentualDesconto(desconto);

        }
        return desconto;
    }

    }

