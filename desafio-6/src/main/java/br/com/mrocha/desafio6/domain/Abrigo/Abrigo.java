package br.com.mrocha.desafio6.domain.Abrigo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "nome", "email", "telefone"})
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

    public void atualizarDados(DadosAtualizacaoAbrigo dados) {
        this.nome = dados.nome() != null ? dados.nome() : this.nome;
        this.email = dados.email() != null ? dados.email() : this.email;
        this.telefone = dados.telefone() != null ? dados.telefone() : this.telefone;
    }
}
