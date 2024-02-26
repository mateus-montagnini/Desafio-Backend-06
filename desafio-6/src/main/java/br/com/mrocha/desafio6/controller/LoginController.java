package br.com.mrocha.desafio6.controller;

import br.com.mrocha.desafio6.domain.Usuario.DadosLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity login(@RequestBody DadosLogin dados) {

        var dadosLoginSpring = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        authenticationManager.authenticate(dadosLoginSpring);

        return ResponseEntity.ok().build();
    }
}
