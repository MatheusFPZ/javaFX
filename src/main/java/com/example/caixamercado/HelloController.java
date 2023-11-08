package com.example.caixamercado;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField cod_barras;

    @FXML
    private ListView<?> list;

    @FXML
    private TextField subtotal;

    @FXML
    private TextField total_item;

    @FXML
    private TextField total_recebi;

    @FXML
    private TextField troco;

    @FXML
    private TextField valor_unit;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cod_barras.setStyle("-fx-control-inner-background:  grey;");
        subtotal.setStyle("-fx-control-inner-background:  grey;");
        total_item.setStyle("-fx-control-inner-background:  grey;");
        total_recebi.setStyle("-fx-control-inner-background:  grey;");
        troco.setStyle("-fx-control-inner-background:  grey;");
        valor_unit.setStyle("-fx-control-inner-background:  grey;");
        cod_barras.setEditable(false);
        subtotal.setEditable(false);
        total_item.setEditable(false);
        total_recebi.setEditable(false);
        troco.setEditable(false);
        valor_unit.setEditable(false);
    }
}
