/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.controller;

import io.bootify.test_stack_eapp.dto.OracionDTO;
import io.bootify.test_stack_eapp.domain.Oracion;
import io.bootify.test_stack_eapp.service.OracionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oraciones")
public class OracionController {

    @Autowired
    private OracionService oracionService;

    @GetMapping("/{id}")
    public ResponseEntity<OracionDTO> getOracion(@PathVariable Long id) {
        Oracion oracion = oracionService.getOracionById(id); // Necesitarás implementar el método getOracionById en OracionService
        if (oracion != null) {
            return ResponseEntity.ok(oracionService.convertToDTO(oracion));
        } else {
            return ResponseEntity.notFound().build(); // Si no se encuentra la oración
        }
    }

    @PostMapping
    public ResponseEntity<Oracion> createOracion(@RequestBody OracionDTO oracionDTO) {
        Oracion oracion = oracionService.convertToEntity(oracionDTO);
        oracion = oracionService.guardarOracion(oracion);
        return ResponseEntity.ok(oracion);
    }
    
    @GetMapping
    public ResponseEntity<List<OracionDTO>> getAllOraciones() {
        List<OracionDTO> oraciones = oracionService.obtenerTodas();
        return ResponseEntity.ok(oraciones);
    }


    // ... otros endpoints
}
