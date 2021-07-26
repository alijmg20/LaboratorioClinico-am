/*
Created: 18/6/2021
Modified: 18/7/2021
Model: MySQL 5.6
Database: MySQL 5.6
*/

-- Create tables section -------------------------------------------------

-- Table citas

CREATE TABLE `citas`
(
  `idcitas` Int NOT NULL AUTO_INCREMENT,
  `fecha_cita` Datetime NOT NULL,
  `idpaciente` Int NOT NULL,
  `idempleado` Int NOT NULL,
  PRIMARY KEY (`idcitas`)
)
;

CREATE INDEX `IX_Relationship38` ON `citas` (`idpaciente`)
;

CREATE INDEX `IX_Relationship53` ON `citas` (`idempleado`)
;

-- Table examenes

CREATE TABLE `examenes`
(
  `idexamen` Int NOT NULL AUTO_INCREMENT,
  `nombre` Varchar(100) NOT NULL,
  `precio` Double NOT NULL,
  `unidad` Char(40) NOT NULL,
  `tipov` Varchar(20) NOT NULL,
  `idcategoria` Int NOT NULL,
  PRIMARY KEY (`idexamen`)
)
;

CREATE INDEX `IX_Relationship59` ON `examenes` (`idcategoria`)
;

-- Table orden

CREATE TABLE `orden`
(
  `idorden` Int NOT NULL AUTO_INCREMENT,
  `fecha_emision` Date NOT NULL,
  `idcitas` Int NOT NULL,
  PRIMARY KEY (`idorden`)
)
;

CREATE INDEX `IX_Relationship51` ON `orden` (`idcitas`)
;

-- Table detalle_orden

CREATE TABLE `detalle_orden`
(
  `iddetallesorden` Int NOT NULL AUTO_INCREMENT,
  `estadoo` Char(20) NOT NULL,
  `idorden` Int NOT NULL,
  `idexamen` Int NOT NULL,
  PRIMARY KEY (`iddetallesorden`)
)
;

CREATE INDEX `IX_Relationship56` ON `detalle_orden` (`idorden`)
;

CREATE INDEX `IX_Relationship57` ON `detalle_orden` (`idexamen`)
;

-- Table categoria

CREATE TABLE `categoria`
(
  `idcategoria` Int NOT NULL AUTO_INCREMENT,
  `nombre` Char(100) NOT NULL,
  `descripcion` Text NOT NULL,
  PRIMARY KEY (`idcategoria`)
)
;

-- Table empleados

CREATE TABLE `empleados`
(
  `idempleado` Int NOT NULL AUTO_INCREMENT,
  `nombre` Varchar(100) NOT NULL,
  `username` Varchar(120) NOT NULL,
  `correo` Varchar(150) NOT NULL,
  `clave` Varchar(255) NOT NULL,
  `cedula` Int NOT NULL,
  `sexo` Char(1) NOT NULL,
  `fecha_nacimiento` Date NOT NULL,
  `telefono` Varchar(20),
  `direccion` Varchar(100),
  `idtipoempleado` Int NOT NULL,
  PRIMARY KEY (`idempleado`)
)
;

CREATE INDEX `IX_Relationship55` ON `empleados` (`idtipoempleado`)
;

ALTER TABLE `empleados` ADD UNIQUE `username` (`username`)
;

ALTER TABLE `empleados` ADD UNIQUE `correo` (`correo`)
;

-- Table factura

CREATE TABLE `factura`
(
  `idfactura` Int NOT NULL AUTO_INCREMENT,
  `precio_total` Float NOT NULL,
  `pagado` Char(2) NOT NULL,
  `fecha_pagada` Date NOT NULL,
  `idorden` Int NOT NULL,
  `idempleado` Int NOT NULL,
  PRIMARY KEY (`idfactura`)
)
;

CREATE INDEX `IX_Relationship52` ON `factura` (`idorden`)
;

CREATE INDEX `IX_Relationship54` ON `factura` (`idempleado`)
;

-- Table muestras

