DROP DATABASE IF EXISTS jediarchives;
CREATE DATABASE jediarchives;
USE jediarchives;

CREATE TABLE Beings (
	beingID BIGINT NOT NULL AUTO_INCREMENT,
	lastName VARCHAR(30) UNIQUE NOT NULL,
	firstName VARCHAR(250),
	birthDate VARCHAR(250),
	birthPlace VARCHAR(250),
	deathDate VARCHAR(250),
	deathPlace VARCHAR(250),
	Species VARCHAR(250),
	beingClass ENUM('Jedi', 'Sith', 'BountyHunter', 'Smuggler'),
	PRIMARY KEY (beingID)
);

CREATE TABLE Jedi (
	jediID BIGINT NOT NULL AUTO_INCREMENT,
	jediRank ENUM('Grand Master', 'Master', 'Knight', 'Padawan') NOT NULL,
	jediSpecialization ENUM ('Guardian', 'Consular', 'Sentinel') NOT NULL,
	saberType VARCHAR(30) NOT NULL,
	saberColor VARCHAR(30) NOT NULL,
    beingRefID BIGINT NOT NULL,
	PRIMARY KEY (jediID),
    FOREIGN KEY (beingRefID) REFERENCES beings (beingID) ON DELETE CASCADE
);

CREATE TABLE Sith (
	sithID BIGINT NOT NULL AUTO_INCREMENT,
	titleAtDeath ENUM ('Master', 'Apprentice') NOT NULL,
	sithSpecialization ENUM ('Marauder', 'Assassin', 'Lord') NOT NULL,
	saberType VARCHAR(30) NOT NULL,
	saberColor VARCHAR(25) NOT NULL,
    beingRefID BIGINT NOT NULL,
	PRIMARY KEY (SithID),
	FOREIGN KEY (beingRefID) REFERENCES beings (beingID) ON DELETE CASCADE
);

CREATE TABLE BountyHunters (
	hunterID BIGINT NOT NULL AUTO_INCREMENT,
	organisation VARCHAR(250) NOT NULL,
    beingRefID BIGINT NOT NULL,
	PRIMARY KEY (hunterID),
	FOREIGN KEY (beingRefID) REFERENCES beings (beingID) ON DELETE CASCADE
);

CREATE TABLE Smugglers (
	smugglerID BIGINT NOT NULL AUTO_INCREMENT,
	organisation VARCHAR(250),
	beingRefID BIGINT NOT NULL,
	PRIMARY KEY (smugglerID),
	FOREIGN KEY (beingRefID) REFERENCES beings (beingID) ON DELETE CASCADE
);

CREATE TABLE Battles (
	battleID BIGINT NOT NULL AUTO_INCREMENT,
	location VARCHAR(250) NOT NULL,
	battleDate VARCHAR(30) NOT NULL,
	fighterA1 BIGINT,
	fighterA2 BIGINT,
	fighterB1 BIGINT,
	fighterB2 BIGINT,
	outcome VARCHAR(250) NOT NULL,
	PRIMARY KEY (battleID),
	FOREIGN KEY (fighterA1) REFERENCES beings (beingID) ON DELETE SET NULL,
	FOREIGN KEY (fighterA2) REFERENCES beings (beingID) ON DELETE SET NULL,
	FOREIGN KEY (fighterB1) REFERENCES beings (beingID) ON DELETE SET NULL,
	FOREIGN KEY (fighterB2) REFERENCES beings (beingID) ON DELETE SET NULL
);

CREATE TABLE Planets (
	planetID BIGINT NOT NULL AUTO_INCREMENT,
    planetName VARCHAR(32) NOT NULL,
    region VARCHAR(64) NOT NULL,  
    sector VARCHAR(64) NOT NULL,
    suns INT,
    diameter BIGINT NOT NULL,
    atmosphere VARCHAR(64) NOT NULL,
    climate VARCHAR(64) NOT NULL,
    nativeSpecies VARCHAR(128),
    PRIMARY KEY (planetID)
);

