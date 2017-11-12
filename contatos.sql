
<! ---Criação da tabela de contatos
create table contatos(
    id serial,
    nome varchar(255),
    email varchar(255),
    endereco varchar(255),
    dataNascimento DATE,
    primary key(id)
);
