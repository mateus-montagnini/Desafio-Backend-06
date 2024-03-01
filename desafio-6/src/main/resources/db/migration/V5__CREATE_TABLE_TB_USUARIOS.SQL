CREATE TABLE tb_usuarios(
    id bigint not null auto_increment,
    login not null,
    senha not null,

    primary key(id)
);