package br.com.banco.carteiras.repository;

import br.com.banco.carteiras.model.ClientePessoaFisica;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientePessoaFisicaRepository extends MongoRepository<ClientePessoaFisica, String> {

}
