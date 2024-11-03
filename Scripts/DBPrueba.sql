create table productos (
idproducto int (3) auto_increment primary key,
nomproducto varchar (30) not null,
cantidad int(4),
estatus int(1)
);
Create table usuarios(
idUsuario int (6) primary key,
nombre varchar(100),
correo varchar(50),
contraseña varchar(25),
idRol int (2),
estatus int(1)
);

create table historicoProductos(
idmovimiento int auto_increment primary key,
idProducto int(3),
tipoMovimiento varchar(10),
idUsuario int(6),
fechaMOv datetime
);
