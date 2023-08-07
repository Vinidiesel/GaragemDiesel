package garagem.diesel.api.domain.cliente;

import garagem.diesel.api.domain.cliente.DTO.DadosAtualizacaoClientes;
import garagem.diesel.api.domain.cliente.DTO.DadosCadastroClientes;
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

    public void atualizarInformacoes(DadosAtualizacaoClientes dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.placaVeiculo() != null){
            this.placaVeiculo = dados.placaVeiculo();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
    }

    public void deletar() {
        this.ativo = false;
    }
}
