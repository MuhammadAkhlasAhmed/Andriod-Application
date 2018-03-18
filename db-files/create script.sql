/*
SQLyog Enterprise Trial - MySQL GUI v7.11 
MySQL - 5.7.17-log : Database - moviesrecommendation
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`moviesrecommendation` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `moviesrecommendation`;

/*Table structure for table `movies` */

DROP TABLE IF EXISTS `movies`;

CREATE TABLE `movies` (
  `id` INT NOT NULL,
  `name` VARCHAR(500) NULL DEFAULT NULL,
  `runtime` INT(15) NULL DEFAULT NULL,
  `revenue` BIGINT(18) NULL DEFAULT NULL,
  `vote_average` DOUBLE NULL DEFAULT NULL,
  `vote_count` INT(15) NULL DEFAULT NULL,
  `popularity` DOUBLE NULL DEFAULT NULL,
  `budget` BIGINT(18) NULL DEFAULT NULL,
  `release_date` DATE NULL DEFAULT NULL,
  `tagline` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `genres` */

DROP TABLE IF EXISTS `genres`;

CREATE TABLE `genres` (
  `id` INT NOT NULL,
  `genre` VARCHAR(65) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `movie_genres` */

DROP TABLE IF EXISTS `movie_genres`;

CREATE TABLE `movie_genres` (
  `movie_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL,
  CONSTRAINT `fk_movie_id` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_genre_id` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `item_review` */

DROP TABLE IF EXISTS `item_review`;

CREATE TABLE `item_review`(
  `item_id` INT(11) NOT NULL AUTO_INCREMENT, 
  `action` VARCHAR(15) NULL DEFAULT 0 ,
  `adventure` VARCHAR(45) NULL DEFAULT 0 ,
  `animation` VARCHAR(45) NULL DEFAULT 0 ,
  `childrens` VARCHAR(45) NULL DEFAULT 0 ,
  `comedy` VARCHAR(45) NULL DEFAULT 0 ,
  `crime` VARCHAR(45) NULL DEFAULT 0 ,
  `documentary` VARCHAR(45) NULL DEFAULT 0 ,
  `drama` VARCHAR(45) NULL DEFAULT 0 ,
  `fantasy` VARCHAR(45) NULL DEFAULT 0 ,
  `film_noir` VARCHAR(45) NULL DEFAULT 0 ,
  `horror` VARCHAR(45) NULL DEFAULT 0 ,
  `musical` VARCHAR(45) NULL DEFAULT 0 ,
  `mystery` VARCHAR(45) NULL DEFAULT 0 ,
  `romance` VARCHAR(45) NULL DEFAULT 0 ,
  `sci_fi` VARCHAR(45) NULL DEFAULT 0 ,
  `thriller` VARCHAR(45) NULL DEFAULT 0 ,
  `war` VARCHAR(45) NULL DEFAULT 0 ,
  `western` VARCHAR(45) NULL DEFAULT 0 ,
  `family` VARCHAR(45) NULL DEFAULT 0 ,
  `history` VARCHAR(45) NULL DEFAULT 0 ,
  `reality_tv` VARCHAR(45) NULL DEFAULT 0 ,
  `music` VARCHAR(45) NULL DEFAULT 0 ,
   PRIMARY KEY (`item_id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `movies_title` */

DROP TABLE IF EXISTS `movies_title`;
   
CREATE TABLE `movies_title`(
  `movie_id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(500) NULL DEFAULT NULL,
     PRIMARY KEY (`movie_id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	 
	 
   
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;
