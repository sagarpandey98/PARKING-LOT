package Repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
//    map--> ticketid : ticketobj
    private Map<Long,Ticket> tickets = new HashMap<>();
    private Long ticketIdSequence = 0L;
    public Ticket saveTicket(Ticket ticket){
        ticketIdSequence+=1;
        ticket.setId(ticketIdSequence);
        tickets.put(ticketIdSequence,ticket);
        return ticket;
    }
}
