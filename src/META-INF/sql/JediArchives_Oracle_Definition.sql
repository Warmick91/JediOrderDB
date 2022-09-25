DROP SEQUENCE BeingsSequence;
DROP SEQUENCE Jedi_Index;
DROP SEQUENCE Sith_Index;
DROP SEQUENCE BH_Index;
DROP SEQUENCE SmugglersSequence;
DROP TABLE Jedi;
DROP TABLE Sith;
DROP TABLE BountyHunters;
DROP TABLE Smugglers;
DROP TABLE Battles;
DROP TABLE Beings;


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


-- Sequence for Beings

CREATE SEQUENCE Beings_Index INCREMENT BY 1 START WITH 1;

CREATE OR REPLACE TRIGGER Beings_Index_TR
BEFORE INSERT ON Beings
FOR EACH ROW
DECLARE id NUMBER;
BEGIN
SELECT Beings_Index.NEXTVAL INTO id FROM DUAL;
:new.beingID := id;
END;

-- Sequence for Jedi

CREATE SEQUENCE Jedi_Index INCREMENT BY 1 START WITH 1;

CREATE OR REPLACE TRIGGER Jedi_Index_TR
BEFORE INSERT ON Jedi
FOR EACH ROW
DECLARE id NUMBER;
BEGIN
SELECT Jedi_Index.NEXTVAL INTO id FROM DUAL;
:new.JediID := id;
END;
/

-- Sequence for Sith

CREATE SEQUENCE Sith_Index INCREMENT BY 1 START WITH 1;

CREATE OR REPLACE TRIGGER Sith_Index_TR
BEFORE INSERT ON Sith
FOR EACH ROW
DECLARE id NUMBER;
BEGIN
SELECT Sith_Index.NEXTVAL INTO id FROM DUAL;
:new.SithID := id;
END;
/

-- Sequence for BountyHunters

CREATE SEQUENCE BH_Index INCREMENT BY 1 START WITH 1;


-- Sequence for Smugglers

CREATE SEQUENCE Smugglers_Index INCREMENT BY 1 START WITH 1;




-----
CREATE OR REPLACE PROCEDURE addBeingToClass (
	in_being_class IN CHAR(12),
	in_
)
IS
BEGIN
SELECT 
IF
END addBeingToSpecClass;