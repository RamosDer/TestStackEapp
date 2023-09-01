package io.bootify.test_stack_eapp.repos;

import io.bootify.test_stack_eapp.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
