CREATE DATABASE  IF NOT EXISTS `semi_project` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `semi_project`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: semi_project
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answers` (
  `ANSWER_UID` varchar(200) NOT NULL COMMENT '답항 UID',
  `ANSWER` varchar(200) NOT NULL COMMENT '답항',
  PRIMARY KEY (`ANSWER_UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='설문 답항';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
INSERT INTO `answers` VALUES ('1','전혀 아니다'),('2','아니다'),('3','보통이다'),('4','그렇다'),('5','매우 그렇다');
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participants`
--

DROP TABLE IF EXISTS `participants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participants` (
  `PARTICIPANTS_UID` varchar(200) NOT NULL COMMENT '참여자 UID',
  `NAME` varchar(200) NOT NULL COMMENT '이름',
  PRIMARY KEY (`PARTICIPANTS_UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='참여자';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participants`
--

LOCK TABLES `participants` WRITE;
/*!40000 ALTER TABLE `participants` DISABLE KEYS */;
INSERT INTO `participants` VALUES ('1','박병주'),('2','윤선아');
/*!40000 ALTER TABLE `participants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `QUESTIONS_UID` varchar(200) NOT NULL COMMENT '문항 UID',
  `CONTENTS` varchar(200) NOT NULL COMMENT '문항 내용',
  PRIMARY KEY (`QUESTIONS_UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='설문 문항';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES ('1','현재 구독중인 OTT 에서 제공하는 컨텐츠는 만족하는가'),('2','OTT에서 추천해주는 컨텐츠는 만족하는가'),('3','업로드 주기는 적당하다고 생각하는가'),('4','현재 OTT에서 제공하고 있는 자막 제공 서비스에 만족 하는가'),('5','이용중인 구독료는 적당하다고 생각하는가'),('6','향후 구독을 계속 유지할 생각이 있는가'),('7','지인에게 해당 서비스를 추천할 의향이 있는가');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions_answers`
--

DROP TABLE IF EXISTS `questions_answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions_answers` (
  `ANSWER_UID` varchar(200) NOT NULL COMMENT '답항 UID',
  `QUESTIONS_UID` varchar(200) NOT NULL COMMENT '문항 UID',
  PRIMARY KEY (`ANSWER_UID`,`QUESTIONS_UID`),
  KEY `FK_QUESTIONS_TO_QUESTIONS_ANSWERS` (`QUESTIONS_UID`),
  CONSTRAINT `FK_ANSWERS_TO_QUESTIONS_ANSWERS` FOREIGN KEY (`ANSWER_UID`) REFERENCES `answers` (`ANSWER_UID`),
  CONSTRAINT `FK_QUESTIONS_TO_QUESTIONS_ANSWERS` FOREIGN KEY (`QUESTIONS_UID`) REFERENCES `questions` (`QUESTIONS_UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions_answers`
--

LOCK TABLES `questions_answers` WRITE;
/*!40000 ALTER TABLE `questions_answers` DISABLE KEYS */;
INSERT INTO `questions_answers` VALUES ('1','1'),('2','1'),('3','1'),('4','1'),('5','1'),('1','2'),('2','2'),('3','2'),('4','2'),('5','2'),('1','3'),('2','3'),('3','3'),('4','3'),('5','3'),('1','4'),('2','4'),('3','4'),('4','4'),('5','4'),('1','5'),('2','5'),('3','5'),('4','5'),('5','5'),('1','6'),('2','6'),('3','6'),('4','6'),('5','6'),('1','7'),('2','7'),('3','7'),('4','7'),('5','7');
/*!40000 ALTER TABLE `questions_answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `result` (
  `PARTICIPANTS_UID` varchar(200) NOT NULL COMMENT '참여자 UID',
  `ANSWER_UID` varchar(200) NOT NULL COMMENT '답항 UID',
  `QUESTIONS_UID` varchar(200) NOT NULL COMMENT '문항 UID',
  PRIMARY KEY (`PARTICIPANTS_UID`,`QUESTIONS_UID`),
  KEY `FK_ANSWERS_TO_RESULT` (`ANSWER_UID`),
  KEY `FK_QUESTIONS_TO_RESULT` (`QUESTIONS_UID`),
  CONSTRAINT `FK_ANSWERS_TO_RESULT` FOREIGN KEY (`ANSWER_UID`) REFERENCES `answers` (`ANSWER_UID`),
  CONSTRAINT `FK_PARTICIPANTS_TO_RESULT` FOREIGN KEY (`PARTICIPANTS_UID`) REFERENCES `participants` (`PARTICIPANTS_UID`),
  CONSTRAINT `FK_QUESTIONS_TO_RESULT` FOREIGN KEY (`QUESTIONS_UID`) REFERENCES `questions` (`QUESTIONS_UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='설문 결과';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES ('1','1','1'),('2','1','7'),('1','2','6'),('2','2','1'),('2','2','6'),('1','3','2'),('1','3','3'),('2','3','2'),('2','3','5'),('1','4','4'),('1','4','7'),('2','4','3'),('1','5','5'),('2','5','4');
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'semi_project'
--

--
-- Dumping routines for database 'semi_project'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-25 11:17:43
