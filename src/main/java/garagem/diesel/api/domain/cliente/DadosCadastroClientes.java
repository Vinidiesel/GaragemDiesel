package garagem.diesel.api.domain.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroClientes(
        @NotBlank(message = "O nome é obrigatorio")
        String nome,
        @NotBlank(message = "A placa do veiculo é obrigatoria")
        String placaVeiculo,
        @NotBlank(message = "O telefone é obrigatorio")
        @Pattern(regexp = "\\d{11}", message = "Formato do CEP é invalido")
        String telefone
) {
}
