drop database if exists reservas;
create database reservas;
use reservas;

drop table if exists categorias;
CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL auto_increment,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists tipo_elemento;
CREATE TABLE `tipo_elemento` (
  `idtipo_elemento` int(11) NOT NULL auto_increment,
  `nombre_tipo` varchar(45) NOT NULL,
  `cant_max` int(11) DEFAULT NULL,
  `lim_tiempo` int(11) DEFAULT NULL,
  `dias_anticip` int(11) DEFAULT NULL,
  `encargado` TINYINT(1) DEFAULT 0,
  PRIMARY KEY (`idtipo_elemento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists elementos;
CREATE TABLE `elementos` (
  `idelemento` int(11) NOT NULL auto_increment,
  `nombre` varchar(45) DEFAULT NULL,
  `idtipo_elemento` int(11) NOT NULL,
  PRIMARY KEY (`idelemento`),
  KEY `idtipo_elemento_idx` (`idtipo_elemento`),
  CONSTRAINT `idtipo_elemento` FOREIGN KEY (`idtipo_elemento`) REFERENCES `tipo_elemento` (`idtipo_elemento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists personas;
CREATE TABLE `personas` (
  `idpersona` int(11) NOT NULL auto_increment,
  `dni` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `contrasenia` varchar(45) DEFAULT NULL,
  `habilitado` TINYINT(1) DEFAULT 0,
  `id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`idpersona`),
  KEY `id_categoria_idx` (`id_categoria`),
  CONSTRAINT `id_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists reservas; 
CREATE TABLE `reservas` (
  `id_reserva` int(11) NOT NULL auto_increment,
  `fecha` date NOT NULL,
  `hora` datetime NOT NULL,
  `id_persona` int(11) NOT NULL,
  `id_elemento` int(11) NOT NULL,
  `estado` varchar(30) DEFAULT NULL,
  `detalle` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_reserva`),
  KEY `id_persona_idx` (`id_persona`),
  KEY `id_elemento_idx` (`id_elemento`),
  CONSTRAINT `id_elemento` FOREIGN KEY (`id_elemento`) REFERENCES `elementos` (`idelemento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_persona` FOREIGN KEY (`id_persona`) REFERENCES `personas` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

