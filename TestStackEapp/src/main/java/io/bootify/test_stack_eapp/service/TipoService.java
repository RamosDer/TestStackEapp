/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.service;

import io.bootify.test_stack_eapp.domain.Tipo;
import io.bootify.test_stack_eapp.dto.TipoDTO;
import io.bootify.test_stack_eapp.repos.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    public List<TipoDTO> findAll() {
        return tipoRepository.findAll().stream()
                .map(TipoDTO::new)
                .collect(Collectors.toList());
    }

    public Tipo save(TipoDTO tipoDTO) {
        Tipo tipo = new Tipo();
        tipo.setDescripcion(tipoDTO.getDescripcion());
        tipo.setCodIpo(tipoDTO.getCodIpo());
        // Aquí necesitas convertir el ID de Categoria a una entidad de Categoria. Podrías usar un servicio para Categoria.
        return tipoRepository.save(tipo);
    }
}
