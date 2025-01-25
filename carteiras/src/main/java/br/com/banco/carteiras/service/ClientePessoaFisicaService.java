package br.com.banco.carteiras.service;


import br.com.banco.carteiras.model.ClientePessoaFisica;
import br.com.banco.carteiras.repository.ClientePessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.codec.EncodingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientePessoaFisicaService {
    private final ClientePessoaFisicaRepository clientePessoaFisicaRepository;

    @Autowired
    public ClientePessoaFisicaService(ClientePessoaFisicaRepository clientePessoaFisicaRepository) {
        this.clientePessoaFisicaRepository = clientePessoaFisicaRepository;
    }

    public ClientePessoaFisica criarCliente(ClientePessoaFisica clientePessoaFisica){
        return clientePessoaFisicaRepository.save(clientePessoaFisica);
    }

    public Page<ClientePessoaFisica> listarClientes(Pageable pageable){
        return clientePessoaFisicaRepository.findAll(pageable);
    }

    public ClientePessoaFisica localizarCliente(String id){
        return clientePessoaFisicaRepository.findById(id).orElse(null);
    }

    public ClientePessoaFisica atualizarCliente(String id, ClientePessoaFisica clientePessoaFisica){
        ClientePessoaFisica dados =  clientePessoaFisicaRepository.findById(id).orElseThrow(
                ()-> new EncodingException("Cliente não localizado"));
        dados.setNome(clientePessoaFisica.getNome());
        dados.setEmail(clientePessoaFisica.getEmail());
        dados.setAtivo(clientePessoaFisica.isAtivo());
        dados.setEndereco(clientePessoaFisica.getEndereco());

        return clientePessoaFisicaRepository.save(dados);
    }

    public void apagarCliente(String id){
        clientePessoaFisicaRepository.deleteById(id);
    }
}
