/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.dto;

import java.time.LocalDateTime;

public class PracticaDTO {

    private Long id;
    private LocalDateTime ultimaFecha;
    private Integer conteo;
    // + ID de las relaciones, como usuarioId y palabraFraseId
    // Otros campos...
    
    // Getters y setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getUltimaFecha() {
        return ultimaFecha;
    }

    public void setUltimaFecha(LocalDateTime ultimaFecha) {
        this.ultimaFecha = ultimaFecha;
    }

    public Integer getConteo() {
        return conteo;
    }

    public void setConteo(Integer conteo) {
        this.conteo = conteo;
    }

}
