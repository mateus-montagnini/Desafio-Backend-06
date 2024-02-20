package br.com.mrocha.desafio6.domain.Tutores;

public record DadosDetalheTutor(Long id, String nome, String email) {

    public DadosDetalheTutor(Tutores tutores) {
        this(tutores.getId(), tutores.getNome(), tutores.getEmail());
    }
}
