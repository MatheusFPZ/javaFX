module com.example.caixamercado {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.caixamercado to javafx.fxml;
    exports com.caixamercado;
}