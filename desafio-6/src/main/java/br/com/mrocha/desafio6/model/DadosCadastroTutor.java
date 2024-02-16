package br.com.mrocha.desafio6.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTutor(
        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank String senha,
        @NotBlank String confirmacaoSenha) {
}
