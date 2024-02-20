package br.com.mrocha.desafio6.petsModel;

public record DadosCadastroPet(
        String nome,
        String descricao,
        Boolean adotado,
        String idade,
        String imagem,
        Long abrigoId
) {
}
