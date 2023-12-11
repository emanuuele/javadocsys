create database docsys;

use docsys;

create table paciente(id_paciente int primary key auto_increment,
nome varchar(50),
doenca varchar(50),
estado varchar (50)
);

create table receita( id_receita int primary key auto_increment,
descricao varchar (255));

alter table receita add id_paciente int;
alter table receita add foreign key  (id_paciente) references paciente(id_paciente);


create table medicamento(id_medicamento int primary key auto_increment,
nome varchar (50),
quantidade int,
preco decimal(10,2)
);

alter table receita add id_medicamento int;
alter table receita add foreign key (id_medicamento) references paciente(id_paciente);
