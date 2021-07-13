package com.utn.Servicio.B.repository;

import com.utn.Servicio.B.model.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface LoggerRepository extends JpaRepository <Logger, UUID> {
}
