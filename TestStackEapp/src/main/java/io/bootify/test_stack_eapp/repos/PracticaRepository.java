package io.bootify.test_stack_eapp.repos;

import io.bootify.test_stack_eapp.domain.Practica;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PracticaRepository extends JpaRepository<Practica, Long> {
}
