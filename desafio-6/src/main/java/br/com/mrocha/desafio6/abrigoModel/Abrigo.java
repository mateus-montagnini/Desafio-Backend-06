package br.com.mrocha.desafio6.abrigoModel;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "nome", "email"})
@Table(name = "tb_abrigos")
public class Abrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    public Abrigo(DadosCadastroAbrigo abrigo) {
        this.nome = abrigo.nome();
        this.email = abrigo.email();
        this.telefone = abrigo.telefone();
    }

    public void atualizarDados(DadosAtualizacaoAbrigo abrigo) {
        this.nome = abrigo.nome() != null ? abrigo.nome() : this.nome;
        this.email = abrigo.email() != null ? abrigo.email() : this.email;
        this.telefone = abrigo.telefone() != null ? abrigo.telefone() : this.telefone;
    }
}