CREATE TABLE `muestras`
(
  `idmuestras` Int NOT NULL AUTO_INCREMENT,
  `valor` Char(150) NOT NULL,
  `estadov` Char(20),
  `descripcion` Text NOT NULL,
  `fecha_realizada` Date NOT NULL,
  `iddetallesorden` Int NOT NULL,
  `idempleado` Int NOT NULL,
  PRIMARY KEY (`idmuestras`)
)
;

CREATE INDEX `IX_Relationship60` ON `muestras` (`iddetallesorden`)
;

CREATE INDEX `IX_Relationship61` ON `muestras` (`idempleado`)
;

-- Table pacientes

CREATE TABLE `pacientes`
(
  `idpaciente` Int NOT NULL AUTO_INCREMENT,
  `nombre` Varchar(100) NOT NULL,
  `sexo` Char(1) NOT NULL,
  `fecha_nacimiento` Date NOT NULL,
  `cedula` Int NOT NULL,
  `correo` Varchar(150),
  `direccion` Text,
  `telefono` Varchar(20),
  PRIMARY KEY (`idpaciente`)
)
;

-- Table tipoempleado

CREATE TABLE `tipoempleado`
(
  `idtipoe` Int NOT NULL AUTO_INCREMENT,
  `nombre` Varchar(100) NOT NULL,
  PRIMARY KEY (`idtipoe`)
)
;

-- Table valornormal

CREATE TABLE `valornormal`
(
  `idvalornormal` Int NOT NULL,
  `valor_desde` Varchar(50) NOT NULL,
  `valor_hasta` Varchar(50) NOT NULL,
  `idexamen` Int NOT NULL
)
;

CREATE INDEX `IX_Relationship56` ON `valornormal` (`idexamen`)
;

ALTER TABLE `valornormal` ADD PRIMARY KEY (`idvalornormal`)
;

-- Table tipovalor

CREATE TABLE `tipovalor`
(
  `idtipovalor` Int NOT NULL,
  `valor` Char(150) NOT NULL,
  `idexamen` Int NOT NULL
)
;

CREATE INDEX `IX_Relationship57` ON `tipovalor` (`idexamen`)
;

ALTER TABLE `tipovalor` ADD PRIMARY KEY (`idtipovalor`)
;

-- Create foreign keys (relationships) section -------------------------------------------------

ALTER TABLE `citas` ADD CONSTRAINT `pide` FOREIGN KEY (`idpaciente`) REFERENCES `pacientes` (`idpaciente`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `orden` ADD CONSTRAINT `genera` FOREIGN KEY (`idcitas`) REFERENCES `citas` (`idcitas`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `factura` ADD CONSTRAINT `crea` FOREIGN KEY (`idorden`) REFERENCES `orden` (`idorden`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `citas` ADD CONSTRAINT `agenda` FOREIGN KEY (`idempleado`) REFERENCES `empleados` (`idempleado`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `factura` ADD CONSTRAINT `realiza` FOREIGN KEY (`idempleado`) REFERENCES `empleados` (`idempleado`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `empleados` ADD CONSTRAINT `Relationship55` FOREIGN KEY (`idtipoempleado`) REFERENCES `tipoempleado` (`idtipoe`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `detalle_orden` ADD CONSTRAINT `posee` FOREIGN KEY (`idorden`) REFERENCES `orden` (`idorden`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `detalle_orden` ADD CONSTRAINT `tiene` FOREIGN KEY (`idexamen`) REFERENCES `examenes` (`idexamen`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `examenes` ADD CONSTRAINT `clasifica` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `muestras` ADD CONSTRAINT `origina` FOREIGN KEY (`iddetallesorden`) REFERENCES `detalle_orden` (`iddetallesorden`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `muestras` ADD CONSTRAINT `inserta` FOREIGN KEY (`idempleado`) REFERENCES `empleados` (`idempleado`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `valornormal` ADD CONSTRAINT `Relationship56` FOREIGN KEY (`idexamen`) REFERENCES `examenes` (`idexamen`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `tipovalor` ADD CONSTRAINT `Relationship57` FOREIGN KEY (`idexamen`) REFERENCES `examenes` (`idexamen`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

