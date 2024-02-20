package br.com.mrocha.desafio6.repository;

import br.com.mrocha.desafio6.domain.Adocao.Adocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {
}
