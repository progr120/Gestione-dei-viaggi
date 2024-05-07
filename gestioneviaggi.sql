CREATE DATABASE gestioneviaggi;

USE gestioneviaggi;

CREATE TABLE viaggi(
id_viaggio INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
destinazione VARCHAR(100) NOT NULL,
data_partenza VARCHAR(50) NOT NULL,
data_ritorno VARCHAR(50) NOT NULL,
posti_disponibili SMALLINT
);

CREATE TABLE turisti(
id_turista INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50) NOT NULL,
cognome VARCHAR(50) NOT NULL,
data_nascita VARCHAR(50) NOT NULL,
nazionalita VARCHAR(50) NOT NULL,
email VARCHAR(100) NOT NULL,
documento VARCHAR(50) NOT NULL
);

CREATE TABLE partecipanti(
id_partecipante INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
id_viaggio INT NOT NULL,
id_turista INT NOT NULL,
stato_prenotazione VARCHAR(50),
FOREIGN KEY (id_viaggio) REFERENCES viaggi(id_viaggio),
FOREIGN KEY (id_turista) REFERENCES turisti(id_turista)
);

INSERT INTO viaggi (destinazione, data_partenza, data_ritorno, posti_disponibili) 
VALUES ("Francia", "12-10-2024", "26-10-2024", 49),
("Italia","29-05-2023","08-06-2023", 62),
("Brasile","10-02-2020","27-02-2020", 49);

INSERT INTO turisti (nome, cognome, data_nascita, nazionalita, email, documento) 
VALUES ("Mario", "Rossi", "15-05-1998", "Francese", "mario.rossi@gmail.com", "Identita"),
("Carlo", "Lima", "19-11-1983", "Italiano", "carloLima@hotmail.com", "Passaporto"),
("Felipe", "Augusto", "31-08-2001", "Brasiliano", "felipe@augusto.ig", "Identita Locale");

INSERT INTO partecipanti (id_viaggio, id_turista, stato_prenotazione) 
VALUES (1, 1, "Confermato"),
(2, 2, "Pendente"),
(3, 2, "Cancellato");





