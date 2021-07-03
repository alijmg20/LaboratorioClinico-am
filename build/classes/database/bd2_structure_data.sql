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

/*Data for the table `bioquimica` */

LOCK TABLES `bioquimica` WRITE;

insert  into `bioquimica`(`idbioquimica`,`idmuestras`,`glucosa`,`acido_urico`,`creatinina`,`colesterol`,`hdl`,`ldl`,`trigliceridos`,`fosfatasa_alcalina`,`calcio`,`hierro`,`potasio`,`sodio`,`bilirrubina`,`analisis`,`estadob`) values 
(1,11,80,4,90,142,70,140,115,152,8.8,112,3.7,142,0.8,'','Analizado'),
(2,14,104,4.5,84,152,84,155,142,94,10.2,129,3.9,144,0.4,'','Analizado'),
(3,26,94,6.2,97,163,76,112,162,122,9.7,132,4.1,145,0.3,'','Analizado'),
(4,27,49,2.3,102,175,88,96,117,217,8.9,105,3.5,138,0.9,'','Analizado');

UNLOCK TABLES;

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

/*Data for the table `citas` */

LOCK TABLES `citas` WRITE;

insert  into `citas`(`idcitas`,`fecha_cita`,`idpaciente`,`idlaboratorista`) values 
(1,'2021-07-19 13:08:22',1,1),
(2,'2021-07-18 10:00:22',35,1),
(3,'2021-07-17 14:18:00',36,2),
(4,'2021-07-16 08:08:22',4,3),
(5,'2021-07-16 09:08:22',5,4),
(6,'2021-07-15 11:08:00',6,5),
(7,'2021-07-14 16:08:22',7,6),
(8,'2021-07-30 10:08:22',8,7),
(9,'2021-07-29 10:30:00',9,1),
(10,'2021-07-28 13:08:22',10,1),
(11,'2021-07-27 13:08:22',11,2),
(12,'2021-08-26 13:08:00',12,2),
(13,'2021-08-25 13:08:22',13,3),
(14,'2021-08-24 12:20:10',14,3),
(15,'2021-08-23 13:08:22',15,4),
(16,'2021-07-22 13:08:22',16,4);

UNLOCK TABLES;

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

/*Data for the table `detalle_orden` */

LOCK TABLES `detalle_orden` WRITE;

insert  into `detalle_orden`(`iddetallesorden`,`idorden`,`idexamen`) values 
(1,1,1),
(2,1,2),
(3,1,8),
(4,1,6),
(5,2,2),
(6,2,1),
(7,2,4),
(8,3,8),
(9,3,9),
(10,3,12),
(11,3,30),
(12,4,20),
(13,4,8),
(14,4,28),
(15,5,16),
(16,5,14),
(17,5,22),
(18,5,1),
(19,6,4),
(20,6,3),
(21,6,9),
(22,7,14),
(23,7,10),
(24,8,10),
(25,9,22),
(26,10,30),
(29,11,28),
(30,11,10);

UNLOCK TABLES;

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

/*Data for the table `empleados` */

LOCK TABLES `empleados` WRITE;

insert  into `empleados`(`idempleado`,`nombre`,`username`,`correo`,`clave`,`cedula`,`sexo`,`fecha_nacimiento`,`telefono`,`direccion`,`tipo`) values 
(1,'Ali','sup.1','ali@clinica.com','12345678',28031628,'M','2000-07-20','04147723591','Puerto Ordaz','SuperAdmin'),
(2,'Miguel','sup.2','miguel@clinica.com','87654321',27296179,'M','1999-12-21','04249292269','Puerto Ordaz','SuperAdmin'),
(3,'Julio','lab.1','julio@clinica.com','12345678',14859605,'M','1980-02-15','04128394854','Puerto Ordaz Villa ikabaru','Laboratorista'),
(4,'Paula','lab.2','paula@clinica.com','12345678',19394384,'F','1990-08-18','04167384952','Puerto Ordaz Unare II','Laboratorista'),
(5,'Rebeca','lab.3','rebe@clinica.com','12345678',17838943,'F','1993-03-01','04249584932','Puerto Ordaz villa alianza','Laboratorista'),
(6,'Rosa','rec.1','rosa@clinica.com','12345678',12849586,'F','1975-05-10','04248596954','Puerto Ordaz urbanizacion los pinos','Recepcionista'),
(7,'Juan','lab.4','juan@clinica.com','12345678',123845943,'M','1974-03-12','04128394594','Puerto Ordaz alta vista sur','Laboratorista'),
(8,'Jose','lab.5','jose@clinica.com','12345678',18938495,'M','1984-07-26','04248596054','San Felix urbanizacion la 45','Laboratorista'),
(9,'Carla','lab.6','carla@clinica.com','12345678',20948596,'F','1987-09-14','04269586953','San Felix urbanizacion simon bolivar','Laboratorista'),
(10,'Valery','lab.7','valery@clinica.com','12345678',24950495,'F','1990-10-15','04248594932','Puerto Ordaz urbanizacion las casitas','Laboratorista'),
(11,'Sofia','rec.2','sofia@clinica.com','12345678',28606592,'F','2002-01-05','04249372405','Puerto Ordaz','Recepcionista'),
(12,'Paulina','rec.3','paulina@clinica.com','12345678',28869584,'F','2000-12-20','04248573122','Puerto Ordaz','Recepcionista'),
(13,'Johana','lab.8','johana@clinica.com','12345678',20384595,'F','1992-10-28','04127384950','Puerto Ordaz','Laboratorista'),
(14,'Lucia','rec.4','lucia@clinica.com','12345678',253647584,'F','1998-03-20','04128384954','Puerto Ordaz Villa asia','Recepcionista');

