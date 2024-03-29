package models;

import java.util.List;
//PL-Gate -> 1 : M
//           1 : 1
//PL - gate -> 1:M
// how to represent one-to-many relation in database  :
// In the Gates table, for every gate we will have the parking lot id.

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> parkingFloors;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private List<Gate> gates;
    private ParkingLotStatus parkingLotStatus;
    private String name;
    private String address;
}

// all the model classes are going to be a table in the database;
