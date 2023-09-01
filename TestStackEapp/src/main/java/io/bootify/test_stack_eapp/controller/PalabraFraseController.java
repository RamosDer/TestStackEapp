/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.controller;

import io.bootify.test_stack_eapp.domain.PalabraFrase;
import io.bootify.test_stack_eapp.dto.PalabraFraseDTO;
import io.bootify.test_stack_eapp.service.PalabraFraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/palabrasfrases")
public class PalabraFraseController {

    @Autowired
    private PalabraFraseService palabraFraseService;

    @GetMapping("/{id}")
    public ResponseEntity<PalabraFraseDTO> getPalabraFrase(@PathVariable Long id) {
        PalabraFraseDTO palabraFraseDTO = palabraFraseService.obtenerPorId(id);
        if (palabraFraseDTO != null) {
            return ResponseEntity.ok(palabraFraseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PalabraFrase> createPalabraFrase(@RequestBody PalabraFraseDTO palabraFraseDTO) {
        PalabraFrase savedPalabraFrase = palabraFraseService.guardarPalabraFrase(palabraFraseService.convertToEntity(palabraFraseDTO));
        return ResponseEntity.ok(savedPalabraFrase);
    }
}
