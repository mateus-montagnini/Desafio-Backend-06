package br.com.mrocha.desafio6.petsModel;

public record DadosPets(
        Long id,
        String nome,
        String descricao,
        Boolean adotado,
        String idade,
        String imagem
) {
    public DadosPets(Pets pet) {
        this(pet.getId(), pet.getNome(), pet.getDescricao(), pet.getAdotado(), pet.getIdade(), pet.getImagem());
    }
}
