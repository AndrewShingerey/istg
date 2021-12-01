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

UPDATE Usr SET role_user = 'ADMIN' where id_user=1;