UNLOCK TABLES;

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

/*Data for the table `examenes` */

LOCK TABLES `examenes` WRITE;

insert  into `examenes`(`idexamen`,`nombre`,`idtipoexamen`) values 
(1,'Hemograma / VHS',1),
(2,'Hematocrito',1),
(3,'Hemoglobina',1),
(4,'Rcto. de plaquetas',1),
(5,'Rcto. reticulocitos',1),
(6,'Tiempo de protrombina',1),
(7,'TTPK',1),
(8,'Tiempo de sangría de ivy',1),
(9,'Grupo  sanguíneo  / RH',1),
(10,'Rcto. de eosinofilos nasales',1),
(11,'Examen de glóbulos rojos',2),
(12,'Examen de glucosa en la orina',2),
(13,'Examen de proteina en sangre',2),
(14,'Examen de pH en la orina',2),
(15,'Examen de cetonas en orina',2),
(16,'Examen de bilirrubina',2),
(17,'Examen de gravedad específica',2),
(18,'Examen macroscópico de heces',3),
(19,'Examen parasitológico de heces',3),
(20,'Coprocultivo',3),
(21,'Examen de buscar sangre oculta',3),
(22,'Búsqueda de rotavirus',3),
(23,'Tinción con azul de metileno',3),
(24,'Búsqueda de huevos y parásitos',3),
(25,'Analisis bioquimico completo',4),
(26,'Analisis bioquimico de Urea',4),
(27,'Analisis de Creatina ',4),
(28,'Analisis de glicemia',4),
(29,'Analisis de transaminasa',4),
(30,'Analisis de acido urico',4),
(31,'Analisis de proteina',4);

UNLOCK TABLES;

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

/*Data for the table `factura` */

LOCK TABLES `factura` WRITE;

insert  into `factura`(`idfactura`,`idorden`,`precio_total`,`pagado`,`fecha_pagada`) values 
(1,1,800,'Si','2021-06-25'),
(2,2,600,'Si','2021-05-29'),
(3,3,920,'Si','2021-06-08'),
(4,4,850,'Si','2021-05-17'),
(5,5,890,'Si','2021-05-21'),
(6,6,600,'Si','2021-05-30'),
(7,7,320,'Si','2021-06-29'),
(8,8,200,'Si','2021-06-17'),
(9,9,250,'Si','2021-06-04'),
(10,10,400,'Si','2021-06-04'),
(11,11,600,'Si','2021-06-27');

UNLOCK TABLES;

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

/*Data for the table `heces` */

LOCK TABLES `heces` WRITE;

insert  into `heces`(`idheces`,`idmuestras`,`aspecto`,`color`,`grasa`,`nitrogeno`,`urobilinogeno`,`peso`,`parasitos`,`bacterias`,`analisis`,`estadoh`) values 
(1,12,'aguado','marron oscuro',3,1.2,270,114,'ausente','shigella','','Analizado'),
(2,17,'aguado','marron claro',1.7,1.8,90,75,'ausente','Campylobacter','','Analizado'),
(3,25,'espeso','marron oscuro',4.4,1.6,147,187,'ausente','ausente','','Analizado');

