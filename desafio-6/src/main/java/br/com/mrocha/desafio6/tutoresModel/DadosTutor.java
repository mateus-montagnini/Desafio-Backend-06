package br.com.mrocha.desafio6.tutoresModel;

public record DadosTutor(Long id, String nome) {

    public DadosTutor(Tutores tutores) {
        this(tutores.getId(), tutores.getNome());
    }
}
