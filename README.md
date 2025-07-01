# 📘 API de Alunos e Pessoas

API REST feita com Spring Boot para gerenciar dados de alunos e pessoas.

## 🔧 Funcionalidades

### Pessoa

- `GET /pessoas/todos` – Lista todas as pessoas
- `POST /pessoas/inserir` – Cadastra uma nova pessoa
- `PUT /pessoas/atualizar/{id}` – Atualiza dados de uma pessoa
- `DELETE /pessoas/deletar/{id}` – Remove uma pessoa

### Aluno

- `GET /alunos/todos` – Lista todos os alunos
- `POST /alunos/inserir` – Cadastra um novo aluno
- `PUT /alunos/atualizar/{id}` – Atualiza dados do aluno
- `DELETE /alunos/deletar/{id}` – Remove um aluno
- `GET /alunos/buscar/nome/{nome}` – Busca por nome do estudante
- `GET /alunos/buscar/curso/{curso}` – Busca por curso
- `GET /alunos/buscar/campus/{campus}` – Busca por campus

## 🗃️ Dados

### Pessoa

- `nomeEstudante` (obrigatório)
- `idade`
- `sexo`

### Aluno

- `campus` (obrigatório)
- `curso` (obrigatório)
- `emailInstitucional` (obrigatório)
- `periodoEntrada` (obrigatório)
- Outros: polo, coordenacao, situacao, idPessoa (referência para Pessoa)

## ▶️ Como rodar

1. Configure seu banco (ex: PostgreSQL)
2. Rode o projeto com:

```bash
./mvnw spring-boot:run
