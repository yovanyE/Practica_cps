create database practica_gps;

use  practica_gps;

CREATE TABLE tregion(
	idRegion INT IDENTITY,
	descripcion VARCHAR(200),
	PRIMARY KEY(idRegion)
);
CREATE TABLE tpais(
	idPais INT IDENTITY,
	descripcion VARCHAR(200),
	tarifas DECIMAL(18,2),
	idRegion INT,
	PRIMARY KEY(idPais),
	CONSTRAINT FK_tpais_tregion FOREIGN KEY(idRegion) REFERENCES tregion(idRegion)
);
CREATE TABLE tpedido(
	idPedido INT IDENTITY,
	peso DECIMAL(18,2),
	ancho DECIMAL(18,2),
	alto DECIMAL(18,2),
	largo DECIMAL(18,2),
	tarifa DECIMAL(18,2),
	cotizacion DECIMAL(18,2),
	paisOrigen VARCHAR(200),
	idPaisDestino INT,
	PRIMARY KEY(idPedido),
	CONSTRAINT FK_tpedido_tpais FOREIGN KEY(idPaisDestino) REFERENCES tpais(idPais)
);



----------- SCRIPTS DE INSERCION DE DATOS
INSERT INTO tregion values('CENTRO AMERICA');
INSERT INTO tregion values('NORTE AMERICA');
INSERT INTO tregion values('ASIA');
INSERT INTO tregion values('OCEANIA');
INSERT INTO tregion values('AFRICA');
INSERT INTO tregion values('SUDAMERICA');

select * from tregion;
----REGION CENTRO AMERICA
INSERT INTO tpais values('GUATEMALA',35.50,1);
INSERT INTO tpais values('SALVADOR',125.7,1);
INSERT INTO tpais values('HONDURAS',135.80,1);
INSERT INTO tpais values('NICARAGUA',80.55,1);
-----NORTE AMERICA
INSERT INTO tpais values('USA',50.55,2);
----REGION SUDAMERICA
INSERT INTO tpais values('ARGENTINA',355,6);
INSERT INTO tpais values('BRASIL',270.5,6);



SELECT * FROM tpais;