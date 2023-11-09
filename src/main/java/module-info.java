module com.example.caixamercado {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.caixamercado to javafx.fxml;
    exports com.example.caixamercado;
}