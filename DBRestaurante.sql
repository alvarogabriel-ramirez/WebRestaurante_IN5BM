create database DBRestaurante;
use DBRestaurante ;

CREATE TABLE meseros (
    idmesero INT NOT NULL,
    nombreMesero VARCHAR(25) NOT NULL,
    
    primary key (idmesero)
);

CREATE TABLE platos (
    idplato INT NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(50) NOT NULL,
    costo DOUBLE(10 , 2 ) NOT NULL,
    PRIMARY KEY (idplato)
);

CREATE TABLE areas (
    idarea INT NOT NULL AUTO_INCREMENT,
    nombreArea VARCHAR(50) NOT NULL,
    numEmpleados INT(8) NOT NULL,
    PRIMARY KEY (idarea)
);


CREATE TABLE cocineros (
    idcocinero INT NOT NULL,
    nombrecocinero VARCHAR(45) NOT NULL,
    
    PRIMARY KEY (idcocinero)
);

 


CREATE TABLE mesas (
    idmesa INT NOT NULL AUTO_INCREMENT,
    idmesero INT NOT NULL,
    idarea INT NOT NULL,
    primary key (idmesa),
    FOREIGN KEY (idmesero)
        REFERENCES meseros (idmesero)
        ON DELETE CASCADE,
    FOREIGN KEY (idarea)
        REFERENCES areas (idarea)
        ON DELETE CASCADE
        
);




CREATE TABLE clientes (
    idcliente INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50),
    telefono VARCHAR(50) NOT NULL,
    nit VARCHAR(50) NOT NULL,
    correoElectronico VARCHAR(50) NOT NULL,
    idmesa INT NOT NULL,
    FOREIGN KEY (idmesa)
        REFERENCES mesas (idmesa)
);

CREATE TABLE facturas (
    idfactura INT NOT NULL  AUTO_INCREMENT,
    idcliente INT NOT NULL,
    idmesero INT NOT NULL,
    idmesa INT NOT NULL,
    PRIMARY KEY (idfactura),
    FOREIGN KEY (idcliente)
        REFERENCES clientes (idcliente)
        ON DELETE CASCADE,
    FOREIGN KEY (idmesa)
        REFERENCES mesas (idmesa)
        ON DELETE CASCADE,
    FOREIGN KEY (idmesero)
        REFERENCES meseros (idmesero)
        ON DELETE CASCADE
);



create table detallefactura(

	idplato int not null,
	idfactura int not null,
	idcocinero int not null,
	primary key(idplato,idfactura),
	cantidad int(8) not null,
	precioventa double(10,2) not null,
	costoTotal double as(cantidad*precioventa),
	foreign key (idplato) references platos(idplato)on delete cascade,
	foreign key (idfactura) references facturas(idfactura)on delete cascade,
	foreign key (idcocinero) references cocineros(idcocinero)on delete cascade
);


 
 








































