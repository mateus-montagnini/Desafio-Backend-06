# Pets-API-Java-Spring

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=CONCLUÍDO&color=GREEN&style=for-the-badge)

API Rest que possibilita realizar CRUD de produtos. Cada produto possui um nome, um valor e um id. Não é possível criar produtos sem um nome ou sem um valor. O id é gerado automaticamente .Os dados são armazenados no banco de dados relacional Postgres.

## Instalação

Realizar o clone do projeto

```shell
git clone https://github.com/mateus-montagnini/Product-API-Java-Spring.git
```

## Uso da API

Utilizar a URL: http://localhost:8080 no Postman para poder realizar os testes de criação, retorno, atualização e remoção de produtos


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
