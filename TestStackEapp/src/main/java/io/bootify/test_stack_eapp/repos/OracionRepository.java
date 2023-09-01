package io.bootify.test_stack_eapp.repos;

import io.bootify.test_stack_eapp.domain.Oracion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OracionRepository extends JpaRepository<Oracion, Long> {
}
