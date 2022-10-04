INSERT ALL
INTO Beings (LastName, FirstName, BirthDate, BirthPlace, DeathDate, DeathPlace, beingClass) VALUES ('Yoda', 'Unknown', 'Unknown', 'Unknown', '4 ABY', 'Dagobah', 'Jedi')
INTO Beings (LastName, FirstName, BirthDate, BirthPlace, DeathDate, DeathPlace, beingClass) VALUES ('Windu', 'Mace', '72 BBY', 'Haruun Kal', '19 BBY', 'Coruscant', 'Jedi') 
INTO Beings (LastName, FirstName, BirthDate, BirthPlace, DeathDate, DeathPlace, beingClass) VALUES ('Mundi', 'Ki-Adi', 'Unknown', 'Unknown', '19 BBY', 'Mygeeto', 'Jedi')
INTO Beings (LastName, FirstName, BirthDate, BirthPlace, DeathDate, DeathPlace, beingClass) VALUES ('Bridger', 'Ezra', '19 BBY', 'Lothal', NULL, NULL, 'Jedi')
INTO Beings (LastName, FirstName, BirthDate, BirthPlace, DeathDate, DeathPlace, beingClass) VALUES ('Tano', 'Ahsoka', '36 BBY', 'Shili', NULL, NULL, 'Jedi')
INTO Beings (LastName, FirstName, BirthDate, BirthPlace, DeathDate, DeathPlace, beingClass) VALUES ('Kenobi', 'Obi-Wan', '57 BBY', 'Stewjon', '0 BBY', 'Death Start', 'Jedi')
INTO Beings (LastName, FirstName, BirthDate, BirthPlace, DeathDate, DeathPlace, beingClass) VALUES ('Jinn', 'Qui-Gon', '80 BBY', 'Coruscant', '32 BBY', 'Naboo', 'Jedi') 
INTO Beings (LastName, FirstName, BirthDate, BirthPlace, DeathDate, DeathPlace, beingClass) VALUES ('Maul', 'Unknown', '54 BBY', 'Dathomir', '2 BBY', 'Tatooine', 'Sith')
INTO Beings (LastName, FirstName, BirthDate, BirthPlace, DeathDate, DeathPlace, beingClass) VALUES ('Palpatine', 'Sheev', '82 BBY', 'Naboo', '35 ABY', 'Exegol', 'Sith')
INTO Beings (LastName, FirstName, BirthDate, BirthPlace, DeathDate, DeathPlace, beingClass) VALUES ('Damask II', 'Hego', '147 BBY', 'Mygeeto', '32 BBY', 'Coruscant', 'Sith')
INTO Beings (LastName, FirstName, BirthDate, BirthPlace, DeathDate, DeathPlace, beingClass) VALUES ('Fett', 'Boba', '32 BBY', 'Kamino', NULL, NULL, 'BountyHunter')
INTO Beings (LastName, FirstName, BirthDate, BirthPlace, DeathDate, DeathPlace, beingClass) VALUES ('Sing', 'Aurra', '51 BBY', 'Nar Shaddaa', '10 BBY', 'Unknown', 'BountyHunter')
INTO Beings (LastName, FirstName, BirthDate, BirthPlace, DeathDate, DeathPlace, beingClass) VALUES ('Bane', 'Cad', '62 BBY', 'Duro', '9 ABY', 'Tatooine', 'BountyHunter')
INTO Beings (LastName, FirstName, BirthDate, BirthPlace, DeathDate, DeathPlace, beingClass) VALUES ('Solo', 'Han', '32 BBY', 'Corellia', '34 ABY', 'Ilum', 'Smuggler')
INTO Beings (LastName, FirstName, BirthDate, BirthPlace, DeathDate, DeathPlace, beingClass) VALUES ('Chewbacca', NULL, '200 BBY', 'Kashyyyk', NULL, NULL, 'Smuggler')
INTO Beings (LastName, FirstName, BirthDate, BirthPlace, DeathDate, DeathPlace, beingClass) VALUES ('Calrissian', 'Lando', '43 BBY', 'Socorro', NULL, NULL, 'Smuggler')
SELECT * FROM dual;


INSERT ALL
INTO Jedi (JediLastName, JediRank, JediSpecialization, SaberType, SaberColor) VALUES ('Yoda', 'Grand Master', 'Consular', 'shoto, single', 'green')
INTO Jedi (JediLastName, JediRank, JediSpecialization, SaberType, SaberColor) VALUES ('Windu', 'Master', 'Guardian', 'regular, single', 'amethyst')
INTO Jedi (JediLastName, JediRank, JediSpecialization, SaberType, SaberColor) VALUES ('Mundi', 'Master', 'Guardian', 'regular, single', 'blue')
INTO Jedi (JediLastName, JediRank, JediSpecialization, SaberType, SaberColor) VALUES ('Bridger', 'Padawan', 'Sentinel', 'regular, single', 'blue')
INTO Jedi (JediLastName, JediRank, JediSpecialization, SaberType, SaberColor) VALUES ('Tano', 'Padawan', 'Guardian', 'regular, two', 'white')
INTO Jedi (JediLastName, JediRank, JediSpecialization, SaberType, SaberColor) VALUES ('Kenobi', 'Master', 'Guardian', 'regular, single', 'blue')
INTO Jedi (JediLastName, JediRank, JediSpecialization, SaberType, SaberColor) VALUES ('Jinn', 'Master', 'Sentinel', 'regular, single', 'green')
SELECT * FROM dual;


INSERT ALL
INTO Sith (SithLastName, TitleAtDeath, SithSpecialization, SaberType, SaberColor) VALUES ('Maul', 'Apprentice', 'Assassin', 'lightstaff', 'red')
INTO Sith (SithLastName, TitleAtDeath, SithSpecialization, SaberType, SaberColor) VALUES ('Palpatine', 'Master', 'Lord', 'regular, single', 'red')
INTO Sith (SithLastName, TitleAtDeath, SithSpecialization, SaberType, SaberColor) VALUES ('Damask II', 'Master', 'Lord', 'regular, single', 'red')
SELECT * FROM dual;

-----

INSERT ALL
INTO BountyHunters (BountyHunterLastName, Organisation) VALUES ('Fett', 'Fett gotra')
INTO BountyHunters (BountyHunterLastName, Organisation) VALUES ('Sing', 'Hutt Clan')
INTO BountyHunters (BountyHunterLastName, Organisation) VALUES ('Bane', 'Pyke Syndicate')
SELECT * FROM dual;

-----

INSERT ALL
INTO Smugglers (SmugglerLastName, Organisation) VALUES ('Solo', 'Rebel Alliance')
INTO Smugglers (SmugglerLastName, Organisation) VALUES ('Chewbacca', 'Rebel Alliance')
INTO Smugglers (SmugglerLastName, Organisation) VALUES ('Calrissian', 'Rebel Alliance')
SELECT * FROM dual;

-----

INSERT ALL
INTO Battles (Location, BattleDate, FighterA1, FighterA2, FighterB1, FighterB2, Outcome) VALUES ('Naboo', '32 BBY', 'Jinn', 'Kenobi', 'Maul', NULL, 'Death of Qui-Gon and Darth Maul') 
INTO Battles (Location, BattleDate, FighterA1, FighterA2, FighterB1, FighterB2, Outcome) VALUES ('Tatooine', '4 ABY', 'Solo', NULL, 'Fett', NULL, 'An Apparent death of Boba Fett')
SELECT * FROM dual;