package controller;

import DTO.GeneateTicketRequestDto;
import DTO.GenerateTicketResponseDto;
import exceptions.NoParkingSpotAvailableException;
import models.ResponseStatus;
import models.Ticket;
import services.TicketService;

public class TicketController {
    TicketService ticketService;
    public TicketController(TicketService ticketService)
    {
        this.ticketService = ticketService;
    }
//    public Ticket generateTicket(Vehicle vehicle, Gate gate){
//        return null;
//        issues with generateTicketTicket method:
//        1.if we add more parameters in input then the current users will start failing.
//        2.Models are the internal details of my system we might not want to expose them.
//        3. Client will have to make lot get calls to create vehicle and other objects.

//        DTO-> Data Transfer Objects.
//        request -> requestDTO
//        response -> responseDTO
//    }
    public GenerateTicketResponseDto generateTicket(GeneateTicketRequestDto generateTicketRequestDto) throws NoParkingSpotAvailableException {
//        vehicle Number -> Get the vehicle object
//        Gate id -> get the gate object

        try{
            Ticket ticket = ticketService.generateTicket(   generateTicketRequestDto.getVehicleNumber(),
                    generateTicketRequestDto.getVehicleType(),
                    generateTicketRequestDto.getGateId());
            GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
            generateTicketResponseDto.setTicket(ticket);
            generateTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return generateTicketResponseDto;
        }
        catch (NoParkingSpotAvailableException noParkingSpotAvailableException){
            GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
            generateTicketResponseDto.setTicket(null);
            generateTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            return generateTicketResponseDto;
        }
    }



}
