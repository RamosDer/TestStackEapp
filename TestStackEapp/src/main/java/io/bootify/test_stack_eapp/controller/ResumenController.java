/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.controller;

import io.bootify.test_stack_eapp.domain.Resumen;
import io.bootify.test_stack_eapp.dto.ResumenDTO;
import io.bootify.test_stack_eapp.service.ResumenService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resumenes")
public class ResumenController {

    @Autowired
    private ResumenService resumenService;

    @GetMapping("/{id}")
    public ResponseEntity<ResumenDTO> getResumen(@PathVariable Long id) {
        ResumenDTO resumenDTO = resumenService.obtenerPorId(id);
        if (resumenDTO != null) {
            return ResponseEntity.ok(resumenDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<ResumenDTO>> getAllResumenes() {
        List<ResumenDTO> resumenes = resumenService.findAll()
                                            .stream()
                                            .map(ResumenDTO::new)
                                            .collect(Collectors.toList());
        return ResponseEntity.ok(resumenes);
    }

    @PostMapping
    public ResponseEntity<Resumen> createResumen(@RequestBody ResumenDTO resumenDTO) {
        Resumen savedResumen = resumenService.save(resumenDTO);
        return ResponseEntity.ok(savedResumen);
    }
}
