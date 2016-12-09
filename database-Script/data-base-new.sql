-- MySQL dump 10.13  Distrib 5.7.12, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.16-0ubuntu0.16.04.1

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
-- Table structure for table `atleta`
--

DROP TABLE IF EXISTS `atleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atleta` (
  `id_atleta` int(11) NOT NULL AUTO_INCREMENT,
  `fk_endereco_atleta` int(11) NOT NULL,
  `nome_atleta` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `sexo` char(1) NOT NULL,
  `idade` int(11) DEFAULT NULL,
  `fk_grupo_atleta` int(11) DEFAULT NULL,
  `fk_categoria_atleta` int(11) DEFAULT NULL,
  `foto` varchar(45) DEFAULT NULL,
  `descricao` varchar(400) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_atleta`),
  UNIQUE KEY `usuario` (`usuario`),
  KEY `fk_endereco_idx` (`fk_endereco_atleta`),
  KEY `fk_grupo_idx` (`fk_grupo_atleta`),
  KEY `fk_categoria_idx` (`fk_categoria_atleta`),
  CONSTRAINT `fk_categoria_atleta` FOREIGN KEY (`fk_categoria_atleta`) REFERENCES `categoria` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_endereco_atleta` FOREIGN KEY (`fk_endereco_atleta`) REFERENCES `endereco` (`id_endereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_grupo_atleta` FOREIGN KEY (`fk_grupo_atleta`) REFERENCES `grupo` (`id_grupo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `atleta_evento`
--

DROP TABLE IF EXISTS `atleta_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atleta_evento` (
  `fk_evento_rel` int(11) NOT NULL,
  `fk_atleta_rel` int(11) NOT NULL,
  `colocacao` int(11) DEFAULT NULL,
  `id_atletaevento` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_atletaevento`),
  KEY `fk_atleta_idx` (`fk_atleta_rel`),
  KEY `fk_evento_idx` (`fk_evento_rel`),
  CONSTRAINT `fk_atleta_rel` FOREIGN KEY (`fk_atleta_rel`) REFERENCES `atleta` (`id_atleta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evento_rel` FOREIGN KEY (`fk_evento_rel`) REFERENCES `evento` (`id_evento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome_categoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email` (
  `id_email` int(11) NOT NULL AUTO_INCREMENT,
  `assunto` varchar(45) DEFAULT NULL,
  `corpo` varchar(700) DEFAULT NULL,
  `fk_atleta_email` int(11) NOT NULL,
  PRIMARY KEY (`id_email`),
  KEY `fk_atleta_idx` (`fk_atleta_email`),
  CONSTRAINT `fk_atleta_email` FOREIGN KEY (`fk_atleta_email`) REFERENCES `atleta` (`id_atleta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `email_atleta`
--

DROP TABLE IF EXISTS `email_atleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email_atleta` (
  `fk_email` int(11) NOT NULL,
  `fk_atleta` int(11) NOT NULL,
  `lido` tinyint(1) DEFAULT NULL,
  `id_emailatleta` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_emailatleta`),
  KEY `fk_email_idx` (`fk_email`),
  KEY `fk_atleta_idx` (`fk_atleta`),
  CONSTRAINT `fk_atleta` FOREIGN KEY (`fk_atleta`) REFERENCES `atleta` (`id_atleta`),
  CONSTRAINT `fk_email` FOREIGN KEY (`fk_email`) REFERENCES `email` (`id_email`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `id_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `cep` varchar(45) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `esporte`
--

DROP TABLE IF EXISTS `esporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `esporte` (
  `id_esporte` int(11) NOT NULL AUTO_INCREMENT,
  `nome_esporte` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_esporte`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `esporte_categoria`
--

DROP TABLE IF EXISTS `esporte_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `esporte_categoria` (
  `fk_esporte_rel` int(11) NOT NULL,
  `fk_categoria_rel` int(11) NOT NULL,
  KEY `fk_esporte_idx` (`fk_esporte_rel`),
  KEY `fk_categoria_idx` (`fk_categoria_rel`),
  CONSTRAINT `fk_categoria_rel` FOREIGN KEY (`fk_categoria_rel`) REFERENCES `categoria` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_esporte_rel` FOREIGN KEY (`fk_esporte_rel`) REFERENCES `esporte` (`id_esporte`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `id_evento` int(11) NOT NULL AUTO_INCREMENT,
  `nome_evento` varchar(45) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `fk_endereco_evento` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fk_grupo_evento` int(11) NOT NULL,
  PRIMARY KEY (`id_evento`),
  KEY `fk_grupo_idx` (`fk_grupo_evento`),
  KEY `fk_endereco_idx` (`fk_endereco_evento`),
  CONSTRAINT `fk_endereco_evento` FOREIGN KEY (`fk_endereco_evento`) REFERENCES `endereco` (`id_endereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_grupo_evento` FOREIGN KEY (`fk_grupo_evento`) REFERENCES `grupo` (`id_grupo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `id_grupo` int(11) NOT NULL AUTO_INCREMENT,
  `nome_` varchar(45) DEFAULT NULL,
  `fk_esporte` int(11) NOT NULL,
  `fk_endereco` int(11) NOT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `descricao` varchar(140) DEFAULT NULL,
  `img` varchar(45) DEFAULT NULL,
  `user_main` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_grupo`),
  KEY `fk_esporte_idx` (`fk_esporte`),
  KEY `fk_endereco_idx` (`fk_endereco`),
  KEY `user_main` (`user_main`),
  CONSTRAINT `fk_endereco` FOREIGN KEY (`fk_endereco`) REFERENCES `endereco` (`id_endereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_esporte` FOREIGN KEY (`fk_esporte`) REFERENCES `esporte` (`id_esporte`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-08  0:27:41
