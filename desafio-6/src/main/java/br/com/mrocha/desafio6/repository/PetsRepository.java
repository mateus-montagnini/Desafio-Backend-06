package br.com.mrocha.desafio6.repository;

import br.com.mrocha.desafio6.petsModel.Pets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetsRepository extends JpaRepository<Pets, Long> {
}
