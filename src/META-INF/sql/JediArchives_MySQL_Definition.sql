DROP DATABASE IF EXISTS jediarchives;
CREATE DATABASE jediarchives;
USE jediarchives;

CREATE TABLE Beings (
	beingID BIGINT NOT NULL AUTO_INCREMENT,
	LastName VARCHAR(30) NOT NULL,
	FirstName VARCHAR(250),
	BirthDate VARCHAR(250),
	BirthPlace VARCHAR(250),
	DeathDate VARCHAR(250),
	DeathPlace VARCHAR(250),
	Species VARCHAR(250),
	beingClass ENUM('Jedi', 'Sith', 'BountyHunter', 'Smuggler'),
	PRIMARY KEY (beingID)
);

CREATE TABLE Jedi (
	JediID BIGINT NOT NULL AUTO_INCREMENT,
	JediLastName VARCHAR(250) NOT NULL,
	JediRank ENUM('Grand Master', 'Master', 'Knight', 'Padawan'),
	JediSpecialization ENUM ('Guardian', 'Consular', 'Sentinel'),
	SaberType VARCHAR(30) NOT NULL,
	SaberColor VARCHAR(30) NOT NULL,
	PRIMARY KEY (JediID),
	FOREIGN KEY (JediID) REFERENCES beings (beingID)
);

CREATE TABLE Sith (
	SithID BIGINT NOT NULL AUTO_INCREMENT,
	SithLastName VARCHAR(250) NOT NULL,
	TitleAtDeath ENUM ('Master', 'Apprentice'),
	SithSpecialization ENUM ('Marauder', 'Assassin', 'Lord'),
	SaberType VARCHAR(30) NOT NULL,
	SaberColor VARCHAR(25) NOT NULL,
	PRIMARY KEY (SithID),
	FOREIGN KEY (SithID) REFERENCES beings (beingID)
);

CREATE TABLE BountyHunters (
	HunterID BIGINT NOT NULL AUTO_INCREMENT,
	BountyHunterLastName VARCHAR(250) NOT NULL,
	Organisation VARCHAR(250) NOT NULL,
	PRIMARY KEY (HunterID),
	FOREIGN KEY (HunterID) REFERENCES beings (beingID)
);

CREATE TABLE Smugglers (
	SmugglerID BIGINT NOT NULL AUTO_INCREMENT,
	SmugglerLastName VARCHAR(250) NOT NULL,
	Organisation VARCHAR(250),
	PRIMARY KEY (SmugglerID),
	FOREIGN KEY (SmugglerID) REFERENCES beings (beingID)
);

CREATE TABLE Battles (
	BattleID BIGINT NOT NULL AUTO_INCREMENT,
	Location VARCHAR(250) NOT NULL,
	BattleDate VARCHAR(30) NOT NULL,
	FighterA1 BIGINT NOT NULL,
	FighterA2 BIGINT,
	FighterB1 BIGINT NOT NULL,
	FighterB2 BIGINT,
	Outcome VARCHAR(250) NOT NULL,
	PRIMARY KEY (BattleID),
	FOREIGN KEY (FighterA1) REFERENCES beings (beingID),
	FOREIGN KEY (FighterA2) REFERENCES beings (beingID),
	FOREIGN KEY (FighterB1) REFERENCES beings (beingID),
	FOREIGN KEY (FighterB2) REFERENCES beings (beingID)
);