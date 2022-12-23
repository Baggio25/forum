INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@gmail.com', '123456');

INSERT INTO CURSO(nome, categoria) VALUES ('SpringBoot', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES ('HTML 5', 'Front-end');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES ('Dúvida', 'Erro ao criar projeto', '2022-12-23 16:57', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES ('Dúvida 2', 'Projeto não compila', '2022-12-23 16:57', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES ('Dúvida 3', 'Tag Html', '2022-12-23 16:57', 'NAO_RESPONDIDO', 1, 2);
