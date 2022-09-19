USE jediarchives;

INSERT INTO Beings
VALUES 
(NULL, 'Yoda', 'Unknown', 'Unknown', 'Unknown', '4 ABY', 'Dagobah', 'Jedi'),
(NULL, 'Windu', 'Mace', '72 BBY', 'Haruun Kal', '19 BBY', 'Coruscant', 'Jedi'),
(NULL, 'Mundi', 'Ki-Adi', 'Unknown', 'Unknown', '19 BBY', 'Mygeeto', 'Jedi'),
(NULL, 'Bridger', 'Ezra', '19 BBY', 'Lothal', NULL, NULL, 'Jedi'),
(NULL, 'Tano', 'Ahsoka', '36 BBY', 'Shili', NULL, NULL, 'Jedi'), 

(NULL, 'Maul', 'Unknown', '54 BBY', 'Dathomir', '2 BBY', 'Tatooine', 'Sith'),
(NULL, 'Palpatine', 'Sheev', '82 BBY', 'Naboo', '35 ABY', 'Exegol', 'Sith'),
(NULL, 'Damask II', 'Hego', '147 BBY', 'Mygeeto', '32 BBY', 'Coruscant', 'Sith'),

(NULL, 'Fett', 'Boba', '32 BBY', 'Kamino', NULL, NULL, 'BountyHunter'),
(NULL, 'Sing', 'Aurra', '51 BBY', 'Nar Shaddaa', '10 BBY', 'Unknown', 'BountyHunter'),
(NULL, 'Bane', 'Cad', '62 BBY', 'Duro', '9 ABY', 'Tatooine', 'BountyHunter'),

(NULL, 'Solo', 'Han', '32 BBY', 'Corellia', '34 ABY', 'Ilum', 'Smuggler'),
(NULL, 'Chewbacca', NULL, '200 BBY', 'Kashyyyk', NULL, NULL, 'Smuggler'),
(NULL, 'Calrissian', 'Lando', '43 BBY', 'Socorro', NULL, NULL, 'Smuggler');


INSERT INTO Jedi
VALUES 
(NULL, 'Yoda', 'Grand Master', 'Consular', 'shoto, single', 'green'),
(NULL, 'Windu', 'Master', 'Guardian', 'regular, single', 'amethyst'),
(NULL, 'Mundi', 'Master', 'Guardian', 'regular, single', 'blue'),
(NULL, 'Bridger', 'Padawan', 'Sentinel', 'regular, single', 'blue'),
(NULL, 'Tano', 'Padawan', 'Guardian', 'regular, two', 'white');


INSERT INTO Sith
VALUES
(NULL, ),
(NULL, ),
(NULL, );

CREATE TABLE Sith (
	SithID BIGINT NOT NULL AUTO_INCREMENT,
	SithName VARCHAR(15) NOT NULL,
	TitleAtDeath VARCHAR(15) NOT NULL,
	SaberType VARCHAR(10) NOT NULL,
	SaberColor VARCHAR(25) NOT NULL,
	PRIMARY KEY (SithID),
	FOREIGN KEY (SithID) REFERENCES beings (beingID)
);

CREATE TABLE BountyHunters (
	HunterID BIGINT NOT NULL AUTO_INCREMENT,
	Organisation VARCHAR(250) NOT NULL,
	PRIMARY KEY (HunterID),
	FOREIGN KEY (HunterID) REFERENCES beings (beingID)
);

CREATE TABLE Smugglers (
	SmugglerID BIGINT NOT NULL AUTO_INCREMENT,
	Organisation VARCHAR(250),
	PRIMARY KEY (SmugglerID),
	FOREIGN KEY (SmugglerID) REFERENCES beings (beingID)
);

CREATE TABLE Battles (
	BattleID BIGINT NOT NULL,
	Location VARCHAR(250) NOT NULL,
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