/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.dto;

import io.bootify.test_stack_eapp.domain.Tipo;

public class TipoDTO {

    private Long id;
    private String descripcion;
    private String codIpo;
    private Long categoriaId; // Solo usaremos el ID aquí
    
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

    public String getCodIpo() {
        return codIpo;
    }

    public void setCodIpo(String codIpo) {
        this.codIpo = codIpo;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    // Constructores, getters, setters...
    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public TipoDTO() {
    }

    public TipoDTO(Tipo tipo) {
        this.id = tipo.getId();
        this.descripcion = tipo.getDescripcion();
        this.codIpo = tipo.getCodIpo();
        if (tipo.getCategoriaId() != null) {
            this.categoriaId = tipo.getCategoriaId().getId();
        }
    }

    // ...resto de los getters y setters...
    
}
