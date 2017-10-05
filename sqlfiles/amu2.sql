/*
SQLyog Community Edition- MySQL GUI v8.2 
MySQL - 5.1.52-community : Database - amu_patient_app
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`amu_patient_app` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

/*Table structure for table `contactinfo` */

DROP TABLE IF EXISTS `contactinfo`;

CREATE TABLE `contactinfo` (
  `contact_info_id` varchar(20) COLLATE utf8_bin NOT NULL,
  `contact_reference` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `phoneno` varchar(20) COLLATE utf8_bin NOT NULL,
  `street` varchar(100) COLLATE utf8_bin NOT NULL,
  `city` varchar(100) COLLATE utf8_bin NOT NULL,
  `province` varchar(50) COLLATE utf8_bin NOT NULL,
  `country` varchar(20) COLLATE utf8_bin NOT NULL,
  `zipcode` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`contact_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `contactinfo` */

LOCK TABLES `contactinfo` WRITE;

insert  into `contactinfo`(`contact_info_id`,`contact_reference`,`phoneno`,`street`,`city`,`province`,`country`,`zipcode`) values ('ADD000AQNSARRV','PAT000OEALIXH','9848626441','abcd','abc','','Canada','256444'),('ADD000EWIEQE','DOC000AAGRACQW','9848626441','sdg','sd','Quebec','Canada','sdg'),('ADD000FDMRVT','DOC000CLQAFV','9848626441','abcd','abc','Quebec','Canada','256444'),('ADD000FKXAAWLY','PAT000AEZIBXMW','asd','sdf','asf','Alberta','Canada','asdf'),('ADD000HMIG','PAT000ZJNKMB','asf','asf','saf','Ontario','Canada','asf'),('ADD000TVBC','DOC000BLNBESP','sf','sdf','sf','Quebec','Canada','sf'),('ADD000XBSL','DOC000WUDFIT','9848626441','asf','asf','Alberta','Canada','asf'),('ADD000YN','DOC000BRMAXYR','sf','sdf','sf','Quebec','Canada','sf');

UNLOCK TABLES;

/*Table structure for table `doc` */

DROP TABLE IF EXISTS `doc`;

CREATE TABLE `doc` (
  `docid` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `doc_registrationId` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `docname` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `docorg` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `doc_clinic_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `doc_address` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `pass` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `doc` */

LOCK TABLES `doc` WRITE;

insert  into `doc`(`docid`,`doc_registrationId`,`docname`,`docorg`,`doc_clinic_name`,`doc_address`,`pass`,`email`) values ('DOC000BLNBESP','sfd','sf','ssdfs','sfds','sf','test','raghu@gmail.com');

UNLOCK TABLES;

/*Table structure for table `patient` */

DROP TABLE IF EXISTS `patient`;

CREATE TABLE `patient` (
  `patid` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `docid` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `patient_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `emergcon` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `patcondn` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `gender` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `age` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `cont_info_id` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `pass` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `patient` */

LOCK TABLES `patient` WRITE;

insert  into `patient`(`patid`,`docid`,`patient_name`,`emergcon`,`patcondn`,`gender`,`age`,`cont_info_id`,`email`,`pass`) values ('PAT000AEZIBXMW','DOC000BLNBESP','asdf','','','','','','raghu@gmail.com','raghu');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
