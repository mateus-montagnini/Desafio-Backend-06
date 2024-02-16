package br.com.mrocha.desafio6.controller;

import br.com.mrocha.desafio6.model.DadosCadastroTutor;
import br.com.mrocha.desafio6.model.DadosDetalheTutor;
import br.com.mrocha.desafio6.model.DadosTutor;
import br.com.mrocha.desafio6.model.Tutores;
import br.com.mrocha.desafio6.repository.TutoresRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
}
