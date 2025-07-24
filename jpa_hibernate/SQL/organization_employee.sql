-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: organization
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `department_id` int DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `address_id` int DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `fk_department` (`department_id`),
  KEY `fk_address` (`address_id`),
  CONSTRAINT `fk_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_department` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `employee_chk_1` CHECK ((`salary` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'John','Doe',1,60000.00,1,'Software Engineer'),(2,'Jane','Smith',2,55000.00,2,'Sales Executive'),(3,'Alice','Johnson',3,50000.00,3,'HR Specialist'),(4,'Bob','Brown',4,62000.00,4,'Marketing Manager'),(5,'Charlie','Davis',5,58000.00,5,'Financial Analyst'),(6,'Emma','Wilson',1,61000.00,6,'Backend Developer'),(7,'Liam','Miller',2,56000.00,7,'Sales Rep'),(8,'Olivia','Anderson',3,51000.00,8,'Recruiter'),(9,'Noah','Thomas',4,63000.00,9,'Content Strategist'),(10,'Ava','Moore',5,59000.00,10,'Accountant'),(11,'Ethan','Martin',1,62000.00,1,'DevOps Engineer'),(12,'Sophia','Taylor',2,57000.00,2,'Inside Sales'),(13,'Mason','Lee',3,52000.00,3,'HR Executive'),(14,'Isabella','White',4,64000.00,4,'Digital Marketer'),(15,'Logan','Harris',5,60000.00,5,'Budget Analyst'),(16,'Lucas','Clark',1,61000.00,6,'Frontend Developer'),(17,'Mia','Lewis',2,57000.00,7,'Sales Coordinator'),(18,'Jacob','Walker',3,53000.00,8,'HR Coordinator'),(19,'Amelia','Hall',4,65000.00,9,'SEO Specialist'),(20,'Elijah','Allen',5,61000.00,10,'Auditor'),(27,'Lokesh','Pathak',1,10000.00,14,'Developer'),(28,'Rohan','Jain',14,10000.00,15,'Manager');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-24 15:02:39
