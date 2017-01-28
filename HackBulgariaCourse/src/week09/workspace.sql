USE pandaSocialNetwork;
DROP DATABASE pandaSocialNetwork;
CREATE DATABASE pandaSocialNetwork;
CREATE TABLE panda(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(255) NOT NULL,
email varchar(255) NOT NULL,
gender ENUM('M','F') 
);


CREATE TABLE panda_friend(
id INT PRIMARY KEY AUTO_INCREMENT,
panda_id int NOT NULL,
CONSTRAINT FOREIGN KEY (panda_id) REFERENCES panda(id) ON DELETE CASCADE,
friend_id int NOT NULL,
CONSTRAINT FOREIGN KEY (friend_id) REFERENCES panda(id) ON DELETE CASCADE

);

INSERT INTO panda(name,email,gender) 
VALUES('Gosho','gosho@gmail.com','M'),
('Ceco','ceco@gmail.com','M');

INSERT INTO panda_friend(panda_id,friend_id)
VALUES(1,2),
(2,1);

SELECT p.name as Panda,f.name as Friend FROM panda as p
JOIN panda as f
ON p.id IN(
SELECT panda_id From panda_friend
WHERE panda_friend.friend_id=f.id
)WHERE p.name='Jorko';



SELECT DISTINCT * FROM panda;

SELECT * FROM panda_friend;
