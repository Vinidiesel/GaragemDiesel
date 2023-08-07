package garagem.diesel.api.controller;

import garagem.diesel.api.domain.cliente.Cliente;
import garagem.diesel.api.domain.cliente.DTO.DadosAtualizacaoClientes;
import garagem.diesel.api.domain.cliente.repository.ClienteRepository;
import garagem.diesel.api.domain.cliente.DTO.DadosListagemClientes;
import garagem.diesel.api.domain.cliente.DTO.DadosCadastroClientes;
import garagem.diesel.api.domain.cliente.DTO.DadosDetalhamentoClientes;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity<Page<DadosListagemClientes>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemClientes::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoClientes dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoClientes(cliente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.deletar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoClientes(cliente));
    }


}
