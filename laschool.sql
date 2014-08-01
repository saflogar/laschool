-- MySQL dump 10.13  Distrib 5.5.37, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: multiplik
-- ------------------------------------------------------
-- Server version	5.5.37-0+wheezy1

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
-- Table structure for table `lab_data`
--

DROP TABLE IF EXISTS `lab_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lab_data` (
  `labData_name_x` int(6) DEFAULT NULL,
  `labData_name_y` int(6) DEFAULT NULL,
  `labData_gra_x` int(6) DEFAULT NULL,
  `labData_gra_y` int(6) DEFAULT NULL,
  `labData_sec_x` int(6) DEFAULT NULL,
  `labData_sec_y` int(6) DEFAULT NULL,
  `labData_schy_x` int(6) DEFAULT NULL,
  `lab_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='		';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab_data`
--

LOCK TABLES `lab_data` WRITE;
/*!40000 ALTER TABLE `lab_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `lab_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab_subject`
--

DROP TABLE IF EXISTS `lab_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lab_subject` (
  `sbj_id` int(11) NOT NULL AUTO_INCREMENT,
  `sbj_x` int(10) NOT NULL,
  `sbj_y` int(10) NOT NULL,
  `sbj_name` varchar(160) DEFAULT NULL,
  PRIMARY KEY (`sbj_id`),
  UNIQUE KEY `sbj_id_UNIQUE` (`sbj_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab_subject`
--

LOCK TABLES `lab_subject` WRITE;
/*!40000 ALTER TABLE `lab_subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `lab_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `label`
--

DROP TABLE IF EXISTS `label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `label` (
  `lab_id` int(11) NOT NULL AUTO_INCREMENT,
  `lab_path` varchar(250) NOT NULL,
  `sch_id` int(11) NOT NULL,
  PRIMARY KEY (`lab_id`),
  UNIQUE KEY `lab_id_UNIQUE` (`lab_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `label`
--

LOCK TABLES `label` WRITE;
/*!40000 ALTER TABLE `label` DISABLE KEYS */;
/*!40000 ALTER TABLE `label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list`
--

DROP TABLE IF EXISTS `list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list` (
  `grade` tinyint(1) unsigned NOT NULL,
  `scholar_year` year(4) NOT NULL,
  `id_list` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_school` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_list`),
  KEY `id_school` (`id_school`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list`
--

LOCK TABLES `list` WRITE;
/*!40000 ALTER TABLE `list` DISABLE KEYS */;
/*!40000 ALTER TABLE `list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schools`
--

DROP TABLE IF EXISTS `schools`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schools` (
  `id_school` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `school_name` varchar(120) NOT NULL,
  `sch_label` varchar(150) NOT NULL,
  PRIMARY KEY (`id_school`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schools`
--

LOCK TABLES `schools` WRITE;
/*!40000 ALTER TABLE `schools` DISABLE KEYS */;
INSERT INTO `schools` VALUES (13,'Anexa Mañana','');
/*!40000 ALTER TABLE `schools` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `subject_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(100) NOT NULL,
  `list_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`subject_id`),
  KEY `list_id` (`list_id`)
) ENGINE=MyISAM AUTO_INCREMENT=74 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects_peer_label`
--

DROP TABLE IF EXISTS `subjects_peer_label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjects_peer_label` (
  `subject_id` int(10) unsigned NOT NULL,
  `list_id` int(10) unsigned NOT NULL,
  KEY `subject_id` (`subject_id`),
  KEY `list_id` (`list_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects_peer_label`
--

LOCK TABLES `subjects_peer_label` WRITE;
/*!40000 ALTER TABLE `subjects_peer_label` DISABLE KEYS */;
/*!40000 ALTER TABLE `subjects_peer_label` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-31 20:40:49
