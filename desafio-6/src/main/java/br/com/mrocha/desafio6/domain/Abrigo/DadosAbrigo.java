package br.com.mrocha.desafio6.domain.Abrigo;

public record DadosAbrigo(
        Long id,
        String nome,
        String email,
        String telefone) {

    public DadosAbrigo(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome(), abrigo.getEmail(), abrigo.getTelefone());
    }
}
