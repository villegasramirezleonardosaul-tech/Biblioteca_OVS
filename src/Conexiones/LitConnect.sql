drop database if exists LitConnect;
create database LitConnect;
use LitConnect;
create table TipoTag(
idTag int primary key auto_increment,
descrip varchar(30));
insert into TipoTag (descrip) values ('programacion');
insert into TipoTag (descrip) values ('novela');
insert into TipoTag (descrip) values ('fisica');
insert into TipoTag (descrip) values ('matematicas');

create table Ebook(
idLibro int primary key auto_increment,
idTag int,
titulo varchar(30),
autor varchar(30),
nPaginas int,
editorial varchar(30),
foreign key (idTag) references TipoTag (idTag),
urlLibro varchar(30),
urlImagen varchar(30)
);

insert into Ebook (idTag,titulo,autor,nPaginas,editorial,urlLibro,urlImagen) 
values ('4','Algebra de Baldor','Baldor','287','Grupo Editorial Patria',
'Libros/Algebra_de_baldor','Imagenes/Algebra_de_baldor');

create table TipoUsuario(
idTipo int primary key auto_increment,
usuario varchar(30));

insert into TipoUsuario (usuario) values('admin');
insert into TipoUsuario (usuario) values('user');

create table Usuario(
boleta int primary key,
idTipo  int,
nomUser varchar(30),
contrasenia varchar(30),
foreign key (idTipo) references TipoUsuario (idTipo));

create table ListaFavoritos(
idLista int primary key auto_increment,
idLibro int,
boleta int,
nomLista varchar(30),
foreign key (idLibro) references ebook (idLibro),
foreign key (boleta) references Usuario (boleta));

create table Comunidad(
	idComunidad int primary key auto_increment,
    nombre varchar(30)
);

create table Mensaje(
idMensaje int primary key auto_increment,
idComunidad int,
descripcion varchar(100),
fecha date,
foreign key (idComunidad) references Comunidad (idComunidad));

select * from Ebook;
select* from Comunidad;
select * from Mensaje;
select * from Usuario;