CREATE TABLE IF NOT EXISTS users (
  id BIGINT PRIMARY KEY,
  email VARCHAR(100) UNIQUE NOT NULL,
  name VARCHAR(100) UNIQUE NOT NULL,
  photo BYTEA,
  password_hash VARCHAR(255),
  password_salt VARCHAR(32)
);
COMMENT ON TABLE users IS 'Table containing the application users'' data';
COMMENT ON COLUMN users.id IS 'User''s identifier';
COMMENT ON COLUMN users.email IS 'User''s email';
COMMENT ON COLUMN users.name IS 'User''s name';
COMMENT ON COLUMN users.photo IS 'Byte array with user''s photo';
COMMENT ON COLUMN users.password_hash IS 'User''s password hash';
COMMENT ON COLUMN users.password_salt IS 'A salt to calculate a password hash';


CREATE SEQUENCE IF NOT EXISTS user_id_sequence START WITH 1 MINVALUE 1 INCREMENT BY 1;
COMMENT ON SEQUENCE user_id_sequence IS 'Sequence for identifiers of table ''users''';


CREATE TABLE IF NOT EXISTS areas(
  id BIGINT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

COMMENT ON TABLE areas IS 'Table containing the application areas'' data';
COMMENT ON COLUMN areas.id IS 'Area''s identifier';
COMMENT ON COLUMN areas.name IS 'Area''s name';

CREATE SEQUENCE IF NOT EXISTS area_id_sequence START WITH 1 MINVALUE 1 INCREMENT BY 1;
COMMENT ON SEQUENCE area_id_sequence IS 'Sequence for identifiers of table ''areas''';

CREATE TABLE IF NOT EXISTS companies (
  id BIGINT PRIMARY KEY,
  email VARCHAR(100) UNIQUE NOT NULL,
  name VARCHAR(100) NOT NULL,
  photo BYTEA,
  password_hash VARCHAR(255),
  password_salt VARCHAR(32)


);


COMMENT ON TABLE companies IS 'Table containing the application companies'' data';
COMMENT ON COLUMN companies.id IS 'Company''s identifier';
COMMENT ON COLUMN companies.name IS 'Company''s name';
COMMENT ON COLUMN companies.photo IS 'Byte array with company''s photo';
COMMENT ON COLUMN companies.email IS 'Company''s email';
COMMENT ON COLUMN companies.password_hash IS 'Company''s password hash';
COMMENT ON COLUMN companies.password_salt IS 'A salt to calculate a password hash';


CREATE SEQUENCE IF NOT EXISTS  company_id_sequence START WITH 1 MINVALUE 1 INCREMENT BY 1;
COMMENT ON SEQUENCE company_id_sequence IS 'Sequence for identifiers of table ''companies''';


CREATE TABLE IF NOT EXISTS vacancies(
  id BIGINT PRIMARY KEY,
  --FOREIGN KEY
  company_id BIGINT REFERENCES companies(id) ON DELETE CASCADE,
  name VARCHAR(100) NOT NULL,
  vacancy VARCHAR(1000) NOT NULL,
  status SMALLINT,
  --FOREIGN KEY
  area_id BIGINT REFERENCES areas(id)
);

COMMENT ON TABLE vacancies IS 'Table containing the application vacancies'' data';
COMMENT ON COLUMN vacancies.id IS 'Vacancy''s identifier';
COMMENT ON COLUMN vacancies.company_id IS 'ID of the company that left a vacancy';
COMMENT ON COLUMN vacancies.name IS 'The appellation of the job';
COMMENT ON COLUMN vacancies.status IS 'Status of vacancy';
COMMENT ON COLUMN vacancies.vacancy IS 'Detailed information about vacancy';
COMMENT ON COLUMN vacancies.area_id IS 'Where working place is situated';



CREATE SEQUENCE IF NOT EXISTS vacancy_id_sequence START WITH 1 MINVALUE 1 INCREMENT BY 1;
COMMENT ON SEQUENCE vacancy_id_sequence IS 'Sequence for identifiers of table ''vacancies''';


CREATE TABLE IF NOT EXISTS resumes(
  id BIGINT PRIMARY KEY,
  --FOREIGN KEY
  user_id BIGINT REFERENCES users (id) ON DELETE CASCADE,
  name VARCHAR(100) NOT NULL,
  resume VARCHAR(1000) NOT NULL,
  status SMALLINT,
  --FOREIGN KEY
  area_id BIGINT REFERENCES areas(id)
);


COMMENT ON TABLE resumes IS 'Table containing the application resumes'' data';
COMMENT ON COLUMN resumes.id IS 'Resume"s identifier';
COMMENT ON COLUMN resumes.name IS 'The appellation of the job';
COMMENT ON COLUMN resumes.status IS 'Status of resume';
COMMENT ON COLUMN resumes.user_id IS 'ID of the user that wrote a resume';
COMMENT ON COLUMN resumes.resume IS 'Detailed information about user';
COMMENT ON COLUMN resumes.area_id IS 'Where working place is situated';

CREATE SEQUENCE IF NOT EXISTS resume_id_sequence START WITH 1 MINVALUE 1 INCREMENT BY 1;
COMMENT ON SEQUENCE resume_id_sequence IS 'Sequence for identifiers of table ''resumes''';


CREATE TABLE IF NOT EXISTS vacancies_resumes
(
    vacancy_id BIGINT REFERENCES vacancies (id),
    resume_id  BIGINT REFERENCES resumes (id),
    dependency SMALLINT,
    CONSTRAINT vacancies_resumes_pk PRIMARY KEY (vacancy_id, resume_id)
);
COMMENT ON TABLE vacancies_resumes IS 'Linkage table between tables ''resumes'' and ''vacancies'' ';
COMMENT ON COLUMN vacancies_resumes.vacancy_id IS 'Vacancy''s identifier';
COMMENT ON COLUMN vacancies_resumes.resume_id IS 'Resume''s identifier';
COMMENT ON COLUMN vacancies_resumes.dependency IS 'Response to a resume or job offer';
