/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.service;

import io.bootify.test_stack_eapp.domain.Practica;
import io.bootify.test_stack_eapp.domain.Resumen;
import io.bootify.test_stack_eapp.dto.PracticaDTO;
import io.bootify.test_stack_eapp.dto.ResumenDTO;
import io.bootify.test_stack_eapp.repos.ResumenRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumenService {

    @Autowired
    private ResumenRepository resumenRepository;
    @Autowired
    private PracticaService practicaService;

    public List<Resumen> findAll() {
        return resumenRepository.findAll();
    }
    
    public Resumen save(ResumenDTO resumenDTO) {
        Resumen resumen = new Resumen();
        resumen.setTiempo(resumenDTO.getTiempo());
        resumen.setAciertos(resumenDTO.getAciertos());
        resumen.setPalabrasPracticadas(resumenDTO.getPalabrasPracticadas());

        // Aquí, deberías manejar cómo se asigna la entidad 'Practica' al Resumen.
        // Suponiendo que tienes un PracticaService, podrías hacer algo así:
        // Practica practica = practicaService.findById(resumenDTO.getPracticaId());
        // resumen.setPracticaId(practica);

        return resumenRepository.save(resumen);
    }
    public ResumenDTO obtenerPorId(Long id) {
        Optional<Resumen> resumenOptional = resumenRepository.findById(id);
        if (resumenOptional.isPresent()) {
            return new ResumenDTO(resumenOptional.get());
        }
        return null;
    }

    public Resumen convertToEntity(ResumenDTO resumenDTO) {
        Resumen resumen = new Resumen();

        resumen.setId(resumenDTO.getId());
        resumen.setTiempo(resumenDTO.getTiempo());
        resumen.setAciertos(resumenDTO.getAciertos());
        resumen.setPalabrasPracticadas(resumenDTO.getPalabrasPracticadas());
        
        // Usamos PracticaService para obtener una entidad Practica por su ID.
        Optional<PracticaDTO> practicaDTOOptional = practicaService.obtenerPorId(resumenDTO.getPracticaId());
        if (practicaDTOOptional.isPresent()) {
            Practica practica = new Practica();
            practica.setId(practicaDTOOptional.get().getId());
            // Aquí puedes asignar otros campos si es necesario
            resumen.setPracticaId(practica);
        } else {
             throw new EntityNotFoundException("No se encontró una práctica con el ID: " + resumenDTO.getPracticaId());
        }
        return resumen;
    }
}
