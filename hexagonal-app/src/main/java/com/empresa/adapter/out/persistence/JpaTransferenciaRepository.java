package com.empresa.adapter.out.persistence;

import com.empresa.domain.model.Transferencia;
import com.empresa.domain.port.out.TransferenciaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTransferenciaRepository extends JpaRepository<Transferencia, Long>, TransferenciaRepository {
    // Métodos específicos de la implementación
}
