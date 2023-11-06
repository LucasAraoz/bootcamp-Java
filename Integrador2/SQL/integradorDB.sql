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

INSERT INTO productos (nombre, descripcion, precio, stock) values ("Paquete de diamantes mensual", "Paquete de diamantes subscripción", 112000, 70),
("Paquete VIP", "Paquete Súper VIP", 5000, 40),
("Pase de Batalla", "Súper Pase de Batalla ", 120000, 30);
select *from productos;


