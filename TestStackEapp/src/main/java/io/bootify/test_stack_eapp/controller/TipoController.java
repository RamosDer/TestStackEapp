/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.controller;

import io.bootify.test_stack_eapp.domain.Tipo;
import io.bootify.test_stack_eapp.dto.TipoDTO;
import io.bootify.test_stack_eapp.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @GetMapping
    public ResponseEntity<List<TipoDTO>> getAllTipos() {
        List<TipoDTO> tipos = tipoService.findAll();
        return ResponseEntity.ok(tipos);
    }

    @PostMapping
    public ResponseEntity<Tipo> createTipo(@RequestBody TipoDTO tipoDTO) {
        Tipo savedTipo = tipoService.save(tipoDTO);
        return ResponseEntity.ok(savedTipo);
    }
}
