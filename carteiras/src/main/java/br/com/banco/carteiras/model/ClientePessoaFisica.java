package br.com.banco.carteiras.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class ClientePessoaFisica {

    private static final String CAMPO_OBRIGATORIO = "O campo é obrigatório.";

    @Id
    private String id;

    @NotBlank(message = CAMPO_OBRIGATORIO)
    @Size(max = 100, message = "O nome não pode exceder 100 caracteres")
    @Field(name = "nome")
    private String nome;

    @NotBlank(message = CAMPO_OBRIGATORIO)
    @Field(name = "email")
    private String email;

    @Field(name = "ativo")
    private boolean ativo;

    @Field(name = "endereco")
    private Endereco endereco;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
