use jediarchives;

DELIMITER //

CREATE PROCEDURE insertIntoJediAndBeings(
			IN lastName VARCHAR(30)
			 , firstName VARCHAR(250)
			 , bd VARCHAR(250)
			 , bp VARCHAR(250)
			 , dd VARCHAR(250)
			 , dp VARCHAR(250)
			 , speci VARCHAR(250)
			 
			 , jRank VARCHAR(250)
			 , jSpec VARCHAR(250)
			 , saberT VARCHAR(30)
			 , saberC VARCHAR(30)
)
BEGIN
		INSERT INTO Beings VALUES (NULL, lastName, firstName, bd, bp, dd, dp, speci, 'Jedi');
		INSERT INTO Jedi VALUES (NULL, lastName, jRank, jSpec, saberT, saberC);
END //

DELIMITER ;
