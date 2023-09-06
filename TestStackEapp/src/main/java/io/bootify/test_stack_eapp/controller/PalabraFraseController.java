/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.controller;

import io.bootify.test_stack_eapp.domain.PalabraFrase;
import io.bootify.test_stack_eapp.dto.PalabraFraseDTO;
import io.bootify.test_stack_eapp.service.PalabraFraseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/palabrasfrases")
public class PalabraFraseController {

    private final PalabraFraseService palabraFraseService;

    public PalabraFraseController(PalabraFraseService palabraFraseService) {
        this.palabraFraseService = palabraFraseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PalabraFraseDTO> getPalabraFrase(@PathVariable Long id) {
        PalabraFraseDTO palabraFraseDTO = palabraFraseService.obtenerPorId(id);
        if (palabraFraseDTO != null) {
            return ResponseEntity.ok(palabraFraseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping
        public ResponseEntity<List<PalabraFraseDTO>> getAllPalabrasFrases() {
        List<PalabraFraseDTO> listaPalabrasFrases = palabraFraseService.obtenerTodos();
        return ResponseEntity.ok(listaPalabrasFrases);
    }


    @PostMapping
    public ResponseEntity<PalabraFraseDTO> createPalabraFrase(@RequestBody PalabraFraseDTO palabraFraseDTO) {
        PalabraFrase savedPalabraFrase = palabraFraseService.guardarPalabraFrase(palabraFraseService.convertToEntity(palabraFraseDTO));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPalabraFrase.getId()).toUri();
        
        // Convertir el objeto guardado a DTO para la respuesta
        PalabraFraseDTO savedDTO = palabraFraseService.convertToDTO(savedPalabraFrase);
        return ResponseEntity.created(location).body(savedDTO);
    }
}
