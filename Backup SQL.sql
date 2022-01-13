/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 10.4.21-MariaDB : Database - ta_stokbarang
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ta_stokbarang` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `ta_stokbarang`;

/*Table structure for table `tblbarang` */

DROP TABLE IF EXISTS `tblbarang`;

CREATE TABLE `tblbarang` (
  `idBarang` varchar(10) NOT NULL,
  `namaBarang` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idBarang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `tblbarang` */

insert  into `tblbarang`(`idBarang`,`namaBarang`) values 
('BR04','Penggaris'),
('D001','Clear'),
('D002','Lifeboy'),
('D003','Pensil'),
('D007','Teh Gelas');

/*Table structure for table `tblgudang` */

DROP TABLE IF EXISTS `tblgudang`;

CREATE TABLE `tblgudang` (
  `idbarang` varchar(10) DEFAULT NULL,
  `idkategori` varchar(10) DEFAULT NULL,
  `stok` int(255) DEFAULT NULL,
  KEY `idbarang` (`idbarang`),
  KEY `idkategori` (`idkategori`),
  CONSTRAINT `tblgudang_ibfk_1` FOREIGN KEY (`idbarang`) REFERENCES `tblbarang` (`idBarang`),
  CONSTRAINT `tblgudang_ibfk_2` FOREIGN KEY (`idkategori`) REFERENCES `tblkategori` (`idKategori`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `tblgudang` */

insert  into `tblgudang`(`idbarang`,`idkategori`,`stok`) values 
('D002','0001',12),
('D007','0004',99),
('BR04','0003',33);

/*Table structure for table `tblkategori` */

DROP TABLE IF EXISTS `tblkategori`;

CREATE TABLE `tblkategori` (
  `idKategori` varchar(10) NOT NULL,
  `namaKategori` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idKategori`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `tblkategori` */

insert  into `tblkategori`(`idKategori`,`namaKategori`) values 
('0001','Shampo'),
('0003','Alat'),
('0004','Minuman'),
('0005','Makanan');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
