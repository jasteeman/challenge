package com.empresa.adapter.in.web;

import com.empresa.domain.model.Empresa;
import com.empresa.application.service.EmpresaService;
import com.empresa.domain.model.Transferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/transferencias")
    public List<Empresa> obtenerEmpresasConTransferencias() {
        return empresaService.obtenerEmpresasConTransferencias();
    }

    @GetMapping("/adheridas")
    public List<Empresa> obtenerEmpresasAdheridas() {
        return empresaService.obtenerEmpresasAdheridas();
    }

    @PostMapping("/registrar")
    public void registrarEmpresa(@RequestBody Empresa empresa) {
        empresaService.registrar(empresa);
    }

    @PostMapping("/{empresaId}/registrar-transferencias")
    public void registrarTransferencia(@PathVariable Long empresaId, @RequestBody Transferencia transferencia) {
        empresaService.registrarTransferencia(empresaId, transferencia);
    }
}
