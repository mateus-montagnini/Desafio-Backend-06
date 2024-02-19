package br.com.mrocha.desafio6.tutoresModel;

public record DadosDetalheTutor(Long id, String nome, String email) {

    public DadosDetalheTutor(Tutores tutores) {
        this(tutores.getId(), tutores.getNome(), tutores.getEmail());
    }
}
