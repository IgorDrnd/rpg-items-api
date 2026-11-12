# RPG Items API

API REST desenvolvida em Java com Spring Boot para gerenciamento de itens de RPG. O projeto permite cadastrar, consultar, atualizar e excluir itens, utilizando persistência de dados com Spring Data JPA e banco de dados H2.

## Tecnologias utilizadas

- Java 22
- Spring Boot 4.1.2
- Spring Web MVC
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- Bean Validation

## Modelo de dados

A entidade `Item` possui os seguintes atributos:

| Atributo | Tipo | Descrição |
|---|---|---|
| id | Long | Identificador único, gerado automaticamente |
| nome | String | Nome do item |
| raridade | String | Raridade do item |
| preco | Double | Preço do item |
| nivelMinimo | Integer | Nível mínimo necessário para utilizar o item |

## Funcionalidades

A API disponibiliza operações CRUD (Create, Read, Update e Delete).

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/itens` | Lista todos os itens |
| GET | `/itens/{id}` | Busca um item pelo ID |
| POST | `/itens` | Cadastra um novo item |
| PUT | `/itens/{id}` | Atualiza um item existente |
| DELETE | `/itens/{id}` | Remove um item |

## Como executar o projeto

### Pré-requisitos

- Java 22 ou superior
- Git (opcional, para clonar o repositório)

### Executando localmente

1. Clone o repositório:

```bash
git clone https://github.com/IgorDrnd/rpg-items-api.git
```

2. Acesse a pasta do projeto:

```bash
cd rpg-items-api
```

3. Execute a aplicação:

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

A API estará disponível em:

`http://localhost:8080`

## Exemplos de requisições

### Cadastrar item (POST /itens)

```json
{
  "nome": "Espada de Fogo",
  "raridade": "Lendária",
  "preco": 500.0,
  "nivelMinimo": 10
}
```

### Consultar todos os itens

```http
GET http://localhost:8080/itens
```

### Consultar item por ID

```http
GET http://localhost:8080/itens/1
```

### Atualizar item (PUT /itens/1)

```json
{
  "nome": "Espada Flamejante",
  "raridade": "Épica",
  "preco": 750.0,
  "nivelMinimo": 15
}
```

### Excluir item

```http
DELETE http://localhost:8080/itens/1
```

## Validações e tratamento de erros

A API possui validações para garantir a integridade dos dados:

- Nome obrigatório.
- Raridade obrigatória.
- Preço não pode ser negativo.
- Nível mínimo deve ser igual ou superior a 1.

As requisições com dados inválidos retornam HTTP 400 com mensagens de validação. Consultas de itens inexistentes retornam HTTP 404.

## Banco de dados

O projeto utiliza o H2 Database em memória, integrado ao Spring Data JPA.

O console do banco pode ser acessado em:

`http://localhost:8080/h2-console`

Configurações de acesso:

- JDBC URL: `jdbc:h2:mem:rpgdb`
- User Name: `sa`
- Password: deixar em branco.

**Observação:** por utilizar banco em memória, os dados cadastrados são perdidos quando a aplicação é reiniciada.

## Estrutura do projeto

```text
src
├── main
│   ├── java
│   │   └── com.igor.rpgapi
│   │       ├── controller
│   │       ├── exception
│   │       ├── model
│   │       ├── repository
│   │       └── RpgItemsApiApplication.java
│   └── resources
│       └── application.properties
└── test
```

## Autor

**Igor Durando**

[GitHub](https://github.com/IgorDrnd)