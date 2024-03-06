# Pets-API-Java-Spring

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=CONCLUÍDO&color=GREEN&style=for-the-badge)

API Rest desenvolvida com a finalidade de cadastrar adoções de pets. O projeto possibilita realizar CRUD de pets, de tutores, de abrigos e de adoções. Cada tutor possui um id, nome, email e senha, além de poder ter mais de um pet cadastrado. Cada Pet possui um id, nome, descrição, idade, uma imagem e um abrigo, além de poder ser registrado em apenas um abrigo e ser adotado por apenas um tutor. Cada abrigo possui um id, nome, email e telefone, além de poder possuir mais de um pet cadastrado. Os dados são armazenados no banco de dados relacional MySQL.

## Instalação

Realizar o clone do projeto

```shell
git clone git@github.com:mateus-montagnini/Pets-API.git
```

## Uso da API

Utilizar a URL: http://localhost:8080 no Postman para poder realizar os testes de criação, retorno, atualização e remoção de pets, tutores, abrigos e adoções.


## API Endpoints

| Verbos HTTP | Endpoints | Ação |
| --- | --- | --- |
| POST | /products | Registra um novo produto |
| GET | /products | Retorna todos os produtos |
| GET | /products/id | Retorna o produto indicado pelo id |
| PUT | /products/id | Atualiza produto indicado pelo id |
| DELETE | /products/id | Deleta o produto indicado pelo id |


## Tecnologias Usadas

* [Java](https://dev.java/)
* [Maven](https://maven.apache.org/)
* [Spring](https://spring.io/)
* [Postman](https://www.postman.com/)
* [PostgreSQL](https://www.postgresql.org/) 
