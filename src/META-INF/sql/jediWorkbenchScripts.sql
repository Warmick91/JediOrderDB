use jediarchives;

delete from jedi where JediLastName = "aaa";
delete from beings where LastName = "aaa";
delete from jedi where JediLastName = "bbb";
delete from beings where LastName = "bbb";
delete from jedi where JediLastName = "ccc";
delete from beings where LastName = "ccc";
delete from jedi where JediLastName = "ddd";
delete from beings where LastName = "ddd";
delete from jedi where JediLastName = "eee";
delete from beings where LastName = "eee";

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
    
