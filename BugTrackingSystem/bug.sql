USE BUG_TRACKING;
DROP TABLE IF EXISTS issues;
DROP TABLE IF EXISTS developers;


CREATE TABLE developers(
	id INT AUTO_INCREMENT PRIMARY KEY,
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
type ENUM('DEFECT', 'TASK'),
description VARCHAR(255) NOT NULL,
priority ENUM('LOW', 'MEDIUM', 'HIGH', 'BLOCKER'),
issue_status ENUM('NEW', 'IN_PROGRESS','RESOLVED','INVALID'),
owner INT ,
creator INT,
CONSTRAINT FOREIGN KEY(owner) REFERENCES developers(id) ,
CONSTRAINT FOREIGN KEY(creator) REFERENCES developers(id)
);

INSERT INTO developers(name, role, startWorkingDate, teamLead_id) 
VALUES ('Ivan Ivanov','JAVASCRIPT dev','2002-12-01', NULL),
('Georgi Petkov Todorov', 'JAVA dev', '2002-12-01', '1'),
('Todor Petkov', 'Front-End', '2009-11-01', 1),
('Sofiq Dimitrova Petrova', 'Junior', '2010-01-01', 1),
('Teodor Ivanov Stoyanov', 'Intern', '2011-10-01', NULL),
('Iliya Stoynov Todorov', 'Junior', '2000-02-01', 5),
('Mariela Dimitrova Yordanova', 'Senior dev', '2005-05-01', 5),
('Elena Miroslavova Georgieva', 'Manager', '2008-04-01', 5),
('Teodor Milanov Milanov', 'Intern', '2012-04-01', 5);

INSERT INTO issues(title,description,owner,creator)
VALUES ('controller','no info',1,1);

DESCRIBE developers;
SET FOREIGN_KEY_CHECKS=0;
  SELECT * FROM issues;
