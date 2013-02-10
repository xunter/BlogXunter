CREATE DATABASE `blogxunter` /*!40100 DEFAULT CHARACTER SET latin1 */;

DROP TABLE IF EXISTS `blogxunter`.`articles`;
CREATE TABLE  `blogxunter`.`articles` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dateTime` datetime NOT NULL,
  `author` varchar(45) CHARACTER SET latin1 NOT NULL,
  `text` text CHARACTER SET latin1 NOT NULL,
  `title` varchar(100) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `blogxunter`.`comments`;
CREATE TABLE  `blogxunter`.`comments` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idRoot` int(10) NOT NULL,
  `idArticle` int(10) unsigned NOT NULL,
  `author` varchar(50) CHARACTER SET latin1 NOT NULL,
  `dateTime` datetime NOT NULL,
  `text` text CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_comments_idArticle` (`idArticle`),
  CONSTRAINT `FK_comments_idArticle` FOREIGN KEY (`idArticle`) REFERENCES `articles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
