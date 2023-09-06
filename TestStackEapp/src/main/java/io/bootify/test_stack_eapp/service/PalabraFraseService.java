/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.service;

import io.bootify.test_stack_eapp.domain.PalabraFrase;
import io.bootify.test_stack_eapp.dto.PalabraFraseDTO;
import io.bootify.test_stack_eapp.repos.PalabraFraseRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PalabraFraseService {

    private final PalabraFraseRepository palabraFraseRepository;

    public PalabraFraseService(PalabraFraseRepository palabraFraseRepository) {
        this.palabraFraseRepository = palabraFraseRepository;
    }

    public PalabraFraseDTO convertToDTO(PalabraFrase palabraFrase) {
        PalabraFraseDTO palabraFraseDTO = new PalabraFraseDTO();
        palabraFraseDTO.setId(palabraFrase.getId());
        palabraFraseDTO.setContenido(palabraFrase.getContenido());
        palabraFraseDTO.setDificultad(palabraFrase.getDificultad());
        palabraFraseDTO.setAprendido(palabraFrase.getAprendido());
        palabraFraseDTO.setFechaRegistro(palabraFrase.getFechaRegistro());
        
        if (palabraFrase.getUsuarioId() != null) {
            palabraFraseDTO.setUsuarioId(palabraFrase.getUsuarioId().getId());
        }
        
        if (palabraFrase.getTipoId() != null) {
            palabraFraseDTO.setTipoId(palabraFrase.getTipoId().getId());
        }

        return palabraFraseDTO;
    }

    public PalabraFrase convertToEntity(PalabraFraseDTO palabraFraseDTO) {
        PalabraFrase palabraFrase = new PalabraFrase();
        palabraFrase.setContenido(palabraFraseDTO.getContenido());
        palabraFrase.setDificultad(palabraFraseDTO.getDificultad());
        palabraFrase.setAprendido(palabraFraseDTO.getAprendido());
        palabraFrase.setFechaRegistro(palabraFraseDTO.getFechaRegistro());
        
        // NOTA: Para mapear completamente las relaciones como Usuario y Tipo a partir de sus IDs, necesitarías más lógica aquí o usar algún servicio/repositorio para recuperar las entidades completas a partir de los IDs.

        return palabraFrase;
    }

    public PalabraFrase guardarPalabraFrase(PalabraFrase palabraFrase) {
        return palabraFraseRepository.save(palabraFrase);
    }

    public PalabraFraseDTO obtenerPorId(Long id) {
        return palabraFraseRepository.findById(id)
            .map(this::convertToDTO)
            .orElseThrow(() -> new ResourceNotFoundException("PalabraFrase no encontrado con ID: " + id));
    }

    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
    
    // Obtener todas las palabras frases
    public List<PalabraFraseDTO> obtenerTodos() {
    List<PalabraFrase> palabrasFrases = palabraFraseRepository.findAll();
    return palabrasFrases.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
}
