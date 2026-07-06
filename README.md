# 📌 To Do List API - Spring Boot

## 📖 Descrição do Projeto

Este projeto é uma API REST de lista de tarefas (To Do List) desenvolvida com Java + Spring Boot, com foco no aprendizado prático de Programação Orientada a Objetos (POO), construção de APIs REST e boas práticas de desenvolvimento backend.

A aplicação permite realizar operações de CRUD (Create, Read, Update, Delete) em tarefas, simulando um sistema real de gerenciamento de atividades.

### 🎯 Objetivo principal

### Consolidar conhecimentos em:

- Java
- Spring Boot
- API REST
- POO (Programação Orientada a Objetos)
- Estruturação de projetos backend

---

## ⚙️ Funcionalidades

- Criar nova tarefa
- Listar todas as tarefas
- Buscar tarefa por ID
- Atualizar tarefa existente
- Remover tarefa

---

## 🧠 Objetivo do Projeto

### Este projeto foi desenvolvido para:

- Praticar desenvolvimento backend com Spring Boot
- Entender o funcionamento de APIs REST
- Aplicar conceitos de POO na prática
- Simular um projeto real de mercado
- Evoluir para um nível júnior em desenvolvimento backend

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- Banco de dados (H2 / MySQL - se aplicável)

---

## 🚀 Como executar o projeto

### Pré-requisitos

- Java 17 ou superior
- Maven instalado
- IDE (IntelliJ / Eclipse / VS Code)

### Passos

```bash
# Clone o repositório
git clone https://github.com/DouglasJr12/todo-list-api.git

# Acesse a pasta do projeto
cd todo-list-api

# Execute a aplicação
mvn spring-boot:run
```

---

## 📌 Estrutura do Projeto

### O projeto segue uma arquitetura simples baseada em camadas:

- Controller → Responsável pelas requisições HTTP
- Service → Regras de negócio
- Repository → Acesso ao banco de dados
- Entity → Modelagem das tarefas


## 📡 Endpoints da API

| Método | Endpoint        | Descrição                     |
|--------|----------------|-------------------------------|
| GET    | /tasks         | Lista todas as tarefas        |
| GET    | /tasks/{id}    | Busca uma tarefa por ID       |
| POST   | /tasks         | Cria uma nova tarefa          |
| PUT    | /tasks/{id}    | Atualiza uma tarefa existente |
| DELETE | /tasks/{id}    | Remove uma tarefa             |
---

## 📚 Aprendizados

### Durante o desenvolvimento deste projeto, foram praticados:

- Criação de APIs REST com Spring Boot
- Estruturação de projeto em camadas
- Manipulação de dados com JPA
- Organização de código e boas práticas
- Uso do Git e GitHub no fluxo de desenvolvimento


## 🔥 Próximos passos (melhorias futuras)
- Implementar tratamento de exceções global (@ControllerAdvice)
- Adicionar validações com Bean Validation
- Criar autenticação (Spring Security)
- Documentar API com Swagger
- Melhorar arquitetura (DTOs e separação de responsabilidades)

## 👨‍💻 Autor

*Projeto desenvolvido por Douglas Júnior*

*desenvolvedor backend Java ☕*