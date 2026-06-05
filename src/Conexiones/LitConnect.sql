
#para que la puedan crear cuando quieran;
DROP DATABASE IF EXISTS LitConnect;
CREATE DATABASE LitConnect;
USE LitConnect;

CREATE TABLE TipoTag(
    idTag INT PRIMARY KEY AUTO_INCREMENT,
    descrip VARCHAR(30)
);
#Esto se puede cambiar pero de preferencia lo vamos a dejar asi
INSERT INTO TipoTag (descrip) VALUES ('programacion');     
INSERT INTO TipoTag (descrip) VALUES ('novela');           
INSERT INTO TipoTag (descrip) VALUES ('fisica');           
INSERT INTO TipoTag (descrip) VALUES ('matematicas');      
INSERT INTO TipoTag (descrip) VALUES ('base de datos');    
INSERT INTO TipoTag (descrip) VALUES ('ingenieria');    
select * from tipotag;   

CREATE TABLE Ebook(
    idLibro INT PRIMARY KEY AUTO_INCREMENT,
    idTag INT,
    titulo VARCHAR(50),
    autor VARCHAR(50),
    nPaginas INT,
    editorial VARCHAR(50),
    FOREIGN KEY (idTag) REFERENCES TipoTag (idTag),
    urlLibro VARCHAR(50),   
    urlImagen VARCHAR(50)   
);

#Esto si no tocar;

INSERT INTO Ebook (idTag, titulo, autor, nPaginas, editorial, urlLibro, urlImagen) VALUES 
(4, 'Algebra de Baldor', 'Aurelio Baldor', 576, 'Grupo Editorial Patria', 'Libros/Algebra_de_baldor.pdf', '/Imagenes/Algebra_de_baldor'),
(6, 'Analisis Orientado a Objetos', 'Desconocido', 350, 'Editorial S.A.', 'Libros/Analisis_orientado.pdf', '/Imagenes/Analisis_orientado'),
(1, 'Android Studio', 'Desconocido', 400, 'Developer Press', 'Libros/Android_studio.pdf', '/Imagenes/Android_studio'),
(5, 'Bases de Datos', 'Desconocido', 600, 'McGraw-Hill', 'Libros/Bases_de_datos.pdf', '/Imagenes/Bases_de_datos'),
(5, 'Bases de Datos No Relacionales', 'Desconocido', 250, 'Open Source', 'Libros/Bases_de_datos_no_relacionales.pdf', '/Imagenes/Bases_de_datos_no_relacionales'),
(6, 'Constante Navarro', 'Navarro', 300, 'Editorial Tecnica', 'Libros/Constante_navarro.pdf', '/Imagenes/Constante_navarro'),
(6, 'DDOO', 'Desconocido', 280, 'Educacion Superior', 'Libros/DDOO.pdf', '/Imagenes/DDOO'),
(2, 'El Principito', 'Antoine de Saint-Exupéry', 96, 'Reynal & Hitchcock', 'Libros/El_principito.pdf', '/Imagenes/El_principito'),
(3, 'Fundamentos de Fisica', 'Halliday & Resnick', 1100, 'Wiley', 'Libros/Fundamentos_de_fisica.pdf', '/Imagenes/Fundamentos_de_fisica'),
(4, 'Geometria de Baldor', 'Aurelio Baldor', 460, 'Grupo Editorial Patria', 'Libros/Geometria_de_baldor.pdf', '/Imagenes/Geometria_de_baldor'),
(1, 'Informatica', 'Desconocido', 320, 'Santiillana', 'Libros/Informatica.pdf', '/Imagenes/Informatica'),
(5, 'Introduccion a las Bases de Datos', 'C.J. Date', 900, 'Pearson', 'Libros/Introduccion_a_las_bases_de_datos.pdf', '/Imagenes/Introduccion_a_las_bases_de_datos'),
(1, 'Metodologia de la Programacion', 'Osvaldo Cairó', 480, 'McGraw-Hill', 'Libros/Metodologia_de_la_programacion.pdf', '/Imagenes/Metodologia_de_la_programacion'),
(6, 'Ingenieria de Software - Pressman', 'Roger S. Pressman', 900, 'McGraw-Hill', 'Libros/Pressman.pdf', '/Imagenes/Pressman'),
(6, 'Sistema de Control', 'Katsuhiko Ogata', 900, 'Pearson', 'Libros/Sistema_control.pdf', '/Imagenes/Sistema_control');

CREATE TABLE TipoUsuario(
    idTipo INT PRIMARY KEY,
    usuario VARCHAR(30)
);
#Tampoco tocar
INSERT INTO TipoUsuario  VALUES (1,'admin');
INSERT INTO TipoUsuario  VALUES (2, 'user');

CREATE TABLE Usuario(
    boleta VARCHAR(15) PRIMARY KEY,
    idTipo INT,
    nomUser VARCHAR(30),
    contrasenia VARCHAR(30),
    FOREIGN KEY (idTipo) REFERENCES TipoUsuario (idTipo)
);
#Aqui si le pueden cambiar lo que sea pero avisen
insert into Usuario(boleta,idTipo, nomUser, contrasenia) values
('2025090083', 1, 'Chris', 'olajejexd'),
('2025090570', 1, 'Leonardo', '1234'),
('2025090048', 1,' Brandon', 'litconnectjejexd'),
('2025090582', 1, 'Juan', 'makinamijejedxd');
    




CREATE TABLE ListaFavoritos(
    idLista INT PRIMARY KEY AUTO_INCREMENT,
    idLibro INT,
    boleta varchar(15),
    FOREIGN KEY (idLibro) REFERENCES Ebook (idLibro),
    FOREIGN KEY (boleta) REFERENCES Usuario (boleta)
);


CREATE TABLE Comunidad(
    idComunidad INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30)
);
#Esta esta en base a los idTag;
INSERT INTO Comunidad (nombre) VALUES ('Comunidad de Programación'); 
INSERT INTO Comunidad (nombre) VALUES ('Club de Novelas');           
INSERT INTO Comunidad (nombre) VALUES ('Foro de Física');            
INSERT INTO Comunidad (nombre) VALUES ('Rincón de Matemáticas');     
INSERT INTO Comunidad (nombre) VALUES ('Base de Datos Expertos');    
INSERT INTO Comunidad (nombre) VALUES ('Ingeniería y Control');      

CREATE TABLE Mensaje(
    idMensaje INT PRIMARY KEY AUTO_INCREMENT,
    idComunidad INT,
    descripcion VARCHAR(100),
    fecha DATE default(current_date),
    FOREIGN KEY (idComunidad) REFERENCES Comunidad (idComunidad)
);

CREATE TABLE Respuesta(
    idRespuesta INT PRIMARY KEY AUTO_INCREMENT,
    idMensaje INT,
    contenido VARCHAR(100), 
    fecha DATE DEFAULT (CURRENT_DATE), 
    FOREIGN KEY (idMensaje) REFERENCES Mensaje(idMensaje)
);
#Esto para imprimir las tablas que quieran
SELECT * FROM TipoTag;
SELECT * FROM Ebook;
SELECT * FROM Comunidad;
SELECT * FROM Mensaje;
SELECT * FROM Usuario;