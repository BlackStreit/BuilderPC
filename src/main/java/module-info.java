module com.example.builderpc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.builderpc to javafx.fxml;
    exports com.example.builderpc;
    opens com.example.builderpc.Classes to javafx.fxml;
    exports com.example.builderpc.Classes;
    opens  com.example.builderpc.Controllers to javafx.fxml;
    exports com.example.builderpc.Controllers;
}