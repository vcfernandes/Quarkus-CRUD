🚀 Quarkus CRUD API - Gerenciamento de Usuários

Este projeto é uma aplicação de exemplo desenvolvida com Quarkus para demonstrar a implementação de uma API REST de CRUD (Create, Read, Update, Delete) de usuários. Foi concebido como um recurso de aprendizado e comparação com projetos equivalentes em Spring Boot.
✨ Funcionalidades

A aplicação implementa um CRUD completo de usuários, oferecendo as seguintes capacidades:

    API RESTful completa para gerenciamento de usuários.

    Persistência de dados via Hibernate ORM com Panache, simplificando as operações de banco de dados.

    Serialização e desserialização JSON utilizando Jackson.

    Integração com MySQL como banco de dados relacional.

    Tratamento de exceções customizado para respostas de erro claras.

🛠️ Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias e frameworks:

    Quarkus: O framework Java nativo otimizado para a nuvem.

    Java 11+

    Jakarta REST (JAX-RS) com RESTEasy Jackson: Para construção de APIs RESTful e serialização/desserialização JSON.

    Hibernate ORM with Panache: ORM (Object-Relational Mapping) para fácil interação com o banco de dados, com a API simplificada do Panache.

    JDBC Driver MySQL: Conectividade com o banco de dados MySQL.

    Jakarta Persistence (JPA): Padrão para ORM utilizado pelo Hibernate.

    Jakarta Transactions: Gerenciamento de transações.

📌 Endpoints da API

A API expõe os seguintes endpoints para gerenciamento de usuários:
➕ Criar Usuário

Cria um novo usuário no sistema.

    Método: POST

    URL: /users
    
    Corpo da Requisição (Body):
    code JSON    
{
  "username": "vinicius"
}

  

Exemplo de Resposta (201 Created):
code JSON
        
    {
      "id": 1,
      "username": "vinicius"
    }   

📄 Buscar Todos os Usuários

Retorna uma lista paginada de todos os usuários.

    Método: GET

    URL: /users?page=0&pageSize=10

    Parâmetros de Query:

        page: Número da página (default: 0)

        pageSize: Quantidade de itens por página (default: 10)

    Exemplo de Resposta (200 OK):
    code JSON
        
    [
      {
        "id": 1,
        "username": "vinicius"
      },
      {
        "id": 2,
        "username": "maria"
      }
    ]


🔍 Buscar Usuário por ID

Retorna um usuário específico pelo seu ID.

    Método: GET

    URL: /users/{id}

    Exemplo de Resposta (200 OK):
    code JSON

    {
      "id": 1,
      "username": "vinicius"
    }

✏️ Atualizar Usuário

Atualiza as informações de um usuário existente.

    Método: PUT

    URL: /users/{id}

    Corpo da Requisição (Body):
    code JSON
    
{
  "username": "novoNome"
}

  

Exemplo de Resposta (200 OK):
code JSON

    {
      "id": 1,
      "username": "novoNome"
    }

❌ Deletar Usuário

Deleta um usuário específico pelo seu ID.

    Método: DELETE

    URL: /users/{id}

    Exemplo de Resposta (204 No Content): (Resposta vazia, indica sucesso na exclusão)

⚠️ Tratamento de Erros

A API possui um tratamento de erros customizado para fornecer respostas claras em caso de problemas.

Por exemplo, se um usuário não for encontrado para uma operação (GET, PUT, DELETE), a exceção UserNotFoundException é lançada e mapeada pelo UserNotFoundExceptionMapper, retornando:

    Status: 404 Not Found

    Corpo da Resposta:
    code JSON
        
    {
      "error": "User not found"
    }
 

▶️ Como Rodar o Projeto

Siga os passos abaixo para configurar e executar o projeto em sua máquina.
Pré-requisitos

Certifique-se de ter os seguintes softwares instalados:

    Java Development Kit (JDK) 11 ou superior

    Apache Maven (gerenciador de dependências)

    Servidor MySQL em execução

Configuração do Banco de Dados MySQL

    Crie um banco de dados MySQL para o projeto (ex: seu_banco).

    No arquivo src/main/resources/application.properties, configure as credenciais e a URL do seu banco de dados:
    code Properties
        
    quarkus.datasource.db-kind=mysql
    quarkus.datasource.username=seu_usuario
    quarkus.datasource.password=sua_senha
    quarkus.datasource.jdbc.url=jdbc:mysql://localhost:3306/seu_banco
    quarkus.hibernate-orm.database.generation=update

      

        quarkus.hibernate-orm.database.generation=update: Esta propriedade fará com que o Hibernate atualize o schema do banco de dados automaticamente com base nas suas entidades. Cuidado ao usar em produção.

Modo Desenvolvimento (Dev Mode - Live Coding)

Para executar a aplicação em modo de desenvolvimento com "live coding":

    Navegue até o diretório raiz do projeto no terminal.

    Execute o comando:
    code Bash

quarkus dev

  
