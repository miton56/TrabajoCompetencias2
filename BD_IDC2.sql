create database empleados;
use empleados;

create table Cargos(
ID int primary key auto_increment,
Cargo varchar(50) not null
);

create table Empleados(
ID int primary key auto_increment,
Nombre varchar(50) not null,
Apellidos varchar(50) not null,
Telefono varchar(20) not null,
Rut varchar(50) not null unique,
Direccion varchar(50) not null
);

create table Login(

ID int primary key auto_increment,
ID_Empleado int not null,
CorreoUsuario varchar(50) not null unique,
Contraseña varchar(50),
foreign key(ID_Empleado) references Empleados(ID) on delete cascade

);

create table Empleado_Cargos(

ID_Empleado int not null,
ID_Cargo int not null,
primary key(ID_Empleado,ID_Cargo),
foreign key(ID_Empleado) references Empleados(ID) on delete cascade,
foreign key(ID_Cargo) references Cargos(ID) on delete cascade

);

create table Asistencia(

ID int primary key auto_increment,
ID_Empleado int not null,
Fecha date,
Hora_Entrada Time not null,
Hora_Salida Time not null,
foreign key (ID_Empleado) references Empleados(ID) on delete cascade,
unique(ID_Empleados, Fecha)

);

