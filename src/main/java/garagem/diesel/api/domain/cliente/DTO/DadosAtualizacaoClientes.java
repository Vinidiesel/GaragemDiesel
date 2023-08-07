package garagem.diesel.api.domain.cliente.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoClientes(
        @NotNull
        Long id,
        String nome,
        @Pattern(regexp = "\\d{11}", message = "Formato da placa é invalido")
        String cpf,
        @Pattern(regexp = "\\d{11}", message = "Formato do telefone é invalido")
        String telefone
) {
}
