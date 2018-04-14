create database spring;

CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(20),
    password VARCHAR(20)
);
SELECT 
    *
FROM
    user;
DROP TABLE IF EXISTS hibernate_sequence;
CREATE TABLE hibernate_sequence (
    name VARCHAR(50) NOT NULL,
    next_val INT NOT NULL,
    increment INT NOT NULL DEFAULT 1,
    PRIMARY KEY (name)
)  ENGINE=INNODB;  
INSERT INTO hibernate_sequence VALUES ('spring', 1, 1);
SELECT 
    *
FROM
    hibernate_sequence;