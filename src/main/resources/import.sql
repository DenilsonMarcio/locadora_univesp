-- insert para tb_user
INSERT INTO tb_user (id, name, address, age, login, password) VALUES (UUID(), 'ADMINISTRADOR', 'RUA HUM, 1000', 21, 'LOCADORA', '$2a$12$rZfKbNSN7z4V6G0wuGlgG.1/fZrL.f88AuZzGx84aRsn9oXE8yjYS');
-- INSERT INTO tb_user (id, name, address, age, login, password) VALUES (UUID(), 'Jane Smith', '456 Oak St', 25, 'jane_smith', 'securepass');
-- INSERT INTO tb_user (id, name, address, age, login, password) VALUES (UUID(), 'Bob Johnson', '789 Pine St', 40, 'bob_johnson', 'pass123');
-- INSERT INTO tb_user (id, name, address, age, login, password) VALUES (UUID(), 'joao123@gmail.com', 'Rua Justino de Castro, 333', 1,'João da Silva', '123456');
-- INSERT INTO tb_user (id, name, address, age, login, password) VALUES (UUID(), 'marina@bol.com.br', 'Rua das laranjeiras, 44', 2, 'Marina Andrade', '124578');
-- INSERT INTO tb_user (id, name, address, age, login, password) VALUES (UUID(), 'paula@yahoo.com', 'Rua dos Anjos, 221', 3, 'Paula Rodrigues', '347834');
-- INSERT INTO tb_user (id, name, address, age, login, password) VALUES (UUID(), 'guta@gmail.com', 'Rua Barao de Casa Branca, 654', 4, 'Augusta Ronqui', '456456');

-- insert para tb_client
INSERT INTO tb_client (id, name, address, age) VALUES (UUID(), 'Alice Johnson', '123 Main St', 30);
INSERT INTO tb_client (id, name, address, age) VALUES (UUID(), 'Bob Smith', '456 Oak St', 25);
INSERT INTO tb_client (id, name, address, age) VALUES (UUID(), 'Charlie Brown', '789 Pine St', 40);
INSERT INTO tb_client (id, name, address, age) VALUES (UUID(), 'Enzo Smith', '456 Oak St', 15);
INSERT INTO tb_client (id, name, address, age) VALUES (UUID(), 'Karen Boscolo', 'Rua Lacerda Franco,320', 1);
INSERT INTO tb_client (id, name, address, age) VALUES (UUID(), 'Maiara Santos', 'Rua Francisco Arruda, 390', 2);
INSERT INTO tb_client (id, name, address, age) VALUES (UUID(), 'Juliana Boscolo', 'Rua Inhambu, 474', 3);
INSERT INTO tb_client (id, name, address, age) VALUES (UUID(), 'Ana Boscolo', 'Rua Santos Dumont, 33', 4);
INSERT INTO tb_client (id, name, address, age) VALUES (UUID(), 'Marcos Souza', 'Rua Mariquinha Lameira, 571', 5);
INSERT INTO tb_client (id, name, address, age) VALUES (UUID(), 'Norfan Gandalf', 'Rua das Orquideas, 22', 6);
INSERT INTO tb_client (id, name, address, age) VALUES (UUID(), 'Enzo Gabriel', 'Rua das Paineiras, 526', 7);
INSERT INTO tb_client (id, name, address, age) VALUES (UUID(), 'Cristina Araujo', 'Avenida Cel. Jose Julio, 647', 8);


INSERT INTO tb_filme VALUES (12, 1980, 2.00, 1, 'Randal Kleiser', 'romance', UUID(), 'inglês', 'A Lagoa Azul', 'Warner');
INSERT INTO tb_filme VALUES (12, 1989, 3.00, 1, 'Joan Silver', 'comédia', UUID(), 'inglês', 'Loverboy: o garoto de programa', 'Warner');
INSERT INTO tb_filme VALUES (12, 1990, 4.00, 1 , 'Jerry Zucker', 'romance', UUID(), 'português', 'Ghost - Do outro lado da vida', 'Paramount');
INSERT INTO tb_filme VALUES (00, 1981, 3.00, 2, 'J.B.Tanko', 'comédia', UUID(), 'português', 'Os Saltimbancos Trapalhões','Warner');
INSERT INTO tb_filme VALUES (14, 1984, 2.00, 1, 'Hugh Wilson', 'ficção policial', UUID(), 'inglês', 'Loucademia de Polícia', 'Paramount');
INSERT INTO tb_filme VALUES (12, 1993, 3.00, 2, 'Colin Trevorrow', 'ficção', UUID(), 'português', 'Jurassic PArk 1', 'Warner');
INSERT INTO tb_filme VALUES (12, 1998, 4.00, 1, 'Michael Bay', 'drama', UUID(), 'inglês', 'Armageddon', 'Warner');
INSERT INTO tb_filme VALUES (14, 1975, 2.00, 2, 'Steven Spielberg', 'suspense', UUID(), 'português', 'Tubarão', 'Paramount');

