package br.com.mrocha.desafio6.abrigoModel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAbrigo(
        @NotNull String nome,
        @NotNull @Email String email,
        @NotNull String telefone
) {
}
