CREATE TABLE veiculos (
    id bigint PRIMARY KEY AUTO_INCREMENT,
    tipo_de_veiculo VARCHAR(100) NOT NULL,
    placa_do_veiculo VARCHAR(11) NOT NULL UNIQUE,
    cliente_id bigint not null,
    ativo VARCHAR(11) not null,

    constraint fk_veiculos_clientes_id foreign key (cliente_id) references clientes(id)
);