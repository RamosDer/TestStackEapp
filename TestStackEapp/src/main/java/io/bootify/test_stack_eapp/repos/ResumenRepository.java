package io.bootify.test_stack_eapp.repos;

import io.bootify.test_stack_eapp.domain.Resumen;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ResumenRepository extends JpaRepository<Resumen, Long> {
}
