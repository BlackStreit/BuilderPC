package com.example.builderpc.Controllers;

import com.example.builderpc.Classes.*;
import com.example.builderpc.DataBase.DataBase;
import com.example.builderpc.HelloApplication;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

public class ComputerMainController implements Initializable {
    public Button btnClose;

    public TableView<CPU> tableCPU;
    public TableColumn<CPU, Integer> tcCPUnumber;
    public TableColumn<CPU, String> tcCPUmanufacture;
    public TableColumn<CPU, String> tcCPUtitle;
    public TableColumn<CPU, Integer> tcCPUfrequency;
    public TableColumn<CPU, Integer> tcCPUPower;
    public TableColumn<CPU, String> tcCPUsocket;
    public TableColumn<CPU, String> tcCPUarchetype;

    public TableView<VideoCard> tableVideoCard;
    public TableColumn<VideoCard, Integer> tcVideoCardId;
    public TableColumn<VideoCard, String> tcVideoCardGCPU;
    public TableColumn<VideoCard, Integer> tcVideoCardVolumeMemory;
    public TableColumn<VideoCard, String> tcVideoCardTypeMemory;
    public TableColumn<VideoCard, Float> tcVideoCardFrequencyMemory;
    public TableColumn<VideoCard, Integer> tcVideoCardPower;
    public TableColumn<VideoCard, String> tcVideoCardTitle;
    public TableColumn<VideoCard, String> tcVideoCardManufacture;

    public TableView<PowerBlock> tablePowerBlock;
    public TableColumn<PowerBlock, Integer> tcPowerBlockId;
    public TableColumn<PowerBlock, String> tcPowerBlockManufacturer;
    public TableColumn<PowerBlock, String> tcPowerBlockTitle;
    public TableColumn<PowerBlock, Integer> tcPowerBlockPower;

    public TableView<Storage> tableStorage;
    public TableColumn<Storage, Integer> tcStorageId;
    public TableColumn<Storage, String> tcStorageManufacturer;
    public TableColumn<Storage, String> tcStorageTitle;
    public TableColumn<Storage, Integer> tcStorageVolume;
    public TableColumn<Storage, String> tcStorageType;
    public TableColumn<Storage, Integer> tcStorageSteedOfWrite;
    public TableColumn<Storage, Integer> tcStorageSpeedOfRead;

    public TableView<RAM> tableRAM;
    public TableColumn<RAM, Integer> tcRAMId;
    public TableColumn<RAM, String> tcRAMManufacturer;
    public TableColumn<RAM, String> tcRAMTitle;
    public TableColumn<RAM, String> tcRAMTypeMemory;
    public TableColumn<RAM, Integer> tcRAMFrequency;
    public TableColumn<RAM, Integer> tcRAMVolume;

    public TableView<Motherboard> tableMotherboard;
    public TableColumn<Motherboard, Integer> tcMotherboardId;
    public TableColumn<Motherboard, String> tcMotherboardManufacturer;
    public TableColumn<Motherboard, String> tcMotherboardTitle;
    public TableColumn<Motherboard, String> tcMotherboardSocket;
    public TableColumn<Motherboard, String> tcMotherboardGCPUType;
    public TableColumn<Motherboard, String> tcMotherboardRAMType;

    void initTable(){
        initCPUTable();
        initVideoCardTable();
        initPowerBlockTable();
        initStorageTable();
        initRAMTable();
        initMotherboardTable();
    }
    void initCPUTable(){
        //Создание таблицы процессора
        tcCPUnumber.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcCPUmanufacture.setCellValueFactory(new PropertyValueFactory<>("manufacture"));
        tcCPUfrequency.setCellValueFactory(new PropertyValueFactory<>("frequency"));
        tcCPUPower.setCellValueFactory(new PropertyValueFactory<>("power"));
        tcCPUsocket.setCellValueFactory(new PropertyValueFactory<CPU, String>("socket"));
        tcCPUarchetype.setCellValueFactory(new PropertyValueFactory<>("archetype"));
        tcCPUtitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableCPU.setItems(DataBase.getCPU());
        TableView.TableViewSelectionModel<CPU> selectionModelCPU = tableCPU.getSelectionModel();
        selectionModelCPU.selectedItemProperty().addListener(new ChangeListener<CPU>() {
            @Override
            public void changed(ObservableValue<? extends CPU> observableValue, CPU cpu, CPU t1) {
                if(t1!=null){

                }
            }
        });
    }

