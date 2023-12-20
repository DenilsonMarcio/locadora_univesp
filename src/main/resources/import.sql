-- insert para tb_user
INSERT INTO tb_user (id, name, address, age, login, password) VALUES (UUID(), 'ADMINISTRADOR', 'RUA HUM, 1000', 21, 'LOCADORA', '$2a$12$rZfKbNSN7z4V6G0wuGlgG.1/fZrL.f88AuZzGx84aRsn9oXE8yjYS');
-- INSERT INTO tb_user (id, name, address, age, login, password) VALUES (UUID(), 'Jane Smith', '456 Oak St', 25, 'jane_smith', 'securepass');
-- INSERT INTO tb_user (id, name, address, age, login, password) VALUES (UUID(), 'Bob Johnson', '789 Pine St', 40, 'bob_johnson', 'pass123');
-- INSERT INTO tb_user (id, name, address, age, login, password) VALUES (UUID(), 'joao123@gmail.com', 'Rua Justino de Castro, 333', 1,'João da Silva', '123456');
-- INSERT INTO tb_user (id, name, address, age, login, password) VALUES (UUID(), 'marina@bol.com.br', 'Rua das laranjeiras, 44', 2, 'Marina Andrade', '124578');
-- INSERT INTO tb_user (id, name, address, age, login, password) VALUES (UUID(), 'paula@yahoo.com', 'Rua dos Anjos, 221', 3, 'Paula Rodrigues', '347834');
-- INSERT INTO tb_user (id, name, address, age, login, password) VALUES (UUID(), 'guta@gmail.com', 'Rua Barao de Casa Branca, 654', 4, 'Augusta Ronqui', '456456');

-- insert para tb_client
INSERT INTO tb_client (id, matricula, name, address, age) VALUES (UUID(), 0001, 'Alice Johnson', '123 Main St', 30);
INSERT INTO tb_client (id, matricula, name, address, age) VALUES (UUID(), 0002, 'Charlie Brown', '789 Pine St', 40);
INSERT INTO tb_client (id, matricula, name, address, age) VALUES (UUID(), 0003, 'Enzo Smith', '456 Oak St', 15);
INSERT INTO tb_client (id, matricula, name, address, age) VALUES (UUID(), 0004, 'Karen Boscolo', 'Rua Lacerda Franco,320', 1);
INSERT INTO tb_client (id, matricula, name, address, age) VALUES (UUID(), 0005, 'Maiara Santos', 'Rua Francisco Arruda, 390', 2);
INSERT INTO tb_client (id, matricula, name, address, age) VALUES (UUID(), 0006, 'Juliana Boscolo', 'Rua Inhambu, 474', 3);
INSERT INTO tb_client (id, matricula, name, address, age) VALUES (UUID(), 0007, 'Ana Boscolo', 'Rua Santos Dumont, 33', 4);
INSERT INTO tb_client (id, matricula, name, address, age) VALUES (UUID(), 0008, 'Marcos Souza', 'Rua Mariquinha Lameira, 571', 5);
INSERT INTO tb_client (id, matricula, name, address, age) VALUES (UUID(), 0009, 'Norfan Gandalf', 'Rua das Orquideas, 22', 6);
INSERT INTO tb_client (id, matricula, name, address, age) VALUES (UUID(), 0010, 'Enzo Gabriel', 'Rua das Paineiras, 526', 7);
INSERT INTO tb_client (id, matricula, name, address, age) VALUES (UUID(), 0011, 'Cristina Araujo', 'Avenida Cel. Jose Julio, 647', 8);
INSERT INTO tb_client (id, matricula, name, address, age) VALUES (UUID(), 0012, 'Bob Smith', '456 Oak St', 25);

INSERT INTO tb_filme VALUES (12, 0001, 1980, 2.00, 1, 'Randal Kleiser', 'romance', UUID(), 'inglês', 'A Lagoa Azul', 'Warner');
INSERT INTO tb_filme VALUES (12, 0002, 1989, 3.00, 1, 'Joan Silver', 'comédia', UUID(), 'inglês', 'Loverboy: o garoto de programa', 'Warner');
INSERT INTO tb_filme VALUES (12, 0003, 1990, 4.00, 1 , 'Jerry Zucker', 'romance', UUID(), 'português', 'Ghost - Do outro lado da vida', 'Paramount');
INSERT INTO tb_filme VALUES (00, 0004, 1981, 3.00, 2, 'J.B.Tanko', 'comédia', UUID(), 'português', 'Os Saltimbancos Trapalhões','Warner');
INSERT INTO tb_filme VALUES (14, 0005, 1984, 2.00, 1, 'Hugh Wilson', 'ficção policial', UUID(), 'inglês', 'Loucademia de Polícia', 'Paramount');
INSERT INTO tb_filme VALUES (12, 0006, 1993, 3.00, 2, 'Colin Trevorrow', 'ficção', UUID(), 'português', 'Jurassic PArk 1', 'Warner');
INSERT INTO tb_filme VALUES (12, 0007, 1998, 4.00, 1, 'Michael Bay', 'drama', UUID(), 'inglês', 'Armageddon', 'Warner');
INSERT INTO tb_filme VALUES (14, 0008, 1975, 2.00, 2, 'Steven Spielberg', 'suspense', UUID(), 'português', 'Tubarão', 'Paramount');

-- insert tb_jogo
INSERT INTO tb_jogo (id, codigo, name, classificacao, lancamento, produtora, genero, quantidade, preco, plataforma) VALUES (UUID(), 0001, 'Sonic Generations', 0, 2011, 'SEGA', 'Aventura', 5, 4.00, 'PLAYSTATION');
INSERT INTO tb_jogo (id, codigo, name, classificacao, lancamento, produtora, genero, quantidade, preco, plataforma) VALUES (UUID(), 0002, 'Minecraft', 10, 2011, 'Mojang Studios', 'Aventura', 3, 6.00, 'PLAYSTATION');
INSERT INTO tb_jogo (id, codigo, name, classificacao, lancamento, produtora, genero, quantidade, preco, plataforma) VALUES (UUID(), 0003, 'Mario 64', 0, 1996, 'Nintendo Entertainment', 'Aventura', 3, 6.00, 'NINTENDO_64');