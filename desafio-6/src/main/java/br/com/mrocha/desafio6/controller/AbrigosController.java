package br.com.mrocha.desafio6.controller;

import br.com.mrocha.desafio6.domain.Abrigo.Abrigo;
import br.com.mrocha.desafio6.domain.Abrigo.DadosAbrigo;
import br.com.mrocha.desafio6.domain.Abrigo.DadosAtualizacaoAbrigo;
import br.com.mrocha.desafio6.domain.Abrigo.DadosCadastroAbrigo;
import br.com.mrocha.desafio6.repository.AbrigosRepository;
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
@RequestMapping("/abrigos")
public class AbrigosController {

    @Autowired
    private AbrigosRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAbrigo dados) {

        Abrigo abrigo = new Abrigo(dados);
        repository.save(abrigo);

        return ResponseEntity.ok(new DadosAbrigo(abrigo));
    }

    @GetMapping
    public ResponseEntity listarTodos() {
        List<Abrigo> abrigos = repository.findAll();
        if (abrigos.isEmpty()) {
            return ResponseEntity.ok("nao encontrado");
        }
        return ResponseEntity.ok(abrigos.stream().map(DadosAbrigo::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity listarPorId(@PathVariable Long id) {
        try {
            var abrigo = repository.getReferenceById(id);
            return ResponseEntity.ok(new DadosAbrigo(abrigo));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("Abrigo nao encontrado");

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarTutor(@PathVariable Long id) {
        Optional<Abrigo> abrigo = repository.findById(id);
        if (abrigo.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok("Abrigo apagado com sucesso");
        }
        return ResponseEntity.ok("Abrigo nao encontrado");
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH})
    @Transactional
    public ResponseEntity atualizarTutor(@RequestBody @Valid DadosAtualizacaoAbrigo dados) {
        try {
            var abrigo = repository.getReferenceById(dados.id());
            abrigo.atualizarDados(dados);

            return ResponseEntity.ok(new DadosAbrigo(abrigo));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("Abrigo nao encontrado");
        }
    }
}
