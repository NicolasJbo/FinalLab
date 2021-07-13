package com.utn.Final.LabV.controller;

import com.utn.Final.LabV.model.Ticket;
import com.utn.Final.LabV.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ticket")
public class TicketController {

   private TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity generateTicket(){
          Ticket ticket= ticketService.generateTicket();

          return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
    }

    @GetMapping
    public ResponseEntity getAll(){
        List<Ticket> list= ticketService.getall();
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTicketById(@RequestParam UUID id){
        Ticket ticket = ticketService.getTicketById(id);
        /*
        if(ticket.getDiscount() == -200){
            System.out.println(ticket);
        }*/
            return ResponseEntity.status(HttpStatus.OK).body(ticket);


    }

}
