INSERT INTO conta (id_conta, nome_responsavel) VALUES (1,'Fulano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (2,'Sicrano');

INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (1,'2019-01-01 12:00:00+03',30895.46,'DEPOSITO', null, 1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (2,'2019-02-03 09:53:27+03',12.24,'DEPOSITO', null,2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (3,'2019-05-04 08:12:45+03',500.50,'SAQUE', null,1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (4,'2019-08-07 08:12:45+03',530.50,'SAQUE', null,2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (5,'2020-06-08 10:15:01+03',3241.23,'TRANSFERENCIA SAIDA', 'Beltrano',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (6,'2021-04-01 12:12:04+03',25173.09,'TRANSFERENCIA ENTRADA', 'Ronnyscley',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (7,'2023-01-01 12:00:00+03',30895.46,'TRANSFERENCIA ENTRADA', 'Beltrano', 1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (8,'2023-02-03 09:53:27+03',212.24,'TRANSFERENCIA SAIDA', 'Ronnyscley',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (9,'2023-05-04 08:12:45+03',300.50,'TRANSFERENCIA ENTRADA', 'Beltrano',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (10,'2023-08-07 08:12:45+03',530.50,'TRANSFERENCIA SAIDA', 'Beltrano',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (11,'2023-06-08 10:15:01+03',3241.23,'TRANSFERENCIA ENTRADA', 'Ronnyscley',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (12,'2023-04-01 12:12:04+03',5173.09,'TRANSFERENCIA SAIDA', 'Ronnyscley',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (13,'2023-06-08 17:15:01+03',411.23,'Tranferencia Entrada', 'Beltrano',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (14,'2023-08-07 08:12:45+03',1530.50,'Transferência Saída', 'Beltrano',2);

