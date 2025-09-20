# Credit Card Points Management Microservices

Este projeto implementa a **gestão de pontos acumulados por usuários em cartões de crédito** usando arquitetura de microserviços em Java (Spring Boot), com cada serviço rodando em seu próprio contêiner Docker. Todos os microserviços estão organizados em um **monorepo**, permitindo desenvolvimento, versionamento e orquestração centralizada dos serviços.

---

## Objetivo

Gerenciar o acúmulo, consulta, e uso de pontos obtidos por usuários em compras realizadas com cartões de crédito, permitindo integração com parceiros comerciais para resgate ou consumo dos pontos.

---

## Arquitetura Hexagonal

O projeto adota a **arquitetura hexagonal (Ports & Adapters)** em cada microserviço.  
Essa abordagem separa a lógica de negócio do restante da aplicação, promovendo baixo acoplamento e facilidade para testes e mudanças tecnológicas.

- **Core (Domínio):**  
  Contém as regras de negócio centrais, modelos e serviços.
- **Ports (Portas):**  
  Interfaces que representam operações importantes para o domínio (ex: consultar pontos, cadastrar usuário).
- **Adapters (Adaptadores):**  
  Implementações das interfaces (ex: APIs REST, integração com Kafka, acesso a banco de dados).

Cada serviço está estruturado para que:
- O domínio não dependa de frameworks, bancos de dados ou protocolos de comunicação.
- A comunicação com o mundo externo (ex: REST, Kafka, DB) é feita via adaptadores, facilmente substituíveis.

---

## Monorepo

Todos os microserviços são mantidos em um único repositório (**monorepo**), facilitando a gestão e integração entre eles.  
Exemplo de estrutura:

```plaintext
credit-card-points-management/
├── user-service/
├── card-service/
├── point-service/
├── consulta-service/
├── partner-service/
├── docker-compose.yml
└── README.md
```

---

## Microserviços

- **user-service**  
  Gerencia cadastro e dados dos usuários.

- **card-service**  
  Gerencia cartões de crédito vinculados aos usuários e registra transações.

- **point-service**  
  Calcula, credita e atualiza pontos em cada transação.

- **consulta-service**  
  Permite a consulta do saldo de pontos de um usuário.

- **partner-service**  
  Permite que parceiros consultem e consumam pontos dos usuários via integração.

---

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Docker & Docker Compose**
- **Apache Kafka** (mensageria entre serviços)
- **REST API**

---

## Fluxo de Negócio

1. **Compra realizada:** Usuário faz uma compra com o cartão.
2. **Registro de transação:** card-service registra a compra e envia evento para o point-service.
3. **Acúmulo de pontos:** point-service calcula e credita pontos ao usuário.
4. **Consulta de pontos:** Usuário ou parceiro consulta pontos via consulta-service ou partner-service.
5. **Consumo de pontos:** Parceiros podem consumir pontos do usuário para produtos/serviços, mediante autorização.

---

## Como Executar

1. Compile cada microserviço com Maven:
   ```bash
   mvn clean package
   ```
2. Inicie todos os serviços e dependências:
   ```bash
   docker-compose up --build
   ```

---

## Autor

[LUANSENA10](https://github.com/LUANSENA10)
