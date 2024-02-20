package br.com.mrocha.desafio6.controller;

import br.com.mrocha.desafio6.abrigoModel.Abrigo;
import br.com.mrocha.desafio6.domain.Pets.DadosAtualizacaoPet;
import br.com.mrocha.desafio6.domain.Pets.DadosCadastroPet;
import br.com.mrocha.desafio6.domain.Pets.DadosPets;
import br.com.mrocha.desafio6.domain.Pets.Pets;
import br.com.mrocha.desafio6.repository.AbrigosRepository;
import br.com.mrocha.desafio6.repository.PetsRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pets")
public class PetsController {

    @Autowired
    private AbrigosRepository abrigoRepository;

    @Autowired
    private PetsRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPet dados) {

        Abrigo abrigo = abrigoRepository.getReferenceById(dados.abrigoId());

        Pets pet = new Pets(dados, abrigo);
        repository.save(pet);

        return ResponseEntity.ok(new DadosPets(pet));
    }

    @GetMapping
    public ResponseEntity listarTodos() {
        List<Pets> pets = repository.findAll();
        if (pets.isEmpty()) {
            return ResponseEntity.ok("nao encontrado");
        }
        return ResponseEntity.ok(pets.stream().map(DadosPets::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity listarPorId(@PathVariable Long id) {
        try {
            var pet = repository.getReferenceById(id);
            return ResponseEntity.ok(new DadosPets(pet));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("Pet nao encontrado");

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarTutor(@PathVariable Long id) {
        Optional<Pets> pet = repository.findById(id);
        if (pet.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok("Pet apagado com sucesso");
        }
        return ResponseEntity.ok("Pet nao encontrado");
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH})
    @Transactional
    public ResponseEntity atualizarTutor(@RequestBody @Valid DadosAtualizacaoPet dados) {
        try {
            Abrigo abrigo = null;
            if (dados.abrigoId() != null) {
                abrigo = abrigoRepository.getReferenceById(dados.abrigoId());
            }
            var pet = repository.getReferenceById(dados.id());
            pet.atualizarDados(dados, abrigo);

            return ResponseEntity.ok(new DadosPets(pet));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("Pet nao encontrado");
        }
    }
}
