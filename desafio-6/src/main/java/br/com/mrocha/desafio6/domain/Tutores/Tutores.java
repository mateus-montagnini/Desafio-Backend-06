package br.com.mrocha.desafio6.domain.Tutores;

import br.com.mrocha.desafio6.domain.Tutores.DadosAtualizacaoTutor;
import br.com.mrocha.desafio6.domain.Tutores.DadosCadastroTutor;
import br.com.mrocha.desafio6.domain.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "nome", "email"})
@Table(name = "tb_tutores")
public class Tutores extends Usuario {


    @Column(name = "nome")
    private String nome;


    public Tutores(DadosCadastroTutor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.login = dados.login();
        this.senha = dados.senha();
    }

    public void atualizarDados(DadosAtualizacaoTutor dados) {
        this.nome = dados.nome() != null ? dados.nome() : this.nome;
        this.email = dados.email() != null ? dados.email() : this.email;
    }
}
