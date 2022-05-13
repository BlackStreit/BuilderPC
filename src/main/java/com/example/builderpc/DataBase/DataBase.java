package com.example.builderpc.DataBase;

import com.example.builderpc.Classes.CPU;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DataBase {
    public static Connection connection;
    public static Statement statement;
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
        //deleteTable();
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
                cpu.setManufacture(resultSet.getString("manufacture"));
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
}
