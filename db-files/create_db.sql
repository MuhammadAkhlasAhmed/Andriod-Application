-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema moviesrecommendation
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema moviesrecommendation
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `moviesrecommendation` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `moviesrecommendation` ;

-- -----------------------------------------------------
-- Table `genres`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `genres` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `genres` (
  `id` INT(11) NOT NULL,
  `genre` VARCHAR(65) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `item_review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `item_review` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `item_review` (
  `item_id` INT(11) NOT NULL AUTO_INCREMENT,
  `action` VARCHAR(15) NULL DEFAULT '0',
  `adventure` VARCHAR(45) NULL DEFAULT '0',
  `animation` VARCHAR(45) NULL DEFAULT '0',
  `childrens` VARCHAR(45) NULL DEFAULT '0',
  `comedy` VARCHAR(45) NULL DEFAULT '0',
  `crime` VARCHAR(45) NULL DEFAULT '0',
  `documentary` VARCHAR(45) NULL DEFAULT '0',
  `drama` VARCHAR(45) NULL DEFAULT '0',
  `fantasy` VARCHAR(45) NULL DEFAULT '0',
  `film_noir` VARCHAR(45) NULL DEFAULT '0',
  `horror` VARCHAR(45) NULL DEFAULT '0',
  `musical` VARCHAR(45) NULL DEFAULT '0',
  `mystery` VARCHAR(45) NULL DEFAULT '0',
  `romance` VARCHAR(45) NULL DEFAULT '0',
  `sci_fi` VARCHAR(45) NULL DEFAULT '0',
  `thriller` VARCHAR(45) NULL DEFAULT '0',
  `war` VARCHAR(45) NULL DEFAULT '0',
  `western` VARCHAR(45) NULL DEFAULT '0',
  `family` VARCHAR(45) NULL DEFAULT '0',
  `history` VARCHAR(45) NULL DEFAULT '0',
  `reality_tv` VARCHAR(45) NULL DEFAULT '0',
  `music` VARCHAR(45) NULL DEFAULT '0',
  PRIMARY KEY (`item_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1701
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `movies`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `movies` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `movies` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(500) NULL DEFAULT NULL,
  `runtime` INT(15) NULL DEFAULT NULL,
  `revenue` BIGINT(18) NULL DEFAULT NULL,
  `vote_average` DOUBLE NULL DEFAULT NULL,
  `vote_count` INT(15) NULL DEFAULT NULL,
  `popularity` DOUBLE NULL DEFAULT NULL,
  `budget` BIGINT(18) NULL DEFAULT NULL,
  `release_date` DATE NULL DEFAULT NULL,
  `tagline` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `movie_genres`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `movie_genres` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `movie_genres` (
  `movie_id` INT(11) NOT NULL,
  `genre_id` INT(11) NOT NULL,
  INDEX `fk_movie_id` (`movie_id` ASC),
  INDEX `fk_genre_id` (`genre_id` ASC),
  CONSTRAINT `fk_genre_id`
    FOREIGN KEY (`genre_id`)
    REFERENCES `genres` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movie_id`
    FOREIGN KEY (`movie_id`)
    REFERENCES `movies` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `movies_title`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `movies_title` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `movies_title` (
  `movie_id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`movie_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1694
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
