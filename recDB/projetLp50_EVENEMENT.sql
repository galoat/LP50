CREATE DATABASE  IF NOT EXISTS `projetLp50` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `projetLp50`;
-- MySQL dump 10.13  Distrib 5.7.9, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: projetLp50
-- ------------------------------------------------------
-- Server version	5.6.27-0ubuntu0.14.04.1

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
-- Table structure for table `EVENEMENT`
--

DROP TABLE IF EXISTS `EVENEMENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EVENEMENT` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) NOT NULL,
  `START_DATE` datetime NOT NULL,
  `HEURE_D` int(11) NOT NULL,
  `HEURE_F` int(11) NOT NULL,
  `MINUTE_D` int(11) NOT NULL,
  `MINUTE_F` int(11) NOT NULL,
  `TYPE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKA72F5A4968EA89C7` (`TYPE`),
  CONSTRAINT `FKA72F5A4968EA89C7` FOREIGN KEY (`TYPE`) REFERENCES `TYPE_E` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EVENEMENT`
--

LOCK TABLES `EVENEMENT` WRITE;
/*!40000 ALTER TABLE `EVENEMENT` DISABLE KEYS */;
INSERT INTO `EVENEMENT` VALUES (1,'Soirée mousse','Grosse ambiance','2015-01-24 00:00:00',20,21,0,0,7),(2,'Porte ouverte UTBM','Journée porte ouverte','2015-02-03 00:00:00',14,17,0,0,9),(3,'Soirée mousse2','Grosse ambiance','2015-01-24 00:00:00',20,21,0,0,8);
/*!40000 ALTER TABLE `EVENEMENT` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-25 10:05:21
