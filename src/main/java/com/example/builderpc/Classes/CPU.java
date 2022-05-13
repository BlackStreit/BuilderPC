package com.example.builderpc.Classes;

public class CPU {
    private int id;
    private float frequency;
    private int power;
    private String socket;
    private String archetype;
    private String title;
    private String manufacture;

    @Override
    public String toString() {
        return String.format("""
                Производитель: %s
                Название: %s
                Частота: %s
                Энергопотребление: %s
                Сокет: %s
                Архитектура: %s
                """, manufacture, title, frequency, power, socket, archetype);
    }

    public CPU(int id, float frequency, int power, String socket, String archetype, String title, String manufacture) {
        this.id = id;
        this.frequency = frequency;
        this.power = power;
        this.socket = socket;
        this.archetype = archetype;
        this.title = title;
        this.manufacture = manufacture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) throws Exception {
        if(frequency <= 0){
            throw new Exception("Вы ввели некорректное значение");
        }
        this.frequency = frequency;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) throws Exception {
        if(power<=0){
            throw new Exception("Вы ввели некорректное значение");
        }
        this.power = power;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) throws Exception {
        if(socket.length() == 0){
            throw new Exception("Вы ввели некорректное значение");
        }
        this.socket = socket;
    }

    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(String archetype) throws Exception {
        if(archetype.length() == 0){
            throw new Exception("Вы ввели некорректное значение");
        }
        this.archetype = archetype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception {
        if(title.length() == 0){
            throw new Exception("Вы ввели некорректное значение");
        }
        this.title = title;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) throws Exception {
        if(manufacture.length() == 0){
            throw new Exception("Вы ввели некорректное значение");
        }
        this.manufacture = manufacture;
    }

    public CPU() {
        this.id = 0;
        this.frequency = 0.0f;
        this.power = 0;
        this.socket = "socket";
        this.archetype = "archetype";
        this.title = "title";
        this.manufacture = "manufacture";
    }
}
