package com.utn.Servicio.B.service;

import com.utn.Servicio.B.repository.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {

    private LoggerRepository loggerRepository;
    @Autowired
    public LoggerService(LoggerRepository loggerRepository) {
        this.loggerRepository = loggerRepository;
    }
}
