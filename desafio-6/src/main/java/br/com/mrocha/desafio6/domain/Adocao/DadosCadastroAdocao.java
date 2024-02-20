package br.com.mrocha.desafio6.domain.Adocao;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroAdocao(
        @NotNull Long petId,
        @NotNull Long tutorId,
        @NotNull LocalDate data) {
}
