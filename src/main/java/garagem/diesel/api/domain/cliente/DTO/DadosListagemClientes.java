package garagem.diesel.api.domain.cliente.DTO;

import garagem.diesel.api.domain.cliente.Cliente;

public record DadosListagemClientes(
        Long id,
        String nome,
        String cpf,
        String telefone
) {
    public DadosListagemClientes(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getTelefone());
    }
}
