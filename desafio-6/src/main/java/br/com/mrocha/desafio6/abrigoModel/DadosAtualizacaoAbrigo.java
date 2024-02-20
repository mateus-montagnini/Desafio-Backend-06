package br.com.mrocha.desafio6.abrigoModel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAbrigo(
        @NotNull Long id,
        String nome,
        @Email String email,
        String telefone
) {
}
