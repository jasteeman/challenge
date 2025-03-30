package com.empresa.domain.port.out;

import com.empresa.domain.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    @Query("SELECT e FROM Empresa e WHERE e.fechaAdhesion > :fechaLimite")
    List<Empresa> obtenerEmpresasAdheridasUltimoMes(@Param("fechaLimite") LocalDate fechaLimite);

    List<Empresa> findAll();

    @Query("SELECT e FROM Empresa e JOIN e.transferencias t WHERE t.fecha BETWEEN :startDate AND :endDate")
    List<Empresa> obtenerEmpresasConTransferenciasUltimoMes(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    Empresa save(Empresa empresa);
}
