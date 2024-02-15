package br.com.mrocha.desafio6.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tutores")
public class Tutores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;
}
