﻿# Fórum Hub - Alura e Oracle ONE

## Descrição

Este projeto implementa uma API RESTful para um fórum de discussão chamado Forum Hub. A API é desenvolvida em Java utilizando o framework Spring Boot, integrado com Spring Security para gerenciamento de autenticação e autorização. Ele é um projeto desenvolvido como um desafio para graduação no programa ONE (Oracle Next Education).

## Funcionalidades

-**Gerenciamento de Usuários: Cadastro, atualização, remoção e consulta de usuários.
-**Gerenciamento de Cursos: Operações CRUD para cursos disponíveis no fórum.
-**Gerenciamento de Tópicos: Criação, atualização, consulta e remoção de tópicos de discussão.
-**Autenticação e Autorização: Utilização do Spring Security para proteger endpoints e controlar acesso com base em roles de usuário.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.0**
- **Maven**
- **MySQL**
- **Hibernate**
- **JWT (JSON Web Token)**
- **Lombok**
- **Flyway**
- **Spring Security**
- **Spring Data JPA**
- **Springdoc OpenAPI**
- **Swagger para documentação da API**

## Endpoints Principais

### Gerenciamento de Usuários

- **Cadastro de Usuário:** `POST /usuarios`
- **Atualização de Usuário:** `PUT /usuarios/{id}`
- **Remoção de Usuário:** `DELETE /usuarios/{id}`
- **Consulta de Usuário por ID:** `GET /usuarios/{id}`
- **Listagem de Usuários:** `GET /usuarios`

### Gerenciamento de Cursos

- **Cadastro de Curso:** `POST /cursos`
- **Atualização de Curso:** `PUT /cursos/{id}`
- **Remoção de Curso:** `DELETE /cursos/{id}`
- **Consulta de Curso por ID:** `GET /cursos/{id}`
- **Listagem de Cursos:** `GET /cursos`

### Gerenciamento de Tópicos

- **Criação de Tópico:** `POST /topicos`
- **Atualização de Tópico:** `PUT /topicos/{id}`
- **Remoção de Tópico:** `DELETE /topicos/{id}`
- **Consulta de Tópico por ID:** `GET /topicos/{id}`
- **Listagem de Tópicos:** `GET /topicos`

### Autenticação e Autorização

- **Autenticar Usuário:** `POST /login`

A API utiliza Spring Security para proteger os endpoints e controlar o acesso com base nas roles de usuário configuradas.

## Documentação da API
- A documentação da API pode ser acessada localmente através do Swagger:
- Endpoint Swagger UI: http://localhost:8080/swagger-ui/

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request com melhorias ou correções.