UNLOCK TABLES;

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

/*Data for the table `hematologia` */

LOCK TABLES `hematologia` WRITE;

insert  into `hematologia`(`idhematologia`,`idmuestras`,`hematies`,`hemoglobina`,`hematocrito`,`vcm`,`linfocitos`,`leucocitos`,`neutrofilos`,`eosinofilos`,`plaquetas`,`vsg`,`grupo`,`analisis`,`estadohe`) values 
(1,1,5.2,14,0.4,90,3400,9000,6800,480,440000,19,'A+',NULL,'Analizado'),
(2,2,5,12,0.42,87,3448,9053,6823,484,443845,19.04,'A+',NULL,'Analizado'),
(3,3,5.22,12.23,0.4223,87.8,3448.32,9053.21,6824.32,484.23,443865,19.049,'A+',NULL,'Analizado'),
(4,4,5.24,12.64,0.44,88.9,3450.43,9056.3,6826.41,485.3,444562,19.16,'A+',NULL,'Analizado'),
(5,5,4.2,9.54,0.46,83,1245.09,7834.32,2435.13,203.2,160543,9.13,'O+',NULL,'Analizado'),
(6,6,5.24,11.79,0.49,82.89,1453.87,7967.4,2463.16,203.54,173293,9.5,'O+',NULL,'Analizado'),
(7,7,4.97,10.86,0.51,80.34,1356.23,6954.85,2457.19,204.86,160584,9.42,'O+',NULL,'Analizado'),
(8,8,5.32,15,0.45,98.32,3950,10900,7950,499,449000,21,'O-',NULL,'Analizado'),
(9,9,5.4,15,0.47,100,4000,11000,8000,500,450000,22,'O-',NULL,'Analizado'),
(10,13,5.2,12,0.38,86,3965,10835,4596.4,448.59,320000,20.14,'AB+',NULL,'Analizado'),
(11,18,4.34,14.43,0.35,89,3845,9384,6954.02,457.54,259000,18.45,'B-',NULL,'Analizado'),
(12,19,4.53,15.54,0.4,88,2034,9485,5493,489.42,354000,17.93,'AB-',NULL,'Analizado'),
(13,20,4.43,15.89,0.34,94.23,3949,8405.23,6504,495.43,420345,18.43,'AB-',NULL,'Analizado'),
(14,21,4.67,15.43,0.37,92.46,3024.56,8595.26,7456,400,330000,19.56,'AB-',NULL,'Analizado'),
(15,23,3.45,12.46,0.44,96.54,3200,9456.06,7549.45,460,400300,20.34,'B+',NULL,'Analizado'),
(16,24,4.57,14.54,0.46,90.23,3965,10345,5430,410,423945,18.46,'O-',NULL,'Analizado'),
(19,28,4.32,16,0.43,98,4000,8960.56,6000,485,260000,19.04,'AB+',NULL,'Analizado');

UNLOCK TABLES;

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

/*Data for the table `laboratoristas` */

LOCK TABLES `laboratoristas` WRITE;

insert  into `laboratoristas`(`idlaboratorista`,`idempleado`,`numero_laboratorista`) values 
(1,3,1928395),
(2,4,8948484),
(3,5,9402940),
(4,7,1293844),
(5,8,3828384),
(6,9,5948594),
(7,10,6975944);

UNLOCK TABLES;

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

/*Data for the table `muestras` */

LOCK TABLES `muestras` WRITE;

insert  into `muestras`(`idmuestras`,`tipo`,`iddetallesorden`,`estadom`,`idlaboratorista`) values 
(1,'hematologia',1,'examinada',1),
(2,'hematologia',2,'examinada',1),
(3,'hematologia',3,'examinada',1),
(4,'hematologia',4,'examinada',1),
(5,'hematologia',5,'examinada',2),
(6,'hematologia',6,'examinada',2),
(7,'hematologia',7,'examinada',2),
(8,'hematologia',8,'examinada',3),
(9,'hematologia',9,'examinada',3),
(10,'orina',10,'examinada',3),
(11,'bioquimicos',11,'examinada',3),
(12,'heces',12,'examinada',4),
(13,'hematologia',13,'examinada',4),
(14,'bioquimicos',14,'examinada',4),
(15,'orina',15,'examinada',5),
(16,'orina',16,'examinada',5),
(17,'heces',17,'examinada',5),
(18,'hematologia',18,'examinada',5),
(19,'hematologia',19,'examinada',6),
(20,'hematologia',20,'examinada',6),
(21,'hematologia',21,'examinada',6),
(22,'orina',22,'examinada',7),
(23,'hematologia',23,'examinada',7),
(24,'hematologia',24,'examinada',1),
(25,'heces',25,'examinada',2),
(26,'bioquimicos',26,'examinada',3),
(27,'bioquimicos',29,'examinada',4),
(28,'hematologia',30,'examinada',4);