    void initVideoCardTable(){
        tcVideoCardGCPU.setCellValueFactory(new PropertyValueFactory<>("GCPU"));
        tcVideoCardId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcVideoCardFrequencyMemory.setCellValueFactory(new PropertyValueFactory<>("FrequencyMemory"));
        tcVideoCardPower.setCellValueFactory(new PropertyValueFactory<>("power"));
        tcVideoCardManufacture.setCellValueFactory(new PropertyValueFactory<>("manufacture"));
        tcVideoCardTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tcVideoCardTypeMemory.setCellValueFactory(new PropertyValueFactory<>("typeMemory"));
        tcVideoCardVolumeMemory.setCellValueFactory(new PropertyValueFactory<>("volumeMemory"));
        tableVideoCard.setItems(DataBase.getVideoCard());
        TableView.TableViewSelectionModel<VideoCard> selectionModelVideoCard = tableVideoCard.getSelectionModel();
        selectionModelVideoCard.selectedItemProperty().addListener(new ChangeListener<VideoCard>() {
            @Override
            public void changed(ObservableValue<? extends VideoCard> observableValue, VideoCard videoCard, VideoCard t1) {

            }
        });
    }

    void initPowerBlockTable(){
        tcPowerBlockId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcPowerBlockPower.setCellValueFactory(new PropertyValueFactory<>("power"));
        tcPowerBlockTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tcPowerBlockManufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacture"));
        tablePowerBlock.setItems(DataBase.getPowerBlock());
        TableView.TableViewSelectionModel<PowerBlock> selectionModelPowerBlock = tablePowerBlock.getSelectionModel();
        selectionModelPowerBlock.selectedItemProperty().addListener(new ChangeListener<PowerBlock>() {
            @Override
            public void changed(ObservableValue<? extends PowerBlock> observableValue, PowerBlock powerBlock, PowerBlock t1) {
                if(t1 != null){

                }
            }
        });
    }

    void initStorageTable(){
        tcStorageId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcStorageManufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacture"));
        tcStorageTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tcStorageType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tcStorageVolume.setCellValueFactory(new PropertyValueFactory<>("volume"));
        tcStorageSpeedOfRead.setCellValueFactory(new PropertyValueFactory<>("speedOfRead"));
        tcStorageSteedOfWrite.setCellValueFactory(new PropertyValueFactory<>("speedOfWrite"));
        tableStorage.setItems(DataBase.getStorage());
        TableView.TableViewSelectionModel<Storage> selectionModelStorage = tableStorage.getSelectionModel();
        selectionModelStorage.selectedItemProperty().addListener(new ChangeListener<Storage>() {
            @Override
            public void changed(ObservableValue<? extends Storage> observableValue, Storage storage, Storage t1) {
                if(t1 != null){

                }
            }
        });
    }

    void initRAMTable(){
        tcRAMFrequency.setCellValueFactory(new PropertyValueFactory<>("frequency"));
        tcRAMId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcRAMManufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacture"));
        tcRAMTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tcRAMVolume.setCellValueFactory(new PropertyValueFactory<>("volume"));
        tcRAMTypeMemory.setCellValueFactory(new PropertyValueFactory<>("typeMemory"));
        tableRAM.setItems(DataBase.getRAM());
        TableView.TableViewSelectionModel<RAM> selectionModelRAM = tableRAM.getSelectionModel();
        selectionModelRAM.selectedItemProperty().addListener(new ChangeListener<RAM>() {
            @Override
            public void changed(ObservableValue<? extends RAM> observableValue, RAM ram, RAM t1) {
                if(t1 != null){

                }
            }
        });
    }


    void initMotherboardTable(){
        tcMotherboardId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcMotherboardTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tcMotherboardManufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacture"));
        tcMotherboardGCPUType.setCellValueFactory(new PropertyValueFactory<>("GCPUtype"));
        tcMotherboardSocket.setCellValueFactory(new PropertyValueFactory<>("socket"));
        tcMotherboardRAMType.setCellValueFactory(new PropertyValueFactory<>("RAMtype"));
        tableMotherboard.setItems(DataBase.getMotherboard());
        TableView.TableViewSelectionModel<Motherboard> selectionModelMotherboard = tableMotherboard.getSelectionModel();
        selectionModelMotherboard.selectedItemProperty().addListener(new ChangeListener<Motherboard>() {
            @Override
            public void changed(ObservableValue<? extends Motherboard> observableValue, Motherboard motherboard, Motherboard t1) {
                if(t1 != null){

                }
            }
        });
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTable();
    }



    public void btnCloseClick(ActionEvent actionEvent) throws IOException {
        Stage totalStage = (Stage) btnClose.getScene().getWindow();
        DataBase.createDataBase();
        DataBase.createTable();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        totalStage.setTitle("Главная страница");
        totalStage.setScene(scene);
        totalStage.show();
    }
}
