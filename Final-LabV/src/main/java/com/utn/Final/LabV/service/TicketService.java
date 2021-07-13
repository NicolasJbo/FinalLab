package com.utn.Final.LabV.service;

import com.utn.Final.LabV.Exception.NotFoundTicket;
import com.utn.Final.LabV.model.Ticket;
import com.utn.Final.LabV.repository.TicketRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketService {

     private TicketRepository ticketRepository;
    @Autowired
    public TicketService(TicketRepository ticketRepository) {

        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket() {
        Ticket ticket = new Ticket(UUID.randomUUID(),Math.random());
        return  ticketRepository.save(ticket);

    }

    public Ticket getTicketById(UUID id) {
     Ticket ticket = ticketRepository.findById(id).orElseThrow( );

         //Prueba
        // Ticket ticket = ticketRepository.findById(id).orElse(new Ticket(UUID.randomUUID(),-200D));

      return ticket;
    }

    public List<Ticket> getall() {

       List<Ticket>t= ticketRepository.findAll();
       return t;
    }
}
