package br.com.mrocha.desafio6.repository;

import br.com.mrocha.desafio6.abrigoModel.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbrigosRepository extends JpaRepository<Abrigo, Long> {
}
