-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 10, 2019 at 10:44 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `todoservlet`
--

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `ID` int(11) NOT NULL,
  `DATE` text NOT NULL,
  `NOTE` text NOT NULL,
  `STATUS` tinyint(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`ID`, `DATE`, `NOTE`, `STATUS`) VALUES
(67, '02/10/2019', '111', 0),
(66, '02/10/2019', '222', 0),
(61, '02/10/2019', '111', 0),
(62, '02/10/2019', '222', 0),
(63, '02/10/2019', '12', 0),
(64, '02/10/2019', '2', 0),
(65, '02/10/2019', '12', 0),
(59, '02/10/2019', '2', 0),
(60, '02/10/2019', '21', 0),
(38, '01/05/2019', 'df', 0),
(39, '01/05/2019', 'sdsdsd??????22', 1),
(46, '02/08/2019', 'asd', 0),
(44, '01/14/2019', 'wefwef111', 1),
(45, '01/14/2019', 'wdfwefweffe22w', 0),
(47, '02/08/2019', 'sad', 0),
(48, '02/10/2019', '1', 0),
(49, '02/10/2019', '12', 0),
(50, '02/10/2019', '122', 0),
(51, '02/10/2019', '3', 0),
(52, '02/10/2019', '3', 0),
(53, '02/10/2019', '32', 0),
(54, '02/10/2019', '3', 0),
(55, '02/10/2019', '2', 0),
(56, '02/10/2019', '1', 0),
(57, '02/10/2019', '12', 0),
(58, '02/10/2019', '1212', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
