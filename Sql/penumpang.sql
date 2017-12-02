-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2017 at 11:57 AM
-- Server version: 10.1.22-MariaDB
-- PHP Version: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `travel`
--

-- --------------------------------------------------------

--
-- Table structure for table `penumpang`
--

CREATE TABLE `penumpang` (
  `id_penumpang` int(11) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `harga` varchar(20) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `umur` varchar(40) NOT NULL,
  `jenis_kel` enum('L','P') NOT NULL,
  `tujuan` varchar(50) NOT NULL,
  `tgl_pesan` date NOT NULL,
  `paket` varchar(50) NOT NULL,
  `jam` varchar(50) NOT NULL,
  `kendaraan` varchar(30) NOT NULL,
  `uang` int(11) NOT NULL,
  `tlp` varchar(20) NOT NULL,
  `kembali` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penumpang`
--

INSERT INTO `penumpang` (`id_penumpang`, `nama`, `harga`, `alamat`, `umur`, `jenis_kel`, `tujuan`, `tgl_pesan`, `paket`, `jam`, `kendaraan`, `uang`, `tlp`, `kembali`) VALUES
(14, 'Antareza Ghifary A.M', '70000', 'Ds.Pucungkidul Kec.Boyolangu Kab. Tulungagung', '17', 'L', 'Tulungagung - Malang (Patas)', '2017-11-28', 'MorningSlow', '09.00', 'Rush', 100000, '0897867564', '30000'),
(15, 'angger', '70000', 'sumber pucung malang jatim', '18', 'L', 'Tulungagung - Surabaya (Bisnis)', '2017-11-30', 'MorningSlow', '06.00', 'Kijang inova', 100000, '08977665543', '30000'),
(16, 'ali maschur', '70000', 'boyolangu tulungagung', '30', 'L', 'Tulungagung - Surabaya (Bisnis)', '2017-12-31', 'MorningSlow', '06.00', 'Kijang inova', 100000, '089787676767', '30000'),
(18, 'shafira nur izza', '180000', 'jl. raya jombang-mojokerto gang 5', '17', 'P', 'Tulungagung - Yogyakarta (Executive)', '2018-01-27', 'AfternoonHot', '16.00', 'Xenia', 200000, '089786567456', '20000'),
(19, 'nata parahita anindya', '120000', 'pucungkidul boyolangu', '8', 'L', 'Tulungagung - Surabaya (Bisnis)', '2017-12-31', 'AfternoonHot', '06.00', 'Kijang inova', 150000, '8987675544', '30000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `penumpang`
--
ALTER TABLE `penumpang`
  ADD PRIMARY KEY (`id_penumpang`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `penumpang`
--
ALTER TABLE `penumpang`
  MODIFY `id_penumpang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
