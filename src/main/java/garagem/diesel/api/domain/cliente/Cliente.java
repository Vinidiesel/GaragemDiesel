package garagem.diesel.api.domain.cliente;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String placaVeiculo;
    private String telefone;
    private Boolean ativo;

    public Cliente(DadosCadastroClientes dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.placaVeiculo = dados.placaVeiculo();
        this.telefone = dados.telefone();
    }
}
