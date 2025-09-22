# Credit Card Points - Documentação

## Regra de Negócio

O sistema Credit Card Points tem como objetivo gerenciar o acúmulo e o resgate de pontos de cartão de crédito dos usuários. Usuários podem acumular pontos ao realizar transações, consultar seu saldo de pontos, e trocar pontos por benefícios oferecidos por parceiros cadastrados no sistema. O fluxo principal envolve:

- Cadastro e autenticação de usuários.
- Registro de transações que geram pontos.
- Consulta e controle do saldo de pontos de cada usuário.
- Cadastro de parceiros que oferecem benefícios ou produtos para resgate.
- Resgate de pontos por meio de trocas com parceiros.

A arquitetura de microsserviços garante escalabilidade, separação de responsabilidades e facilidade de manutenção, permitindo que cada domínio (usuário, pontos, parceiros) evolua de forma independente.

## Tecnologias Utilizadas

- **Java 21**: Linguagem principal para desenvolvimento dos microsserviços.
- **Spring Boot**: Framework para construção dos microsserviços (bff, user-service, point-service, partner-service).
- **Spring Cloud OpenFeign**: Comunicação entre microsserviços via HTTP declarativo.
- **Docker & Docker Compose**: Containerização dos serviços e orquestração de ambiente local.
- **PostgreSQL**: Banco de dados relacional utilizado pelo user-service.
- **Maven**: Gerenciador de dependências e build dos projetos Java.

## Arquitetura

O sistema segue uma arquitetura de microsserviços, composta por:

- **BFF (Backend For Frontend)**: Camada intermediária entre o frontend e os microsserviços, responsável por orquestrar chamadas e agregar dados.
- **User Service**: Gerencia usuários e autenticação.
- **Point Service**: Gerencia pontos de cartão de crédito.
- **Partner Service**: Gerencia parceiros do sistema.

A comunicação entre os microsserviços é feita via HTTP, utilizando Feign Clients para facilitar a integração. Todos os serviços são containerizados com Docker e se comunicam por meio de uma rede Docker compartilhada.

## Como Executar e Testar Localmente

### Pré-requisitos
- Docker e Docker Compose instalados
- Java 21 e Maven instalados (opcional, para builds manuais)

### Passos para subir o ambiente completo

1. **Clone o repositório:**
   ```sh
   git clone <url-do-repositorio>
   cd creditcardpoints
   ```

2. **Suba todos os serviços com Docker Compose:**
   ```sh
   docker compose -f compose.yaml up --build
   ```
   Isso irá:
   - Construir as imagens dos microsserviços
   - Subir containers para bff, user-service, point-service, partner-service e bancos de dados necessários

3. **Acesse os serviços:**
   - BFF: http://localhost:8085
   - User Service: http://localhost:8081
   - Point Service: http://localhost:8080
   - Partner Service: http://localhost:8084

   (As portas podem variar conforme configuração dos docker-compose)

4. **Testes automatizados:**
   Para rodar os testes de cada serviço:
   ```sh
   cd <nome-do-serviço>
   ./mvnw test
   ```
   Exemplo:
   ```sh
   cd bff
   ./mvnw test
   ```

### Observações
- Certifique-se de que todas as portas necessárias estão livres.
- Os serviços se comunicam via nomes de host definidos no Docker Compose (ex: `user-service`, `point-service`).
- As configurações de URLs dos serviços estão nos arquivos `application.yml` de cada projeto.

## Estrutura dos Diretórios

- `bff/` - Backend For Frontend
- `user-service/` - Serviço de usuários
- `point-service/` - Serviço de pontos
- `partner-service/` - Serviço de parceiros
- `compose.yaml` - Orquestração de todos os serviços

---
