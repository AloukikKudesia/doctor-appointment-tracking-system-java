-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: doctorappointment_db
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `doctor_details`
--

DROP TABLE IF EXISTS `doctor_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor_details` (
  `DoctorId` varchar(45) NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  `MiddleName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `Address` varchar(60) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `PhoneNumber` varchar(10) NOT NULL,
  `Days` varchar(45) NOT NULL,
  `Timing` varchar(45) NOT NULL,
  `Qualification` varchar(45) NOT NULL,
  `Field` varchar(100) NOT NULL,
  `Experience` varchar(20) NOT NULL,
  PRIMARY KEY (`DoctorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_details`
--

LOCK TABLES `doctor_details` WRITE;
/*!40000 ALTER TABLE `doctor_details` DISABLE KEYS */;
INSERT INTO `doctor_details` VALUES ('27596','Vishal','','Singh','8,Amausi,Lucknow','vishalsingh@gmail.com','M','9198641804','Tuesday,Thursday,Saturday,','10am-3pm','BPT','Physiotherapist','11'),('69572','Sudhir','','Kumar','2/111,Charbagh,Lucknow','kumarsudhir@gmail.com','M','7754942777','Monday,Tuesday,Wednesday,Thursday,Friday,','10am-4pm','MBBS,MS','Gastroenterologist','12'),('71101','Aloy','','Majumdar','3,Vibhuthi Khand,Lucknow','aloymajumdar@gmail.com','M','7052670569','Tuesday,Wednesday,Thursday,Friday,Saturday,','9am-7pm','MBBS,MS','Opthalmologist','22'),('87669','Vivek','','Singh','9,Aliganj,Lucknow','vivek@gmail.com','M','8299153598','Thursday,Friday,Saturday,','10am-6pm','MD','Medicine','16'),('97192','Sambhavi','','Srivastav','7/289,TriveniNagar,Lucknow','sambhavi24@gmail.com','F','9451350714','Wednesday,Saturday,Sunday,','5pm-9pm','MBBS,BDS','Dentist','13');
/*!40000 ALTER TABLE `doctor_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_details`
--

DROP TABLE IF EXISTS `patient_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_details` (
  `Serial_Number` int NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `AppointmentDate` date NOT NULL,
  `AppointmentNo` varchar(45) NOT NULL,
  `DoctorId` varchar(45) NOT NULL,
  `PatientName` varchar(30) NOT NULL,
  `Age` varchar(3) NOT NULL,
  `PhoneNumber` varchar(10) NOT NULL,
  `Problem` varchar(255) NOT NULL,
  `AppointmentMode` varchar(20) NOT NULL,
  `PatientVisitStatus` varchar(6) NOT NULL,
  PRIMARY KEY (`Serial_Number`,`AppointmentNo`),
  KEY `DoctorId_HK_idx` (`DoctorId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_details`
--

LOCK TABLES `patient_details` WRITE;
/*!40000 ALTER TABLE `patient_details` DISABLE KEYS */;
INSERT INTO `patient_details` VALUES (1,'2023-08-24','2023-07-28','8','69572','AjeetKumar','31','9899157231','StomachInfection','Phone','Yes'),(2,'2023-08-24','2023-08-06','2','97192','Shubham','29','8604636577','CavityInTeeth','Manual','Yes'),(3,'2023-08-24','2023-07-04','11','27596','Harshita','32','7007432199','ShoulderPain','Phone','Yes'),(4,'2023-08-24','2023-08-10','5','87669','AishwaryPratapSingh','21','7007107653','Typhoid','Manual','No');
/*!40000 ALTER TABLE `patient_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_feedback`
--

DROP TABLE IF EXISTS `patient_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_feedback` (
  `Serialno` int NOT NULL AUTO_INCREMENT,
  `Patient_name` varchar(45) NOT NULL,
  `Patient_phone` varchar(10) NOT NULL,
  `DoctorName` varchar(45) NOT NULL,
  `Feedback` varchar(255) NOT NULL,
  `Ratings` varchar(10) NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`Serialno`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_feedback`
--

LOCK TABLES `patient_feedback` WRITE;
/*!40000 ALTER TABLE `patient_feedback` DISABLE KEYS */;
INSERT INTO `patient_feedback` VALUES (1,'Harshita','7007432199','Vishal Singh','Very Good Doctor','4','2023-08-24'),(2,'Shubham','8604636577','Sambhavi Srivastav','she give sufficient time to each patient in her clinic','5','2023-08-24');
/*!40000 ALTER TABLE `patient_feedback` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-25 10:19:46
