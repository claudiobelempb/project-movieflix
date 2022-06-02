--tb_user
INSERT INTO tb_user (first_name, last_name, email, password, created_at, status) VALUES ('Alex', 'Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (first_name, last_name, email, password, created_at, status) VALUES ('Maria', 'Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (first_name, last_name, email, password, created_at, status) VALUES ('João', 'Silva', 'joao@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (first_name, last_name, email, password, created_at, status) VALUES ('Ana', 'Pereira', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);
INSERT INTO tb_user (first_name, last_name, email, password, created_at, status) VALUES ('Joaquim', 'Ferreira', 'joaquim@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', now(), 0);

--tb_role
INSERT INTO tb_role (authority, created_at, status) VALUES ('ROLE_OPERATOR', now(), 0);
INSERT INTO tb_role (authority, created_at, status) VALUES ('ROLE_STUDENT', now(), 0);
INSERT INTO tb_role (authority, created_at, status) VALUES ('ROLE_INSTRUCTOR', now(), 0);
INSERT INTO tb_role (authority, created_at, status) VALUES ('ROLE_ADMIN', now(), 0);

--tb_user_role
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 3);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 4);

--TB_NOTIFICATION
INSERT INTO tb_notification (text, read, route, user_id, created_at, status) VALUES ('Primeiro feedback de tarefa: favor revisar', 'true', '/offers/1/resource/1/sections/1', 1, NOW(), 'true');
INSERT INTO tb_notification (text, read, route, user_id, created_at, status) VALUES ('Segundo feedback: favor revisar', 'true', '/offers/1/resource/1/sections/1', 2, NOW(), 'true');
INSERT INTO tb_notification (text, read, route, user_id, created_at, status) VALUES ('Terceiro feedback: favor revisar', 'true', '/offe/rs1/resource/1/sections/1', 1, NOW(), 'true');

