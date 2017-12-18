
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

/*Table structure for table `real_time_feedback` */

DROP TABLE IF EXISTS `real_time_feedback`;

CREATE TABLE `real_time_feedback` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `rating` VARCHAR(45) NULL DEFAULT NULL,
  `comments` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;
