package io.bootify.test_stack_eapp.service;

import io.bootify.test_stack_eapp.domain.Oracion;
import io.bootify.test_stack_eapp.dto.OracionDTO;
import io.bootify.test_stack_eapp.repos.OracionRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OracionService {

    @Autowired
    private OracionRepository oracionRepository;

    public OracionDTO convertToDTO(Oracion oracion) {
        OracionDTO oracionDTO = new OracionDTO();
        oracionDTO.setId(oracion.getId());
        oracionDTO.setTexto(oracion.getTexto());
        if (oracion.getPalabraFraseId() != null) {
            oracionDTO.setPalabraFraseId(oracion.getPalabraFraseId().getId());
        }
        return oracionDTO;
    }

    public Oracion convertToEntity(OracionDTO oracionDTO) {
        Oracion oracion = new Oracion();
        oracion.setTexto(oracionDTO.getTexto());
        // Puede que necesites establecer PalabraFrase aquí si es relevante para tus operaciones
        return oracion;
    }

    public Oracion guardarOracion(Oracion oracion) {
        return oracionRepository.save(oracion);
    }
    public Oracion getOracionById(Long id) {
    return oracionRepository.findById(id).orElse(null);
    }
    
    public List<OracionDTO> obtenerTodas() {
    List<Oracion> oraciones = oracionRepository.findAll();
    return oraciones.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
}
