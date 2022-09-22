DROP SEQUENCE BeingsSequence;
DROP SEQUENCE JediSequence;
DROP SEQUENCE SithSequence;
DROP SEQUENCE BountyHuntersSequence;
DROP SEQUENCE SmugglersSequence;
DROP TABLE Beings;
DROP TABLE Jedi;
DROP TABLE Sith;
DROP TABLE BountyHunters;
DROP TABLE Smugglers;
DROP TABLE Battles;


CREATE TABLE Beings (
	beingID INTEGER UNIQUE NOT NULL,
	LastName VARCHAR(30) NOT NULL,
	FirstName VARCHAR(250),
	BirthDate VARCHAR(250),
	BirthPlace VARCHAR(250),
	DeathDate VARCHAR(250),
	DeathPlace VARCHAR(250),
	beingClass CHAR(12) NOT NULL CHECK (beingClass IN ('Jedi', 'Sith', 'BountyHunter', 'Smuggler')),
	PRIMARY KEY (LastName)
);

CREATE TABLE Jedi (
	JediID INTEGER UNIQUE NOT NULL,
	JediLastName VARCHAR(250) NOT NULL,
	JediRank CHAR(12) NOT NULL CHECK (JediRank IN ('Grand Master', 'Master', 'Knight', 'Padawan')),
	JediSpecialization CHAR(8) NOT NULL CHECK (JediSpecialization IN ('Guardian', 'Consular', 'Sentinel')),
	SaberType VARCHAR(30) NOT NULL,
	SaberColor VARCHAR(30) NOT NULL,
	PRIMARY KEY (JediLastName),
	FOREIGN KEY (JediLastName) REFERENCES beings (LastName) ON DELETE CASCADE
);

CREATE TABLE Sith (
	SithID INTEGER UNIQUE NOT NULL,
	SithLastName VARCHAR(250) NOT NULL,
	TitleAtDeath CHAR(10) NOT NULL CHECK (TitleAtDeath IN ('Master', 'Apprentice')),
	SithSpecialization CHAR(8) NOT NULL CHECK (SithSpecialization IN ('Marauder', 'Assassin', 'Lord')),
	SaberType VARCHAR(30) NOT NULL,
	SaberColor VARCHAR(25) NOT NULL,
	PRIMARY KEY (SithLastName),
	FOREIGN KEY (SithLastName) REFERENCES beings (LastName) ON DELETE CASCADE
);

CREATE TABLE BountyHunters (
	HunterID INTEGER UNIQUE NOT NULL,
	BountyHunterLastName VARCHAR(250) NOT NULL,
	Organisation VARCHAR(250) NOT NULL,
	PRIMARY KEY (BountyHunterLastName),
	FOREIGN KEY (BountyHunterLastName) REFERENCES beings (LastName) ON DELETE CASCADE
);

CREATE TABLE Smugglers (
	SmugglerID INTEGER UNIQUE NOT NULL,
	SmugglerLastName VARCHAR(250) NOT NULL,
	Organisation VARCHAR(250),
	PRIMARY KEY (SmugglerLastName),
	FOREIGN KEY (SmugglerLastName) REFERENCES beings (LastName) ON DELETE CASCADE
);

-----------

CREATE TABLE Battles (
	BattleID INTEGER NOT NULL,
	Location VARCHAR(250) NOT NULL,
	BattleDate VARCHAR(30) NOT NULL,
	FighterA1 VARCHAR(250) NOT NULL,
	FighterA2 VARCHAR(250),
	FighterB1 VARCHAR(250) NOT NULL,
	FighterB2 VARCHAR(250),
	Outcome VARCHAR(250) NOT NULL,
	PRIMARY KEY (BattleID),
	FOREIGN KEY (FighterA1) REFERENCES beings (LastName) ON DELETE CASCADE,
	FOREIGN KEY (FighterA2) REFERENCES beings (LastName) ON DELETE CASCADE,
	FOREIGN KEY (FighterB1) REFERENCES beings (LastName) ON DELETE CASCADE,
	FOREIGN KEY (FighterB2) REFERENCES beings (LastName) ON DELETE CASCADE
);