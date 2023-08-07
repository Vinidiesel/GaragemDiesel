package garagem.diesel.api.domain.cliente.DTO;

import garagem.diesel.api.domain.cliente.Cliente;

public record DadosDetalhamentoClientes(
        Long id,
        String nome,
        String placaVeiculo,
        String telefone
) {

    public DadosDetalhamentoClientes(Cliente dados) {
        this(dados.getId(), dados.getNome(), dados.getPlacaVeiculo(), dados.getTelefone());
    }
}
