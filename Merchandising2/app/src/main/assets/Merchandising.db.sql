BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "table_employee" (
	"id_employee"	INTEGER NOT NULL,
	"nom"	TEXT NOT NULL,
	"prenom"	TEXT NOT NULL,
	"date_naissance"	TEXT NOT NULL,
	"nom_usager"	TEXT NOT NULL,
	"mdp"	TEXT NOT NULL,
	"adresse"	TEXT NOT NULL,
	"date_inscrit"	TEXT NOT NULL,
	PRIMARY KEY("id_employee" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "table_magasin" (
	"id_succursale"	INTEGER NOT NULL,
	"libelle_succursale"	TEXT NOT NULL,
	"libelle_magasin"	TEXT NOT NULL,
	"adresse"	TEXT NOT NULL,
	"groupe"	TEXT NOT NULL,
	PRIMARY KEY("id_succursale" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "table_visites" (
	"id_visite"	INTEGER NOT NULL,
	"id_employee"	INTEGER NOT NULL,
	"id_succursale"	INTEGER NOT NULL,
	"date_visite"	TEXT,
	"visite_terminee"	INTEGER NOT NULL,
	FOREIGN KEY("id_employee") REFERENCES "table_employee"("id_employee"),
	PRIMARY KEY("id_visite" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "table_produit" (
	"id_produit"	INTEGER NOT NULL,
	"libelle_produit"	TEXT NOT NULL,
	"id_categorie"	INTEGER NOT NULL,
	"poids_volume"	REAL,
	"image"	TEXT,
	"prix"	REAL,
	PRIMARY KEY("id_produit" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "table_taches" (
	"id_tache"	INTEGER NOT NULL,
	"id_produit"	INTEGER NOT NULL,
	"id_visite"	INTEGER NOT NULL,
	"date_tache"	TEXT NOT NULL,
	"produit_existant"	INTEGER,
	"emplacement"	TEXT,
	"type_promo"	TEXT,
	"prix"	REAL,
	"commentaire"	TEXT,
	"tache_terminee"	INTEGER NOT NULL,
	"photo"	TEXT,
	FOREIGN KEY("id_produit") REFERENCES "table_produit"("id_produit"),
	PRIMARY KEY("id_tache" AUTOINCREMENT)
);
INSERT INTO "table_employee" VALUES (1,'riahi','kadhem','17/01/1997','riahikadhem','123','H2E2C9','19/02/2022');
INSERT INTO "table_employee" VALUES (2,'doe','john','01/01/2000','johndoe','456','H2E2C9','18/02/2022');
INSERT INTO "table_employee" VALUES (3,'user','user','31/01/1999','user','user','H2E2C9','17/02/2022');
INSERT INTO "table_magasin" VALUES (1,'Costco Wholesale longueuil','Costco Wholesale','5025 Bd Cousineau, Longueuil, QC J3Y 3K7','1');
INSERT INTO "table_magasin" VALUES (2,'Costco Wholesale westmount','Costco Wholesale','300 Rue Bridge, Montréal, QC H3K 2C3','1');
INSERT INTO "table_magasin" VALUES (3,'Metro Plus Fleury','Metro','1745 Rue Fleury E, Montreal, Quebec H2C 1T3','2');
INSERT INTO "table_magasin" VALUES (4,'Metro Plus André-Grasset','Metro','8935 Av. André-Grasset, Montréal, QC H2M 2E9','2');
INSERT INTO "table_magasin" VALUES (5,'Maxi angus','Maxi','2925 Sherbrooke St E, Montreal, Quebec H1W 1B2','3');
INSERT INTO "table_magasin" VALUES (6,'Maxi villeray','Maxi','8305 Av. Papineau, Montréal, QC H2M 2G2','3');
INSERT INTO "table_magasin" VALUES (7,'IGA hochelaga','IGA','2600 Ontario St E, Montreal, Quebec H2K 4K4','3');
INSERT INTO "table_magasin" VALUES (8,'Super C westmount','Super C','1000 Rue De La Gauchetière O #028A, Montréal, QC H3B 4W5','3');
INSERT INTO "table_visites" VALUES (1,1,1,'19/02/2022',0);
INSERT INTO "table_visites" VALUES (2,1,2,'19/02/2022',0);
INSERT INTO "table_visites" VALUES (3,2,3,'19/02/2022',0);
INSERT INTO "table_produit" VALUES (1,'Kirkland Signature Organic Extra Virgin Olive Oil',1,'2L','image1',18.99);
INSERT INTO "table_produit" VALUES (2,'Kirkland Signature Maple Syrup',2,'1L','image2',14.99);
INSERT INTO "table_produit" VALUES (3,'Kirkland Signature Queen Olives',3,'1L','image3',8.49);
INSERT INTO "table_produit" VALUES (4,'Kirkland Signature Pistachios',4,'1.36kg','image4',22.99);
INSERT INTO "table_produit" VALUES (5,'Kirkland Signature Dry Roasted Almonds',4,'1.13kg','image5',16.99);
INSERT INTO "table_produit" VALUES (6,'Kirkland Signature Creamy Almond Butter',5,'765g','image6',10.99);
INSERT INTO "table_produit" VALUES (7,'Kirkland Signature 100% Pure Liquid Honey',2,'3kg','image7',24.99);
INSERT INTO "table_produit" VALUES (8,'Kirkland Signature Superfine Grind Almond Flour, Blanched',6,'1.36kg','image8',17.99);
INSERT INTO "table_produit" VALUES (9,'Kirkland Signature Organic Sugar',6,'4.54kg','image9',13.99);
INSERT INTO "table_taches" VALUES (1,4,1,'20/02/2022',NULL,NULL,NULL,NULL,NULL,0,NULL);
INSERT INTO "table_taches" VALUES (2,5,1,'20/02/2022',NULL,NULL,NULL,NULL,NULL,0,NULL);
INSERT INTO "table_taches" VALUES (3,6,2,'19/02/2022',NULL,NULL,NULL,NULL,NULL,0,NULL);
INSERT INTO "table_taches" VALUES (4,1,2,'19/02/2022',NULL,NULL,NULL,NULL,NULL,0,NULL);
INSERT INTO "table_taches" VALUES (5,2,3,'19/02/2022',NULL,NULL,NULL,NULL,NULL,0,NULL);
INSERT INTO "table_taches" VALUES (6,3,3,'19/02/2022',NULL,NULL,NULL,NULL,NULL,0,NULL);
COMMIT;
