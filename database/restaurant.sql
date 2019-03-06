-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 06, 2019 at 07:30 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.0.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restaurant`
--

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `id` int(10) NOT NULL,
  `name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`id`, `name`) VALUES
(1, 'Calicut'),
(2, 'Malappuram'),
(3, 'Manjeri'),
(4, 'Palakkad'),
(5, 'Thrissur'),
(6, 'Kochi'),
(7, 'Kollam'),
(8, 'Kottayam');

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_details`
--

CREATE TABLE `restaurant_details` (
  `id` int(10) NOT NULL,
  `c_id` int(10) DEFAULT NULL,
  `rest_name` varchar(100) DEFAULT NULL,
  `address` text,
  `image` varchar(50) DEFAULT 'restaurant.jpg',
  `mail` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restaurant_details`
--

INSERT INTO `restaurant_details` (`id`, `c_id`, `rest_name`, `address`, `image`, `mail`, `phone`) VALUES
(1, 1, 'Paragon', 'kannur road,\r\nnear overbridge,\r\ncalicut\r\n', 'paragon.jpg', 'paragon@gmail.com', '9876587696'),
(2, 1, 'Hotel Rahmath', 'aravind ghosh rd,\r\ncalicut\r\n', 'rahmath.jpg', 'rahmath@gmail.com', '9453765357'),
(3, 1, 'Kings Bay', 'customs Rd,\r\ncalicut', 'kingsbay.jpg', 'kings@gmail.com', '7658934765'),
(4, 1, 'M Grill', 'focus mall,\r\ncalicut', 'mgrill.jpg', 'grills@gmail.com', '8767543985'),
(5, 1, 'Zam Zam', 'red cross Rd,\r\ncalicut', 'zamzam.jpg', 'zamzam@gmail.com', '7867865435'),
(6, 2, 'Hotel Delicia', 'kottappadi,\r\nmalappuram', 'delicia.jpg', 'delicia@gmail.com', '9756419003'),
(7, 2, 'Airlines Celestial', 'kizhakethala,\r\nmalappuram', 'airlines.jpg', 'airlines@gmail.com', '8940167343'),
(8, 2, 'Thandhoor Hut', 'up hill,\r\nmalappuram', 'tandhoor.jpg', 'thandhoorhut@gmail.com', '9803715883'),
(9, 2, 'Madhbi Mandhi', 'munduparamb,\r\nmalappuram', 'madhbi.jpg', 'mandhi@gmail.com', '7025894260'),
(10, 2, 'The veg', 'kavungal,\r\nmalappuram', 'theveg.jpg', 'veg@gmail.com', '8089547832'),
(11, 3, 'Farsa Restaurant', 'kozhikode Rd,\r\nManjeri', 'farsa.jpg', 'farsa@gmail.com', '7656589754'),
(12, 3, 'Olene Canto', 'melakkam,\r\nmanjeri', 'olene.jpg', 'olene@gmail.com', '7865414141'),
(13, 3, 'Woodbine', 'court RD,\r\nManjeri', 'woodbine.jpg', 'woodbine@gmail.com', '8989854715'),
(14, 3, 'Albaik', 'thurakkal,\r\nmanjeri', 'albaik.jpg', 'albaik@gmail.com', '7861562798'),
(15, 3, 'Chicking', 'court Rd,\r\nManjeri', 'chicking.jpg', 'chicking@gmail.com', '7865430915'),
(16, 4, 'Noorjahan', 'stadium Rd,\r\nPalakkad\r\n', 'noor.jpg', 'noorjahan@gmail.com', '7664523245'),
(17, 5, 'Alibaba And 41 Dishes', 'manappuram tower,\r\nthrissur', 'ali.jpg', 'alibaba@gmail.com', '8975430134'),
(18, 6, 'Fort House Hotel', 'fort kochi,\r\nKochi\r\n', 'forthouse.png', 'forthouse@gmail.com', '9821455278'),
(19, 7, 'All spice Restaurant', 'kollam,\r\nkerala', 'all.jpg', 'spices@gmail.com', '9875430161'),
(20, 8, 'Thali Restaurant', 'kk rd,\r\nkottayam', 'thali.png', 'thali@gmail.com', '9765487320'),
(21, 4, 'Malabar Restaurant', 'near stadium,\r\npalakkad', 'malabar.jpg', 'malabar@gmail.com', '9865656565'),
(22, 4, 'Devikripa Restaurant', 'court Rd,\r\npalakkad', 'devi.png', 'devikripa@gmail.com', '9895454545'),
(23, 4, 'Hotel Nalanda', 'Post office rd,\r\nsulthanpett,\r\npalakkad', 'nalanda.jpg', 'nalanda@gmail.com', '9645445455'),
(24, 4, 'Hotel Ashok Bhavan', 'sulthanpett,\r\npalakkad', 'ashok.jpg', 'ashokbavan@gmail.com', '8972303845'),
(25, 5, 'Akshaya Hotel', 'high Rd,\r\nthrissur', 'akshaya.jpg', 'akshaya@gmail.com', '7895143209'),
(26, 5, 'Ayush Hotel', 'vadakkumnadhan complex,\r\nthrissur', 'ayush.jpg', 'ayush@gmail.com', '9856410543'),
(27, 5, 'Pisharody\'s Restaurant', 'vip Rd,\r\nthrissur', 'pish.jpg', 'pisharady@gmail.com', '8976037614'),
(28, 5, 'Burger Hub', 'venus complex,\r\nMG rd,\r\nthrissur', 'burger.jpg', 'hub@gmail.com', '8956432108'),
(29, 6, 'Kochi Kitchen', 'lulu shopping mall,\r\nkochi', 'kochi.jpg', 'kitchen@gmail.com', '7685432109'),
(30, 6, 'Sutra Restaurant', 'pt complex,\r\nkochi', 'sutra.jpg', 'sutra@gmail.com', '9871235643'),
(31, 6, 'The Pepper Restaurant', 'taj tower,\r\nkochi', 'pepper.jpg', 'pepper@gmail.com', '9087234750'),
(32, 6, 'Cafe Royale', 'near central mall,\r\nkochi', 'cafe.jpg', 'royalcafe@gmail.com', '9765132094'),
(33, 7, 'Sree Suprabhatham Restaurant', 'kollam,\r\nkerala', 'supra.jpg', 'sreess@gmail.com', '8954783621'),
(34, 7, 'Sree Ayyappa Restaurant', 'kollam,\r\nkerala', 'sree.jpg', 'ayyappasri@gmail.com', '9567092622'),
(35, 7, 'Ramees Restaurant', 'kollam,\r\nkerala', 'rami.jpg', 'rami@gmail.com', '9805426234'),
(36, 7, 'Masala Square Restaurant', 'kollam,\r\nkerala', 'masala.jpg', 'masalasr@gmail.com', '9872733855'),
(37, 8, 'Wheels Restaurant', 'near plantation corporation,\r\nkottayam', 'wheels.jpg', 'wheelsr@gmail.com', '8976502641'),
(38, 8, 'Theos Restaurant', 'aida junction,\r\nkottayam', 'theos.jpg', 'the@gmail.com', '9562091512'),
(39, 8, 'Tonico Cafe', 'near nehru stadium,\r\nkottayam', 'toni.jpg', 'toni@gmail.com', '8974501231'),
(40, 8, 'Shalimar Restaurant', 'NH 7 Rd,\r\nkottayam', 'shalimar.jpg', 'shali@gmail.com', '8905624252');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `restaurant_details`
--
ALTER TABLE `restaurant_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `c_id` (`c_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `restaurant_details`
--
ALTER TABLE `restaurant_details`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `restaurant_details`
--
ALTER TABLE `restaurant_details`
  ADD CONSTRAINT `restaurant_details_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `city` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
