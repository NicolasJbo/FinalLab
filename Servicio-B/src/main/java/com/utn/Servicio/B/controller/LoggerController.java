package com.utn.Servicio.B.controller;

import com.utn.Servicio.B.model.Logger;
import com.utn.Servicio.B.model.Ticket;
import com.utn.Servicio.B.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/logger")
public class LoggerController {
    private LoggerService loggerService;
    @Autowired
    public LoggerController(LoggerService loggerService) {
        this.loggerService = loggerService;
    }
    @PostMapping
    public Logger checkTicket(){
        //Hace el llamado al servicio A GetById , pero no me acuerdo como hacer para que le pegue al ENDPOINT.
        Ticket ticket=new Ticket(UUID.randomUUID(),Math.random());

        Logger logger = new Logger();
        logger.setTicketNumber(ticket.getTicketNumber());
        logger.setDiscount(ticket.getDiscount());
        logger.setDate(LocalDateTime.now());

        return logger;
    }

}
