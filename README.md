# Task Manager API

API REST para gerenciamento de tarefas, desenvolvida com Java 17 e Spring Boot 3.4.5. Os dados são armazenados em memória.

## Requisitos

- JDK 17 ou superior
- Maven

## Executar a aplicação

Abra o terminal na pasta `taskManager` (a mesma pasta deste README, onde está o `pom.xml`) e execute:

```powershell
mvn spring-boot:run
```

A aplicação inicia por padrão em `http://localhost:8080`. Mantenha esse terminal aberto enquanto estiver usando a API. Para interromper o servidor, pressione `Ctrl+C`.

## Documentação Swagger / OpenAPI

Com o servidor iniciado, abra a documentação interativa do Swagger UI:

- http://localhost:8080/swagger-ui/index.html

A especificação OpenAPI também pode ser acessada diretamente:

- JSON: http://localhost:8080/v3/api-docs
- YAML: http://localhost:8080/v3/api-docs.yaml

No Swagger UI, é possível consultar os endpoints, seus parâmetros e exemplos, além de enviar requisições.

## Endpoints

| Método | Caminho | Descrição | Resposta esperada |
|---|---|---|---|
| `POST` | `/tasks` | Cria uma tarefa | `201 Created` |
| `GET` | `/tasks` | Lista as tarefas | `200 OK` |
| `GET` | `/tasks/{id}` | Busca tarefa pelo UUID | `200 OK` ou `404 Not Found` |
| `PATCH` | `/tasks/{id}` | Atualiza campos da tarefa | `200 OK` ou `404 Not Found` |
| `DELETE` | `/tasks/{id}` | Remove uma tarefa | `204 No Content` ou `404 Not Found` |

### Criar tarefa

Envie `POST http://localhost:8080/tasks` com `Content-Type: application/json`:

```json
{
  "title": "Estudar Spring Boot",
  "description": "Revisar controllers e validação"
}
```

O título é obrigatório e deve conter entre 3 e 100 caracteres. A descrição é opcional e aceita até 200 caracteres. A resposta inclui o UUID gerado e o status inicial `PENDING`.

### Buscar tarefa por ID

Use o UUID retornado ao criar a tarefa:

```http
GET http://localhost:8080/tasks/{id}
```

### Atualizar tarefa

Envie `PATCH http://localhost:8080/tasks/{id}` com os campos que deseja alterar. Os campos são opcionais; os status aceitos são `PENDING`, `IN_PROGRESS` e `COMPLETED`.

```json
{
  "title": "Estudar Spring Boot a fundo",
  "status": "IN_PROGRESS"
}
```

### Excluir tarefa

```http
DELETE http://localhost:8080/tasks/{id}
```

## Observações

- O armazenamento é em memória: as tarefas são apagadas quando a aplicação é encerrada ou reiniciada.
- UUIDs inexistentes retornam `404 Not Found`.
- Erros de validação na criação retornam `400 Bad Request` com os campos inválidos.
