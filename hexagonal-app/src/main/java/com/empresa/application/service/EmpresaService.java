package com.empresa.application.service;

import com.empresa.domain.model.Empresa;
import com.empresa.domain.model.Transferencia;
import com.empresa.domain.port.in.ObtenerEmpresasAdheridas;
import com.empresa.domain.port.in.ObtenerEmpresasConTransferencias;
import com.empresa.domain.port.in.RegistrarEmpresa;
import com.empresa.domain.port.out.EmpresaRepository;
import com.empresa.domain.port.out.TransferenciaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpresaService implements ObtenerEmpresasAdheridas, ObtenerEmpresasConTransferencias, RegistrarEmpresa {

    private final EmpresaRepository empresaRepository;
    private final TransferenciaRepository transferenciaRepository;

    public EmpresaService(EmpresaRepository empresaRepository, TransferenciaRepository transferenciaRepository) {
        this.empresaRepository = empresaRepository;
        this.transferenciaRepository = transferenciaRepository;
    }

    // 1. Empresas que hicieron transferencias el último mes
    @Override
    public List<Empresa> obtenerEmpresasConTransferencias() {
        LocalDate inicioMesPasado = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        LocalDate finMesPasado = inicioMesPasado.withDayOfMonth(inicioMesPasado.lengthOfMonth());
        System.out.println(inicioMesPasado);
        System.out.println(finMesPasado);
        return empresaRepository.obtenerEmpresasConTransferenciasUltimoMes(inicioMesPasado, finMesPasado);
    }

    // 2. Empresas que se adhirieron el último mes
    @Override
    public List<Empresa> obtenerEmpresasAdheridas() {
        LocalDate haceUnMes = LocalDate.now().minusMonths(1);
        return empresaRepository.obtenerEmpresasAdheridasUltimoMes(haceUnMes);
    }

    // 3. Registrar una empresa
    @Override
    public void registrar(Empresa empresa) {
        empresaRepository.save(empresa);
    }

    // 4. Nueva transferencia
    public void registrarTransferencia(Long empresaId, Transferencia transf) {
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new IllegalArgumentException("Empresa no encontrada con ID: " + empresaId));

        // Crear la transferencia con la empresa asociada
        Transferencia transferencia = new Transferencia();
        transferencia.setEmpresa(empresa);
        transferencia.setCuentaCredito(transf.getCuentaCredito());
        transferencia.setCuentaDebito(transf.getCuentaDebito());
        transferencia.setImporte(transf.getImporte());
        transferencia.setFecha(LocalDate.now());

        // Guardar la transferencia
        transferenciaRepository.save(transferencia);
    }

}
