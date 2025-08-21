Quarkus CRUD 

Este projeto foi desenvolvido com Quarkus para aprendizado e comparação com Spring Boot.
A aplicação implementa um CRUD de usuários utilizando:

Quarkus REST (JAX-RS)

Hibernate ORM with Panache

Jackson para serialização JSON

MySQL como banco de dados

Tratamento de exceções customizadas

🚀 Tecnologias utilizadas

Quarkus

REST (JAX-RS)

Hibernate ORM with Panache

RESTEasy Jackson

JDBC Driver MySQL

Jakarta Persistence (JPA)

Jakarta Transactions

📂 Estrutura do Projeto

src/main/java/org/project
 ├── Controller
 │    └── UserController.java         # Endpoints REST
 ├── Entity
 │    └── UserEntity.java             # Entidade User
 ├── Repository
 │    └── UserRepository.java         # Repositório Panache
 ├── Service
 │    └── UserService.java            # Regras de negócio
 └── Exception
      ├── UserNotFoundException.java
      └── UserNotFoundExceptionMapper.java

📌 Endpoints

➕ Criar Usuário

POST /users
Body: {
  "username": "vinicius"
}

📄 Buscar Todos

GET /users?page=0&pageSize=10

🔍 Buscar por ID

GET /users/{id}

✏️ Atualizar Usuário

PUT /users/{id}
Body: {
  "username": "novoNome"
}

❌ Deletar Usuário

DELETE /users/{id}

⚠️ Tratamento de Erros

Se um usuário não for encontrado, é lançada a exceção UserNotFoundException,
mapeada pelo UserNotFoundExceptionMapper, retornando:

    Status: 404 Not Found

    Body:

{
  "error": "User not found"
}

▶️ Como rodar o projeto
Dev Mode (Live Coding)

Execute no terminal:

quarkus dev

A aplicação sobe em http://localhost:8080.
No modo dev você também tem acesso ao Dev UI em http://localhost:8080/q/dev/.
Configuração do MySQL

No arquivo application.properties, configure:

quarkus.datasource.db-kind=mysql
quarkus.datasource.username=seu_usuario
quarkus.datasource.password=sua_senha
quarkus.datasource.jdbc.url=jdbc:mysql://localhost:3306/seu_banco
quarkus.hibernate-orm.database.generation=update



🔍 Diferenças para Spring Boot

    Quarkus inicia mais rápido e é otimizado para aplicações nativas (GraalVM).

    Utiliza JAX-RS no lugar do Spring MVC.

    Panache simplifica muito os repositórios (menos código boilerplate).

    Configuração mais enxuta e focada em cloud-native.
