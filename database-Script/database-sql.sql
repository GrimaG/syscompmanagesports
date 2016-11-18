sys_config-- MySQL Script generated by MySQL Workbench
-- Dom 13 Nov 2016 00:10:39 BRST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`endereco` (
  `id_endereco` INT NOT NULL,
  `cep` VARCHAR(45) NULL,
  `complemento` VARCHAR(45) NULL,
  `endereco` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(2) NULL,
  PRIMARY KEY (`id_endereco`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`esporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`esporte` (
  `id_esporte` INT NOT NULL,
  `nome_esporte` VARCHAR(45) NULL,
  PRIMARY KEY (`id_esporte`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`grupo` (
  `id_grupo` INT NOT NULL,
  `nome_` VARCHAR(45) NULL,
  `fk_esporte` INT NOT NULL,
  `fk_endereco` INT NOT NULL,
  `telefone` VARCHAR(45) NULL,
  `descricao` VARCHAR(140) NULL,
  `img` VARCHAR(45) NULL,
  PRIMARY KEY (`id_grupo`),
  INDEX `fk_esporte_idx` (`fk_esporte` ASC),
  INDEX `fk_endereco_idx` (`fk_endereco` ASC),
  CONSTRAINT `fk_esporte`
    FOREIGN KEY (`fk_esporte`)
    REFERENCES `mydb`.`esporte` (`id_esporte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_endereco`
    FOREIGN KEY (`fk_endereco`)
    REFERENCES `mydb`.`endereco` (`id_endereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`categoria` (
  `id_categoria` INT NOT NULL,
  `nome_categoria` VARCHAR(45) NULL,
  PRIMARY KEY (`id_categoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`atleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`atleta` (
  `id_atleta` INT NOT NULL,
  `fk_endereco_atleta` INT NOT NULL,
  `nome_atleta` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `sexo` CHAR(1) NOT NULL,
  `idade` INT NULL,
  `fk_grupo_atleta` INT NULL,
  `fk_categoria_atleta` INT NULL,
  `foto` VARCHAR(45) NULL,
  `descricao` VARCHAR(400) NULL,
  PRIMARY KEY (`id_atleta`),
  INDEX `fk_endereco_idx` (`fk_endereco_atleta` ASC),
  INDEX `fk_grupo_idx` (`fk_grupo_atleta` ASC),
  INDEX `fk_categoria_idx` (`fk_categoria_atleta` ASC),
  CONSTRAINT `fk_endereco_atleta`
    FOREIGN KEY (`fk_endereco_atleta`)
    REFERENCES `mydb`.`endereco` (`id_endereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_grupo_atleta`
    FOREIGN KEY (`fk_grupo_atleta`)
    REFERENCES `mydb`.`grupo` (`id_grupo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_categoria_atleta`
    FOREIGN KEY (`fk_categoria_atleta`)
    REFERENCES `mydb`.`categoria` (`id_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`evento` (
  `id_evento` INT NOT NULL,
  `nome_evento` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NULL,
  `fk_endereco_evento` INT NOT NULL,
  `data` TIMESTAMP NOT NULL,
  `fk_grupo_evento` INT NOT NULL,
  PRIMARY KEY (`id_evento`),
  INDEX `fk_grupo_idx` (`fk_grupo_evento` ASC),
  INDEX `fk_endereco_idx` (`fk_endereco_evento` ASC),
  CONSTRAINT `fk_grupo_evento`
    FOREIGN KEY (`fk_grupo_evento`)
    REFERENCES `mydb`.`grupo` (`id_grupo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_endereco_evento`
    FOREIGN KEY (`fk_endereco_evento`)
    REFERENCES `mydb`.`endereco` (`id_endereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`atleta_evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`atleta_evento` (
  `fk_evento_rel` INT NOT NULL,
  `fk_atleta_rel` INT NOT NULL,
  `colocacao` INT NULL,
  INDEX `fk_atleta_idx` (`fk_atleta_rel` ASC),
  INDEX `fk_evento_idx` (`fk_evento_rel` ASC),
  CONSTRAINT `fk_atleta_rel`
    FOREIGN KEY (`fk_atleta_rel`)
    REFERENCES `mydb`.`atleta` (`id_atleta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_evento_rel`
    FOREIGN KEY (`fk_evento_rel`)
    REFERENCES `mydb`.`evento` (`id_evento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`email`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`email` (
  `id_email` INT NOT NULL COMMENT '	',
  `assunto` VARCHAR(45) NULL,
  `corpo` VARCHAR(700) NULL,
  `fk_atleta_email` INT NOT NULL,
  PRIMARY KEY (`id_email`),
  INDEX `fk_atleta_idx` (`fk_atleta_email` ASC),
  CONSTRAINT `fk_atleta_email`
    FOREIGN KEY (`fk_atleta_email`)
    REFERENCES `mydb`.`atleta` (`id_atleta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`esporte_categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`esporte_categoria` (
  `fk_esporte_rel` INT NOT NULL,
  `fk_categoria_rel` INT NOT NULL,
  INDEX `fk_esporte_idx` (`fk_esporte_rel` ASC),
  INDEX `fk_categoria_idx` (`fk_categoria_rel` ASC),
  CONSTRAINT `fk_esporte_rel`
    FOREIGN KEY (`fk_esporte_rel`)
    REFERENCES `mydb`.`esporte` (`id_esporte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_categoria_rel`
    FOREIGN KEY (`fk_categoria_rel`)
    REFERENCES `mydb`.`categoria` (`id_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`email_atleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`email_atleta` (
  `fk_email` INT NOT NULL,
  `fk_atleta` INT NOT NULL,
  `lido` TINYINT(1) NULL,
  INDEX `fk_email_idx` (`fk_email` ASC),
  INDEX `fk_atleta_idx` (`fk_atleta` ASC),
  CONSTRAINT `fk_email`
    FOREIGN KEY (`fk_email`)
    REFERENCES `mydb`.`email` (`id_email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_atleta`
    FOREIGN KEY (`fk_atleta`)
    REFERENCES `mydb`.`atleta` (`id_atleta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;