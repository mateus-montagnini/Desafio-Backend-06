CREATE TABLE tb_adocoes(
    id bigint not null auto_increment,
    pet_id bigint not null,
    tutor_id bigint not null,
    data date not null,

    primary key(id),
    foreign key(pet_id) references tb_pets(id),
    foreign key(tutor_id) references tb_tutores(id),
);