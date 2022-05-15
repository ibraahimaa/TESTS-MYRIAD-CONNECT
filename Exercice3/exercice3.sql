-- Ou introduis-tu l’écriture en base de données dans le code de la partie 1 ?
-- cette question a été répondue dans l'exercice préccédent (voir Service.java ligne 35) ,endroit auquel on accedera a la source de donnée

CREATE DATABASE `USSD`;
USE `USSD`;

--  le schéma de la table SQL 
-- sevrice est la table dans laquelle nous enregistrons chaque accès d’un utilisateur au #123#.
CREATE TABLE `service` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `id_utilisateur` int(11) NOT NULL,
  `date_et_heure` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE="InnoDB";


-- requete d'insertions
INSERT INTO `service` (`id_utilisateur`,`date_et_heure`) VALUES(1,'2020-05-11 10:06:19'),(2,'2020-12-24 10:06:19'),
(1,'2020-03-04 10:06:19'),(4,'2020-01-10 10:06:19');
INSERT INTO `service` (`id_utilisateur`) VALUES(1),(3),(1),(1),(1),(2);



--Requete pour récupérer la liste des dates/heure d'accès d'un utilisateur donné au #123# en 2020 (soit id_utilisateur = 2 pour ce cas)

SELECT date_et_heure as `Date et Heure d'acces` , id_utilisateur  from `service` WHERE YEAR(date_et_heure) ='2020' AND id_utilisateur = 2;


-- Requete pour récupérer le nombre d'accès au #123# tout utilisateurs confondus en mars 2020

SELECT COUNT(*) as `Nombre d'acces en Mars 2020 ` FROM `service` WHERE YEAR(date_et_heure) ='2020' AND MONTH(date_et_heure)='03';



-- Pour réduire le temps de lecture en base de données:
-- l'utilisation d'index peut permettre de retrouver rapidement les données.
-- Faire certains traitements et les stockers en bases de données graces aux triggers ou procédures stockée ,par exemple on pourrait 
--ajouter un champ au niveau de chaque utilisateur qui sera son nombre d'acces automatiquement mis a jour par un trigger

--Ces propositions réduiront sans doute le temps de lecture mais cela a un prix telle .Lors de l'insertion ou de la mise à jour effet --mettre à jour les index pour qu'ils continuent à refléter l'état des enregistrements,de plus les triggers  exécutent toutes les mises à --jour apportées à la table, ce qui ajoute de la charge de travail à la base de données et ralentit le fonctionnement du système.
