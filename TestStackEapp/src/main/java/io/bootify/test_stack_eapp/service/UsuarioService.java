/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.service;

import io.bootify.test_stack_eapp.domain.Usuario;
import io.bootify.test_stack_eapp.dto.UsuarioDTO;
import io.bootify.test_stack_eapp.repos.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioDTO::new)
                .collect(Collectors.toList());
    }

    public Usuario save(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setContrasenha(usuarioDTO.getContrasenha());
        usuario.setApellido(usuarioDTO.getApellido());
        return usuarioRepository.save(usuario);
    }
}
