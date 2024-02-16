package br.com.mrocha.desafio6.controller;

import br.com.mrocha.desafio6.model.DadosCadastroTutor;
import br.com.mrocha.desafio6.model.Tutores;
import br.com.mrocha.desafio6.repository.TutoresRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        repository.save(new Tutores(dados));

        return ResponseEntity.ok().body("Tutor cadastrado com sucesso");
    }
}