--TB_MOVIE
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id, created_at, status) VALUES ('Bob Esponja', 'O Incrível Resgate', 2020,  'https://image.tmdb.org/t/p/w533_and_h300_bestv2/wu1uilmhM4TdluKi2ytfz8gidHf.jpg', 'Onde está Gary? Segundo Bob Esponja, Gary foi "caracolstrado" pelo temível Rei Poseidon e levado para a cidade perdida de Atlantic City. Junto a Patrick Estrela, ele sai em uma missão de resgate ao querido amigo, e nesta jornada os dois vão conhecer novos personagens e viver inimagináveis aventuras.', 1 , NOW() ,0);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id, created_at, status) VALUES ('O Orfanato', null, 2007, 'https://image.tmdb.org/t/p/w533_and_h300_bestv2/2AlVaQDH67RgulE2AqXBSPr2POF.jpg', 'Laura (Belén Rueda) passou os anos mais felizes de sua vida em um orfanato, onde recebeu os cuidados de uma equipe e de outros companheiros órfãos, a quem considerava como se fossem seus irmãos e irmãs verdadeiros. Agora, 30 anos depois, ela retornou ao local com seu marido Carlos (Fernando Cayo) e seu filho Simón (Roger Príncep), de 7 anos. Ela deseja restaurar e reabrir o orfanato, que está abandonado há vários anos. O local logo desperta a imaginação de Simón, que passa a criar contos fantásticos. Entretanto à medida que os contos ficam mais estranhos Laura começa a desconfiar que há algo à espreita na casa.', 2, NOW(),0);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id, created_at, status) VALUES ('O Labirinto do Fauno', null, 2006, 'https://image.tmdb.org/t/p/w500_and_h282_face/oXMfT5OM6HAgQ9sGANB8cs1ifCG.jpg', 'Em 1944, na Espanha, a jovem Ofélia e sua mãe doente chegam ao posto do novo marido de sua mãe, um sádico oficial do exército que está tentando reprimir uma guerrilheira. Enquanto explorava um labirinto antigo, Ofélia encontra o Pan fauno, que diz que a menina é uma lendária princesa perdida e que ela precisa completar três tarefas perigosas a fim de se tornar imortal.', 3, NOW(), 0);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id, created_at,status) VALUES ('Your Name', null, 2016, 'https://image.tmdb.org/t/p/w533_and_h300_bestv2/wqZapHpXyZEaCkpsLVszmEQcDIy.jpg', 'Mitsuha é a filha do prefeito de uma pequena cidade, mas sonha em tentar a sorte em Tóquio. Taki trabalha em um restaurante em Tóquio e deseja largar o seu emprego. Os dois não se conhecem, mas estão conectados pelas imagens de seus sonhos.', 3, NOW() ,0);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id, created_at, status) VALUES ('Código de Conduta', null , 2009, 'https://image.tmdb.org/t/p/w533_and_h300_bestv2/mwlLjL3jTDmTdLWe2PyUVqYQTuK.jpg', 'Quando um dos suspeitos do assassinato de sua mulher e filha é solto, Clyde quer vingança e decide fazer justiça com as próprias mãos. Clyde é preso e dentro da cadeia organiza uma matança para desmascarar o sistema judicial corrupto.', 3, NOW() ,0);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id, created_at, status) VALUES ('A Voz do Silêncio', 'Koe no Katachi', 2016, 'https://image.tmdb.org/t/p/w533_and_h300_bestv2/5lAMQMWpXMsirvtLLvW7cJgEPkU.jpg', 'Nishimiya Shouko é uma estudante com deficiência auditiva. Durante o ensino fundamental, após se transferir para uma nova escola, Shouko passa a ser alvo de bullying e em pouco tempo precisa se transferir. O que ela não esperava é que alguns anos depois, Ishida Shouya, um dos valentões que tanto a fez sofrer no passado surgisse de novo em sua vida com um novo propósito.', 3, NOW(), 0);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id, created_at, status) VALUES ('Kingsman', 'Serviço Secreto', 2014, 'https://image.tmdb.org/t/p/w533_and_h300_bestv2/qzUIOTk0E3F1zjvYjcBRTKUTgf9.jpg','Eggsy (Taron Egerton) é um jovem com problemas de disciplina que parece perto de se tornar um criminoso. Determinado dia, ele entra em contato com Harry (Colin Firth), que lhe apresenta à agência de espionagem Kingsman. O jovem se une a um time de recrutas em busca de uma vaga na agência. Ao mesmo tempo, Harry tenta impedir a ascensão do vilão Valentine (Samuel L. Jackson). Adaptação da série de quadrinhos criada por Mark Millar e Dave Gibbons.', 1, NOW(), 0);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id, created_at,status) VALUES ('Sonic', 'O Filme', 2020, 'https://image.tmdb.org/t/p/w533_and_h300_bestv2/diFNHa3SXaGSSFovGatNWxLz2tn.jpg','Sonic, o porco-espinho azul mais famoso do mundo, se junta com os seus amigos para derrotar o terrível Doutor Eggman, um cientista louco que planeja dominar o mundo, e o Doutor Robotnik, responsável por aprisionar animais inocentes em robôs.', 1, NOW(), 0);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id, created_at, status) VALUES ('Uma Noite de Crime', 'Anarquia', 2014, 'https://image.tmdb.org/t/p/w500_and_h282_face/ecD9hT8odHzFCDeGDy4N2IKh0LN.jpg', 'O governo dos Estados Unidos sanciona uma lei em que os assassinatos são permitidos durante uma noite, para que os cidadãos liberem seus instintos violentos. Cinco desconhecidos se unem para tentar sobreviver a essa verdadeira noite de terror.', 2, NOW(), 0);
INSERT INTO tb_movie (title, sub_title, year, img_url, synopsis, genre_id, created_at, status) VALUES ('O Segredo da Cabana', null, 2012, 'https://image.tmdb.org/t/p/w533_and_h300_bestv2/5iiVfPS6LsAqmVQVOzhyCHhCFgU.jpg', 'Cinco amigos fazem uma pausa em uma cabana remota, onde conseguem mais do que esperavam, descobrindo a verdade atrás da cabana na floresta.', 2, NOW() ,0);

--TB_REVIEW
INSERT INTO tb_review (text, movie_id, user_id) VALUES ('Meh, filme OK', 1, 1);
INSERT INTO tb_review (text, movie_id, user_id) VALUES ('Gostei e recomendo!', 1, 1);
INSERT INTO tb_review (text, movie_id, user_id) VALUES ('Que Filme!!!', 2, 1);

--TB_GENRE
INSERT INTO tb_genre (name) VALUES ('Comédia');
INSERT INTO tb_genre (name) VALUES ('Terror');
INSERT INTO tb_genre (name) VALUES ('Drama');


