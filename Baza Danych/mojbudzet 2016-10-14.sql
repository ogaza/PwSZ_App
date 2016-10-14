-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 14 Paź 2016, 18:29
-- Wersja serwera: 10.1.16-MariaDB
-- Wersja PHP: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `mojbudzet`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kategoria`
--

CREATE TABLE `kategoria` (
  `id` int(11) NOT NULL,
  `nazwa` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `kategoria`
--

INSERT INTO `kategoria` (`id`, `nazwa`) VALUES
(1, 'kat 1'),
(2, 'kat 2');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wpis`
--

CREATE TABLE `wpis` (
  `id` int(11) NOT NULL,
  `typ` tinyint(4) DEFAULT NULL,
  `wartosc` double DEFAULT NULL,
  `data` date DEFAULT NULL,
  `kategoriaId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `wpis`
--

INSERT INTO `wpis` (`id`, `typ`, `wartosc`, `data`, `kategoriaId`) VALUES
(1, -1, 1, '2016-10-14', 1),
(2, 1, 12, '2016-10-14', 2);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `kategoria`
--
ALTER TABLE `kategoria`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `wpis`
--
ALTER TABLE `wpis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_3xddhrwqgojdoxdutgqu7fly3` (`kategoriaId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `kategoria`
--
ALTER TABLE `kategoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT dla tabeli `wpis`
--
ALTER TABLE `wpis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `wpis`
--
ALTER TABLE `wpis`
  ADD CONSTRAINT `FK_3xddhrwqgojdoxdutgqu7fly3` FOREIGN KEY (`kategoriaId`) REFERENCES `kategoria` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
