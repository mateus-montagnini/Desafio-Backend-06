package br.com.mrocha.desafio6.domain.Abrigo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAbrigo(
        @NotNull String nome,
        @NotBlank String login,
        @NotBlank String senha,
        @NotNull @Email String email,
        @NotNull String telefone
) {
}
