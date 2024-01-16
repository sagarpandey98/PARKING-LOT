package models;

public class ElectricMeter extends  BaseModel{
    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    private int consumption;
}
