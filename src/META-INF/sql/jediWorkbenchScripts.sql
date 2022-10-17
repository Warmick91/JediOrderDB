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