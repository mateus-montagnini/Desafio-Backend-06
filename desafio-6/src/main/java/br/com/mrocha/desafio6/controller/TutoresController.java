package br.com.mrocha.desafio6.controller;

import br.com.mrocha.desafio6.model.*;
import br.com.mrocha.desafio6.repository.TutoresRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tutores")
public class TutoresController {

    @Autowired
    private TutoresRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTutor dados) {

        if (!dados.senha().equals(dados.confirmacaoSenha())) {
            return ResponseEntity.badRequest().body("Senha precisa ser igual a confirmacao de senha");
        }

        Tutores tutor = new Tutores(dados);
        repository.save(tutor);

        return ResponseEntity.ok(new DadosTutor(tutor));
    }

    @GetMapping
    public ResponseEntity listarTodos() {
        List<Tutores> tutores = repository.findAll();
        if (tutores.isEmpty()) {
            return ResponseEntity.ok("nao encontrado");
        }
        return ResponseEntity.ok(tutores.stream().map(DadosDetalheTutor::new).collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    public ResponseEntity listarPorId(@PathVariable Long id) {
        try {
            var tutor = repository.getReferenceById(id);
            return ResponseEntity.ok(new DadosDetalheTutor(tutor));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("Tutor nao encontrado");

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarTutor(@PathVariable Long id) {
        Optional<Tutores> tutor = repository.findById(id);
        if (tutor.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok("Tutor apagado com sucesso");
        }
        return ResponseEntity.ok("Tutor nao encontrado");
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH})
    @Transactional
    public ResponseEntity atualizarTutor(@RequestBody @Valid DadosAtualizacaoTutor dados) {
        try {
            var tutor = repository.getReferenceById(dados.id());

            if (dados.senha() != null && !dados.senha().equals(dados.confirmacaoSenha())) {
                return ResponseEntity.ok("Senha e confirtmacao de senha precisam ser iguais");
            }
            tutor.atualizarDados(dados);

            return ResponseEntity.ok(new DadosTutor(tutor));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("Tutor nao encontrado");
        }
    }
}
