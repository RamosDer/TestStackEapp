/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.bootify.test_stack_eapp.service;

import io.bootify.test_stack_eapp.domain.PalabraFrase;
import io.bootify.test_stack_eapp.domain.Significado;
import io.bootify.test_stack_eapp.dto.PalabraFraseDTO;
import io.bootify.test_stack_eapp.dto.SignificadoDTO;
import io.bootify.test_stack_eapp.repos.SignificadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignificadoService {

    @Autowired
    private SignificadoRepository significadoRepository;
    @Autowired
    private PalabraFraseService palabraFraseService;

    public SignificadoDTO obtenerPorId(Long id) {
        Optional<Significado> significado = significadoRepository.findById(id);
        if (significado.isPresent()) {
            // Aquí deberías convertir tu entidad Significado a SignificadoDTO.
            // Puedes usar ModelMapper, Dozer o simplemente un constructor/custom method.
            return convertToDto(significado.get());
        } else {
            return null;
        }
    }
    
    public List<Significado> findAll() {
        return significadoRepository.findAll();
    }

    public Significado guardarSignificado(Significado significado) {
        return significadoRepository.save(significado);
    }

    private SignificadoDTO convertToDto(Significado significado) {
        // Suponiendo que tienes un constructor o un método en SignificadoDTO que acepta un objeto Significado.
        return new SignificadoDTO(significado);
    }
    
     public Significado convertToEntity(SignificadoDTO significadoDTO) {
        Significado significado = new Significado();
        significado.setId(significadoDTO.getId());
        significado.setDescripcion(significadoDTO.getDescripcion());
        significado.setFechaRegistro(significadoDTO.getFechaRegistro());
        if (significadoDTO.getPalabraFraseId() != null) {
            PalabraFraseDTO palabraFraseDTO = palabraFraseService.obtenerPorId(significadoDTO.getPalabraFraseId());
            PalabraFrase palabraFrase = palabraFraseService.convertToEntity(palabraFraseDTO);
            significado.setPalabraFraseId(palabraFrase);
        }
        // Establece los otros atributos de significado a partir de significadoDTO aquí...
        return significado;
    }
}
