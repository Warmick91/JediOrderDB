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
	beingClass ENUM('Jedi', 'Sith', 'BountyHunter', 'Smuggler'),
    UNIQUE (beingID),
	PRIMARY KEY (LastName)
);

CREATE TABLE Jedi (
	JediID BIGINT NOT NULL AUTO_INCREMENT,
	JediLastName VARCHAR(250) NOT NULL,
	JediRank VARCHAR(15) NOT NULL,
	JediSpecialization VARCHAR(15),
	SaberType VARCHAR(30) NOT NULL,
	SaberColor VARCHAR(30) NOT NULL,
	UNIQUE (JediID),
	PRIMARY KEY (JediLastName),
	FOREIGN KEY (JediLastName) REFERENCES beings (LastName)
);

CREATE TABLE Sith (
	SithID BIGINT NOT NULL AUTO_INCREMENT,
	SithLastName VARCHAR(250) NOT NULL,
	TitleAtDeath VARCHAR(15) NOT NULL,
	SaberType VARCHAR(10) NOT NULL,
	SaberColor VARCHAR(25) NOT NULL,
	UNIQUE (SithID),
	PRIMARY KEY (SithLastName),
	FOREIGN KEY (SithLastName) REFERENCES beings (LastName)
);

CREATE TABLE BountyHunters (
	HunterID BIGINT NOT NULL AUTO_INCREMENT,
	BountyHunterLastName VARCHAR(250) NOT NULL,
	Organisation VARCHAR(250) NOT NULL,
	UNIQUE (HunterID),
	PRIMARY KEY (BountyHunterLastName),
	FOREIGN KEY (BountyHunterLastName) REFERENCES beings (LastName)
);

CREATE TABLE Smugglers (
	SmugglerID BIGINT NOT NULL AUTO_INCREMENT,
	SmugglerLastName VARCHAR(250) NOT NULL,
	Organisation VARCHAR(250),
	UNIQUE (SmugglerID),
	PRIMARY KEY (SmugglerLastName),
	FOREIGN KEY (SmugglerLastName) REFERENCES beings (LastName)
);

CREATE TABLE Battles (
	BattleID BIGINT NOT NULL,
	Location VARCHAR(250) NOT NULL,
	FighterA1 VARCHAR(250) NOT NULL,
	FighterA2 VARCHAR(250),
	FighterB1 VARCHAR(250) NOT NULL,
	FighterB2 VARCHAR(250),
	Outcome VARCHAR(250) NOT NULL,
	PRIMARY KEY (BattleID),
	FOREIGN KEY (FighterA1) REFERENCES beings (LastName),
	FOREIGN KEY (FighterA2) REFERENCES beings (LastName),
	FOREIGN KEY (FighterB1) REFERENCES beings (LastName),
	FOREIGN KEY (FighterB2) REFERENCES beings (LastName)
);