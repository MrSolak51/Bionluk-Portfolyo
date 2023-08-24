-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.25-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table student_otomation.absence_status
CREATE TABLE IF NOT EXISTS `absence_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lesson_date` date NOT NULL,
  `is_absence` bit(1) NOT NULL,
  `student_number` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table student_otomation.absence_status: ~30 rows (approximately)
INSERT INTO `absence_status` (`id`, `lesson_date`, `is_absence`, `student_number`) VALUES
	(1, '2023-04-01', b'1', '01'),
	(2, '2023-04-02', b'1', '01'),
	(3, '2023-04-03', b'0', '01'),
	(4, '2023-04-04', b'0', '01'),
	(5, '2023-04-05', b'1', '01'),
	(6, '2023-04-06', b'1', '01'),
	(7, '2023-04-07', b'0', '01'),
	(8, '2023-04-08', b'1', '01'),
	(9, '2023-04-09', b'0', '01'),
	(10, '2023-04-10', b'0', '01'),
	(11, '2023-04-11', b'0', '01'),
	(12, '2023-04-12', b'0', '01'),
	(13, '2023-04-13', b'1', '01'),
	(14, '2023-04-14', b'0', '01'),
	(15, '2023-04-15', b'0', '01'),
	(16, '2023-04-16', b'0', '01'),
	(17, '2023-04-17', b'0', '01'),
	(18, '2023-04-18', b'1', '01'),
	(19, '2023-04-19', b'0', '01'),
	(20, '2023-04-20', b'0', '01'),
	(21, '2023-04-21', b'0', '01'),
	(22, '2023-04-22', b'0', '01'),
	(23, '2023-04-23', b'0', '01'),
	(24, '2023-04-24', b'0', '01'),
	(25, '2023-04-25', b'1', '01'),
	(26, '2023-04-26', b'1', '01'),
	(27, '2023-04-27', b'1', '01'),
	(28, '2023-04-28', b'0', '01'),
	(29, '2023-04-29', b'0', '01'),
	(30, '2023-04-30', b'1', '01');

-- Dumping structure for table student_otomation.exams
CREATE TABLE IF NOT EXISTS `exams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lesson_name` varchar(50) NOT NULL DEFAULT '0',
  `date` date NOT NULL,
  `student_number` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table student_otomation.exams: ~1 rows (approximately)
INSERT INTO `exams` (`id`, `lesson_name`, `date`, `student_number`) VALUES
	(1, 'İngilizce', '2023-04-21', '01');

-- Dumping structure for table student_otomation.homeworks
CREATE TABLE IF NOT EXISTS `homeworks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lesson_name` varchar(50) NOT NULL,
  `finish_date` date NOT NULL,
  `statu` bit(1) NOT NULL DEFAULT b'0',
  `student_number` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table student_otomation.homeworks: ~1 rows (approximately)
INSERT INTO `homeworks` (`id`, `lesson_name`, `finish_date`, `statu`, `student_number`) VALUES
	(1, 'Üslü Sayılar 100 soru çözümü', '2023-04-20', b'0', '01');

-- Dumping structure for table student_otomation.lessons
CREATE TABLE IF NOT EXISTS `lessons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lesson_name` varchar(50) NOT NULL,
  `midderm` double DEFAULT NULL,
  `final` double DEFAULT NULL,
  `student_number` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table student_otomation.lessons: ~3 rows (approximately)
INSERT INTO `lessons` (`id`, `lesson_name`, `midderm`, `final`, `student_number`) VALUES
	(1, 'Matematik', 0, 0, '01'),
	(2, 'Matematik', NULL, NULL, '02'),
	(3, 'İngilizce', NULL, NULL, '01');

-- Dumping structure for table student_otomation.students
CREATE TABLE IF NOT EXISTS `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Surname` varchar(50) NOT NULL,
  `Number` varchar(50) NOT NULL,
  `Grade` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table student_otomation.students: ~11 rows (approximately)
INSERT INTO `students` (`id`, `Name`, `Surname`, `Number`, `Grade`) VALUES
	(1, 'Öğrenci1', 'Öğrenir1', '01', 4),
	(2, 'Öğrenci2', 'Öğrenir2', '02', 4),
	(3, 'Öğrenci3', 'Öğrenir3', '03', 4),
	(4, 'Öğrenci4', 'Öğrenir4', '04', 4),
	(5, 'Öğrenci5', 'Öğrenir5', '05', 4),
	(6, 'Öğrenci6', 'Öğrenir6', '06', 4),
	(7, 'Öğrenci7', 'Öğrenir7', '07', 4),
	(8, 'Öğrenci8', 'Öğrenir8', '08', 4),
	(9, 'Öğrenci9', 'Öğrenir9', '09', 4),
	(10, 'Öğrenci10', 'Öğrenir10', '10', 4),
	(11, 'Öğrenci11', 'Öğrenir11', '11', 4);

-- Dumping structure for table student_otomation.syllabus
CREATE TABLE IF NOT EXISTS `syllabus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lesson_name` varchar(50) NOT NULL DEFAULT '0',
  `date_` varchar(50) NOT NULL DEFAULT '0',
  `time_` varchar(50) NOT NULL DEFAULT '0',
  `student_number` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table student_otomation.syllabus: ~20 rows (approximately)
INSERT INTO `syllabus` (`id`, `lesson_name`, `date_`, `time_`, `student_number`) VALUES
	(1, 'Türkçe', 'Pzt', '1', '01'),
	(2, 'Türkçe', 'Pzt', '2', '01'),
	(3, 'Matematik', 'Pzt', '3', '01'),
	(4, 'Matematik', 'Pzt', '4', '01'),
	(5, 'İngilizce', 'Sa', '1', '01'),
	(6, 'Beden', 'Sa', '2', '01'),
	(7, 'Beden', 'Sa', '3', '01'),
	(8, 'Din Kültürü', 'Sa', '4', '01'),
	(9, 'Sosyal', 'Çar', '1', '01'),
	(10, 'Sosyal', 'Çar', '2', '01'),
	(11, 'Fen', 'Çar', '3', '01'),
	(12, 'Fen', 'Çar', '4', '01'),
	(13, 'Türkçe', 'Per', '1', '01'),
	(14, 'Türkçe', 'Per', '2', '01'),
	(15, 'Matematik', 'Per', '3', '01'),
	(16, 'Matematik', 'Per', '4', '01'),
	(17, 'Resim', 'Cu', '1', '01'),
	(18, 'Resim', 'Cu', '2', '01'),
	(19, 'Müzik', 'Cu', '3', '01'),
	(20, 'Müzik', 'Cu', '4', '01');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
