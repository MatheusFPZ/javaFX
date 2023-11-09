package com.example.caixamercado;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

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
    private TableColumn<?, ?> table_n_item;

    @FXML
    private TextField titulo_table;
    @FXML
    private ImageView img_view;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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


    }

}
