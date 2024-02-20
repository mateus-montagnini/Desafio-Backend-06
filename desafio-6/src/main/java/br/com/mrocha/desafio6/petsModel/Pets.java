package br.com.mrocha.desafio6.petsModel;

import br.com.mrocha.desafio6.abrigoModel.Abrigo;
import br.com.mrocha.desafio6.abrigoModel.DadosAtualizacaoAbrigo;
import br.com.mrocha.desafio6.abrigoModel.DadosCadastroAbrigo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "nome", "descricao"})
@Table(name = "tb_pets")
public class Pets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "adotado")
    private Boolean adotado;

    @Column(name = "idade")
    private String idade;

    @Column(name = "imagem")
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "abrigo_id")
    private Abrigo abrigo;

    public Pets(DadosCadastroPet pet, Abrigo abrigo) {
        this.nome = pet.nome();
        this.descricao = pet.descricao();
        this.adotado = pet.adotado();
        this.idade = pet.idade();
        this.imagem = pet.imagem();
        this.abrigo = abrigo;
    }

    public void atualizarDados(DadosAtualizacaoPet dados, Abrigo abrigo) {
        this.nome = dados.nome() != null ? dados.nome() : this.nome;
        this.descricao = dados.descricao() != null ? dados.descricao() : this.descricao;
        this.adotado = dados.adotado() != null ? dados.adotado() : this.adotado;
        this.idade = dados.idade() != null ? dados.idade() : this.idade;
        this.imagem = dados.imagem() != null ? dados.imagem() : this.imagem;
        this.abrigo = abrigo != null ? abrigo : this.abrigo;
    }
}
