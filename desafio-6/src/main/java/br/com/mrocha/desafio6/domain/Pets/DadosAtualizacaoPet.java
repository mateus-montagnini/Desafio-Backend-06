package br.com.mrocha.desafio6.domain.Pets;

public record DadosAtualizacaoPet(
        Long id,
        String nome,
        String descricao,
        Boolean adotado,
        String idade,
        String imagem,
        Long abrigoId
) {
}
