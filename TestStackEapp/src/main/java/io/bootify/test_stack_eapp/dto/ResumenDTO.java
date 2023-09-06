/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.dto;

import io.bootify.test_stack_eapp.domain.Resumen;
import java.time.LocalTime;
import java.time.OffsetDateTime;

public class ResumenDTO {

    private Long id;
    private LocalTime tiempo;
    private Integer aciertos;
    private Integer palabrasPracticadas;
    private Long practicaId;
    private OffsetDateTime dateCreated;
    private OffsetDateTime lastUpdated;

    public ResumenDTO() {}

    public ResumenDTO(Resumen resumen) {
        this.id = resumen.getId();
        this.tiempo = resumen.getTiempo();
        this.aciertos = resumen.getAciertos();
        this.palabrasPracticadas = resumen.getPalabrasPracticadas();
        this.practicaId = resumen.getPracticaId().getId();
        this.dateCreated = resumen.getDateCreated();
        this.lastUpdated = resumen.getLastUpdated();
    }

    // Getter y setter methods...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getTiempo() {
        return tiempo;
    }

    public void setTiempo(LocalTime tiempo) {
        this.tiempo = tiempo;
    }

    public Integer getAciertos() {
        return aciertos;
    }

    public void setAciertos(Integer aciertos) {
        this.aciertos = aciertos;
    }

    public Integer getPalabrasPracticadas() {
        return palabrasPracticadas;
    }

    public void setPalabrasPracticadas(Integer palabrasPracticadas) {
        this.palabrasPracticadas = palabrasPracticadas;
    }

    public Long getPracticaId() {
        return practicaId;
    }

    public void setPracticaId(Long practicaId) {
        this.practicaId = practicaId;
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
