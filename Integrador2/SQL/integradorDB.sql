create database almacen;
use almacen;

create table productos(
 codigo int auto_increment,
 nombre varchar(30),
 descripcion varchar(100),
 precio int,
 stock int,
 primary key(codigo),
 unique(codigo)
);

INSERT INTO productos (nombre, descripcion, precio, stock) values ("Guitarra Electrica Lespaul", "Guitarra de la marca Gibson color negro", 112000, 70),
("Armonica Golden Cup", "Armonica diatonica C colores: azul, amarillo.", 5000, 40),
("Guitarra acustica", "Guitarra acustica de cuerdas de nilon", 120000, 30);
select *from productos;


