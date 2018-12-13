USE adlister_db;

CREATE TABLE users (
  id int UNSIGNED AUTO_INCREMENT,
  username VARCHAR(100),
  email VARCHAR(100),
  password VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE ads (
  id int UNSIGNED AUTO_INCREMENT,
  user_id int UNSIGNED,
  title VARCHAR(240),
  description VARCHAR(500),
  FOREIGN KEY (user_id) REFERENCES users(id),
  PRIMARY KEY (id)
);