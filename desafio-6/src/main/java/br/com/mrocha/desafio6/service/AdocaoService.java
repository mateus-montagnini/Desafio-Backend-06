package br.com.mrocha.desafio6.service;

import br.com.mrocha.desafio6.domain.Adocao.Adocao;
import br.com.mrocha.desafio6.domain.Adocao.DadosCadastroAdocao;
import br.com.mrocha.desafio6.domain.Pets.Pets;
import br.com.mrocha.desafio6.domain.Tutores.Tutores;
import br.com.mrocha.desafio6.repository.AdocaoRepository;
import br.com.mrocha.desafio6.repository.PetsRepository;
import br.com.mrocha.desafio6.repository.TutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdocaoService {

    @Autowired
    private PetsRepository petsRepository;

    @Autowired
    private TutoresRepository tutoresRepository;

    @Autowired
    AdocaoRepository adocaoRepository;

    public Adocao cadastraAdocao(DadosCadastroAdocao dados) {
        Pets pet = petsRepository.findById(dados.petId()).orElseThrow(() -> new IllegalArgumentException("Pet nao cadastrado"));
        if (pet.getAdotado()) {
            throw new IllegalArgumentException("Pet ja foi adotado");
        }

        Tutores tutor = tutoresRepository.findById(dados.tutorId()).orElseThrow(() -> new IllegalArgumentException("Tutor nao cadastrado"));

        Adocao adocao = new Adocao(dados, pet, tutor);
        adocaoRepository.save(adocao);

        pet.setAdotado(true);
        return adocao;
    }

    public void deletarAdocao(Long id) {
        Adocao adocao = adocaoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Adocao nao cadastrada"));

        adocaoRepository.deleteById(id);
    }
}
