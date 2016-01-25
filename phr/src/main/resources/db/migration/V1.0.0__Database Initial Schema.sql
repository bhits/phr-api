CREATE DATABASE  IF NOT EXISTS `phr` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `phr`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: phr
-- ------------------------------------------------------
-- Server version	5.6.14-log

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
-- Table structure for table `address_use_code`
--

DROP TABLE IF EXISTS `address_use_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address_use_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(250) NOT NULL,
  `code_system` varchar(250) DEFAULT NULL,
  `code_system_name` varchar(250) NOT NULL,
  `display_name` varchar(250) NOT NULL,
  `originalText` varchar(250) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_use_code`
--

LOCK TABLES `address_use_code` WRITE;
/*!40000 ALTER TABLE `address_use_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `address_use_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrative_gender_code`
--

DROP TABLE IF EXISTS `administrative_gender_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrative_gender_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(250) NOT NULL,
  `code_system` varchar(250) DEFAULT NULL,
  `code_system_name` varchar(250) NOT NULL,
  `display_name` varchar(250) NOT NULL,
  `originalText` varchar(250) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrative_gender_code`
--

LOCK TABLES `administrative_gender_code` WRITE;
/*!40000 ALTER TABLE `administrative_gender_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrative_gender_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country_code`
--

DROP TABLE IF EXISTS `country_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(250) NOT NULL,
  `code_system` varchar(250) DEFAULT NULL,
  `code_system_name` varchar(250) NOT NULL,
  `display_name` varchar(250) NOT NULL,
  `originalText` varchar(250) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country_code`
--

LOCK TABLES `country_code` WRITE;
/*!40000 ALTER TABLE `country_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `country_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `street_address_line` varchar(255) DEFAULT NULL,
  `birth_day` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `socialSecurityNumber` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `addressUseCode` bigint(20) DEFAULT NULL,
  `countryCode` bigint(20) DEFAULT NULL,
  `stateCode` bigint(20) DEFAULT NULL,
  `administrativeGenderCode` bigint(20) DEFAULT NULL,
  `telecomUseCode` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_lbh8hbceyrre0pfipl92ii1wt` (`addressUseCode`),
  KEY `FK_jwhgsp1eis0aojql368la2xvi` (`countryCode`),
  KEY `FK_fmxslsh56nc572uxg7oifk0ib` (`stateCode`),
  KEY `FK_8sfvh85lrg919dnvj9iqhh986` (`administrativeGenderCode`),
  KEY `FK_n25syp9n9i4ywios3imhyf1ga` (`telecomUseCode`),
  CONSTRAINT `FK_n25syp9n9i4ywios3imhyf1ga` FOREIGN KEY (`telecomUseCode`) REFERENCES `telecom_use_code` (`id`),
  CONSTRAINT `FK_8sfvh85lrg919dnvj9iqhh986` FOREIGN KEY (`administrativeGenderCode`) REFERENCES `administrative_gender_code` (`id`),
  CONSTRAINT `FK_fmxslsh56nc572uxg7oifk0ib` FOREIGN KEY (`stateCode`) REFERENCES `state_code` (`id`),
  CONSTRAINT `FK_jwhgsp1eis0aojql368la2xvi` FOREIGN KEY (`countryCode`) REFERENCES `country_code` (`id`),
  CONSTRAINT `FK_lbh8hbceyrre0pfipl92ii1wt` FOREIGN KEY (`addressUseCode`) REFERENCES `address_use_code` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_audit`
--

DROP TABLE IF EXISTS `patient_audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient_audit` (
  `id` bigint(20) NOT NULL,
  `REV` int(11) NOT NULL,
  `REVTYPE` tinyint(4) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `street_address_line` varchar(255) DEFAULT NULL,
  `birth_day` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `socialSecurityNumber` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `addressUseCode` bigint(20) DEFAULT NULL,
  `countryCode` bigint(20) DEFAULT NULL,
  `stateCode` bigint(20) DEFAULT NULL,
  `administrativeGenderCode` bigint(20) DEFAULT NULL,
  `telecomUseCode` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FK_ahxtfw2b36s4wuro530bvkxro` (`REV`),
  CONSTRAINT `FK_ahxtfw2b36s4wuro530bvkxro` FOREIGN KEY (`REV`) REFERENCES `revinfo` (`REV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_audit`
--

LOCK TABLES `patient_audit` WRITE;
/*!40000 ALTER TABLE `patient_audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient_audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revinfo`
--

DROP TABLE IF EXISTS `revinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `revinfo` (
  `REV` int(11) NOT NULL AUTO_INCREMENT,
  `REVTSTMP` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`REV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revinfo`
--

LOCK TABLES `revinfo` WRITE;
/*!40000 ALTER TABLE `revinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `revinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state_code`
--

DROP TABLE IF EXISTS `state_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(250) NOT NULL,
  `code_system` varchar(250) DEFAULT NULL,
  `code_system_name` varchar(250) NOT NULL,
  `display_name` varchar(250) NOT NULL,
  `originalText` varchar(250) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_code`
--

LOCK TABLES `state_code` WRITE;
/*!40000 ALTER TABLE `state_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `state_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telecom_use_code`
--

DROP TABLE IF EXISTS `telecom_use_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telecom_use_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(250) NOT NULL,
  `code_system` varchar(250) DEFAULT NULL,
  `code_system_name` varchar(250) NOT NULL,
  `display_name` varchar(250) NOT NULL,
  `originalText` varchar(250) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telecom_use_code`
--

LOCK TABLES `telecom_use_code` WRITE;
/*!40000 ALTER TABLE `telecom_use_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `telecom_use_code` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-17 15:01:56
