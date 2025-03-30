package com.empresa.domain.port.out;

import com.empresa.domain.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query("SELECT t FROM Transferencia t WHERE t.fecha BETWEEN :startDate AND :endDate")
    List<Transferencia> obtenerTransferenciasUltimoMes(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}