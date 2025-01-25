package br.com.banco.carteiras.controller;

import br.com.banco.carteiras.model.ClientePessoaFisica;
import br.com.banco.carteiras.service.ClientePessoaFisicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cliente")
public class ClientePessoaFisicaController {

    private final ClientePessoaFisicaService clientePessoaFisicaService;

    @Autowired
    public ClientePessoaFisicaController(ClientePessoaFisicaService clientePessoaFisicaService) {
        this.clientePessoaFisicaService = clientePessoaFisicaService;
    }
    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<ClientePessoaFisica> cadastrar(@RequestBody @Valid ClientePessoaFisica clientePessoaFisica){
        ClientePessoaFisica dados = clientePessoaFisicaService.criarCliente(clientePessoaFisica);
        return ResponseEntity.status(HttpStatus.CREATED).body(dados);
    }
    @GetMapping
    @Transactional
    public ResponseEntity<Page<ClientePessoaFisica>> listar(@PageableDefault(size = 3, sort = {"nome"})Pageable pageable){
        Page<ClientePessoaFisica> dados = clientePessoaFisicaService.listarClientes(pageable);
        return ResponseEntity.ok(dados);
    }
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<ClientePessoaFisica> atualizar(@PathVariable String id, @RequestBody @Valid ClientePessoaFisica clientePessoaFisica){
        ClientePessoaFisica dados = clientePessoaFisicaService.localizarCliente(id);
        if (dados == null){
            return ResponseEntity.notFound().build();
        }

        ClientePessoaFisica atualizado = clientePessoaFisicaService.atualizarCliente(id, clientePessoaFisica);
        return ResponseEntity.ok(atualizado);
    }
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> apagar(@PathVariable String id){
        ClientePessoaFisica dados = clientePessoaFisicaService.localizarCliente(id);
        if (dados == null){
            return ResponseEntity.notFound().build();
        }

        clientePessoaFisicaService.apagarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
