package com.utn.Final.LabV.ControllerTest;

import com.utn.Final.LabV.controller.TicketController;
import com.utn.Final.LabV.model.Ticket;
import com.utn.Final.LabV.service.TicketService;
import org.junit.Assert;
import org.junit.Before;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;


public class TicketController_Test {

   private TicketController ticketController;
    @Mock
    private TicketService ticketService;

    @Before
    public void setup(TicketService ticketService,TicketController ticketController){
        this.ticketController=ticketController;
        this.ticketService=Mockito.mock(TicketService.class);

    }
@Test
    public void generateTicket_OK(){
        Ticket ticket= new Ticket(UUID.randomUUID(),20D);
        Mockito.when(ticketService.generateTicket()).thenReturn(ticket);
        ResponseEntity response=ticketController.generateTicket();
        Assert.assertEquals(HttpStatus.CREATED,response.getStatusCode());


    }

}
