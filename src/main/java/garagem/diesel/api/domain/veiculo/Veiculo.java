package garagem.diesel.api.domain.veiculo;

import garagem.diesel.api.domain.cliente.Cliente;
import garagem.diesel.api.domain.cliente.repository.ClienteRepository;
import garagem.diesel.api.domain.veiculo.DTO.DadosCadastroVeiculos;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "veiculos")
@Entity(name = "Veiculo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoDeVeiculo tipoDeVeiculo;
    private String placaVeiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private Boolean ativo;

    public Veiculo(DadosCadastroVeiculos dados) {
        this.ativo = true;
        this.tipoDeVeiculo = dados.tipoVeiculo();
        this.placaVeiculo = dados.placaVeiculo();
        this.cliente = new Cliente();
    }

//    @NotBlank(message = "A placa do veiculo é obrigatoria")
//    @Pattern(regexp = "\\d{7}", message = "Formato da placa é invalido")
//    String placaVeiculo
}
