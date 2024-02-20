package br.com.mrocha.desafio6.petsModel;

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
