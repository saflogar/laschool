-- MySQL dump 10.13  Distrib 5.5.37, for debian-linux-gnu (i686)
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
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list`
--

LOCK TABLES `list` WRITE;
/*!40000 ALTER TABLE `list` DISABLE KEYS */;
INSERT INTO `list` VALUES (1,2014,17,13);
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
) ENGINE=MyISAM AUTO_INCREMENT=69 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (6,'                     Español',12),(7,'                    Matemáticas',12),(8,'                       Geografía',12),(9,'',12),(10,'',12),(11,'',12),(12,'                    Español',13),(13,'                      Matemáticas',14),(14,'                     Español',14),(15,'                    Geografìa',14),(16,'                Ciencias Naturales',14),(17,'                                  Ciencias Naturales',14),(18,'                Ciencias Naturales',14),(19,'                Ciencias Naturales',14),(20,'                Ciencias Naturales',14),(21,'                Ciencias Naturales',14),(22,'                Ciencias Naturales',14),(23,'                Ciencias Naturales           ',14),(24,'                Ciencias Naturales',14),(25,'                      Español',15),(26,'                  Matemáticas',15),(27,'                      Español',15),(28,'                      Español',15),(29,'                      Español',15),(30,'                      Español',15),(31,'                      Español',15),(32,'                      Español',15),(33,'                      Español',15),(34,'                      Español',15),(35,'                      Español',15),(36,'                      Español',15),(37,'                    Matemáticas',16),(38,'                    Español',16),(39,'                     Geografìa',16),(40,'                Ciencias Naturales',16),(41,'             Formaciòn Civica y Ética',16),(42,'              Formaciòn Civica y Ética',16),(43,'             Formaciòn Civica y Ética',16),(44,'             Formaciòn Civica y Ética',16),(45,'             Formaciòn Civica y Ética',16),(46,'             Formaciòn Civica y Ética',16),(47,'             Formaciòn Civica y Ética',16),(48,'             Formaciòn Civica y Ética',16),(49,'             Formaciòn Civica y Ética',16),(50,'             Formaciòn Civica y Ética',16),(51,'             Formaciòn Civica y Ética',16),(52,'             Formaciòn Civica y Ética',16),(53,'                     Español',17),(54,'                     Español',17),(55,'                     Español',17),(56,'                     Español',17),(57,'                     Español',17),(58,'                     Español',17),(59,'                     Español',17),(60,'                     Español',17),(61,'                     Español',17),(62,'                     Español',17),(63,'                     Español',17),(64,'                     Español',17),(65,'                     Español',17),(66,'                     Español',17),(67,'                     Español',17),(68,'                     Español',17);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjects` (
  `subject_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(120) NOT NULL,
  `subject_cor_x` int(10) NOT NULL,
  `subject_cor_y` int(10) unsigned NOT NULL,
  `subject_size` int(10) unsigned NOT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects_peer_list`
--

DROP TABLE IF EXISTS `subjects_peer_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjects_peer_list` (
  `subject_id` int(10) unsigned NOT NULL,
  `list_id` int(10) unsigned NOT NULL,
  KEY `subject_id` (`subject_id`),
  KEY `list_id` (`list_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects_peer_list`
--

LOCK TABLES `subjects_peer_list` WRITE;
/*!40000 ALTER TABLE `subjects_peer_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `subjects_peer_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-30 14:33:33
