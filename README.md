# 📅 Agendamento de Consultas - API

> Uma API REST robusta construída com Spring Boot 3.3.4 e Java 17 para gerenciar agendamentos de consultas médicas.

---

## 📋 Sumário

- [Visão Geral](#visão-geral)
- [Tecnologias](#-tecnologias)
- [Pré-requisitos](#-pré-requisitos)
- [Instalação e Configuração](#-instalação-e-configuração)
- [Executando a Aplicação](#-executando-a-aplicação)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Endpoints da API](#-endpoints-da-api)
  - [Pacientes](#pacientes)
  - [Profissionais de Saúde](#profissionais-de-saúde)
  - [Slots de Agendamento](#slots-de-agendamento)
  - [Agendamentos](#agendamentos)
- [Exemplos de Requisições](#-exemplos-de-requisições)
- [Tratamento de Erros](#-tratamento-de-erros)
- [Autor](#-autor)

---

## 🎯 Visão Geral

A API de Agendamento de Consultas é um sistema completo para gerenciar:

- **Pacientes**: Cadastro e consulta de pacientes
- **Profissionais de Saúde**: Gerenciamento de médicos e outros profissionais
- **Horários Disponíveis**: Criação e gerenciamento de slots de agendamento
- **Agendamentos**: Booking de consultas entre pacientes e profissionais

A aplicação utiliza banco de dados MySQL e segue os princípios de RESTful API com tratamento robusto de exceções.

---

## 🛠 Tecnologias

| Tecnologia | Versão |
|------------|--------|
| **Java** | 17 |
| **Spring Boot** | 3.3.4 |
| **Spring Data JPA** | 3.3.4 |
| **Hibernate** | 6.x |
| **MySQL** | 8.0+ |
| **Maven** | 3.6+ |
| **Lombok** | 1.18.x |
| **Actuator Spring Boot** | 3.3.4 |
| **Hibernate Validator** | 8.x |

---

## 📦 Pré-requisitos

Antes de começar, certifique-se de ter instalados:

- ✅ **Java JDK 17** ou superior
- ✅ **Maven 3.6** ou superior
- ✅ **MySQL 8.0** ou superior
- ✅ **Git** (opcional)

### Verificar Instalação

```bash
# Verificar Java
java -version

# Verificar Maven
mvn -version

# Verificar MySQL
mysql --version
```

---

## ⚙️ Instalação e Configuração

### 1. Clonar o Repositório

```bash
git clone <seu-repositorio>
cd appointment-scheduling
```

### 2. Configurar o Banco de Dados

Abra o MySQL e crie a base de dados:

```sql
CREATE DATABASE `appointment-scheduling`;
USE `appointment-scheduling`;
```

### 3. Configurar Credentials (Opcional)

Edite o arquivo `src/main/resources/application.properties`:

```properties
# Configurações do Banco de Dados
spring.datasource.url=jdbc:mysql://localhost:3306/appointment-scheduling?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root

# Estratégia JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update

# Configurações da Aplicação
spring.application.name=appointment-scheduling
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

# URL Frontend
FRONTEND_API=http://localhost:5173/
```

### 4. Instalar Dependências

```bash
mvn clean install
```

---

## ▶️ Executando a Aplicação

### Usando Maven

```bash
mvn spring-boot:run
```

A aplicação estará disponível em: **http://localhost:8080**

### Usando Java Direto

```bash
mvn clean package
java -jar target/appointment-scheduling-0.0.1-SNAPSHOT.jar
```

### Health Check

Para verificar se a aplicação está rodando:

```bash
curl http://localhost:8080/actuator/health
```

---

## 📁 Estrutura do Projeto

```
appointment-scheduling/
├── src/
│   ├── main/
│   │   ├── java/com/othavio/appointment_scheduling/
│   │   │   ├── configurations/        # Configurações da aplicação
│   │   │   ├── controllers/           # REST Controllers
│   │   │   ├── dtos/                  # Data Transfer Objects
│   │   │   │   ├── appointment/
│   │   │   │   ├── pacient/
│   │   │   │   └── professional/
│   │   │   ├── exceptions/            # Tratamento de exceções
│   │   │   ├── model/                 # Entidades JPA
│   │   │   ├── repositories/          # Repositórios (Data Access)
│   │   │   ├── service/               # Lógica de negócio
│   │   │   └── AppointmentSchedulingApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/...                   # Testes unitários
├── pom.xml                            # Dependências Maven
└── README.md                          # Este arquivo
```

---

## 🔌 Endpoints da API

### Base URL
```
http://localhost:8080
```

---

### **Pacientes**

#### 1. Listar Todos os Pacientes
```http
GET /v1/pacients
```

**Resposta (200 OK):**
```json
[
  {
    "id": "550e8400-e29b-41d4-a716-446655440000",
    "name": "João Silva",
    "email": "joao@example.com",
    "phone": "119999999",
    "cpf": "12345678900"
  }
]
```

#### 2. Obter Paciente por ID
```http
GET /v1/pacients/{id}
```

**Parâmetro:**
- `id` (UUID) - ID do paciente

**Resposta (200 OK):**
```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "name": "João Silva",
  "email": "joao@example.com",
  "phone": "119999999",
  "cpf": "12345678900"
}
```

#### 3. Criar Novo Paciente
```http
POST /v1/pacients
```

**Body (JSON):**
```json
{
  "name": "Maria Santos",
  "email": "maria@example.com",
  "phone": "11987654321",
  "cpf": "98765432100"
}
```

**Resposta (201 CREATED):**
```json
{
  "id": "660e8400-e29b-41d4-a716-446655440001",
  "name": "Maria Santos",
  "email": "maria@example.com",
  "phone": "11987654321",
  "cpf": "98765432100"
}
```

#### 4. Deletar Paciente
```http
DELETE /v1/pacients/{id}
```

**Parâmetro:**
- `id` (UUID) - ID do paciente

**Resposta (200 OK):** Sem conteúdo

---

### **Profissionais de Saúde**

#### 1. Listar Todos os Profissionais
```http
GET /v1/health-professionals
```

**Resposta (200 OK):**
```json
[
  {
    "id": "770e8400-e29b-41d4-a716-446655440000",
    "name": "Dr. Carlos",
    "specialization": "Cardiologia",
    "cpf": "11111111100",
    "email": "carlos@hospital.com"
  }
]
```

#### 2. Buscar Profissional por CPF
```http
GET /v1/health-professionals/cpf?cpf=11111111100
```

**Parâmetro Query:**
- `cpf` (String) - CPF do profissional

**Resposta (200 OK):**
```json
{
  "id": "770e8400-e29b-41d4-a716-446655440000",
  "name": "Dr. Carlos",
  "specialization": "Cardiologia",
  "cpf": "11111111100",
  "email": "carlos@hospital.com"
}
```

#### 3. Criar Novo Profissional
```http
POST /v1/health-professionals
```

**Body (JSON):**
```json
{
  "name": "Dra. Ana",
  "specialization": "Oftalmologia",
  "cpf": "22222222200",
  "email": "ana@hospital.com"
}
```

**Resposta (201 CREATED):**
```json
{
  "id": "880e8400-e29b-41d4-a716-446655440000",
  "name": "Dra. Ana",
  "specialization": "Oftalmologia",
  "cpf": "22222222200",
  "email": "ana@hospital.com"
}
```

---

### **Slots de Agendamento**

#### 1. Obter Slot por ID
```http
GET /v1/appointment-slots/{id}
```

**Parâmetro:**
- `id` (UUID) - ID do slot

**Resposta (200 OK):**
```json
{
  "id": "990e8400-e29b-41d4-a716-446655440000",
  "healthProfessionalId": "770e8400-e29b-41d4-a716-446655440000",
  "startTime": "2024-06-15T10:00:00",
  "endTime": "2024-06-15T10:30:00",
  "isAvailable": true
}
```

#### 2. Listar Slots por Profissional
```http
GET /v1/appointment-slots/professional-id?id=770e8400-e29b-41d4-a716-446655440000
```

**Parâmetro Query:**
- `id` (UUID) - ID do profissional de saúde

**Resposta (200 OK):**
```json
[
  {
    "id": "990e8400-e29b-41d4-a716-446655440000",
    "healthProfessionalId": "770e8400-e29b-41d4-a716-446655440000",
    "startTime": "2024-06-15T10:00:00",
    "endTime": "2024-06-15T10:30:00",
    "isAvailable": true
  }
]
```

#### 3. Criar Novo Slot
```http
POST /v1/appointment-slots
```

**Body (JSON):**
```json
{
  "healthProfessionalId": "770e8400-e29b-41d4-a716-446655440000",
  "startTime": "2024-06-20T14:00:00",
  "endTime": "2024-06-20T14:30:00"
}
```

**Resposta (201 CREATED):**
```json
{
  "id": "aa0e8400-e29b-41d4-a716-446655440000",
  "healthProfessionalId": "770e8400-e29b-41d4-a716-446655440000",
  "startTime": "2024-06-20T14:00:00",
  "endTime": "2024-06-20T14:30:00",
  "isAvailable": true
}
```

#### 4. Deletar Slot
```http
DELETE /v1/appointment-slots/{id}
```

**Parâmetro:**
- `id` (UUID) - ID do slot

**Resposta (200 OK):** Sem conteúdo

---

### **Agendamentos**

#### 1. Agendar Consulta
```http
POST /v1/appointments
```

**Body (JSON):**
```json
{
  "pacientId": "550e8400-e29b-41d4-a716-446655440000",
  "appointmentSlotId": "990e8400-e29b-41d4-a716-446655440000"
}
```

**Resposta (201 CREATED):**
```json
{
  "id": "bb0e8400-e29b-41d4-a716-446655440000",
  "pacientId": "550e8400-e29b-41d4-a716-446655440000",
  "appointmentSlotId": "990e8400-e29b-41d4-a716-446655440000",
  "bookingDate": "2024-06-10T15:30:00"
}
```

---

## 📝 Exemplos de Requisições

### Usando cURL

#### 1. Criar um Paciente
```bash
curl -X POST http://localhost:8080/v1/pacients \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Pedro Oliveira",
    "email": "pedro@example.com",
    "phone": "11991234567",
    "cpf": "12345678901"
  }'
```

#### 2. Listar Profissionais
```bash
curl -X GET http://localhost:8080/v1/health-professionals
```

#### 3. Criar Slot de Agendamento
```bash
curl -X POST http://localhost:8080/v1/appointment-slots \
  -H "Content-Type: application/json" \
  -d '{
    "healthProfessionalId": "770e8400-e29b-41d4-a716-446655440000",
    "startTime": "2024-06-25T09:00:00",
    "endTime": "2024-06-25T09:30:00"
  }'
```

#### 4. Agendar Consulta
```bash
curl -X POST http://localhost:8080/v1/appointments \
  -H "Content-Type: application/json" \
  -d '{
    "pacientId": "550e8400-e29b-41d4-a716-446655440000",
    "appointmentSlotId": "990e8400-e29b-41d4-a716-446655440000"
  }'
```

### Usando Postman

1. Importe a coleção no Postman
2. Configure a variável `{{base_url}}` como `http://localhost:8080`
3. Utilize os exemplos acima adaptados para a interface do Postman

---

## ❌ Tratamento de Erros

A API retorna mensagens de erro padronizadas:

### Erro 400 - Requisição Inválida
```json
{
  "timestamp": "2024-06-10T15:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Dados de entrada inválidos"
}
```

### Erro 404 - Não Encontrado
```json
{
  "timestamp": "2024-06-10T15:30:00",
  "status": 404,
  "error": "Not Found",
  "message": "Paciente não encontrado"
}
```

### Erro 500 - Erro Interno
```json
{
  "timestamp": "2024-06-10T15:30:00",
  "status": 500,
  "error": "Internal Server Error",
  "message": "Erro ao processar a requisição"
}
```

### Erro 422 - UUID Inválida
```json
{
  "timestamp": "2024-06-10T15:30:00",
  "status": 422,
  "error": "Invalid UUID Format",
  "message": "O ID fornecido não está em um formato UUID válido"
}
```

---

## 🔄 Fluxo de Agendamento

```
1. Criar Paciente (POST /v1/pacients)
   ↓
2. Criar Profissional (POST /v1/health-professionals)
   ↓
3. Criar Slots de Agendamento (POST /v1/appointment-slots)
   ↓
4. Listar Slots Disponíveis (GET /v1/appointment-slots/professional-id)
   ↓
5. Agendar Consulta (POST /v1/appointments)
```

---

## 🛡️ Validação

A API valida automaticamente:

- ✅ Formato de UUID
- ✅ Campos obrigatórios
- ✅ Formato de email
- ✅ Comprimento de strings
- ✅ Valores booleanos

---

## 📊 Banco de Dados

### Tabelas Principais

- **pacients** - Informações dos pacientes
- **health_professionals** - Dados dos profissionais
- **appointment_slots** - Horários disponíveis
- **appointments** - Registros de agendamentos

As tabelas são criadas automaticamente via Hibernate DDL (update mode).

---

## 💡 Dicas Úteis

1. **Desenvolvimento**: Use `spring.jpa.show-sql=true` para ver as queries SQL
2. **Testes**: Inicie com a criação de um paciente e profissional
3. **Debugging**: Verifique os logs em `target/logs/` se disponível
4. **CORS**: Configure em `WebConfig.java` se precisar aceitar requisições de outros domínios

---

## 📄 Licença

Este projeto é fornecido como está, sem garantias.

---

## 👨‍💻 Autor

**Othavio**

---

## 📞 Suporte

Para dúvidas ou problemas, verifique:

1. Se o MySQL está rodando
2. Se as credenciais estão corretas em `application.properties`
3. Se a porta 8080 não está em uso
4. Logs da aplicação em caso de erros

---

**Última atualização**: Junho de 2024
