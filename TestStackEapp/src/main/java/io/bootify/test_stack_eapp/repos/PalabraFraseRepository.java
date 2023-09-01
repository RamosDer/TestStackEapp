package io.bootify.test_stack_eapp.repos;

import io.bootify.test_stack_eapp.domain.PalabraFrase;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PalabraFraseRepository extends JpaRepository<PalabraFrase, Long> {
}
