USE jediarchives;

INSERT INTO Beings
VALUES 
(NULL, 'Yoda', 'Unknown', 'Unknown', 'Unknown', '4 ABY', 'Dagobah', 'Unknown', 'Jedi'),
(NULL, 'Windu', 'Mace', '72 BBY', 'Haruun Kal', '19 BBY', 'Coruscant', 'Human ', 'Jedi'),
(NULL, 'Mundi', 'Ki-Adi', 'Unknown', 'Unknown', '19 BBY', 'Mygeeto', 'Cerean','Jedi'),
(NULL, 'Bridger', 'Ezra', '19 BBY', 'Lothal', NULL, NULL, 'Human','Jedi'),
(NULL, 'Tano', 'Ahsoka', '36 BBY', 'Shili', NULL, NULL, 'Togruta', 'Jedi'),
(NULL, 'Kenobi', 'Obi-Wan', '57 BBY', 'Stewjon', '0 BBY', 'Death Start', 'Human','Jedi'),
(NULL, 'Jinn', 'Qui-Gon', '80 BBY', 'Coruscant', '32 BBY', 'Naboo', 'Human','Jedi'), 

(NULL, 'Maul', 'Unknown', '54 BBY', 'Dathomir', '2 BBY', 'Tatooine', 'Zabrak','Sith'),
(NULL, 'Palpatine', 'Sheev', '82 BBY', 'Naboo', '35 ABY', 'Exegol', 'Human', 'Sith'),
(NULL, 'Damask II', 'Hego', '147 BBY', 'Mygeeto', '32 BBY', 'Coruscant', 'Muun','Sith'),

(NULL, 'Fett', 'Boba', '32 BBY', 'Kamino', NULL, NULL, 'Human', 'BountyHunter'),
(NULL, 'Sing', 'Aurra', '51 BBY', 'Nar Shaddaa', '10 BBY', 'Unknown', 'Palliduvan', 'BountyHunter'),
(NULL, 'Bane', 'Cad', '62 BBY', 'Duro', '9 ABY', 'Tatooine', 'Duros', 'BountyHunter'),

(NULL, 'Solo', 'Han', '32 BBY', 'Corellia', '34 ABY', 'Ilum', 'Human','Smuggler'),
(NULL, 'Chewbacca', NULL, '200 BBY', 'Kashyyyk', NULL, NULL, 'Wookie', 'Smuggler'),
(NULL, 'Calrissian', 'Lando', '43 BBY', 'Socorro', NULL, NULL, 'Human','Smuggler');


INSERT INTO Jedi
VALUES 
(NULL, 'Yoda', 'Grand Master', 'Consular', 'shoto, single', 'green'),
(NULL, 'Windu', 'Master', 'Guardian', 'regular, single', 'amethyst'),
(NULL, 'Mundi', 'Master', 'Guardian', 'regular, single', 'blue'),
(NULL, 'Bridger', 'Padawan', 'Sentinel', 'regular, single', 'blue'),
(NULL, 'Tano', 'Padawan', 'Guardian', 'regular, two', 'white'),
(NULL, 'Kenobi', 'Master', 'Guardian', 'regular, single', 'blue'),
(NULL, 'Jinn', 'Master', 'Sentinel', 'regular, single', 'green');


INSERT INTO Sith
VALUES
(NULL, 'Maul', 'Apprentice', 'Assassin', 'lightstaff', 'red'),
(NULL, 'Palpatine', 'Master', 'Lord', 'regular, single', 'red'),
(NULL, 'Damask II', 'Master', 'Lord', 'regular, single', 'red');


INSERT INTO BountyHunters
VALUES
(NULL, 'Fett', 'Fett gotra'),
(NULL, 'Sing', 'Hutt Clan'),
(NULL, 'Bane', 'Pyke Syndicate');

INSERT INTO Smugglers
VALUES
(NULL, 'Solo', 'Rebel Alliance'),
(NULL, 'Chewbacca', 'Rebel Alliance'),
(NULL, 'Calrissian', 'Rebel Alliance');

INSERT INTO Battles
VALUES
(NULL, 'Naboo', '32 BBY', 7, 6, 8, NULL, 'Death of Qui-Gon and Darth Maul'),
(NULL, 'Tatooine', '4 ABY', 14, NULL, 11, NULL, 'Apparent death of Boba Fett');

-- proba
