package com.example.builderpc;

import com.example.builderpc.Classes.CPU;
import com.example.builderpc.DataBase.DataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public TableView<CPU> tableCPU;
    public TableColumn<Integer, CPU> tcCPUnumber;
    public TableColumn<String, CPU> tcCPUmanufacture;
    public TableColumn<String, CPU> tcCPUtitle;
    public TableColumn<Float, CPU> tcCPUfrequency;
    public TableColumn<Integer, CPU> tcCPUPower;
    public TableColumn<String, CPU> tcCPUsocket;
    public TableColumn<String, CPU> tcCPUarchetype;
    public Button btnCPUadd;
    public Button btnCPDelete;
    public Button btnCPUedit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTable();
    }
    void initTable(){
        //Создание таблицы процессора

        tcCPUnumber.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcCPUmanufacture.setCellValueFactory(new PropertyValueFactory<>("manufacture"));
        tcCPUfrequency.setCellValueFactory(new PropertyValueFactory<>("frequency"));
        tcCPUPower.setCellValueFactory(new PropertyValueFactory<>("power"));
        tcCPUsocket.setCellValueFactory(new PropertyValueFactory<>("socket"));
        tcCPUarchetype.setCellValueFactory(new PropertyValueFactory<>("archetype"));
        tcCPUtitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableCPU.setItems(DataBase.getCPU());
    }

    public void btnCPUaddClick(ActionEvent actionEvent) throws IOException {
        Stage totalStage = (Stage) btnCPUadd.getScene().getWindow();
        DataBase.createDataBase();
        DataBase.createTable();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CPUadd.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        totalStage.setTitle("Добавить процессор");
        totalStage.setScene(scene);
        totalStage.show();
    }

    public void btnCPUdeleteClick(ActionEvent actionEvent) {
    }

    public void btnCPUeditClick(ActionEvent actionEvent) {
    }
}