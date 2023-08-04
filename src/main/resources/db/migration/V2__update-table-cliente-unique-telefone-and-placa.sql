ALTER TABLE clientes ADD CONSTRAINT telefone_unique UNIQUE (telefone);
ALTER TABLE clientes ADD CONSTRAINT placa_veiculo_unique UNIQUE (placa_veiculo);

