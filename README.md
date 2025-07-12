# CourtReserve API 🏀🎾⚽

## Sobre o Projeto

O **CourtReserve** é uma API RESTful completa e segura, desenvolvida em Java com Spring Boot, para um sistema de gerenciamento e reserva de quadras esportivas. O projeto foi construído com foco em boas práticas de desenvolvimento, segurança e manutenibilidade, servindo como um backend robusto para qualquer aplicação frontend (web ou mobile).

## ✨ Funcionalidades Principais

- **Gerenciamento de Usuários**: Sistema de CRUD completo para os usuários da plataforma
- **Gerenciamento de Quadras**: CRUD para as quadras disponíveis para reserva, com filtros por tipo de esporte
- **Sistema de Agendamento**: Lógica para criar, visualizar e cancelar agendamentos
- **Segurança com JWT**: Autenticação baseada em **Bearer Token (JWT)** para proteger os endpoints da API
- **Migrações de Banco de Dados**: Versionamento de schema automatizado e confiável com **Flyway**
- **Ambiente Containerizado**: Banco de dados PostgreSQL rodando em um contêiner **Docker**

## 🔧 Tecnologias Utilizadas

| Tecnologia | Descrição |
|------------|-----------|
| **Java 21** | Linguagem de programação principal |
| **Spring Boot** | Framework principal para criação da aplicação e da API RESTful |
| **Spring Security** | Framework para implementação da camada de autenticação e autorização com JWT |
| **Spring Data JPA** | Camada de persistência de dados para facilitar a comunicação com o banco |
| **PostgreSQL** | Banco de dados relacional para armazenamento dos dados |
| **Flyway** | Ferramenta para versionamento e migração do schema do banco de dados |
| **Docker** | Plataforma de containerização para o banco de dados |
| **Maven** | Ferramenta de gerenciamento de dependências e build do projeto |

## 🚀 Como Executar o Projeto

Siga os passos abaixo para configurar e rodar o ambiente de desenvolvimento localmente.

### Pré-requisitos

- **Java (JDK) 21** ou superior
- **Maven 3.8+**
- **Docker** e **Docker Compose**

### Instalação e Execução

1. **Clone o repositório:**
   ```bash
   git clone [URL_DO_SEU_REPOSITORIO_AQUI]
   cd court-reserve

Inicie o banco de dados com Docker:
bashdocker-compose up -d

Execute a aplicação Spring Boot:
bash./mvnw spring-boot:run

Pronto! A API estará rodando em http://localhost:8080

📚 Uso da API
🔑 Autenticação (Fluxo JWT)
A API utiliza autenticação via Bearer Token (JWT). O fluxo é o seguinte:
Passo 1: Registrar um novo usuário
Primeiro, crie uma conta. Este endpoint é público.

POST /court_reserve/auth/register
Body (JSON):
json{

    "email": "meu-email@exemplo.com",
    "password": "minha-senha-segura"
}


Passo 2: Fazer Login para Gerar o Token
Envie as credenciais do usuário registrado para obter um token de acesso.

POST /court_reserve/auth/login

Body (JSON):
json{

    "email": "meu-email@exemplo.com",
    "password": "minha-senha-segura"
}
Resposta de Sucesso (JSON):
json{

    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ..." // Token JWT longo
}


Passo 3: Acessar Endpoints Protegidos
Copie o token recebido e use-o para acessar todos os outros endpoints. No Postman acesse Auth e preencha Auth Type como "Bearer Token" e cole o token.
Endpoints Protegidos (Exemplos)
Nota: Todos os endpoints abaixo exigem o Bearer Token no cabeçalho Authorization.
Usuários (/users)

GET /court_reserve/users
Lista todos os usuários

GET /court_reserve/users/{id}
Busca um usuário por ID

POST /court_reserve/users
Cria um novo usuário
Body (JSON):

json{

    "email": "usuario@exemplo.com",
    "password": "senha123"
    
}

DELETE /court_reserve/users/{id}
Deleta um usuário por ID

PATCH /court_reserve/users/{id}/password
Atualiza a senha do usuário
Body (JSON):

json{

    "password": "nova-senha-segura"
}

Quadras (/courts)

GET /court_reserve/courts
Lista todas as quadras

GET /court_reserve/courts/{id}
Busca uma quadra por ID

POST /court_reserve/courts
 - Cria uma nova quadra
Body (JSON):

json{

    "name": "Quadra de Futebol 1",
    "sportType": "FOOTBALL",
    "description": "Quadra de futebol com grama sintética"
}

PATCH /court_reserve/courts/{id}
Atualiza uma quadra
   Body (JSON):

   json{
   
    "name": "Quadra de Futebol 1 - Atualizada",
    "description": "Quadra reformada com nova iluminação"
   }

DELETE /court_reserve/courts/{id} 
Deleta uma quadra

Agendamentos (/bookings)

GET /court_reserve/bookings 
Lista todos os agendamentos

GET /court_reserve/bookings/{id}
Busca um agendamento por ID

POST /court_reserve/bookings
Cria um novo agendamento
Body (JSON):

   json{

    "courtId": 1,
    "userId": 1,
    "startTime": "2024-12-15T10:00:00",
    "endTime": "2024-12-15T11:00:00"
   }

PATCH /court_reserve/bookings/{id} 
- Atualiza um agendamento
Body (JSON):

json{
    
    "endTime": "2024-12-15T15:00:00"
}

DELETE /court_reserve/bookings/{id} 
- Cancela um agendamento

📜 Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.
