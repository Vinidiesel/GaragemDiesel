package garagem.diesel.api.controller;

import garagem.diesel.api.domain.cliente.Cliente;
import garagem.diesel.api.domain.cliente.ClienteRepository;
import garagem.diesel.api.domain.cliente.DadosCadastroClientes;
import garagem.diesel.api.domain.cliente.DadosDetalhamentoClientes;
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
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroClientes dados, UriComponentsBuilder uriComponentsBuilder){
        var cliente = new Cliente(dados);
        repository.save(cliente);

        var uri = uriComponentsBuilder.path("/hospedes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoClientes(cliente));
    }

}
