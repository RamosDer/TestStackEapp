/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.dto;

import io.bootify.test_stack_eapp.domain.Significado;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class SignificadoDTO {

    private Long id;
    private String descripcion;
    private LocalDateTime fechaRegistro;
    private Long palabraFraseId; // Sólo almacenamos el ID de la palabra o frase relacionada para simplificar.
    private OffsetDateTime dateCreated;
    private OffsetDateTime lastUpdated;

    public SignificadoDTO() {
    }

    // Constructor que convierte de entidad a DTO
    public SignificadoDTO(Significado significado) {
        this.id = significado.getId();
        this.descripcion = significado.getDescripcion();
        this.fechaRegistro = significado.getFechaRegistro();
        this.palabraFraseId = significado.getPalabraFraseId() != null ? significado.getPalabraFraseId().getId() : null;
        this.dateCreated = significado.getDateCreated();
        this.lastUpdated = significado.getLastUpdated();
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Long getPalabraFraseId() {
        return palabraFraseId;
    }

    public void setPalabraFraseId(Long palabraFraseId) {
        this.palabraFraseId = palabraFraseId;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
