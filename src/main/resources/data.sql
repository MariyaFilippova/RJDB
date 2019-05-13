DELETE FROM vacancies_resumes;
DELETE FROM vacancies;
delete from companies;


insert into companies (id, email, name) values (1, 'support@corp.mail.ru','Mail.ru Group' );
insert into companies (id, email, name) values (2, 'hr@mipt.ru','МФТИ' );
insert into companies (id, email, name) values (3, 'jetbrains@gmail.com','JetBrains' );
insert into companies (id, email, name) values (4, 'info@milandr.ru','Миландр' );
insert into companies (id, email, name) values (5, 'rabotavmcdonalds@ru.mcd.com','Макдональдс' );
Insert into vacancies (id, company_id, name, vacancy, status, area_id) VALUES
(1, 1, 'Frontend Developer', 'Excellent knowledge of javascript
experience with high-loaded service;
knowledge of the principles of client application optimization.', 1, 1);

Insert into vacancies (id, company_id, name, vacancy, status, area_id) VALUES (2, 4,  'Lead Researcher, Deep Learning, Computer Vision (Cloud)', '3-5 years of working with Python or other scripting languages;
knowledge of modern ML in relevant areas (NLP, Machine Translation, Computer Vision)',1, 1 );
Insert into vacancies (id, company_id, name, vacancy, status, area_id) VALUES (3, 3, 'SoС Back-end designer', 'Writing restrictions on the project in the .sdc format,
insertion of test structures (DFT, OPCG, PMBIST, BSCAN) into the project, implementation of the logical synthesis stage.', 1, 3);
Insert into vacancies (id, company_id, name, vacancy, status, area_id) VALUES (4, 5, 'Personnel officer', 'Registration of holidays, record keeping', 1, 2)