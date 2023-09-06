/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.controller;

import io.bootify.test_stack_eapp.domain.Practica;
import io.bootify.test_stack_eapp.dto.PracticaDTO;
import io.bootify.test_stack_eapp.service.PracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practicas")
public class PracticaController {

    @Autowired
    private PracticaService practicaService;

    @GetMapping("/{id}")
    public ResponseEntity<PracticaDTO> getPractica(@PathVariable Long id) {
        return practicaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PracticaDTO>> getAllPracticas() {
        return ResponseEntity.ok(practicaService.obtenerTodas());
    }

    @PostMapping
    public ResponseEntity<PracticaDTO> createPractica(@RequestBody PracticaDTO practicaDTO) {
        Practica practica = null;
        // Aquí necesitas convertir el DTO a una entidad, si es necesario.
        // Practica practica = convertToEntity(practicaDTO);
        PracticaDTO savedPractica = practicaService.guardarPractica(practica);
        return ResponseEntity.ok(savedPractica);
    }
}
