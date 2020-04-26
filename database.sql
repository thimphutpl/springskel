CREATE DATABASE  IF NOT EXISTS `dhica_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dhica_db`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: dhica_db
-- ------------------------------------------------------
-- Server version	5.5.13

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
-- Table structure for table `tbl_roles`
--

DROP TABLE IF EXISTS `tbl_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_roles` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(150) NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_roles`
--

LOCK TABLES `tbl_roles` WRITE;
/*!40000 ALTER TABLE `tbl_roles` DISABLE KEYS */;
INSERT INTO `tbl_roles` VALUES (1,'Adminstrator'),(2,'Company Manager'),(3,'Approval'),(4,'Reviewer');
/*!40000 ALTER TABLE `tbl_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_screen`
--

DROP TABLE IF EXISTS `tbl_screen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_screen` (
  `screenId` int(11) NOT NULL,
  `screenName` varchar(150) NOT NULL,
  `screenUrl` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`screenId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_screen`
--

LOCK TABLES `tbl_screen` WRITE;
/*!40000 ALTER TABLE `tbl_screen` DISABLE KEYS */;
INSERT INTO `tbl_screen` VALUES (1,'User Creation','createUser'),(2,'User Access Permission','userAccessPermission');
/*!40000 ALTER TABLE `tbl_screen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_useraccesspermission`
--

DROP TABLE IF EXISTS `tbl_useraccesspermission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_useraccesspermission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) DEFAULT NULL,
  `screenId` int(11) DEFAULT NULL,
  `isScreenAccessAllowed` bit(1) NOT NULL,
  `isEditAccessAllowed` bit(1) DEFAULT NULL,
  `isDeleteAccessAllowed` bit(1) DEFAULT NULL,
  `isSaveAccessAllowed` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_useraccesspermission`
--

LOCK TABLES `tbl_useraccesspermission` WRITE;
/*!40000 ALTER TABLE `tbl_useraccesspermission` DISABLE KEYS */;
INSERT INTO `tbl_useraccesspermission` VALUES (1,1,1,'','\0','\0','\0'),(2,1,2,'','','\0','\0'),(3,2,1,'','\0','\0','\0'),(4,2,2,'','\0','\0','\0');
/*!40000 ALTER TABLE `tbl_useraccesspermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_users`
--

DROP TABLE IF EXISTS `tbl_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_users` (
  `UserId` varchar(45) NOT NULL,
  `UserName` varchar(45) DEFAULT NULL,
  `UserMobileNo` varchar(8) DEFAULT NULL,
  `UserPassword` varchar(400) DEFAULT NULL,
  `UserCreatedDate` date DEFAULT NULL,
  `UserUpdatedDate` date DEFAULT NULL,
  `UserUpdatedBy` varchar(45) DEFAULT NULL,
  `userStatus` char(1) DEFAULT NULL,
  `userRoleTypeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_users`
--

LOCK TABLES `tbl_users` WRITE;
/*!40000 ALTER TABLE `tbl_users` DISABLE KEYS */;
INSERT INTO `tbl_users` VALUES ('admin','Administrator','111111','$2a$10$cTxvwTpevowDGyP13j1aa.mk/4QHIzJ2QRtqci8M7usW5WnP3MzQG','2018-11-15',NULL,NULL,'A',1),('Birkha','Birkha(NRDCL)',NULL,'$2a$10$OWAaYjptJOZ077EHLbEbEugjCmgCOIDukbeMaL0mzt4vQqMOuL9X.','2020-04-23',NULL,NULL,'A',2),('DorjiWangs','Dorji Wangdi(DHI)',NULL,'$2a$10$rjuYJuoNNg0jcL6srOhOauLajCkQIz4Do8HmPq.FbzuTNp5cuTPXK','2020-04-23',NULL,NULL,'A',3),('Zepa','Zepa(TTPL)',NULL,'$2a$10$WQyt7UvyDzVxZ.CsKnTJjeQUgefkx8sUEFDShkUcM7xIzytEFqXLu','2020-04-23',NULL,NULL,'A',2);
/*!40000 ALTER TABLE `tbl_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-23 19:29:26
