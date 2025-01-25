package br.com.banco.carteiras.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Endereco {

    @Field(name = "logradouro")
    private String logradouro;

    @Field(name = "numero")
    private String numero;

    @Field(name = "cidade")
    private String cidade;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
