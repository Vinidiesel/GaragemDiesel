CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    placa_veiculo VARCHAR(10) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    ativo VARCHAR(11) not null
);