Create database GestionEtudiant;

use GestionEtudiant
 
CREATE TABLE etudiants (
    id int NOT NULL AUTO_INCREMENT primary key,
    nom varchar(50) NOT NULL,
    prenom varchar(50) NOT NULL,
    login varchar(50) NOT NULL,
    password varchar(50) NOT NULL
    
);