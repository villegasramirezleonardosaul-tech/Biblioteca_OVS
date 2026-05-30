drop database if exists LitConnect;
create database LitConnect;
use LitConnect;

create table Ebook(
idLibro int primary key auto_increment,
idTag int,
titulo varchar(30),
autor varchar(30),
nPaginas int,
editorial varchar(30),
foreign key (idTag) references TipoTag (idTag));

create table ListaFavoritos(
idLista int primary key auto_increment,
idLibro int,
boleta int,
nomLista varchar(30),
foreign key (idLibro) references ebook (idLibro),
foreign key (boleta) references Usuario (boleta));

create table TipoTag(
idTag int primary key auto_increment,
descrip varchar(30));

create table Usuario(
boleta int primary key,
idTipo  int,
nomUser varchar(30),
contrasenia int,
foreign key (idTipo) references TipoUsuario (idTipo));

create table TipoUsuario(
idTipo int primary key,
usuario varchar(30));

create table Mensaje(
idMensaje int primary key auto_increment,
idType int,
idComunidad int,
descripcion varchar(100),
fecha date,
foreign key (idType) references TipoMensaje (idType),
foreign key (idComunidad) references Foro (idComunidad));

create table Foro(
idComunidad int primary key auto_increment,
boleta int,
nombre varchar(20),
foreign key (boleta) references Usuario (boleta));

create table TipoMensaje(
idType int primary key auto_increment,
tipo varchar(30));









