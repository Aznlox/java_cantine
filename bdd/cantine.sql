-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 25 avr. 2020 à 14:05
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cantine`
--
CREATE DATABASE IF NOT EXISTS `cantine` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `cantine`;

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identifiant` varchar(40) COLLATE utf8_bin NOT NULL,
  `mdp` varchar(40) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id`, `identifiant`, `mdp`) VALUES
(1, 'test', 'test');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `nom` varchar(40) COLLATE utf8_bin NOT NULL,
  `prenom` varchar(40) COLLATE utf8_bin NOT NULL,
  `classe` varchar(20) COLLATE utf8_bin NOT NULL,
  `cantine` varchar(40) COLLATE utf8_bin NOT NULL,
  `jour` varchar(40) COLLATE utf8_bin NOT NULL,
  `regime` text COLLATE utf8_bin NOT NULL,
  `tarif` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`nom`, `prenom`, `classe`, `cantine`, `jour`, `regime`, `tarif`) VALUES
('test', 'test', 'Première', 'Oui', 'Me J V ', 'test', 72),
('b', 'b', 'Terminale', 'Oui', 'Ma Me ', 'b', 48),
('Goncalves', 'Nathan', 'BTS', 'Non', '', 'Non', 0),
('Bruno', 'Marco', 'Terminale', 'Oui', 'L Ma ', 'bla', 48);

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

DROP TABLE IF EXISTS `professeur`;
CREATE TABLE IF NOT EXISTS `professeur` (
  `nom` varchar(40) COLLATE utf8_bin NOT NULL,
  `prenom` varchar(40) COLLATE utf8_bin NOT NULL,
  `cantine` varchar(40) COLLATE utf8_bin NOT NULL,
  `jour` varchar(40) COLLATE utf8_bin NOT NULL,
  `regime` text COLLATE utf8_bin NOT NULL,
  `tarif` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `professeur`
--

INSERT INTO `professeur` (`nom`, `prenom`, `cantine`, `jour`, `regime`, `tarif`) VALUES
('test', 'test', 'Oui', 'L Ma Me J V', 'Non', 120),
('test2', 'test2', 'Oui', 'L Ma', 'Non', 48);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
