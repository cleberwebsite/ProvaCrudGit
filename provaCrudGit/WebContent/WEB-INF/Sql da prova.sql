create database medicacao;

use medicacao;

create table Paciente(
    id int(11)unsigned not null auto_increment,
    nome varchar(80) not null,
	dosagem float(6.2) not null,
	intervalo float(6.2) not null,
	duracao float(6.2) not null,
    primary key(id)
);