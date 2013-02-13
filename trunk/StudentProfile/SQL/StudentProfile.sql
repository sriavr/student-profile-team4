-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.8 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL version:             7.0.0.4053
-- Date/time:                    2013-01-28 16:07:43
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping database structure for studentprofile
DROP DATABASE IF EXISTS `studentprofile`;
CREATE DATABASE IF NOT EXISTS `studentprofile` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `studentprofile`;


-- Dumping structure for table studentprofile.anouncements
DROP TABLE IF EXISTS `anouncements`;
CREATE TABLE IF NOT EXISTS `anouncements` (
  `anoID` int(10) NOT NULL AUTO_INCREMENT,
  `anoName` varchar(50) NOT NULL,
  PRIMARY KEY (`anoID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table studentprofile.anouncements: ~0 rows (approximately)
DELETE FROM `anouncements`;
/*!40000 ALTER TABLE `anouncements` DISABLE KEYS */;
INSERT INTO `anouncements` (`anoID`, `anoName`) VALUES
	(1, '20 days Holidays'),
	(2, 'Project Completed');
/*!40000 ALTER TABLE `anouncements` ENABLE KEYS */;


-- Dumping structure for table studentprofile.enrollment
DROP TABLE IF EXISTS `enrollment`;
CREATE TABLE IF NOT EXISTS `enrollment` (
  `enrID` int(10) NOT NULL AUTO_INCREMENT,
  `subID` int(10) NOT NULL,
  `stuID` int(10) NOT NULL,
  `enrGrade` varchar(5) NOT NULL,
  PRIMARY KEY (`enrID`),
  KEY `FK_enrollment_subject` (`subID`),
  KEY `FK_enrollment_student` (`stuID`),
  CONSTRAINT `FK_enrollment_subject` FOREIGN KEY (`subID`) REFERENCES `subject` (`subID`),
  CONSTRAINT `FK_enrollment_student` FOREIGN KEY (`stuID`) REFERENCES `student` (`stuID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- Dumping data for table studentprofile.enrollment: ~0 rows (approximately)
DELETE FROM `enrollment`;
/*!40000 ALTER TABLE `enrollment` DISABLE KEYS */;
INSERT INTO `enrollment` (`enrID`, `subID`, `stuID`, `enrGrade`) VALUES
	(22, 211, 2, 'A'),
	(23, 210, 1, 'A+');
/*!40000 ALTER TABLE `enrollment` ENABLE KEYS */;


-- Dumping structure for table studentprofile.faculty
DROP TABLE IF EXISTS `faculty`;
CREATE TABLE IF NOT EXISTS `faculty` (
  `facID` int(10) NOT NULL AUTO_INCREMENT,
  `facName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`facID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table studentprofile.faculty: ~0 rows (approximately)
DELETE FROM `faculty`;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` (`facID`, `facName`) VALUES
	(1, 'RC'),
	(2, 'DAS'),
	(3, 'NATH');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;


-- Dumping structure for table studentprofile.friend
DROP TABLE IF EXISTS `friend`;
CREATE TABLE IF NOT EXISTS `friend` (
  `friID` int(10) NOT NULL AUTO_INCREMENT,
  `stuID2` int(10) DEFAULT NULL,
  `stuID1` int(10) DEFAULT NULL,
  PRIMARY KEY (`friID`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;


-- Dumping data for table studentprofile.friend: ~0 rows (approximately)
DELETE FROM `friend`;
/*!40000 ALTER TABLE `friend` DISABLE KEYS */;
INSERT INTO `friend` (`friID`, `stuID2`, `stuID1`) VALUES
	(45, 2, 1),
	(46, 3, 2);
/*!40000 ALTER TABLE `friend` ENABLE KEYS */;


-- Dumping structure for table studentprofile.interests
DROP TABLE IF EXISTS `interests`;
CREATE TABLE IF NOT EXISTS `interests` (
  `intID` int(10) NOT NULL AUTO_INCREMENT,
  `intName` varchar(50) NOT NULL,
  PRIMARY KEY (`intID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- Dumping data for table studentprofile.interests: ~0 rows (approximately)
DELETE FROM `interests`;
/*!40000 ALTER TABLE `interests` DISABLE KEYS */;
INSERT INTO `interests` (`intID`, `intName`) VALUES
	(12, 'Cricket'),
	(13, 'FootBall'),
	(14, 'Hockey');
/*!40000 ALTER TABLE `interests` ENABLE KEYS */;

DROP TABLE IF EXISTS `mapStudentInterests`;
CREATE TABLE IF NOT EXISTS `mapStudentInterests` (
  `mapID` int(10) NOT NULL AUTO_INCREMENT,
  `stuID` int(10) DEFAULT NULL,
  `intID` int(10) DEFAULT NULL,
  PRIMARY KEY(`mapID`),
  KEY `FK_map_student` (`stuID`),
  KEY `FK_map_interest` (`intID`),
  KEY (`stuID`,`intID`),
  CONSTRAINT `FK_map_student` FOREIGN KEY (`stuID`) REFERENCES `student` (`stuID`),
  CONSTRAINT `FK_map_interest` FOREIGN KEY (`intID`) REFERENCES `interests` (`intID`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=latin1;

-- Dumping structure for table studentprofile.news
DROP TABLE IF EXISTS `news`;
CREATE TABLE IF NOT EXISTS `news` (
  `newID` int(10) NOT NULL,
  `newName` varchar(50) NOT NULL,
  PRIMARY KEY (`newID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table studentprofile.news: ~0 rows (approximately)
DELETE FROM `news`;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` (`newID`, `newName`) VALUES
	(1, 'hockey News'),
	(2, 'central News');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;


-- Dumping structure for table studentprofile.semester
DROP TABLE IF EXISTS `semester`;
CREATE TABLE IF NOT EXISTS `semester` (
  `semID` int(10) NOT NULL AUTO_INCREMENT,
  `semName` varchar(50) NOT NULL,
  PRIMARY KEY (`semID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table studentprofile.semester: ~0 rows (approximately)
DELETE FROM `semester`;
/*!40000 ALTER TABLE `semester` DISABLE KEYS */;
INSERT INTO `semester` (`semID`, `semName`) VALUES
	(1, 'Fall'),
	(2, 'Spring');
/*!40000 ALTER TABLE `semester` ENABLE KEYS */;

/*
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user`(
  `usrID` int(10) NOT NULL AUTO_INCREMENT,
  `usrName` varchar(50) NOT NULL, 	
  `password` varchar(50) NOT NULL,
  `role` varchar(30) NOT NULL,
   PRIMARY KEY (`usrID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COMMENT='User Table';
INSERT INTO `user` (`usrID`, `usrName`, `password`, `role`) values (1, 'vamsi', 'vamsi123', 'student');
INSERT INTO `user` (`usrID`, `usrName`, `password`, `role`) values (2, 'admin', 'admin123', 'admin');
*/

/*
DROP TABLE IF EXISTS 'admin';
CREATE TABLE IF NOT EXISTS 'admin' (

) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COMMENT='Admin table';
*/

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin`(
  `adminID` int(10) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(50) NOT NULL, 	
  `password` varchar(50) NOT NULL,
   PRIMARY KEY (`adminID`),
   CONSTRAINT  UNIQUE (`adminName`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COMMENT='Admin Table';

INSERT INTO `admin` (`adminID`, `adminName`, `password`) values (1, 'admin', 'admin123');

-- Dumping structure for table studentprofile.student
DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `stuID` int(10) NOT NULL AUTO_INCREMENT,
  `stuName` varchar(50) NOT NULL,
  `stuPassword` varchar(50) NOT NULL,
  `stuPhoto` blob,
  `stuLoggedIn` time DEFAULT NULL,
  `stuRollNo` varchar(10) NOT NULL,
  `stuDOB` date DEFAULT NULL,
  PRIMARY KEY (`stuID`),
  CONSTRAINT  UNIQUE (`stuRollNo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COMMENT='Student Table';

-- Dumping data for table studentprofile.student: ~0 rows (approximately)
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`stuID`, `stuName`, `stuPassword`, `stuPhoto`, `stuLoggedIn`, `stuRollNo`, `stuDOB`) VALUES
	(1, 'Vamsi', 'vamsi123', NULL, curtime(), 'STU_1', '1989-06-21'),
	(2, 'Ranadheer', 'ranadheer123', NULL, curtime(), 'STU_2', '1989-07-11'),
	(3, 'Ganguly', 'ganguly123', NULL, curtime(), 'STU_3', '1989-04-21');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

/*DROP TABLE IF EXISTS `subject`;
CREATE TABLE IF NOT EXISTS `subject` (
  `facsubID` int(10) NOT NULL AUTO_INCREMENT,
  `subID` int(10) NOT NULL,
  `facID` int(10) NOT NULL,
  PRIMARY KEY (`facsubID`),
  KEY `FK_facsub_subject` (`semID`),
  KEY `FK_facsub_faculty` (`facID`),
  CONSTRAINT `FK_facsub_subject` FOREIGN KEY (`semID`) REFERENCES `semester` (`semID`),
  CONSTRAINT `FK_facsub_faculty` FOREIGN KEY (`facID`) REFERENCES `faculty` (`facID`)
) ENGINE=InnoDB AUTO_INCREMENT=212 DEFAULT CHARSET=latin1;
*/

-- Dumping structure for table studentprofile.subject
DROP TABLE IF EXISTS `subject`;
CREATE TABLE IF NOT EXISTS `subject` (
  `subID` int(10) NOT NULL AUTO_INCREMENT,
  `subCode` varchar(50) DEFAULT NULL,
  `subName` varchar(50) DEFAULT NULL,
  `subSyllabus` text,
  `semID` int(10) DEFAULT NULL,
  `facID` int(10) DEFAULT NULL,
  PRIMARY KEY (`subID`),
  KEY `FK_subject_semester` (`semID`),
  KEY `FK_subject_faculty` (`facID`),
  CONSTRAINT `FK_subject_semester` FOREIGN KEY (`semID`) REFERENCES `semester` (`semID`),
  CONSTRAINT `FK_subject_faculty` FOREIGN KEY (`facID`) REFERENCES `faculty` (`facID`)
) ENGINE=InnoDB AUTO_INCREMENT=212 DEFAULT CHARSET=latin1;

-- Dumping data for table studentprofile.subject: ~0 rows (approximately)
DELETE FROM `subject`;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` (`subID`, `subCode`, `subName`, `subSyllabus`, `semID`, `facID`) VALUES
	(210, 'NC', 'Networking', 'Syllabus for Networking here', 1, 1),
	(211, 'DB', 'DataBase', 'Syllabus for Database here', 2, 2);

DROP TABLE IF EXISTS `mapSubjectFaculty`;
CREATE TABLE IF NOT EXISTS `mapSubjectFaculty` (
  `mapSubFacID` int(10) NOT NULL AUTO_INCREMENT,
  `subID` int(10) DEFAULT NULL,
  `facID` int(10) DEFAULT NULL,
  PRIMARY KEY(`mapSubFacID`),
  KEY `FK_map_faculty` (`subID`),
  KEY `FK_map_subject` (`facID`),
  CONSTRAINT `FK_map_faculty` FOREIGN KEY (`facID`) REFERENCES `faculty` (`facID`),
  CONSTRAINT `FK_map_subject` FOREIGN KEY (`subID`) REFERENCES `subject` (`subID`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `enrollduration`;
CREATE TABLE IF NOT EXISTS `enrollduration` (
  `enrID` int(10) NOT NULL AUTO_INCREMENT,
  `semID` int(10) DEFAULT NULL,
  `subID` int(10) DEFAULT NULL,
  `strDate` DATETIME NOT NULL,
  `endDate` DATETIME NOT NULL,
  PRIMARY KEY(`enrID`),
  KEY `FK_map_sub` (`subID`),
  KEY `FK_map_sem` (`semID`),
  CONSTRAINT `FK_map_sub` FOREIGN KEY (`subID`) REFERENCES `subject` (`subID`),
  CONSTRAINT `FK_map_sem` FOREIGN KEY (`semID`) REFERENCES `semester` (`semID`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=latin1;


/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
