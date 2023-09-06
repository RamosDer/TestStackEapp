/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.controller;

/**
 *
 * @author Derlis Ramos
 */
import io.bootify.test_stack_eapp.domain.Usuario;
import io.bootify.test_stack_eapp.dto.UsuarioDTO;
import io.bootify.test_stack_eapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario savedUsuario = usuarioService.save(usuarioDTO);
        return ResponseEntity.ok(savedUsuario);
    }
}