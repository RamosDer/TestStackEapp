package io.bootify.test_stack_eapp.repos;

import io.bootify.test_stack_eapp.domain.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TipoRepository extends JpaRepository<Tipo, Long> {
}
