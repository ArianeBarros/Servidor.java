
--hard data
--
create table Salas(
codSala int primary key,
nome varchar(20) not null,
qtd int not null
)

select * from Salas

insert into Salas values(1, 'A', 6)
insert into Salas values(2, 'B', 6)
insert into Salas values(3, 'C', 6)