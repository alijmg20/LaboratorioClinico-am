/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 10.5.7-MariaDB-1:10.5.7+maria~focal : Database - bd2_202125_grupo4
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bd2_202125_grupo4` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `bd2_202125_grupo4`;

/*Table structure for table `bioquimica` */

DROP TABLE IF EXISTS `bioquimica`;

CREATE TABLE `bioquimica` (
  `idbioquimica` int(11) NOT NULL AUTO_INCREMENT,
  `idmuestras` int(11) NOT NULL,
  `glucosa` double NOT NULL,
  `acido_urico` double NOT NULL,
  `creatinina` double NOT NULL,
  `colesterol` double NOT NULL,
  `hdl` double NOT NULL,
  `ldl` double NOT NULL,
  `trigliceridos` double NOT NULL,
  `fosfatasa_alcalina` double NOT NULL,
  `calcio` double NOT NULL,
  `hierro` double NOT NULL,
  `potasio` double NOT NULL,
  `sodio` double NOT NULL,
  `bilirrubina` double NOT NULL,
  `analisis` text DEFAULT NULL,
  `estadob` varchar(20) NOT NULL,
  PRIMARY KEY (`idbioquimica`),
  KEY `IX_Relationship36` (`idmuestras`),
  CONSTRAINT `Relationship36` FOREIGN KEY (`idmuestras`) REFERENCES `muestras` (`idmuestras`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `citas` */

DROP TABLE IF EXISTS `citas`;

CREATE TABLE `citas` (
  `idcitas` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_cita` datetime NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `idlaboratorista` int(11) NOT NULL,
  PRIMARY KEY (`idcitas`),
  KEY `IX_Relationship38` (`idpaciente`),
  KEY `IX_Relationship42` (`idlaboratorista`),
  CONSTRAINT `Relationship38` FOREIGN KEY (`idpaciente`) REFERENCES `pacientes` (`idpaciente`),
  CONSTRAINT `Relationship42` FOREIGN KEY (`idlaboratorista`) REFERENCES `laboratoristas` (`idlaboratorista`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `detalle_orden` */

DROP TABLE IF EXISTS `detalle_orden`;

CREATE TABLE `detalle_orden` (
  `iddetallesorden` int(11) NOT NULL AUTO_INCREMENT,
  `idorden` int(11) NOT NULL,
  `idexamen` int(11) NOT NULL,
  PRIMARY KEY (`iddetallesorden`),
  KEY `IX_Relationship27` (`idexamen`),
  KEY `IX_Relationship28` (`idorden`),
  CONSTRAINT `Relationship27` FOREIGN KEY (`idexamen`) REFERENCES `examenes` (`idexamen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Relationship28` FOREIGN KEY (`idorden`) REFERENCES `orden` (`idorden`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `empleados` */

DROP TABLE IF EXISTS `empleados`;

CREATE TABLE `empleados` (
  `idempleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `correo` char(50) NOT NULL,
  `clave` varchar(255) NOT NULL,
  `cedula` int(11) NOT NULL,
  `sexo` char(1) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `tipo` varchar(30) NOT NULL,
  PRIMARY KEY (`idempleado`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `examenes` */

DROP TABLE IF EXISTS `examenes`;

CREATE TABLE `examenes` (
  `idexamen` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `idtipoexamen` int(11) NOT NULL,
  PRIMARY KEY (`idexamen`),
  KEY `IX_Relationship25` (`idtipoexamen`),
  CONSTRAINT `Relationship25` FOREIGN KEY (`idtipoexamen`) REFERENCES `tipo_examen` (`idtipoexamen`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `factura` */

DROP TABLE IF EXISTS `factura`;

CREATE TABLE `factura` (
  `idfactura` int(11) NOT NULL AUTO_INCREMENT,
  `idorden` int(11) NOT NULL,
  `precio_total` float NOT NULL,
  `pagado` char(2) NOT NULL,
  `fecha_pagada` date NOT NULL,
  PRIMARY KEY (`idfactura`),
  KEY `IX_Relationship31` (`idorden`),
  CONSTRAINT `relationship1` FOREIGN KEY (`idorden`) REFERENCES `orden` (`idorden`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `heces` */

DROP TABLE IF EXISTS `heces`;

CREATE TABLE `heces` (
  `idheces` int(11) NOT NULL AUTO_INCREMENT,
  `idmuestras` int(11) NOT NULL,
  `aspecto` varchar(20) NOT NULL,
  `color` varchar(20) NOT NULL,
  `grasa` double NOT NULL,
  `nitrogeno` double NOT NULL,
  `urobilinogeno` double NOT NULL,
  `peso` double NOT NULL,
  `parasitos` varchar(30) NOT NULL,
  `bacterias` varchar(30) NOT NULL,
  `analisis` text DEFAULT NULL,
  `estadoh` varchar(20) NOT NULL,
  PRIMARY KEY (`idheces`),
  KEY `IX_Relationship34` (`idmuestras`),
  CONSTRAINT `Relationship34` FOREIGN KEY (`idmuestras`) REFERENCES `muestras` (`idmuestras`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `hematologia` */

DROP TABLE IF EXISTS `hematologia`;

CREATE TABLE `hematologia` (
  `idhematologia` int(11) NOT NULL AUTO_INCREMENT,
  `idmuestras` int(11) NOT NULL,
  `hematies` double NOT NULL,
  `hemoglobina` double NOT NULL,
  `hematocrito` double NOT NULL,
  `vcm` double NOT NULL,
  `linfocitos` double NOT NULL,
  `leucocitos` double NOT NULL,
  `neutrofilos` double NOT NULL,
  `eosinofilos` double NOT NULL,
  `plaquetas` double NOT NULL,
  `vsg` double NOT NULL,
  `grupo` varchar(30) NOT NULL,
  `analisis` text DEFAULT NULL,
  `estadohe` varchar(20) NOT NULL,
  PRIMARY KEY (`idhematologia`),
  KEY `IX_Relationship37` (`idmuestras`),
  CONSTRAINT `Relationship37` FOREIGN KEY (`idmuestras`) REFERENCES `muestras` (`idmuestras`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `laboratoristas` */

DROP TABLE IF EXISTS `laboratoristas`;

CREATE TABLE `laboratoristas` (
  `idlaboratorista` int(11) NOT NULL AUTO_INCREMENT,
  `idempleado` int(11) NOT NULL,
  `numero_laboratorista` int(11) NOT NULL,
  PRIMARY KEY (`idlaboratorista`),
  KEY `IX_Relationship50` (`idempleado`),
  CONSTRAINT `Relationship50` FOREIGN KEY (`idempleado`) REFERENCES `empleados` (`idempleado`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `muestras` */

DROP TABLE IF EXISTS `muestras`;

CREATE TABLE `muestras` (
  `idmuestras` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(20) NOT NULL DEFAULT '0',
  `iddetallesorden` int(11) NOT NULL,
  `estadom` varchar(20) NOT NULL DEFAULT '0',
  `idlaboratorista` int(11) NOT NULL,
  PRIMARY KEY (`idmuestras`),
  KEY `IX_Relationship33` (`iddetallesorden`),
  KEY `IX_Relationship43` (`idlaboratorista`),
  CONSTRAINT `Relationship33` FOREIGN KEY (`iddetallesorden`) REFERENCES `detalle_orden` (`iddetallesorden`),
  CONSTRAINT `Relationship43` FOREIGN KEY (`idlaboratorista`) REFERENCES `laboratoristas` (`idlaboratorista`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `orden` */

DROP TABLE IF EXISTS `orden`;

CREATE TABLE `orden` (
  `idorden` int(11) NOT NULL AUTO_INCREMENT,
  `idpaciente` int(11) NOT NULL,
  `idrecepcionista` int(11) NOT NULL,
  `fecha_emision` date NOT NULL,
  PRIMARY KEY (`idorden`),
  KEY `IX_Relationship40` (`idpaciente`),
  KEY `IX_Relationship51` (`idrecepcionista`),
  CONSTRAINT `Relationship40` FOREIGN KEY (`idpaciente`) REFERENCES `pacientes` (`idpaciente`),
  CONSTRAINT `Relationship51` FOREIGN KEY (`idrecepcionista`) REFERENCES `recepcionista` (`idrecepcionista`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `orina` */

DROP TABLE IF EXISTS `orina`;

CREATE TABLE `orina` (
  `idorina` int(11) NOT NULL AUTO_INCREMENT,
  `idmuestras` int(11) NOT NULL,
  `aldosterona` double NOT NULL,
  `aminoacidos` double NOT NULL,
  `calcio` double NOT NULL,
  `catecolaminas` double NOT NULL,
  `cloruro` double NOT NULL,
  `creatina_peso` double NOT NULL,
  `cortisol` double NOT NULL,
  `color` varchar(20) NOT NULL,
  `osmolalidad` double NOT NULL,
  `fosfato` double NOT NULL,
  `proteina` double NOT NULL,
  `acido_urico` double NOT NULL,
  `ph` double NOT NULL DEFAULT 0,
  `bacterias` varchar(30) NOT NULL,
  `analisis` text DEFAULT NULL,
  `estadoo` varchar(20) NOT NULL,
  PRIMARY KEY (`idorina`),
  KEY `IX_Relationship35` (`idmuestras`),
  CONSTRAINT `Relationship35` FOREIGN KEY (`idmuestras`) REFERENCES `muestras` (`idmuestras`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `pacientes` */

DROP TABLE IF EXISTS `pacientes`;

CREATE TABLE `pacientes` (
  `idpaciente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` char(30) NOT NULL,
  `correo` char(50) NOT NULL,
  `sexo` char(1) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `cedula` int(11) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idpaciente`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `recepcionista` */

DROP TABLE IF EXISTS `recepcionista`;

CREATE TABLE `recepcionista` (
  `idrecepcionista` int(11) NOT NULL AUTO_INCREMENT,
  `idempleado` int(11) NOT NULL,
  PRIMARY KEY (`idrecepcionista`),
  KEY `IX_Relationship48` (`idempleado`),
  CONSTRAINT `Relationship48` FOREIGN KEY (`idempleado`) REFERENCES `empleados` (`idempleado`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Table structure for table `tipo_examen` */

DROP TABLE IF EXISTS `tipo_examen`;

CREATE TABLE `tipo_examen` (
  `idtipoexamen` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `descripcion` varchar(60) NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`idtipoexamen`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
