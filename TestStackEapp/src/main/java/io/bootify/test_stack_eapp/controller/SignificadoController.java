/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.controller;

import io.bootify.test_stack_eapp.domain.Significado;
import io.bootify.test_stack_eapp.dto.SignificadoDTO;
import io.bootify.test_stack_eapp.service.SignificadoService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/significados")
public class SignificadoController {

    @Autowired
    private SignificadoService significadoService;

    @GetMapping("/{id}")
    public ResponseEntity<SignificadoDTO> getSignificado(@PathVariable Long id) {
        SignificadoDTO significadoDTO = significadoService.obtenerPorId(id);
        if (significadoDTO != null) {
            return ResponseEntity.ok(significadoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<SignificadoDTO>> getAllSignificados() {
        List<SignificadoDTO> significados = significadoService.findAll()
                                            .stream()
                                            .map(SignificadoDTO::new)
                                            .collect(Collectors.toList());
        return ResponseEntity.ok(significados);
    }

    @PostMapping
    public ResponseEntity<SignificadoDTO> createSignificado(@RequestBody SignificadoDTO significadoDTO) {
        Significado significado = significadoService.convertToEntity(significadoDTO);
        Significado savedSignificado = significadoService.guardarSignificado(significado);
        return ResponseEntity.ok(new SignificadoDTO(savedSignificado));
}

}
