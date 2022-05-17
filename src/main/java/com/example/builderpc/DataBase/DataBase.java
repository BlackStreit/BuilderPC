package com.example.builderpc.DataBase;

import com.example.builderpc.Classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DataBase {
    private static Connection connection;
    private static Statement statement;
    public static void createDataBase() {
        try {
            Class.forName("org.sqlite.JDBC"); //Проверяем наличие JDBC драйвера для работы с БД
            connection = DriverManager.getConnection("jdbc:sqlite:BuilderPC");//соединениесБД
            System.out.println("Соединение с СУБД выполнено.");
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }
    }
    public static void createTable(){
        String sql = """
                CREATE TABLE IF NOT EXISTS CPU
                ( id integer PRIMARY KEY AUTOINCREMENT,
                frequency float,
                power integer,
                socket text,
                archetype text,
                title text,
                manufacturer text);
                """;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = """
                CREATE TABLE VideoCard (
                id integer PRIMARY KEY AUTOINCREMENT,
                GCPU text,
                VolumeMemory integer,
                TypeMemory text,
                FrequencyMemory float,
                Power integer,
                title text,
                manufacturer text);
                """;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = """
                CREATE TABLE PowerBlock (
                id integer PRIMARY KEY AUTOINCREMENT,
                power integer,
                title text,
                manufacturer text);
                """;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = """
                CREATE TABLE Storage (
                id integer PRIMARY KEY AUTOINCREMENT,
                volume integer,
                type text,
                speedOfWrite integer,
                speedOfRead integer,
                title text,
                manufacturer text);
                """;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = """
                CREATE TABLE RAM (
                id integer PRIMARY KEY AUTOINCREMENT,
                typeMemory text,
                frequency float,
                volume integer,
                title text,
                manufacturer text);
                """;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = """
                CREATE TABLE MotherBoard (
                id integer PRIMARY KEY AUTOINCREMENT,
                socket text,
                GCPUtype text,
                RAMtype text,
                title text,
                manufacturer text);
                """;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<CPU> getCPU(){
        ObservableList<CPU> cpus = FXCollections.observableArrayList();
        var req = """
                SELECT * FROM CPU;
                """;
        try {
            ResultSet resultSet = statement.executeQuery(req);
            while (resultSet.next()){
                var cpu = new CPU();
                cpu.setId(resultSet.getInt("id"));
                cpu.setTitle(resultSet.getString("title"));
                cpu.setArchetype(resultSet.getString("archetype"));
                cpu.setFrequency(resultSet.getFloat("frequency"));
                cpu.setManufacture(resultSet.getString("manufacturer"));
                cpu.setPower(resultSet.getInt("power"));
                cpu.setSocket(resultSet.getString("socket"));
                cpus.add(cpu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cpus;
    }
    public static void addCPU(CPU cpu){
        var req = String.format("""
                INSERT INTO CPU(frequency, power, socket, archetype, title, manufacturer) 
                VALUES (%s, %s, '%s', '%s', '%s', '%s');
                """, cpu.getFrequency(), cpu.getPower(), cpu.getSocket(), cpu.getArchetype(), cpu.getTitle(), cpu.getManufacture());
        try {
            statement.executeUpdate(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteCPU(int id){
        var req =String.format("DELETE FROM cpu where id = %s", id);
        try {
            statement.executeUpdate(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addVideoCard(VideoCard vc){
        var req = String.format("""
                INSERT INTO VideoCard(GCPU, VolumeMemory, TypeMemory, FrequencyMemory, Power, title, manufacturer) 
                VALUES ('%s", %s, '%s', %s, %s, '%s', '%s');
                """, vc.getGCPU(), vc.getVolumeMemory(), vc.getTypeMemory(), vc.getFrequencyMemory(),
                vc.getPower(), vc.getPower(), vc.getTitle(), vc.getManufacture());
        try {
            statement.executeUpdate(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteVideoCard(int id){
        var req = String.format("""
                DELETE FROM VideoCard WHERE id = %s;
                """, id);
        try {
            statement.executeUpdate(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ObservableList<VideoCard> getVideoCard(){
        ObservableList<VideoCard> vcs = FXCollections.observableArrayList();
        var req = "SELECT * FROM VideoCard";
        try {
            ResultSet resultSet = statement.executeQuery(req);
            while (resultSet.next()){
                var vc = new VideoCard();
                vc.setGCPU(resultSet.getString("GCPU"));
                vc.setFrequencyMemory(resultSet.getFloat("FrequencyMemory"));
                vc.setPower(resultSet.getInt("Power"));
                vc.setTypeMemory(resultSet.getString("TypeMemory"));
                vc.setId(resultSet.getInt("id"));
                vc.setTitle(resultSet.getString("title"));
                vc.setManufacture(resultSet.getString("manufacturer"));
                vc.setVolumeMemory(resultSet.getInt("VolumeMemory"));
                vcs.add(vc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vcs;
    }

    public static void addPowerBlock(PowerBlock pb){
        var req = String.format("""
                INSERT INTO PowerBlock (power, title, manufacturer)
                VALUES (%s, '%s', '%s')
                """, pb.getPower(), pb.getTitle(), pb.getManufacture());
        try {
            statement.executeUpdate(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deletePowerBlock(int id){
        var req = String.format("""
                DELETE FROM PowerBlock WHERE id = %s
                """, id);
        try {
            statement.executeUpdate(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ObservableList<PowerBlock> getPowerBlock(){
        ObservableList<PowerBlock> powerBlocks = FXCollections.observableArrayList();
        var sql = "SELECT * FROM PowerBlock";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                var pb = new PowerBlock();
                pb.setPower(resultSet.getInt("power"));
                pb.setManufacture(resultSet.getString("manufacturer"));
                pb.setTitle(resultSet.getString("title"));
                pb.setId(resultSet.getInt("id"));
                powerBlocks.add(pb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return powerBlocks;
    }

    public static void addStorage(Storage storage){
        var req =String.format("""
                INSERT INTO Storage (volume, type, speedOfWrite, speedOfRead, title, manufacturer)
                VALUES (%s, '%s', %s, %s, '%s', '%s')
                """, storage.getVolume(), storage.getType(), storage.getSpeedOfWrite(), storage.getSpeedOfRead(),
                storage.getTitle(), storage.getManufacture());
        try {
            statement.executeUpdate(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteStorage(int id){
        var req = String.format("""
                DELETE FROM Storage WHERE id = %s
                """, id);
        try {
            statement.executeUpdate(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ObservableList<Storage> getStorage(){
        ObservableList<Storage> storages = FXCollections.observableArrayList();
        var sql = "SELECT * FROM Storage";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                var storage = new Storage();
                storage.setType(resultSet.getString("type"));
                storage.setSpeedOfRead(resultSet.getInt("speedOfRead"));
                storage.setVolume(resultSet.getInt("volume"));
                storage.setSpeedOfWrite(resultSet.getInt("speedOfWrite"));
                storage.setId(resultSet.getInt("id"));
                storage.setTitle(resultSet.getString("title"));
                storage.setManufacture(resultSet.getString("manufacturer"));
                storages.add(storage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return storages;
    }

    public static void addRAM(RAM ram){
        var req = String.format("""
                INSERT INTO RAM (typeMemory, frequency, volume, title, manufacturer)
                VALUES ('%s', %s, %s, '%s', '%s')
                """, ram.getTypeMemory(), ram.getFrequency(), ram.getVolume(), ram.getTitle(), ram.getManufacture());
        try {
            statement.executeUpdate(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteRAM(int id){
        var req =  String.format("""
                DELETE FROM RAM WHERE id = %s
                """, id);
        try {
            statement.executeUpdate(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ObservableList<RAM> getRAM(){
        ObservableList<RAM> rams = FXCollections.observableArrayList();
        var sql = "SELECT * FROM RAM";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                RAM ram = new RAM();
                ram.setFrequency(resultSet.getFloat("frequency"));
                ram.setVolume(resultSet.getInt("volume"));
                ram.setId(resultSet.getInt("id"));
                ram.setTypeMemory(resultSet.getString("typeMemory"));
                ram.setManufacture(resultSet.getString("manufacturer"));
                ram.setTitle(resultSet.getString("title"));
                rams.add(ram);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rams;
    }

    public static void addMotherboard(Motherboard motherboard){
        var req = String.format("""
                INSERT INTO MotherBoard (socket, GCPUtype, RAMtype, title, manufacture)
                VALUES ('%s', '%s', '%s', '%s', '%s')
                """, motherboard.getSocket(), motherboard.getGCPUtype(), motherboard.getRAMtype(),
                motherboard.getTitle(), motherboard.getManufacture());
        try {
            statement.executeUpdate(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteMotherboard(int id){
        var req = String.format("""
                DELECT FROM MotherBoard WHERE id = %s
                """, id);
        try {
            statement.executeUpdate(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static ObservableList<Motherboard> getMotherboard(){
        ObservableList<Motherboard> motherboards = FXCollections.observableArrayList();
        var sql = "SELECT * FROM MotherBoard";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Motherboard mb = new Motherboard();
                mb.setId(resultSet.getInt("id"));
                mb.setTitle(resultSet.getString("title"));
                mb.setSocket(resultSet.getString("socket"));
                mb.setManufacture(resultSet.getString("manufacturer"));
                mb.setGCPUtype(resultSet.getString("GCPUtype"));
                mb.setRAMtype(resultSet.getString("RAMtype"));
                motherboards.add(mb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return motherboards;
    }
}
