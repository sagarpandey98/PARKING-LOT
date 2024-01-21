import DTO.GeneateTicketRequestDto;
import DTO.GenerateTicketResponseDto;
import Repositories.ParkingLotRepository;
import Repositories.TicketRepository;
import controller.TicketController;
import exceptions.NoParkingSpotAvailableException;
import models.Ticket;
import models.VehicleType;
import services.GateService;
import services.TicketService;
import services.VehicleService;
import strategy.spotAssignmentStrategy.RandomSpotAssignmentStrategy;
import strategy.spotAssignmentStrategy.SpotAssignmentStrategy;

public class Main {
    public static void main(String[] args) throws NoParkingSpotAvailableException {
//      Create the objects of all the services, repositories and controllers.
//      Dependencies
//       Registry design pattern we are using to store all objects at one place so we dont have to initialise it again and again
        ObjectRegistry objectRegistry = new ObjectRegistry();
        VehicleService vehicleService = new VehicleService();
        GateService gateService = new GateService();
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy(parkingLotRepository);
        TicketService ticketService = new TicketService(vehicleService, gateService, spotAssignmentStrategy, ticketRepository);
        TicketController ticketController = new TicketController(ticketService);

        objectRegistry.register("vehicleService", vehicleService);
        objectRegistry.register("gateService", gateService);
        objectRegistry.register("ticketRepository", ticketRepository);
        objectRegistry.register("parkingLotRepository", parkingLotRepository);
        objectRegistry.register("spotAssignmentStrategy", spotAssignmentStrategy);
        objectRegistry.register("ticketService", ticketService);
        objectRegistry.register("ticketController", ticketController);

        GeneateTicketRequestDto requestDto = new GeneateTicketRequestDto();
        requestDto.setVehicleType(VehicleType.SMALL);
        requestDto.setVehicleNumber("HR3x3434");
        requestDto.setGateId(123L);

        GenerateTicketResponseDto responseDto = ticketController.generateTicket(requestDto);
        Ticket ticket = responseDto.getTicket();
//        we have got the ticket do whatever you want


    }
}

// DTO -> Data Transfer Objects.
// request -> RequestDTO
// response -> responseDTO
// response -> responseDTO

//Dependencies -> Topological Sort
//SpringBoot
//Dependency graph, apply the topological sort on the garph and
// find the order in which the dependencies should be resolved.
// A->B->C_D