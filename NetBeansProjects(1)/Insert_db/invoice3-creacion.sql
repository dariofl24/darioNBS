-- MySQL dump 10.13  Distrib 5.5.28, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: efacturaantescancela
-- ------------------------------------------------------
-- Server version	5.5.28-0ubuntu0.12.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;



--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `CTE_ID_PK` decimal(12,0) NOT NULL,
  `GRPO_ID_FK` decimal(12,0) NOT NULL,
  `NOMBRE_RAZON` varchar(150) NOT NULL,
  `AP_PATERNO` varchar(50) DEFAULT NULL,
  `AP_MATERNO` varchar(50) DEFAULT NULL,
  `TIPO_PERSONA` char(1) DEFAULT NULL,
  `TEL_PARTICULAR` varchar(20) DEFAULT NULL,
  `TEL_CELULAR` varchar(20) DEFAULT NULL,
  `RFC` varchar(13) NOT NULL,
  `TAX_ID` varchar(60) DEFAULT NULL,
  `CURP` varchar(18) DEFAULT NULL,
  `FEC_NAC` datetime DEFAULT NULL,
  `FEC_ALTA` datetime NOT NULL,
  `EMAIL` varchar(150) DEFAULT NULL,
  `STATUS` tinyint(1) NOT NULL,
  `FEC_BAJA` datetime DEFAULT NULL,
  `DOM_FISCAL_CALLE` varchar(100) DEFAULT NULL,
  `DOM_FISCAL_NO_EXT` varchar(50) DEFAULT NULL,
  `DOM_FISCAL_NO_INT` varchar(50) DEFAULT NULL,
  `DOM_FISCAL_COLONIA` varchar(100) DEFAULT NULL,
  `DOM_FISCAL_LOCALIDAD` varchar(100) DEFAULT NULL,
  `DOM_FISCAL_REFERENCIA` varchar(100) DEFAULT NULL,
  `DOM_FISCAL_MUNICIPIO` varchar(50) DEFAULT NULL,
  `DOM_FISCAL_ESTADO` varchar(50) DEFAULT NULL,
  `DOM_FISCAL_PAIS` varchar(50) NOT NULL,
  `DOM_FISCAL_CP` varchar(5) DEFAULT NULL,
  `NUM_CTA_PAGO` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`CTE_ID_PK`),
  KEY `CLIENTE_GRUPO_CLIENTE_DESC_FK` (`GRPO_ID_FK`),
  CONSTRAINT `CLIENTE_GRUPO_CLIENTE_DESC_FK` FOREIGN KEY (`GRPO_ID_FK`) REFERENCES `grupo_cliente_desc` (`GRPO_ID_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `comprobante`
--

DROP TABLE IF EXISTS `comprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comprobante` (
  `COMP_ID_PK` decimal(12,0) NOT NULL,
  `FECHA_CREACION` datetime NOT NULL,
  `STATUS` smallint(1) NOT NULL,
  `USU_ID` decimal(12,0) NOT NULL,
  `TIPO_COMPROBANTE` varchar(50) NOT NULL,
  `TIPO_CFD_ID_FK` decimal(12,0) NOT NULL,
  `TOTAL` decimal(15,2) NOT NULL,
  `CONTRIBUYENTE_ID_FK` decimal(12,0) NOT NULL,
  `CLIENTE_ID_FK` decimal(12,0) NOT NULL,
  PRIMARY KEY (`COMP_ID_PK`),
  KEY `FK_contribuyente_fk` (`CONTRIBUYENTE_ID_FK`),
  KEY `FK_cliente_fk` (`CLIENTE_ID_FK`),
  KEY `FK_sucursal_fk` (`SUC_ID_FK`),
  CONSTRAINT `FK_persona_cliente_fk` FOREIGN KEY (`CLIENTE_ID_FK`) REFERENCES `cliente` (`CTE_ID_PK`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_persona_contribuyente_fk` FOREIGN KEY (`CONTRIBUYENTE_ID_FK`) REFERENCES `contribuyente` (`CONTR_ID_PK`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_sucursal_fk` FOREIGN KEY (`SUC_ID_FK`) REFERENCES `sucursal` (`SUC_ID_PK`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `contribuyente`
--

DROP TABLE IF EXISTS `contribuyente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contribuyente` (
  `CONTR_ID_PK` decimal(12,0) NOT NULL,
  `GPO_USR_ID_FK` decimal(12,0) NOT NULL,
  `NOMBRE_RAZON` varchar(150) NOT NULL,
  `AP_PATERNO` varchar(50) DEFAULT NULL,
  `AP_MATERNO` varchar(50) DEFAULT NULL,
  `TIPO_PERSONA` char(1) DEFAULT NULL,
  `TEL_PARTICULAR` varchar(20) DEFAULT NULL,
  `TEL_CELULAR` varchar(20) DEFAULT NULL,
  `RFC` varchar(13) NOT NULL,
  `CURP` varchar(18) DEFAULT NULL,
  `FEC_NAC` datetime DEFAULT NULL,
  `FEC_ALTA` datetime NOT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `REGIMEN_FISCAL` varchar(100) NOT NULL,
  `STATUS` tinyint(1) NOT NULL,
  `FEC_BAJA` datetime DEFAULT NULL,
  `DOM_FISCAL_CALLE` varchar(150) NOT NULL,
  `DOM_FISCAL_NO_EXT` varchar(50) DEFAULT NULL,
  `DOM_FISCAL_NO_INT` varchar(50) DEFAULT NULL,
  `DOM_FISCAL_COLONIA` varchar(100) DEFAULT NULL,
  `DOM_FISCAL_LOCALIDAD` varchar(100) DEFAULT NULL,
  `DOM_FISCAL_REFERENCIA` varchar(100) DEFAULT NULL,
  `DOM_FISCAL_MUNICIPIO` varchar(50) NOT NULL,
  `DOM_FISCAL_ESTADO` varchar(50) NOT NULL,
  `DOM_FISCAL_PAIS` varchar(50) NOT NULL,
  `DOM_FISCAL_CP` varchar(5) NOT NULL,
  `DOM_EXPED_CALLE` varchar(150) DEFAULT NULL,
  `DOM_EXPED_NO_EXT` varchar(50) DEFAULT NULL,
  `DOM_EXPED_NO_INT` varchar(50) DEFAULT NULL,
  `DOM_EXPED_COLONIA` varchar(100) DEFAULT NULL,
  `DOM_EXPED_MUNICIPIO` varchar(100) DEFAULT NULL,
  `DOM_EXPED_ESTADO` varchar(50) DEFAULT NULL,
  `DOM_EXPED_PAIS` varchar(50) DEFAULT NULL,
  `DOM_EXPED_CP` varchar(5) DEFAULT NULL,
  `DOM_EXPED_LOCALIDAD` varchar(100) DEFAULT NULL,
  `DOM_EXPED_REFERENCIA` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CONTR_ID_PK`),
  KEY `FK_GPO_USR_ID` (`GPO_USR_ID_FK`),
  KEY `IDX_RFC` (`RFC`),
  CONSTRAINT `FK_GPO_USR_ID` FOREIGN KEY (`GPO_USR_ID_FK`) REFERENCES `grupo_usuarios` (`GPO_USR_ID_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sucursal` (
  `SUC_ID_PK` decimal(12,0) NOT NULL,
  `CONTR_ID_FK` decimal(12,0) NOT NULL,
  `STATUS` tinyint(1) NOT NULL,
  `DOM_FISCAL_MUNICIPIO` varchar(50) NOT NULL,
  `DOM_FISCAL_ESTADO` varchar(50) NOT NULL,
  `DOM_FISCAL_PAIS` varchar(50) NOT NULL,
  `DOM_FISCAL_CP` varchar(5) NOT NULL,
  PRIMARY KEY (`SUC_ID_PK`),
  KEY `FK_sucursal_contribuyente_fk` (`CONTR_ID_FK`),
  KEY `IDX_SUC_CONTR` (`SUC_ID_PK`,`CONTR_ID_FK`),
  CONSTRAINT `FK_sucursal_contribuyente_fk` FOREIGN KEY (`CONTR_ID_FK`) REFERENCES `contribuyente` (`CONTR_ID_PK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-01-24 16:03:44
