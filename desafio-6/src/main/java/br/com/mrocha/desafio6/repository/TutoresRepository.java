package br.com.mrocha.desafio6.repository;

import br.com.mrocha.desafio6.model.Tutores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutoresRepository extends JpaRepository<Tutores, Long> {
}
