DROP TABLE IF EXISTS survey;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS options;
DROP TABLE IF EXISTS survey_response;
DROP TABLE IF EXISTS question_response;
 
CREATE TABLE survey (
  id IDENTITY NOT NULL PRIMARY KEY,
  name VARCHAR NOT NULL
);

CREATE TABLE question (
  id IDENTITY NOT NULL PRIMARY KEY,
  description VARCHAR NOT NULL,
  survey_id INT not null,
  null_text boolean,
  type int not null,
  foreign key (survey_id) references survey(id)
);

CREATE TABLE options (
  id IDENTITY NOT NULL PRIMARY KEY,
  description VARCHAR NOT NULL,
  question_id INT not null,
  foreign key (question_id) references question(id)
);


CREATE TABLE survey_response (
  id IDENTITY NOT NULL PRIMARY KEY
);

CREATE TABLE question_response (
  id IDENTITY NOT NULL PRIMARY KEY,
  response VARCHAR NOT NULL,
  question_id INT not null,
  survey_response_id INT not null,
  foreign key (question_id) references question(id),
  foreign key (survey_response_id) references survey_response(id)
);

