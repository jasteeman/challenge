package com.empresa.adapter.out.persistence;

import com.empresa.domain.model.Empresa;
import com.empresa.domain.port.out.EmpresaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEmpresaRepository extends JpaRepository<Empresa, Long>, EmpresaRepository {
    // Métodos específicos de la implementación
}