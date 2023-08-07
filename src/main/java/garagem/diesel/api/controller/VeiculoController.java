package garagem.diesel.api.controller;

import garagem.diesel.api.domain.cliente.repository.ClienteRepository;
import garagem.diesel.api.domain.veiculo.DTO.DadosCadastroVeiculos;
import garagem.diesel.api.domain.veiculo.Veiculo;
import garagem.diesel.api.domain.veiculo.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repository;
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroVeiculos dados, UriComponentsBuilder uriComponentsBuilder){
        var cliente = clienteRepository.getReferenceById(dados.idCliente());
        var veiculo = new Veiculo();

    }

}
