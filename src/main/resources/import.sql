--genre
INSERT INTO genre(id, libelle) VALUES (1, 'plateau');
INSERT INTO genre(id, libelle) VALUES (2, 'dé');
INSERT INTO genre(id, libelle) VALUES (3, 'coopération');
INSERT INTO genre(id, libelle) VALUES (4, 'logique');
INSERT INTO genre(id, libelle) VALUES (5, 'mémoire ');
INSERT INTO genre(id, libelle) VALUES (6, 'plateau');

--modele_jeu
INSERT INTO modele_jeu VALUES (1,3,'Monopoly');
INSERT INTO modele_jeu VALUES (2,5,'Scrable');
INSERT INTO modele_jeu VALUES (3,7,'Cluedo');
INSERT INTO modele_jeu VALUES (4,2,'Loup Garou');

--modele_jeu_genre
INSERT INTO modele_jeu_genre (model_jeu_id,genre_id) VALUES (1,1)
INSERT INTO modele_jeu_genre (model_jeu_id,genre_id) VALUES (1,4)
INSERT INTO modele_jeu_genre (model_jeu_id,genre_id) VALUES (2,3)
INSERT INTO modele_jeu_genre (model_jeu_id,genre_id) VALUES (2,5)
INSERT INTO modele_jeu_genre (model_jeu_id,genre_id) VALUES (2,4)
INSERT INTO modele_jeu_genre (model_jeu_id,genre_id) VALUES (3,6)
INSERT INTO modele_jeu_genre (model_jeu_id,genre_id) VALUES (4,2)

--exemplaire_jeu
INSERT exemplaire_jeu (id,modele_jeu_id,code_barre,est_louable) VALUES (1,1,123456789012,1)
INSERT exemplaire_jeu (id,modele_jeu_id,code_barre,est_louable) VALUES (2,1,4006381333931,1)
INSERT exemplaire_jeu (id,modele_jeu_id,code_barre,est_louable) VALUES (3,1,9780201379624,1)

INSERT exemplaire_jeu (id,modele_jeu_id,code_barre,est_louable) VALUES (4,2,5901234123457,1)
INSERT exemplaire_jeu (id,modele_jeu_id,code_barre,est_louable) VALUES (5,2,5012345678900,1)

INSERT exemplaire_jeu (id,modele_jeu_id,code_barre,est_louable) VALUES (6,3,0075678164125,1)

INSERT exemplaire_jeu (id,modele_jeu_id,code_barre,est_louable) VALUES (7,4,2001234567890,1)
INSERT exemplaire_jeu (id,modele_jeu_id,code_barre,est_louable) VALUES (8,4,3001234567897,1)
INSERT exemplaire_jeu (id,modele_jeu_id,code_barre,est_louable) VALUES (9,4,4001234567894,1)
INSERT exemplaire_jeu (id,modele_jeu_id,code_barre,est_louable) VALUES (10,4,5001234567891,1)