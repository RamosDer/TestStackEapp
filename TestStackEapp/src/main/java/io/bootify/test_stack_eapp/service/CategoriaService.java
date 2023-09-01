/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.service;

/**
 *
 * @author Derlis Ramos
 */

import io.bootify.test_stack_eapp.domain.Categoria;
import io.bootify.test_stack_eapp.dto.CategoriaDTO;
import io.bootify.test_stack_eapp.repos.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    public CategoriaDTO convertToDTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setDescripcion(categoria.getDescripcion());
        // Si hay más campos, añádelos aquí
        
        return categoriaDTO;
    }
    
    public Categoria convertToEntity(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setDescripcion(categoriaDTO.getDescripcion());
        // Si hay más campos, añádelos aquí
        
        return categoria;
    }
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
