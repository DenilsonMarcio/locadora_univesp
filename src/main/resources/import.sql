-- insert para tb_user
INSERT INTO tb_user (id, name, address, age, login, password) VALUES (UUID(), 'John Doe', '123 Main St', 30, 'john_doe', 'password123');
INSERT INTO tb_user (id, name, address, age, login, password) VALUES (UUID(), 'Jane Smith', '456 Oak St', 25, 'jane_smith', 'securepass');
INSERT INTO tb_user (id, name, address, age, login, password) VALUES (UUID(), 'Bob Johnson', '789 Pine St', 40, 'bob_johnson', 'pass123');

-- insert para tb_client
INSERT INTO tb_client (id, name, address, age) VALUES (UUID(), 'Alice Johnson', '123 Main St', 30);
INSERT INTO tb_client (id, name, address, age) VALUES (UUID(), 'Bob Smith', '456 Oak St', 25);
INSERT INTO tb_client (id, name, address, age) VALUES (UUID(), 'Charlie Brown', '789 Pine St', 40);
INSERT INTO tb_client (id, name, address, age) VALUES (UUID(), 'Enzo Smith', '456 Oak St', 15);