UNLOCK TABLES;

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

/*Data for the table `orden` */

LOCK TABLES `orden` WRITE;

insert  into `orden`(`idorden`,`idpaciente`,`idrecepcionista`,`fecha_emision`) values 
(1,17,1,'2021-05-12'),
(2,18,1,'2021-04-21'),
(3,19,1,'2021-06-21'),
(4,20,1,'2021-05-19'),
(5,21,1,'2021-06-14'),
(6,22,2,'2021-06-11'),
(7,23,2,'2021-05-17'),
(8,24,2,'2021-04-13'),
(9,25,2,'2021-05-09'),
(10,26,2,'2021-03-23'),
(11,27,2,'2021-05-18'),
(12,28,3,'2021-05-20'),
(13,29,3,'2021-06-15'),
(14,30,3,'2021-05-29'),
(15,31,3,'2021-06-02'),
(16,32,3,'2021-05-10'),
(17,33,4,'2021-04-14'),
(18,34,4,'2021-04-13');

UNLOCK TABLES;

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

/*Data for the table `orina` */

LOCK TABLES `orina` WRITE;

insert  into `orina`(`idorina`,`idmuestras`,`aldosterona`,`aminoacidos`,`calcio`,`catecolaminas`,`cloruro`,`creatina_peso`,`cortisol`,`color`,`osmolalidad`,`fosfato`,`proteina`,`acido_urico`,`ph`,`bacterias`,`analisis`,`estadoo`) values 
(1,10,10,300,200,80,180,21,3.8,'amarillo claro',75,0,80,480,5,'ausentes','','Analizado'),
(2,15,17,240,128,92,240,24,4.4,'amarillo fuerte',97,0,98,724,4,'ausentes','','Analizado'),
(3,16,5,215,288,12,210,24,3.5,'amarillo ',133,0,98,714,6,'ausentes','','Analizado'),
(4,22,13,396,274,75,166,15,4.4,'Amarillo opaco',121,0,27,272,4,'ausentes','','Analizado');

UNLOCK TABLES;

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

/*Data for the table `pacientes` */

LOCK TABLES `pacientes` WRITE;

