package br.com.mrocha.desafio6.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTutor(
        @NotNull Long id,
        String nome,
        @Email String email,
        String senha,
        String confirmacaoSenha) {
}
