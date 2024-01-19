package strategy.spotAssignmentStrategy;

import models.Gate;
import models.ParkingSpot;
import models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assginspot(VehicleType vehicleType, Gate gate);
}
