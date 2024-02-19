package br.com.mrocha.desafio6.tutoresModel;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "nome", "email"})
@Table(name = "tb_tutores")
public class Tutores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    public Tutores(DadosCadastroTutor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
    }

    public void atualizarDados(DadosAtualizacaoTutor dados) {
        this.nome = dados.nome() != null ? dados.nome() : this.nome;
        this.email = dados.email() != null ? dados.email() : this.email;
        this.senha = dados.senha() != null ? dados.senha() : this.senha;
    }
}
