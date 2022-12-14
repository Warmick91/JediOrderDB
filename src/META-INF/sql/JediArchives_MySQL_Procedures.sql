use jediarchives;
DROP PROCEDURE IF EXISTS insertIntoJediAndBeings;
DROP PROCEDURE IF EXISTS editJediAndBeings;

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
		INSERT INTO Jedi SELECT NULL, jRank, jSpec, saberT, saberC, MAX(beings.beingID) FROM beings;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE editJediAndBeings(
			IN ID BIGINT
			 , lastName VARCHAR(30)
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
		UPDATE Beings
        SET   LastName = lastName
			, FirstName = firstName
            , BirthDate = bd
            , BirthPlace = bp
            , DeathDate = dd
            , DeathPlace = dp
            , Species = speci
		WHERE 
			beingID = ID;
            
		UPDATE Jedi
        SET   JediRank = jRank
            , JediSpecialization = jSpec
            , SaberType = saberT
            , SaberColor = saberC
		WHERE
			JediID = ID;

END //
DELIMITER ;