package com.example.builderpc.Classes;

import com.example.builderpc.DataBase.DataBase;

public class Computer{
    private int id;
    private CPU cpu;
    private VideoCard videoCard;
    private RAM ram;
    private Storage storage;
    private PowerBlock powerBlock;
    private Motherboard motherboard;

    private String cpuInfo;
    private String vcInfo;
    private String ramInfo;
    private String storageInfo;
    private String pbInfo;
    private String mbInfo;

    public String getCpuInfo() {
        cpuInfo = DataBase.foundCPU(this.cpu.getId()).toString();
        return cpuInfo;
    }

    public String getVcInfo() {
        vcInfo = DataBase.foundVideoCard(this.videoCard.getId()).toString();
        return vcInfo;
    }

    public String getRamInfo() {
        ramInfo = DataBase.foundRAM(ram.getId()).toString();
        return ramInfo;
    }

    public String getStorageInfo() {
        storageInfo = DataBase.foundStorage(storage.getId()).toString();
        return storageInfo;
    }

    public String getPbInfo() {
        pbInfo = DataBase.foundPowerBlock(powerBlock.getId()).toString();
        return pbInfo;
    }

    public String getMbInfo() {
        mbInfo = DataBase.foundMotherboard(motherboard.getId()).toString();
        return mbInfo;
    }

    public Computer(int id, CPU cpu, VideoCard videoCard, RAM ram, Storage storage, PowerBlock powerBlock, Motherboard motherboard) throws Exception {
        this.id = id;
        this.cpu = cpu;
        this.videoCard = videoCard;
        this.ram = ram;
        this.storage = storage;
        this.powerBlock = powerBlock;
        this.motherboard = motherboard;
        cpuInfo = "";
        vcInfo = "";
        ramInfo = "";
        storageInfo = "";
        pbInfo = "";
        mbInfo = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Computer() {
        this.id = 0;
        this.cpu = new CPU();
        this.videoCard = new VideoCard();
        this.ram = new RAM();
        this.storage = new Storage();
        this.powerBlock = new PowerBlock();
        this.motherboard = new Motherboard();
        cpuInfo = "";
        vcInfo = "";
        ramInfo = "";
        storageInfo = "";
        pbInfo = "";
        mbInfo = "";
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
