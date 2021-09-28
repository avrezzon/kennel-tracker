CREATE TABLE IF NOT EXISTS client(
	id SMALLINT PRIMARY KEY,
	firstName VARCHAR(50) NOT NULL,
	lastName  VARCHAR(50) NOT NULL,
	phoneNumber VARCHAR(50) NOT NULL,
	emergencyContact VARCHAR(50),
	shelterType VARCHAR(50),
	bedNumber SMALLINT
);

CREATE TABLE IF NOT EXISTS PET(
	id SMALLINT PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	type VARCHAR(50) NOT NULL,
	breed VARCHAR(50),
	gender VARCHAR(10),
	color VARCHAR(50),
	kennelNumber SMALLINT,
	restricted BOOLEAN
);
