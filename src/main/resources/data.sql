INSERT INTO survey (name) VALUES ('First survey');

INSERT INTO question (description, survey_id, null_text, type) VALUES
  ('Name', 1 , false, 1),
  ('Phone', 1, false, 1),
  ('Cars o bicycle', 1, false, 2);

INSERT INTO options (description, question_id) VALUES
  ('Cars', 3),
  ('Bicycle', 3);
