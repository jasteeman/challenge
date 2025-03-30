package com.empresa.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Esto genera el ID automáticamente
    private Long id;  // El campo ID

    private String cuit;
    private String razonSocial;
    private LocalDate fechaAdhesion;

    @OneToMany(mappedBy = "empresa")
    @JsonManagedReference
    private List<Transferencia> transferencias;

    // Constructor
    public Empresa() {}

    public Empresa(String cuit, String razonSocial, LocalDate fechaAdhesion) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.fechaAdhesion = fechaAdhesion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public LocalDate getFechaAdhesion() {
        return fechaAdhesion;
    }

    public void setFechaAdhesion(LocalDate fechaAdhesion) {
        this.fechaAdhesion = fechaAdhesion;
    }

    public List<Transferencia> getTransferencias() {
        return transferencias;
    }

    public void setTransferencias(List<Transferencia> transferencias) {
        this.transferencias = transferencias;
    }
}
