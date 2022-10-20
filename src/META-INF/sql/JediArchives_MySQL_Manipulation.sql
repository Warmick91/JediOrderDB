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
(NULL, 'Grand Master', 'Consular', 'shoto, single', 'green', 1),
(NULL, 'Master', 'Guardian', 'regular, single', 'amethyst', 2),
(NULL, 'Master', 'Guardian', 'regular, single', 'blue', 3),
(NULL, 'Padawan', 'Sentinel', 'regular, single', 'blue', 4),
(NULL, 'Padawan', 'Guardian', 'regular, two', 'white', 5),
(NULL, 'Master', 'Guardian', 'regular, single', 'blue', 6),
(NULL,  'Master', 'Sentinel', 'regular, single', 'green', 7);


INSERT INTO Sith
VALUES
(NULL, 'Apprentice', 'Assassin', 'lightstaff', 'red', 8),
(NULL, 'Master', 'Lord', 'regular, single', 'red', 9),
(NULL, 'Master', 'Lord', 'regular, single', 'red', 10);


INSERT INTO BountyHunters
VALUES
(NULL, 'Fett gotra', 11),
(NULL, 'Hutt Clan', 12),
(NULL, 'Pyke Syndicate', 13);

INSERT INTO Smugglers
VALUES
(NULL, 'Rebel Alliance', 14),
(NULL, 'Rebel Alliance', 15),
(NULL, 'Rebel Alliance', 16);

INSERT INTO Battles
VALUES
(NULL, 'Naboo', '32 BBY', 7, 6, 8, NULL, 'Death of Qui-Gon and Darth Maul'),
(NULL, 'Tatooine', '4 ABY', 14, NULL, 11, NULL, 'Apparent death of Boba Fett');

-- proba
