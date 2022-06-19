module com.mycompany.aula {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.aula to javafx.fxml;
    exports com.mycompany.aula;
}
