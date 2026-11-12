# RPG Items API

API REST desenvolvida em Java com Spring Boot para o gerenciamento de itens de um jogo RPG. O projeto permite cadastrar, consultar, atualizar e excluir itens, utilizando banco de dados H2 e persistência com Spring Data JPA.

## Tecnologias utilizadas

- Java 22
- Spring Boot 4.1.2
- Spring Web MVC
- Spring Data JPA
- Hibernate
- Banco de dados H2
- Maven
- Bean Validation

## Modelo de dados

A API possui a entidade `Item`, com os seguintes atributos:

| Campo | Tipo | Descrição |
|---|---|---|
| id | Long | Identificador único, gerado automaticamente |
| nome | String | Nome do item |
| raridade | String | Raridade do item |
| preco | Double | Preço do item |
| nivelMinimo | Integer | Nível mínimo necessário para utilizar o item |

## Como executar o projeto

### Pré-requisitos

- Java 22 ou superior
- Git (opcional, para clonar o repositório)

### Executando localmente

1. Clone o repositório:
   ```bash
   git clone URL_DO_REPOSITORIO
   ```

2. Entre na pasta do projeto:
   ```bash
   cd rpg-items-api
   ```

3. Execute a aplicação pelo Maven Wrapper:

   **Windows:**
   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

   **Linux/macOS:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. A API estará disponível em:
   `http://localhost:8080`

## Rotas da API

| Método | Rota | Descrição | Resposta esperada |
|---|---|---|---|
| GET | `/itens` | Lista todos os itens | 200 OK |
| GET | `/itens/{id}` | Busca um item pelo ID | 200 OK / 404 Not Found |
| POST | `/itens` | Cadastra um novo item | 201 Created / 400 Bad Request |
| PUT | `/itens/{id}` | Atualiza um item existente | 200 OK / 400 Bad Request / 404 Not Found |
| DELETE | `/itens/{id}` | Exclui um item | 204 No Content / 404 Not Found |

## Exemplos de requisições

### Cadastrar um item (POST /itens)

**JSON enviado:**

```json
{
  "nome": "Espada Lendaria",
  "raridade": "Lendaria",
  "preco": 1500.00,
  "nivelMinimo": 20
}
```

**Resposta esperada (201 Created):**

```json
{
  "id": 1,
  "nome": "Espada Lendaria",
  "raridade": "Lendaria",
  "preco": 1500.0,
  "nivelMinimo": 20
}
```

### Consultar todos os itens (GET /itens)

**Resposta esperada (200 OK):**

```json
[
  {
    "id": 1,
    "nome": "Espada Lendaria",
    "raridade": "Lendaria",
    "preco": 1500.0,
    "nivelMinimo": 20
  }
]
```

### Atualizar um item (PUT /itens/1)

**JSON enviado:**

```json
{
  "nome": "Espada Lendaria +10",
  "raridade": "Mitica",
  "preco": 2500.00,
  "nivelMinimo": 30
}
```

### Excluir um item (DELETE /itens/1)

A exclusão retorna `204 No Content` quando realizada com sucesso.

## Validações

A API possui validações para garantir a integridade dos dados:

- O nome é obrigatório.
- A raridade é obrigatória.
- O preço é obrigatório e não pode ser negativo.
- O nível mínimo é obrigatório e deve ser pelo menos 1.

Quando os dados enviados não atendem às regras, a API retorna `400 Bad Request`, com uma mensagem personalizada indicando o erro.

Exemplo de resposta:

```json
{
  "erro": "Erro de validação",
  "mensagens": [
    "O preço não pode ser negativo"
  ],
  "status": 400
}
```

## Banco de dados H2

O projeto utiliza o banco H2 em memória, com persistência gerenciada pelo Spring Data JPA.

A aplicação disponibiliza o console do H2 em:

`http://localhost:8080/h2-console`

Configurações de acesso:

- JDBC URL: `jdbc:h2:mem:rpgdb`
- User Name: `sa`
- Password: deixar em branco

**Observação:** por utilizar um banco em memória, os registros são apagados quando a aplicação é encerrada ou reiniciada.

## Estrutura do projeto

```text
src/main/java/com/igor/rpgapi/
├── controller/
│   └── ItemController.java
├── exception/
│   └── GlobalExceptionHandler.java
├── model/
│   └── Item.java
├── repository/
│   └── ItemRepository.java
└── RpgItemsApiApplication.java

src/main/resources/
└── application.properties
```

## Autor

Igor Durando