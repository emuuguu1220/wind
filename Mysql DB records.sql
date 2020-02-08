-- MySQL dump 10.13  Distrib 8.0.19, for Linux (x86_64)
--
-- Host: localhost    Database: wind
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `barcode_id` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `location_id` bigint NOT NULL,
  `student_id` bigint NOT NULL,
  `time_slot_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9tg02nxjffw4byk5k1v7ynd5g` (`location_id`),
  KEY `FK26jv8kfowsr7rsuyn5bd8gdcc` (`student_id`),
  KEY `FKq7wkp24an3j9yaqd3t4dl43xk` (`time_slot_id`),
  CONSTRAINT `FK26jv8kfowsr7rsuyn5bd8gdcc` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK9tg02nxjffw4byk5k1v7ynd5g` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `FKq7wkp24an3j9yaqd3t4dl43xk` FOREIGN KEY (`time_slot_id`) REFERENCES `timeslot` (`abbrevation`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (1,'123128312370','2020-02-06',1,1,'PM'),(2,'123128312370','2020-02-06',1,1,'PM');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `course_id` varchar(255) DEFAULT NULL,
  `description` longtext,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'cs544','Description of Enterprise architecture','Enterprise architecture'),(2,'cs545','Description of Software Development','Software Development'),(3,'cs100','Description of cs100','about CS'),(4,'cs200','Description of cs200','about Network'),(5,'cs300','Description of cs300','about software');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_offering`
--

DROP TABLE IF EXISTS `course_offering`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `course_offering` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `course_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoodk5pyofbxvbxlupvw86p507` (`course_id`),
  CONSTRAINT `FKoodk5pyofbxvbxlupvw86p507` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_offering`
--

LOCK TABLES `course_offering` WRITE;
/*!40000 ALTER TABLE `course_offering` DISABLE KEYS */;
INSERT INTO `course_offering` VALUES (1,'2020-02-07','2020-01-11',1),(2,'2020-02-24','2020-02-10',3),(3,'2020-03-14','2020-02-28',3);
/*!40000 ALTER TABLE `course_offering` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Verrill Hall'),(2,'Dalby Hall');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `locations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `building` varchar(255) DEFAULT NULL,
  `capacity` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `location_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `room` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'Verril',50,'Class room','V32','named after Verril','32'),(2,'Verril',50,'Class room','V32','named after Verril','32'),(3,NULL,0,NULL,NULL,NULL,NULL),(4,NULL,0,NULL,NULL,NULL,NULL),(5,NULL,0,NULL,NULL,NULL,NULL),(6,NULL,0,NULL,NULL,NULL,NULL),(7,NULL,0,NULL,NULL,NULL,NULL),(9,'Verril',50,'Class room','V32','named after Verril','32'),(10,'Verril',50,'Class room','V32','named after Verril','32'),(11,'Verril',50,'Class room','V32','named after Verril','32'),(12,'Verril',50,'Class room','V32','named after Verril','32'),(13,'Verril',20,'Class room','V32','named after Verril','32'),(14,'Verril',20,'Class room','V32','named after Verril','32');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session`
--

DROP TABLE IF EXISTS `session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `session` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `course_offer_id` bigint NOT NULL,
  `time_slot_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkna42xrv09g26dwkqjmmmvnui` (`course_offer_id`),
  KEY `FK8wgms6q5q0usy2syvk2y75e4e` (`time_slot_id`),
  CONSTRAINT `FK8wgms6q5q0usy2syvk2y75e4e` FOREIGN KEY (`time_slot_id`) REFERENCES `timeslot` (`abbrevation`),
  CONSTRAINT `FKkna42xrv09g26dwkqjmmmvnui` FOREIGN KEY (`course_offer_id`) REFERENCES `course_offering` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session`
--

LOCK TABLES `session` WRITE;
/*!40000 ALTER TABLE `session` DISABLE KEYS */;
INSERT INTO `session` VALUES (1,'2020-01-11',1,'AM'),(2,'2020-01-12',1,'AM'),(3,'2020-01-13',1,'AM'),(4,'2020-01-14',1,'AM'),(5,'2020-01-15',1,'AM'),(6,'2020-01-11',3,'AM'),(7,'2020-01-12',3,'AM'),(8,'2020-01-13',3,'AM'),(9,'2020-01-14',3,'AM'),(10,'2020-01-15',3,'AM');
/*!40000 ALTER TABLE `session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course_offer`
--

DROP TABLE IF EXISTS `student_course_offer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `student_course_offer` (
  `student_id` bigint NOT NULL,
  `course_offering_id` bigint NOT NULL,
  KEY `FK66p1aku0al4d3ipresy8526ii` (`course_offering_id`),
  KEY `FK8rht07sp5m8fihs16huc1a73k` (`student_id`),
  CONSTRAINT `FK66p1aku0al4d3ipresy8526ii` FOREIGN KEY (`course_offering_id`) REFERENCES `course_offering` (`id`),
  CONSTRAINT `FK8rht07sp5m8fihs16huc1a73k` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course_offer`
--

LOCK TABLES `student_course_offer` WRITE;
/*!40000 ALTER TABLE `student_course_offer` DISABLE KEYS */;
INSERT INTO `student_course_offer` VALUES (1,1);
/*!40000 ALTER TABLE `student_course_offer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timeslot`
--

DROP TABLE IF EXISTS `timeslot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `timeslot` (
  `abbrevation` varchar(3) NOT NULL,
  `description` longtext,
  `end_time` time DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  PRIMARY KEY (`abbrevation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timeslot`
--

LOCK TABLES `timeslot` WRITE;
/*!40000 ALTER TABLE `timeslot` DISABLE KEYS */;
INSERT INTO `timeslot` VALUES ('AM','before midday','18:00:00','06:00:00'),('PM','after midday','05:59:59','18:00:01');
/*!40000 ALTER TABLE `timeslot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_type` varchar(31) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `barcode_id` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`),
  UNIQUE KEY `UK_131l8yq38dy433pmiihysj4jt` (`barcode_id`),
  UNIQUE KEY `UK_i1pkkkteed13wt581o8vanlx8` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('student',1,'metolya@miu.edu','Munkh-Erdene','Tolya','$2a$10$lavX9wzg09JPSOJcMFVrG.BZd3huuqwBMwr0SmN5LqtKhnBHSUCGa','student','123128312370','610231'),('admin',2,'admin@miu.edu','Admin','Admin','$2a$10$OqoHcpTwvss7KONfHollAOmTK1xgMszMaDX5QhdU1DqHnV2h/O41y','admin',NULL,NULL),('FACULTY',3,'gguthrie@miu.edu','Gregory','Guthrie','$2a$10$JY6hUOCTotBx8RbFOmqqseDvTF7w7OZlU.byt3ghnvm698Vx/V.WG','faculty',NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-06  6:06:15
