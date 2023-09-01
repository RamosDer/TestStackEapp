/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.service;

import io.bootify.test_stack_eapp.domain.PalabraFrase;
import io.bootify.test_stack_eapp.dto.PalabraFraseDTO;
import io.bootify.test_stack_eapp.repos.PalabraFraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PalabraFraseService {

    @Autowired
    private PalabraFraseRepository palabraFraseRepository;

    public PalabraFraseDTO convertToDTO(PalabraFrase palabraFrase) {
        PalabraFraseDTO palabraFraseDTO = new PalabraFraseDTO();
        palabraFraseDTO.setId(palabraFrase.getId());
        palabraFraseDTO.setContenido(palabraFrase.getContenido());
        palabraFraseDTO.setDificultad(palabraFrase.getDificultad());
        palabraFraseDTO.setAprendido(palabraFrase.getAprendido());
        palabraFraseDTO.setFechaRegistro(palabraFrase.getFechaRegistro());
        // Otros campos pueden ser mapeados aquí según lo requieras

        return palabraFraseDTO;
    }

    public PalabraFrase convertToEntity(PalabraFraseDTO palabraFraseDTO) {
        PalabraFrase palabraFrase = new PalabraFrase();
        palabraFrase.setContenido(palabraFraseDTO.getContenido());
        palabraFrase.setDificultad(palabraFraseDTO.getDificultad());
        palabraFrase.setAprendido(palabraFraseDTO.getAprendido());
        palabraFrase.setFechaRegistro(palabraFraseDTO.getFechaRegistro());
        // Otros campos pueden ser mapeados aquí según lo requieras

        return palabraFrase;
    }

    public PalabraFrase guardarPalabraFrase(PalabraFrase palabraFrase) {
        return palabraFraseRepository.save(palabraFrase);
    }

    public PalabraFraseDTO obtenerPorId(Long id) {
        return convertToDTO(palabraFraseRepository.findById(id).orElse(null));
    }
}
