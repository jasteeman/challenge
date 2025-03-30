package com.empresa.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

    private BigDecimal importe;
    private String cuentaDebito;
    private String cuentaCredito;
    private LocalDate fecha;

    // Constructores, getters y setters
    public Transferencia() {}

    public Transferencia(Empresa empresa, BigDecimal importe, String cuentaDebito, String cuentaCredito, LocalDate fecha) {
        this.empresa = empresa;
        this.importe = importe;
        this.cuentaDebito = cuentaDebito;
        this.cuentaCredito = cuentaCredito;
        this.fecha = fecha;
    }

    public Long getId() { return id; }
    public Empresa getEmpresa() { return empresa; }
    public BigDecimal getImporte() { return importe; }
    public String getCuentaDebito() { return cuentaDebito; }
    public String getCuentaCredito() { return cuentaCredito; }
    public LocalDate getFecha() { return fecha; }

    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }
    public void setImporte(BigDecimal importe) { this.importe = importe; }
    public void setCuentaDebito(String cuentaDebito) { this.cuentaDebito = cuentaDebito; }
    public void setCuentaCredito(String cuentaCredito) { this.cuentaCredito = cuentaCredito; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}
