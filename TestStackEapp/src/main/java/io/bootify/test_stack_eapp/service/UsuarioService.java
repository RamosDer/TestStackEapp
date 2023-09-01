/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.service;

import io.bootify.test_stack_eapp.domain.Usuario;
import io.bootify.test_stack_eapp.dto.UsuarioDTO;
import org.springframework.stereotype.Service;

/**
 *
 * @author Derlis Ramos
 */
@Service
public class UsuarioService {
    
    public UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setApellido(usuario.getApellido());
        usuarioDTO.getNombreUsuario(usuario.getNombreUsuario());
        // Configura otros atributos
        
        return usuarioDTO;
    }
}
