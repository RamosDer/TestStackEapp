/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.controller;

import io.bootify.test_stack_eapp.domain.Categoria;
import io.bootify.test_stack_eapp.dto.CategoriaDTO;
import io.bootify.test_stack_eapp.repos.CategoriaRepository;
import io.bootify.test_stack_eapp.service.CategoriaService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    
    private final CategoriaService categoriaService;
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaController(CategoriaService categoriaService, CategoriaRepository categoriaRepository) {
        this.categoriaService = categoriaService;
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping("/")
    public ResponseEntity<CategoriaDTO> crearCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaService.convertToEntity(categoriaDTO);
        categoria = categoriaRepository.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.convertToDTO(categoria));
    }
    
    @GetMapping("/")
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        
        // Convertir a DTO si es necesario, dependiendo de si tienes una función de conversión
        List<CategoriaDTO> categoriasDTO = categorias.stream()
                .map(this::convertToDTO)  // Suponiendo que tienes un método 'convertToDTO'
                .collect(Collectors.toList());

        return ResponseEntity.ok(categoriasDTO);
    }

    private CategoriaDTO convertToDTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setDescripcion(categoria.getDescripcion());
        return categoriaDTO;
    }

    // Si necesitas otros métodos (listar, actualizar, borrar), añádelos aquí
}
