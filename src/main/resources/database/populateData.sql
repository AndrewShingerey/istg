INSERT INTO Roles
(id_role, role_user)
SELECT 1, 'USER'
    WHERE
    NOT EXISTS (
        SELECT id_role FROM roles WHERE id_role = 1
    );

INSERT INTO Roles
(id_role, role_user)
SELECT 2, 'ADMIN'
    WHERE
    NOT EXISTS (
        SELECT id_role FROM roles WHERE id_role = 2
    );

INSERT INTO TypeGame
(id_type, TypeGame)
SELECT 1, 'ADVENTURE'
    WHERE
    NOT EXISTS (
        SELECT id_type FROM TypeGame WHERE id_type = 1
    );

INSERT INTO TypeGame
(id_type, TypeGame)
SELECT 2, 'ACTION'
    WHERE
    NOT EXISTS (
        SELECT id_type FROM TypeGame WHERE id_type = 2
    );

INSERT INTO TypeGame
(id_type, TypeGame)
SELECT 3, 'INTELEGENT'
    WHERE
    NOT EXISTS (
        SELECT id_type FROM TypeGame WHERE id_type = 3
    );

insert into table_games
(id_game,name_game,describe_game,price,typegame_id,filename_photo)
SELECT 999,'Playing cards ON','The cards were drawn by Velmi Yakasna, jumping and yaўlyayutsa navat, INTO cards pasluzhat doўgі hour. Dzyakuy vyalikі for such argіnalnyy tavar!'
     ,'321','1','https://s1-goods.ozstatic.by/2000/990/57/101/101057990_0.jpg'
    WHERE
    NOT EXISTS (
        SELECT id_game,name_game,describe_game,price,typegame_id,filename_photo FROM table_games WHERE id_game = 999
    );

insert into table_games
(id_game,name_game,describe_game,price,typegame_id,filename_photo)
SELECT 1000,'Chpok (18+)','What is Chpok? This is a mixture of black humor, lecherous words, vulgar topics and bawdy jokes that your friends will remember for the next year. .
'
     ,'512','2','https://s1-goods.ozstatic.by/2000/990/57/101/101057990_0.jpg'
    WHERE
    NOT EXISTS (
        SELECT id_game,name_game,describe_game,price,typegame_id,filename_photo FROM table_games WHERE id_game = 1000
    );

UPDATE Usr SET role_user = 'ADMIN' where id_user=1;