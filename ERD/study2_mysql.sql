SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS user;




/* Create Tables */

CREATE TABLE post
(
	postId bigint NOT NULL AUTO_INCREMENT,
	userId bigint NOT NULL,
	subject varchar(50) NOT NULL,
	content text NOT NULL,
	visibility varchar(20) NOT NULL CHECK (visibility IN ('PUBLIC', 'FRIENDS', 'PRIVATE')),
	regDate datetime DEFAULT now(),
	category varchar(50) NOT NULL,
	PRIMARY KEY (postId)
);


CREATE TABLE user
(
	uid bigint NOT NULL AUTO_INCREMENT,
	username varchar(50) NOT NULL,
	password varchar(50) NOT NULL,
	nickname varchar(50) NOT NULL,
	phonenumber varchar(50) NOT NULL,
	email varchar(100) NOT NULL,
	gender varchar(50) NOT NULL,
	regDate datetime DEFAULT now(),
	PRIMARY KEY (uid),
	UNIQUE (username),
	UNIQUE (nickname),
	UNIQUE (phonenumber),
	UNIQUE (email)
);



/* Create Foreign Keys */

ALTER TABLE post
	ADD FOREIGN KEY (userId)
	REFERENCES user (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



