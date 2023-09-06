/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.service;

import io.bootify.test_stack_eapp.domain.Practica;
import io.bootify.test_stack_eapp.dto.PracticaDTO;
import io.bootify.test_stack_eapp.repos.PracticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PracticaService {

    @Autowired
    private PracticaRepository practicaRepository;

    public PracticaDTO guardarPractica(Practica practica) {
        Practica savedPractica = practicaRepository.save(practica);
        return convertToDTO(savedPractica);
    }

    public Optional<PracticaDTO> obtenerPorId(Long id) {
        return practicaRepository.findById(id).map(this::convertToDTO);
    }

    public List<PracticaDTO> obtenerTodas() {
        return practicaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private PracticaDTO convertToDTO(Practica practica) {
        PracticaDTO practicaDTO = new PracticaDTO();
        practicaDTO.setId(practica.getId());
        practicaDTO.setUltimaFecha(practica.getUltimaFecha());
        practicaDTO.setConteo(practica.getConteo());
        // ... set otros campos según se necesite.
        return practicaDTO;
    }

    // Si necesitas convertir de DTO a Entity, puedes agregar ese método aquí.
}
