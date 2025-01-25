# Gerenciamento de Clientes Pessoa Física com Spring Boot e MongoDB  

Este projeto é uma API REST desenvolvida em **Spring Boot** com integração ao banco de dados **MongoDB**. Ele permite realizar operações CRUD (Create, Read, Update, Delete) para gerenciar informações de clientes pessoa física, como nome, e-mail, endereço e status de atividade.  

## 🚀 Tecnologias Utilizadas  
- **Java 17**  
- **Spring Boot 3.x**  
  - Spring Data MongoDB  
  - Spring Web  
  - Spring Validation  
- **MongoDB**  
- **Insomnia** (para testes)  

## 🛠️ Funcionalidades  
1. **Cadastrar Cliente Pessoa Física**:  
   Permite criar um novo cliente com validações para nome e e-mail.  

2. **Listar Clientes**:  
   Lista todos os clientes com paginação e ordenação pelo nome.  

3. **Atualizar Cliente**:  
   Atualiza os dados de um cliente específico.  

4. **Excluir Cliente**:  
   Remove um cliente pelo ID.  

## 🗂 Estrutura do Projeto  
- **Model**: Representa os dados e suas validações.  
- **Repository**: Interface para interação com o banco de dados MongoDB.  
- **Service**: Contém a lógica de negócio para as operações.  
- **Controller**: Exposição das funcionalidades via endpoints REST.  

## 📦 Exemplos de Uso  

### 📥 Enviar dados:  
```json  
POST /api/cliente/cadastrar  
{  
  "nome": "Thays Santos",  
  "email": "thays.santos@email.com",  
  "ativo": true,  
  "endereco": {  
    "logradouro": "Av. Boa Viagem",  
    "numero": "456",  
    "cidade": "Recife"  
  }  
}  
```  

### 📤 Retorno esperado:  
```json  
{  
  "id": "67955fc075b88603f706db19",  
  "nome": "Thays Santos",  
  "email": "thays.santos@email.com",  
  "ativo": true,  
  "endereco": {  
    "logradouro": "Av. Boa Viagem",  
    "numero": "456",  
    "cidade": "Recife"  
  }  
}  
```  

## 🔗 Endpoints Disponíveis  
| Método  | Endpoint               | Descrição                     |  
|---------|------------------------|-------------------------------|  
| `POST`  | `/api/cliente/cadastrar` | Cadastra um novo cliente       |  
| `GET`   | `/api/cliente`          | Lista todos os clientes        |  
| `PUT`   | `/api/cliente/{id}`     | Atualiza os dados de um cliente |  
| `DELETE`| `/api/cliente/{id}`     | Remove um cliente pelo ID      |  

## 🧪 Testes  
Os testes da API foram realizados utilizando o **Insomnia**, com suporte para todas as operações CRUD e retorno esperado no formato JSON.  

## 📂 Configuração do Banco de Dados  
O banco de dados MongoDB foi configurado utilizando a seguinte URI:  
```properties  
spring.data.mongodb.uri=mongodb://localhost:27017/carteiras-db  
```  

## 🤝 Contribuição  
Fique à vontade para contribuir com melhorias! Basta fazer um fork deste repositório, implementar as alterações e enviar um pull request.  
