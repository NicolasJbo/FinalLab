package com.utn.Final.LabV.service;

import com.utn.Final.LabV.model.Ticket;
import com.utn.Final.LabV.repository.TicketRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.UUID;

public class TicketService_Test {
    private TicketService ticketService;
    @Mock
    private TicketRepository ticketRepository;

    @Before
    public void setUp(TicketService ticketService,TicketRepository ticketRepository){
        this.ticketService=ticketService;
        this.ticketRepository= Mockito.mock(TicketRepository.class);
    }

@Test
    public void generateTicket_OK(){
        Ticket ticket = new Ticket(UUID.randomUUID(),30D);
        Mockito.when(ticketRepository.save(Mockito.any())).thenReturn(ticket);
        Ticket response=ticketService.generateTicket();
        Assert.assertEquals(ticket.getDiscount(),response.getDiscount());

    }

}
