package garagem.diesel.api.domain.veiculo.DTO;

import garagem.diesel.api.domain.veiculo.TipoDeVeiculo;

public record DadosCadastroVeiculos(
        TipoDeVeiculo tipoVeiculo,
        String placaVeiculo,
        Long idCliente
) {
}