insert  into `pacientes`(`idpaciente`,`nombre`,`correo`,`sexo`,`fecha_nacimiento`,`cedula`,`direccion`,`telefono`) values 
(1,'Keyla','keyla@gmail.com','F','1995-01-29',26548959,'Unare 2 Bloque 1','4248549523'),
(4,'Andrea','andrea@gmail.com','F','1984-11-19',20412365,'Unare','4148544523'),
(5,'Maria','maria@gmail.com','F','1991-12-29',22159958,'Unare 2 Bloque 1','4248544443'),
(6,'Paola','paola@gmail.com','F','1990-09-12',21123563,'Alta Vista Sur Casa 10 Mzn 36','4248541623'),
(7,'Yammar','yammar@gmail.com','F','1985-10-09',18456321,'Villa Africana Mzn 28 casa 14','4248541473'),
(8,'Dayana','dayana@gmail.com','F','1999-11-09',27495869,'Unare 3 calle 6','4248556923'),
(9,'Emily','emily@gmail.com','F','1996-11-29',24165239,'El Guamo','4248523223'),
(10,'Albany','albany@gmail.com','F','1997-02-24',23417963,'Terrazas del Atlantico','4248545453'),
(11,'Sofia','sofia@gmail.com','F','1994-03-19',20326148,'Terrazas del Caroni','4268549443'),
(12,'Aleska','aleska@gmail.com','F','1999-04-20',29948959,'Alta Vista','4149949523'),
(13,'Angie','angie@gmail.com','F','1998-05-27',27296185,'Unare 2 Bloque 3','4268549883'),
(14,'Victoria','victoria@gmail.com','F','1992-10-28',26549651,'Unare 3 Bloque 1','4168549743'),
(15,'Dagnny Moncada','dagnyM@gmail.com','F','2000-04-14',20412412,'San Felix','4148548123'),
(16,'Maria Soto','mariaS@gmail.com','F','1989-12-29',22159928,'Unare 2 Bloque 1','4248544943'),
(17,'Carla Espejo','carla@gmail.com','F','1974-09-12',21123533,'San Felix','4248543213'),
(18,'Marilin Reyes','marilin@gmail.com','F','1971-10-09',18456221,'Villa Africana Mzn 28 casa 14','4248541233'),
(19,'Angelymar Poyo','angelymar@gmail.com','F','1959-11-09',27495469,'Unare 3 calle 6','4248471923'),
(20,'Munir Acosta','munir@gmail.com','F','1966-11-29',24165539,'San Felix','4248548923'),
(21,'Mencia Lopez','mencia@gmail.com','F','1977-02-24',23417763,'Villa Colombia','4248545453'),
(22,'Monica Lozada','monica@gmail.com','F','2001-03-19',20328148,'Terrazas del Caroni','4268549443'),
(23,'Alba Uzcaegui','alba@gmail.com','F','2002-04-20',29948999,'Alta Vista','4149949523'),
(24,'Penelope Roder','penelope@gmail.com','F','2003-05-27',27294185,'Villa Colombia','4268549883'),
(25,'Andres Falla','andres@gmail.com','M','2000-10-28',26149651,'Villa Colombia','4168549743'),
(26,'Ali Mata','dagnyM@gmail.com','F','1998-07-24',20363412,'San Felix','4148548123'),
(27,'Jesus Gonzalez','mariaS@gmail.com','F','1989-12-29',22159528,'Unare 2 Bloque 1','4248544943'),
(28,'Miguel Lugo','carla@gmail.com','F','1998-09-12',21145433,'San Felix','4249292269'),
(29,'Orlando Marcano','marilin@gmail.com','F','1971-10-09',18656221,'Villa Africana ','4248592923'),
(30,'Julio Rojas','angelymar@gmail.com','F','1959-11-09',27775469,'Unare 3','4248471923'),
(31,'Fabian Rendon','munir@gmail.com','F','1966-11-29',24164739,'San Felix','4248548923'),
(32,'Gustavo Gonzalez','mencia@gmail.com','F','1996-03-29',23417763,'Villa Colombia','4248545453'),
(33,'Ernesto Flores','monica@gmail.com','F','1998-05-19',20328478,'Terrazas del Caroni','4268549443'),
(34,'Angel Perez','alba@gmail.com','F','1974-06-20',29948339,'Alta Verde','4146949523'),
(35,'Carlos Moran','penelope@gmail.com','F','1985-07-27',27294995,'Villa Adonai','4268549413'),
(36,'Andres Fuenmayor','andresF@gmail.com','M','2010-01-28',26144426,'Villa Colombia','4168549483');

UNLOCK TABLES;

/*Table structure for table `recepcionista` */

DROP TABLE IF EXISTS `recepcionista`;

CREATE TABLE `recepcionista` (
  `idrecepcionista` int(11) NOT NULL AUTO_INCREMENT,
  `idempleado` int(11) NOT NULL,
  PRIMARY KEY (`idrecepcionista`),
  KEY `IX_Relationship48` (`idempleado`),
  CONSTRAINT `Relationship48` FOREIGN KEY (`idempleado`) REFERENCES `empleados` (`idempleado`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `recepcionista` */

LOCK TABLES `recepcionista` WRITE;

insert  into `recepcionista`(`idrecepcionista`,`idempleado`) values 
(1,6),
(2,11),
(3,12),
(4,14);

UNLOCK TABLES;

/*Table structure for table `tipo_examen` */

DROP TABLE IF EXISTS `tipo_examen`;

CREATE TABLE `tipo_examen` (
  `idtipoexamen` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `descripcion` varchar(60) NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`idtipoexamen`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tipo_examen` */

LOCK TABLES `tipo_examen` WRITE;

insert  into `tipo_examen`(`idtipoexamen`,`nombre`,`descripcion`,`precio`) values 
(1,'Estudio Hematologico','Consiste en un análisis de sangre enfocado a características',200),
(2,'Análisis de orina','sirve para detectar padecimientos como infecciones',120),
(3,'Analisis de heces','ayuda a diagnosticar ciertas afecciones en el tubo digestivo',250),
(4,'Estudio bioquimico','se realiza para medir las sustancias químicas en el cuerpo',400);

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
