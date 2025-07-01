# 📘 API de Alunos e Pessoas

API REST desenvolvida com Spring Boot para gerenciar dados de pessoas e alunos vinculados.

# 🔧 Funcionalidades

## Pessoa
- `GET /pessoas/todos` – Lista todas as pessoas
- `POST /pessoas/inserir` – Cadastra uma nova pessoa
- `PUT /pessoas/atualizar/{id}` – Atualiza dados de uma pessoa
- `DELETE /pessoas/deletar/{id}` – Remove uma pessoa

## Aluno
- `GET /alunos/todos` – Lista todos os alunos
- `POST /alunos/inserir` – Cadastra um novo aluno
- `PUT /alunos/atualizar/{id}` – Atualiza dados do aluno
- `DELETE /alunos/deletar/{id}` – Remove um aluno
- `GET /alunos/buscar/nome/{nome}` – Busca por nome do estudante
- `GET /alunos/buscar/curso/{curso}` – Busca por curso
- `GET /alunos/buscar/campus/{campus}` – Busca por campus

# 🧾 Exemplos de JSON

## Pessoa (POST/PUT)
```json
{
  "nomeEstudante": "MICHELLE APADILHA SABATEL",
  "idade": 29,
  "sexo": "Feminino"
}
```

## Aluno (POST/PUT)
```json
{
  "campus": "Campus Corumbá",
  "curso": "Sistemas de Informação",
  "emailInstitucional": "michelle@ifms.edu.br",
  "periodoEntrada": "2022.2",
  "idPessoa": 2
}

```

# ▶️ Como executar a API
Pré-requisitos
* Java 17+
* Maven
* PostgreSQL (ou H2 para testes)

### application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
server.port=8080

## Executar com Maven
* bash
* Copiar
* Editar
* mvn spring-boot:run

# 🔗 Acesso
## A API ficará disponível em:

* arduino
*Copiar
*Editar
*http://localhost:8080
*Use ferramentas como Postman ou Insomnia para testar os endpoints



