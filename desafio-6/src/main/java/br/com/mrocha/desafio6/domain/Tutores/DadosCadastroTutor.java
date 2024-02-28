package br.com.mrocha.desafio6.domain.Tutores;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTutor(
        @NotBlank String nome,
        @NotBlank String login,
        @NotBlank @Email String email,
        @NotBlank String senha,
        @NotBlank String confirmacaoSenha) {

}
