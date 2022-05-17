package com.example.builderpc.Classes;

public class Computer extends Detail{
    private CPU cpu;
    private VideoCard videoCard;
    private RAM ram;
    private Storage storage;
    private PowerBlock powerBlock;
    private Motherboard motherboard;

    public Computer(int id, String title, String manufacture, CPU cpu, VideoCard videoCard, RAM ram, Storage storage, PowerBlock powerBlock, Motherboard motherboard) throws Exception {
        super(id, title, manufacture);
        this.cpu = cpu;
        this.videoCard = videoCard;
        this.ram = ram;
        this.storage = storage;
        this.powerBlock = powerBlock;
        this.motherboard = motherboard;
    }

    public Computer() {
        super();
        this.cpu = new CPU();
        this.videoCard = new VideoCard();
        this.ram = new RAM();
        this.storage = new Storage();
        this.powerBlock = new PowerBlock();
        this.motherboard = new Motherboard();
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public PowerBlock getPowerBlock() {
        return powerBlock;
    }

    public void setPowerBlock(PowerBlock powerBlock) {
        this.powerBlock = powerBlock;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }
}
