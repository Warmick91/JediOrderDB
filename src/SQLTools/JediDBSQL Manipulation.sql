USE jediarchives;

INSERT INTO Beings
VALUES 
(NULL, 'Yoda', 'Unknown', 'Unknown', 'Unknown', '4 ABY', 'Dagobah', 'Jedi'),
(NULL, 'Windu', 'Mace', '72 BBY', 'Haruun Kal', '19 BBY', 'Coruscant', 'Jedi'),
(NULL, 'Mundi', 'Ki-Adi', 'Unknown', 'Unknown', '19 BBY', 'Mygeeto', 'Jedi'),
(NULL, 'Bridger', 'Ezra', '19 BBY', 'Lothal', NULL, NULL, 'Jedi'),
(NULL, 'Tano', 'Ahsoka', '36 BBY', 'Shili', NULL, NULL, 'Jedi'),
(NULL, 'Kenobi', 'Obi-Wan', '57 BBY', 'Stewjon', '0 BBY', 'Death Start', 'Jedi'),
(NULL, 'Jinn', 'Qui-Gon', '80 BBY', 'Coruscant', '32 BBY', 'Naboo', 'Jedi'), 

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
(NULL, 'Naboo', '32 BBY', 'Jinn', 'Kenobi', 'Maul', NULL, 'Death of Qui-Gon and Darth Maul'),
(NULL, 'Tatooine', '4 ABY', 'Solo', NULL, 'Fett', NULL, 'Apparent death of Boba Fett');