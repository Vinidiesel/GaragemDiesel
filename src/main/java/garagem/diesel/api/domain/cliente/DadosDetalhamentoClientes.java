package garagem.diesel.api.domain.cliente;

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
