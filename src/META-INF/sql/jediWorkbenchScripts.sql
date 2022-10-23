use jediarchives;

delete from beings where LastName = "aaa";
delete from beings where LastName = "bbb";
delete from beings where LastName = "ccc";
delete from beings where LastName = "ddd";
delete from beings where LastName = "eee";
delete from beings where LastName = "fff";
delete from beings where LastName = "ggg";

select * from jedi;
select * from beings;

-- SELECT_ALL_JEDI_FOR_EDIT
SELECT j.JediID
	, b.LastName 
    , b.firstName
    , b.species
    , b.birthdate
    , b.birthplace
    , b.deathdate
    , b.deathplace
    , j.jedirank
    , j.jedispecialization
    , j.sabertype
    , j.sabercolor
    FROM beings AS b, jedi AS j WHERE beingID = JediID;
	
	use jediarchives;


/*
static private final String QUERY_SEMINARS = "SELECT * FROM Seminar WHERE " 
		+ "(? IS NULL OR Thema = ?) AND "
		+ "(? IS NULL OR LOWER(Beschreibung) LIKE ?) AND "
		+ "(? IS NULL OR SemNr >= ?) AND "
		+ "(? IS NULL OR SemNr <= ?)";
        */
        
        use jediarchives;

-- Procedure

SELECT j.JediIDeditJediAndBeings
	, b.LastName 
    , b.firstName
    , b.species
    , b.birthdate
    , b.birthplace
    , b.deathdate
    , b.deathplace
    , j.jedirank
    , j.jedispecialization
    , j.sabertype
    , j.sabercolor
    FROM beings AS b, jedi AS j WHERE beingID = JediID;
    

            
SELECT j.jediid, b.lastname, j.jedirank, j.jedispecialization, j.sabertype, j.sabercolor FROM jedi AS j, beings AS b WHERE b.beingclass = 'jedi' AND j.beingRefID = b.beingid ORDER BY JediID;    
SELECT s.sithid, b.lastname, s.titleatdeath, s.sithspecialization, s.sabertype, s.sabercolor FROM sith as s, beings as b WHERE b.beingclass = 'sith' AND s.beingRefID = b.beingid ORDER BY SithID;

select * FROM beings;
select * from jedi;     
select * from sith;


INSERT INTO Jedi SELECT NULL, 'Master', 'Guardian', 'aaa', 'aaa', MAX(beings.beingID) FROM beings;

describe jedi;
describe beings;

SELECT beingRefID FROM jedi WHERE beingReFID = 2;

delete from beings Where beingID BETWEEN 23 AND 40;