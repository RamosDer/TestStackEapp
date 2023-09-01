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
import io.bootify.test_stack_eapp.repos.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import io.bootify.test_stack_eapp.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private final UsuarioService usuarioService;
    
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    @Autowired
    private UsuarioRepository usuarioRepository;

   // @GetMapping("/")
   // public List<Usuario> listarUsuarios() {
     //  return usuarioRepository.findAll();
       //return usuarioRepository.obtenerUsuariosOrdenadosPorNombre();
    //}

    @PostMapping("/")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuariosDTO = usuarios.stream()
                .map(usuarioService::convertToDTO)
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(usuariosDTO);
    }
    
    // Otros métodos para actualizar y eliminar usuarios
}
