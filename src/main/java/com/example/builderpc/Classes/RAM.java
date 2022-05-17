package com.example.builderpc.Classes;

public class RAM extends Detail{
    private String typeMemory;
    private float frequency;
    private int volume;

    public RAM(int id, String title, String manufacture, String typeMemory, float frequency, int volume) throws Exception {
        super(id, title, manufacture);
        this.typeMemory = typeMemory;
        this.frequency = frequency;
        this.volume = volume;
    }

    public RAM() {
        super();
        this.typeMemory = "typeMemory";
        this.frequency = 0.0f;
        this.volume = 0;
    }

    public String getTypeMemory() {
        return typeMemory;
    }

    public void setTypeMemory(String typeMemory) {
        this.typeMemory = typeMemory;
    }

    public float getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + """
                Тип памяти: %s
                Частота памяти: %s
                Объем: %s
                """, typeMemory, frequency, volume);
    }
}
