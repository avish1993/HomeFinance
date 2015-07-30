-- MySQL dump 10.13  Distrib 5.6.19, for Win32 (x86)
--
-- Host: localhost    Database: thomas_home_finance
-- ------------------------------------------------------
-- Server version	5.6.19

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
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch` (
  `slno` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `bname` varchar(35) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `zip` int(7) DEFAULT NULL,
  `manager_name` varchar(35) NOT NULL,
  `phno` varchar(12) DEFAULT NULL,
  `password` varchar(33) NOT NULL,
  PRIMARY KEY (`slno`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'thmum01','Mangal Branch','Mumbai','Maharashtra',400096,'Stannis Baratheon','8090506371',''),(2,'thkol01','Garia Branch','Kolkata','West Bengal',700080,'Tywin Lanister','9080506325','');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `slno` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(10) NOT NULL,
  `name` varchar(35) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `password` varchar(33) NOT NULL,
  `annual_income` decimal(10,0) DEFAULT NULL,
  `phno` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`slno`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (14,'9738d','Nil',21,'329hgcghvgh ygvh','8d4f5191c7dc52e52a7ade3a33542152',12000,'8961458169');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan`
--

DROP TABLE IF EXISTS `loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loan` (
  `slno` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(6) DEFAULT NULL,
  `ref_no` varchar(10) DEFAULT NULL,
  `loan_type` varchar(50) DEFAULT NULL,
  `loan_amount` decimal(10,0) DEFAULT NULL,
  `loan_period` int(10) unsigned NOT NULL DEFAULT '1',
  `loan_code` varchar(10) DEFAULT NULL,
  `sales_rep_id` varchar(10) DEFAULT NULL,
  `annual_income` decimal(10,0) DEFAULT NULL,
  `other_income` decimal(10,0) DEFAULT NULL,
  `down_payment` decimal(10,0) DEFAULT NULL,
  `emi` decimal(20,0) DEFAULT NULL,
  `interest_rate` decimal(5,0) DEFAULT NULL,
  `property_address` varchar(80) DEFAULT NULL,
  `loan_status` tinyint(1) NOT NULL DEFAULT '0',
  `open_date` date DEFAULT NULL,
  `close_date` date DEFAULT NULL,
  PRIMARY KEY (`slno`),
  UNIQUE KEY `ref_no` (`ref_no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan`
--

LOCK TABLES `loan` WRITE;
/*!40000 ALTER TABLE `loan` DISABLE KEYS */;
INSERT INTO `loan` VALUES (2,'9738d','973Lp041','Extension of preowned property',981154,5,'Lp04','sr01',6565,652,8411,18108,4,'gfxvhgvhvhgv\nblah blah',0,'2015-03-01','2014-07-17'),(4,'9738d','973Lp023','Construction of property on preowned land',1500,2,'Lp02','sr01',12,1,3,66,6,'djkvbdkv\ndbvkdb\njdvk',0,'2015-05-11','2014-07-17');
/*!40000 ALTER TABLE `loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_rep`
--

DROP TABLE IF EXISTS `sales_rep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales_rep` (
  `slno` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(10) NOT NULL,
  `name` varchar(35) NOT NULL,
  `password` varchar(33) DEFAULT NULL,
  PRIMARY KEY (`slno`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_rep`
--

LOCK TABLES `sales_rep` WRITE;
/*!40000 ALTER TABLE `sales_rep` DISABLE KEYS */;
INSERT INTO `sales_rep` VALUES (1,'sr01','John Snow','snowjohn'),(2,'sr02','Rob Stark','starkrob'),(3,'sr03','Edard Stark','starkedard');
/*!40000 ALTER TABLE `sales_rep` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-20 21:24:48
