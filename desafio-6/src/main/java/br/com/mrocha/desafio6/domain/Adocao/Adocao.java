package br.com.mrocha.desafio6.domain.Adocao;

import br.com.mrocha.desafio6.abrigoModel.Abrigo;
import br.com.mrocha.desafio6.domain.Pets.DadosAtualizacaoPet;
import br.com.mrocha.desafio6.domain.Pets.DadosCadastroPet;
import br.com.mrocha.desafio6.domain.Pets.Pets;
import br.com.mrocha.desafio6.domain.Tutores.Tutores;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "data"})
@Table(name = "tb_adocoes")
public class Adocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    private LocalDate data;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pets pet;

    @ManyToOne
    @JoinColumn(name = "tutores_id")
    private Tutores tutor;

    public Adocao(DadosCadastroAdocao dados, Pets pet, Tutores tutor) {
        this.data = dados.data();
        this.pet = pet;
        this.tutor = tutor;
    }
}
