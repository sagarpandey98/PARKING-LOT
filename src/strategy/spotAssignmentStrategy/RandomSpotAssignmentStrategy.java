package strategy.spotAssignmentStrategy;

import Repositories.ParkingLotRepository;
import models.Gate;
import models.ParkingLot;
import models.ParkingSpot;
import models.VehicleType;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    ParkingLotRepository parkingLotRepository;
    public RandomSpotAssignmentStrategy(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }
    @Override
    public ParkingSpot assginspot(VehicleType vehicleType, Gate gate) {

//        Logic to assign available spot
        ParkingLot parkingLot = parkingLotRepository.getParkingLot(gate);
//        we can add exception here
        return null;
    }
}
