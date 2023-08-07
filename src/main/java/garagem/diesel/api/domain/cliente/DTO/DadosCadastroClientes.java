package garagem.diesel.api.domain.cliente.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroClientes(
        @NotBlank(message = "O nome é obrigatorio")
        String nome,
        @NotBlank(message = "O CPF do cliente é obrigatoria")
        @Pattern(regexp = "\\d{11}", message = "Formato da placa é invalido")
        String cpf,
        @NotBlank(message = "O telefone é obrigatorio")
        @Pattern(regexp = "\\d{11}", message = "Formato do telefone é invalido")
        String telefone
) {
}
