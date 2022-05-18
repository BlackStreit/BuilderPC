package com.example.builderpc.Controllers;

import com.example.builderpc.Classes.PowerBlock;
import com.example.builderpc.DataBase.DataBase;
import com.example.builderpc.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PowerBlockAddController implements Initializable {
    public ComboBox<String> cmbManufacturer = new ComboBox<>();
    public ComboBox<Integer> cmbPower = new ComboBox<>();
    public TextField txtTitle;
    public Label errors;
    public Button btnAdd;
    public Button btnClose;

    public void btnAddClick(ActionEvent actionEvent) {
        PowerBlock pb = new PowerBlock();
        pb.setPower(cmbPower.getValue());
        try {
            pb.setManufacture(cmbManufacturer.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            pb.setTitle(txtTitle.getText());
        } catch (Exception e) {
            errors.setText("Вы не ввели название");
            return;
        }
        DataBase.addPowerBlock(pb);
        errors.setText("Блок питания добавлен");
        txtTitle.setText("");
    }

    public void btnCloseClose(ActionEvent actionEvent) throws IOException {
        Stage totalStage = (Stage) btnAdd.getScene().getWindow();
        DataBase.createDataBase();
        DataBase.createTable();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        totalStage.setTitle("Главная страница");
        totalStage.setScene(scene);
        totalStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init();
    }
    void init(){
        ObservableList<String> manufacturer = FXCollections.observableArrayList();
        manufacturer.add("Thermaltake");
        manufacturer.add("Sea Sonic");
        manufacturer.add("Chieftec");
        manufacturer.add("Cougar");
        manufacturer.add("Zalman");
        manufacturer.add("ENERMAX");
        manufacturer.add("BE QUIET!");
        manufacturer.add("Corsair");
        manufacturer.add("DeepCool");
        manufacturer.add("FSP");
        cmbManufacturer.setItems(manufacturer);
        cmbManufacturer.setValue(manufacturer.get(0));

        ObservableList<Integer> powers = FXCollections.observableArrayList();
        for(int i = 300; i <=1500; i+=150){
            powers.add(i);
        }
        cmbPower.setItems(powers);
        cmbPower.setValue(powers.get(0));
    }
}
