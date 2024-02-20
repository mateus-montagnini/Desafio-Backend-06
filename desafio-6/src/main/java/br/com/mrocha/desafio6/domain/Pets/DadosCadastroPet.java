package br.com.mrocha.desafio6.domain.Pets;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroPet(
        @NotNull String nome,
        @NotNull String descricao,
        Boolean adotado,
        @NotNull String idade,
        @NotNull String imagem,
        @NotNull Long abrigoId
) {
}
