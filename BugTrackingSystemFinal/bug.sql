USE BUG_TRACKING;
DROP TABLE IF EXISTS issues;
DROP TABLE IF EXISTS developers;

CREATE TABLE developers(
	id INT AUTO_INCREMENT PRIMARY KEY,
	password VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    startWorkingDate DATE, /** YYYY-MM-DD**/
    teamLead_id INT NULL DEFAULT NULL,
    CONSTRAINT FOREIGN KEY (teamLead_id) REFERENCES developers(id) 
);

CREATE TABLE issues(
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(255) NOT NULL,
date_creation DATE DEFAULT NULL,
type ENUM('DEFECT', 'TASK') DEFAULT 'DEFECT',
description VARCHAR(255) NOT NULL,
priority ENUM('LOW', 'MEDIUM', 'HIGH', 'BLOCKER') DEFAULT 'MEDIUM',
issue_status ENUM('NEW', 'PROGRESSING','RESOLVED','INVALID') DEFAULT 'NEW',
owner INT ,
creator INT,
CONSTRAINT FOREIGN KEY(owner) REFERENCES developers(id) ,
CONSTRAINT FOREIGN KEY(creator) REFERENCES developers(id)
);

INSERT INTO developers(name, password, role, startWorkingDate, teamLead_id) 
VALUES ('Ivan Ivanov', '123','JAVASCRIPT dev','2002-12-01', NULL),
('Georgi Petkov Todorov', '123', 'JAVA dev', '2002-12-01', '1'),
('Todor Petkov', '123', 'Front-End', '2009-11-01', 1),
('Sofiq Dimitrova Petrova', '123', 'Junior', '2010-01-01', 1),
('Teodor Ivanov Stoyanov', '123', 'Intern', '2011-10-01', NULL),
('Iliya Stoynov Todorov', '123', 'Junior', '2000-02-01', 5),
('Mariela Dimitrova Yordanova', '123', 'Senior dev', '2005-05-01', 5),
('Elena Miroslavova Georgieva', '123', 'Manager', '2008-04-01', 5),
('Teodor Milanov Milanov', '123', 'Intern', '2012-04-01', 5),
('Pesho Georgiev', 'e10adc3949ba59abbe56e057f20f883e', 'Intern', '2012-04-01', 5);

INSERT INTO issues(title,description,issue_status,owner,creator)
VALUES ('controller','no info','RESOLVED',5,1),
('security','no info', 'PROGRESSING',5, 1),
('login','no info','PROGRESSING', 10,1),
('dao','no info','RESOLVED',10,5),
('service','no info','RESOLVED',5,1),
('jps','no info','RESOLVED',1,5),
('jpa','no info','RESOLVED',1,10),
('post request','no info','RESOLVED',1,10),
('post request','no info','RESOLVED',10,10);

CREATE TABLE projects(
	id INT AUTO_INCREMENT PRIMARY KEY,
    	name VARCHAR(255) NOT NULL,
   	dateInitiated DATE, /** YYYY-MM-DD**/
    	teamLead_id INT NULL DEFAULT NULL,
    	CONSTRAINT FOREIGN KEY (teamLead_id) REFERENCES developers(id) 
);

 CREATE TABLE messages (
     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     title VARCHAR(50) ,
     message VARCHAR(200) not null,
     timestamp DATETIME DEFAULT NOW(),
     dev_id INT DEFAULT NULL 
     );

ALTER TABLE messages
ADD FOREIGN KEY (dev_id)
REFERENCES developers(id);


DESCRIBE developers;
SET FOREIGN_KEY_CHECKS=0;
  SELECT * FROM issues;
  select * from issues where issue_status like 'RESOLVED';
  SELECT * from developers;

