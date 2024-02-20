package br.com.mrocha.desafio6.domain.Adocao;

import java.time.LocalDate;

public record DadosAdocao(Long id, LocalDate data, String nomeTutor, String nomePet) {
    public DadosAdocao(Adocao adocao) {
        this(adocao.getId(), adocao.getData(), adocao.getTutor().getNome(), adocao.getPet().getNome());
    }
}
