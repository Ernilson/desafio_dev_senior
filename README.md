Desafio Desenvolvedor - Plataforma de Gestão Acadêmica
Este projeto é uma aplicação web responsiva desenvolvida para o desafio de desenvolvedor da UNIFOR. O sistema visa permitir a administração de alunos, professores e cursos, com diferentes níveis de acesso e funcionalidades para cada tipo de usuário. 

Tabela de Conteúdos
Arquitetura e Padrões de Projeto

Tecnologias Utilizadas

Como Executar a Aplicação

Decisões Técnicas e Suposições

Arquitetura e Padrões de Projeto
A solução foi desenvolvida seguindo um conjunto de padrões de arquitetura e de projeto para garantir manutenibilidade, clareza e escalabilidade, conforme os critérios de avaliação. 

Padrões de Arquitetura (Alto Nível)
Arquitetura Cliente-Servidor (Client-Server)
Conforme a exigência de desenvolver frontend e backend de forma separada, o projeto adota o modelo Cliente-Servidor. O 

Frontend (Angular) atua como o cliente, responsável pela interface e experiência do usuário, enquanto o Backend (Java/Quarkus) funciona como o servidor, responsável pela lógica de negócio e persistência dos dados.

API RESTful
A comunicação entre o cliente e o servidor é realizada através de uma API RESTful. O backend expõe recursos (como usuários, cursos, etc.) que são manipulados pelo frontend utilizando os verbos padrão do protocolo HTTP (GET, POST, PUT, DELETE).

Autenticação Centralizada
Seguindo o requisito de segurança, a arquitetura utiliza um provedor de identidade centralizado, o 

Keycloak. Nenhuma aplicação (frontend ou backend) gerencia senhas diretamente. Elas delegam a tarefa de autenticação ao Keycloak, que emite tokens de acesso para os clientes autorizados.

Padrões de Código (Backend)
Arquitetura em Camadas (Layered Architecture)
O código do backend foi estruturado em três camadas lógicas para separar as responsabilidades:

Camada de Recurso (Resource/Controller): Classes JAX-RS (@Path) que expõem os endpoints da API e lidam com as requisições e respostas HTTP.

Camada de Serviço (Service): Classes que contêm a lógica de negócio principal, validações e orquestração das operações.


Camada de Dados (Repository/Entity): Entidades JPA (@Entity) que mapeiam o banco de dados relacional  e repositórios (via Panache) que abstraem o acesso aos dados.

Injeção de Dependência (Dependency Injection - DI)
Utilizamos o mecanismo de injeção de dependências do Quarkus (CDI) através da anotação @Inject. Esse padrão remove o acoplamento direto entre os componentes (ex: um Resource não precisa instanciar um Service), o que torna o código mais modular, flexível e fácil de testar.

Data Transfer Object (DTO)
Para a comunicação entre o cliente e o servidor, foram utilizados DTOs. Estes são objetos simples que carregam apenas os dados necessários para uma determinada visão, evitando a exposição de detalhes internos das entidades do banco de dados e otimizando o tráfego de dados.

Padrões de Segurança
Autenticação Baseada em Token (JWT)
O fluxo de segurança é baseado em JSON Web Tokens (JWT). Após o login bem-sucedido no Keycloak, o frontend recebe um JWT, que é enviado no cabeçalho de cada requisição à API. O backend (configurado como um Resource Server) valida este token para garantir a autenticidade e as permissões do usuário antes de processar a requisição.

Padrões de Infraestrutura e Implantação
Containerização
Tanto o frontend quanto o backend foram empacotados em imagens 

Docker. Esse padrão garante que as aplicações rodem em um ambiente consistente e isolado, simplificando a implantação e eliminando problemas de "funciona na minha máquina".

Infraestrutura como Código (Infrastructure as Code - IaC)
Utilizamos o 

Docker Compose para definir e orquestrar toda a pilha de serviços da aplicação (backend, banco de dados, Keycloak) em um único arquivo declarativo (docker-compose.yml). Isso permite que todo o ambiente de desenvolvimento seja recriado de forma rápida e confiável com um único comando.

Tecnologias Utilizadas
Backend: Java 17, Quarkus


Frontend: Angular 15+ (Standalone) 


Banco de Dados: PostgreSQL (ou outro banco relacional) 


Segurança: Keycloak 


Containerização: Docker e Docker Compose 


Versionamento: Git 

Como Executar a Aplicação
Pré-requisitos:

Git

Docker

Docker Compose

Passos:

Clone o repositório:

Bash

git clone <URL_DO_SEU_REPOSITORIO>
Navegue até a raiz do projeto:

Bash

cd <NOME_DA_PASTA_DO_PROJETO>
Suba os containers:

Bash

docker-compose up --build
Acesse as aplicações:

Frontend: http://localhost:4200

Backend (API): http://localhost:8080

Keycloak Admin Console: http://localhost:8081

Decisões Técnicas e Suposições
Toda suposição relevante para a implementação do projeto foi documentada, conforme solicitado. 

Suposição 1: ...

Suposição 2: ...
