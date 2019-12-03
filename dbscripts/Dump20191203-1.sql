-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: smartshop
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `pr_details`
--

DROP TABLE IF EXISTS `pr_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pr_details` (
  `pr_id` int(11) NOT NULL AUTO_INCREMENT,
  `pr_code` varchar(50) NOT NULL,
  `pr_quantity` int(11) NOT NULL,
  `pr_pur_id` int(3) NOT NULL,
  PRIMARY KEY (`pr_id`),
  KEY `fk_purchase_id_idx` (`pr_pur_id`),
  KEY `fk_product_code` (`pr_code`),
  CONSTRAINT `fk_product_code` FOREIGN KEY (`pr_code`) REFERENCES `products` (`Product_Code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_id` FOREIGN KEY (`pr_pur_id`) REFERENCES `purchase` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pr_details`
--

LOCK TABLES `pr_details` WRITE;
/*!40000 ALTER TABLE `pr_details` DISABLE KEYS */;
INSERT INTO `pr_details` VALUES (15,'01',1,17),(16,'02',2,17),(17,'02',3,18),(18,'01',7,18),(19,'01',1,19);
/*!40000 ALTER TABLE `pr_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `Product_Code` varchar(50) NOT NULL,
  `Product_Name` varchar(50) DEFAULT NULL,
  `Product_Type` varchar(10) DEFAULT NULL,
  `Brand` varchar(50) DEFAULT NULL,
  `Quantity_type` varchar(10) DEFAULT NULL,
  `Rate_per_Quantity` varchar(15) DEFAULT NULL,
  `Stock_count` varchar(15) DEFAULT NULL,
  `Add_date` date DEFAULT NULL,
  `Aisle` varchar(15) DEFAULT NULL,
  `Shelf` varchar(15) DEFAULT NULL,
  `Date_of_manufacture` date DEFAULT NULL,
  `Date_of_expiry` date DEFAULT NULL,
  `Product_Image` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Product_Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('01','Milk','Food','Mother Dairy','Litre','50.50','10','2020-11-23','1','A','2020-01-01','2020-01-03','https://images.unsplash.com/photo-1559598467-f8b76c8155d0'),('02','Noodles','Food','Maggi','Pack','60.00','20','2020-11-23','1','B','2020-01-01','2020-01-12','https://images.unsplash.com/photo-1551183053-bf91a1d81141'),('11','Biscuits','Snacks','Goodday','Pack','20.00','11','2020-11-23','3','C','2019-01-08','2020-01-02','https://images.unsplash.com/photo-1548365328-8c6db3220e4c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80'),('12','Chips','Snacks','Lays','Pack','10.00','23','2020-11-23','3','A','2019-01-08','2021-01-01','https://images.unsplash.com/photo-1555965708-54e82207ba97'),('31','Soap','Cosmetics','Dove','Pack','35.00','56','2020-11-23','2','AC','2019-01-08','2020-01-03','https://images.unsplash.com/photo-1558616180-d76238959a2e');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(3) NOT NULL,
  `total` int(11) DEFAULT NULL,
  `rewards` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_id_idx` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` VALUES (17,7,170,34,'2019-11-30'),(18,7,533,106,'2019-11-30'),(19,7,50,10,'2019-12-02');
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(3) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `contact` varchar(10) DEFAULT NULL,
  `username` varchar(15) DEFAULT NULL,
  `password` varchar(150) DEFAULT NULL,
  `user_type` varchar(1) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  `question1` varchar(50) DEFAULT NULL,
  `question2` varchar(50) DEFAULT NULL,
  `question3` varchar(50) DEFAULT NULL,
  `answer1` varchar(50) DEFAULT NULL,
  `answer2` varchar(50) DEFAULT NULL,
  `answer3` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Shubham','Kumar',22,'Male','9090909090','Super','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','S','A','Who is this?','Who is this?','Who is this?','Someone','Noone','You'),(2,'Soap','McTavish',31,'Male','2020202020','User','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','U','A','Who is this?','Who is this?','Who is this?','Someone','Noone','You'),(3,'Capt.','Price',40,'Male','1010101010','Admin','$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK','A','A','Who is this?','Who is this?','Who is this?','Someone','Noone','You is updated'),(6,'Test','Admin',12,'Male','8080808080','Admin1','$2a$10$iA9NLRHqGuhJ9Nu1s0NAgu9s9hobQerdXUFZeh/ax8ICH8fhjMnZG','A','A','test','quest','test','answer','test','ans'),(7,'Vijay','Adithya',22,'Male','1234567890','User1','$2a$10$q6ZdAMVM2uKTLRoe9V0Fce3TX.Rpmfa2MAZ1U6W8d419KxAbnpKGu','U','A','What is what?','what is not','not?','what','not','no'),(8,'Jack','Doe',22,'Male','0123459876','Admin3','$2a$10$lftlaprSpZ6mCYt0KZ3MwePynhqXRwxcVojdM7P11wQDhnpGgGlNy','A','P','Okay','Okay','Okay','Google','Google','Google'),(9,'Elon','Tusk',35,'Male','0123459876','Admin4','$2a$10$OT8OkURZHyTkp3AjIdvr0OyYgQ3fBi.H8Z3C15JlJ4gorjqRLLRdq','A','P','Okay','Okay','Okay','Google','Google','Google'),(10,'Senior','Junior',99,'Male','0123459876','Admin5','$2a$10$3PMyHdWcCpiARUxNRylzBOUV/jiAqpkLVsCd6KF7gBLuCUuDpwpDK','A','P','Okay','Okay','Okay','Google','Google','Google'),(34,'a','a',11,'Male','1234567890','aaa','$2a$10$WNILHhTJc0y/CNOPhLLtQ.gAjfitWQkxg18mDPvsYsgark/WvOQEa','U','A','1','1','1','1','1','1'),(35,'Ashley','Cole',10,'Male','1111111111','TestUser','pwd','U','A','Who?','How?','When?','Him','IDK','Now');
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

-- Dump completed on 2019-12-03 12:57:15
