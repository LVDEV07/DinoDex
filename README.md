# DinoDex

API REST em **Java + Spring Boot** para consulta de informações sobre dinossauros: nome, descrição, era, dieta, família, medidas e imagem. Pode ser usada como backend de uma enciclopédia/"Pokédex" de dinossauros.

> Projeto **Informassauro** (`com.informassauro`).

---

## Funcionalidades

- Listar todos os dinossauros cadastrados
- Buscar um dinossauro pelo ID
- Filtrar por dieta: carnívoros, herbívoros e onívoros
- Documentação interativa dos endpoints com Swagger UI (OpenAPI)
- CORS liberado para o front-end em `http://localhost:8081`

## Tecnologias

| Tecnologia | Uso |
|---|---|
| Java 21 | Linguagem |
| Spring Boot 4.0.8 | Framework principal |
| Spring Web MVC | Camada REST |
| Spring Data JPA | Persistência / ORM |
| MySQL | Banco de dados |
| springdoc-openapi 3.1.0 | Swagger UI |
| Lombok | Redução de boilerplate |
| Maven Wrapper | Build |

## Arquitetura

O projeto segue uma arquitetura em camadas:

```
src/main/java/com/informassauro/
├── InformassauroApiApplication.java   # Classe principal
├── controller/
│   └── DinossauroController.java      # Endpoints REST
├── service/
│   └── DinossauroService.java         # Regras de negócio
├── repository/
│   └── DinossauroRepository.java      # Acesso ao banco (JPA)
└── model/
    └── Dinossauro.java                # Entidade
```

## Modelo de dados

Entidade `Dinossauro`:

| Campo | Tipo | Descrição |
|---|---|---|
| `id` | Long | Identificador (auto incremento) |
| `urlImagem` | String | URL da imagem do dinossauro |
| `nome` | String | Nome |
| `descricao` | String | Descrição |
| `era` | String | Período em que viveu |
| `genero` | String | Gênero |
| `comprimento` | Double | Comprimento |
| `dieta` | String | `Carnívoro`, `Herbívoro` ou `Onívoro` |
| `familia` | String | Família |
| `altura` | Double | Altura |
| `peso` | String | Peso |

## Endpoints

| Método | Rota | Descrição |
|---|---|---|
| GET | `/dinossauros` | Lista todos os dinossauros |
| GET | `/dinossauro/{id}` | Retorna um dinossauro pelo ID |
| GET | `/carnivoros` | Lista os dinossauros carnívoros |
| GET | `/herbivoros` | Lista os dinossauros herbívoros |
| GET | `/onivoros` | Lista os dinossauros onívoros |

### Exemplo

```bash
curl http://localhost:8080/dinossauro/1
```

```json
{
  "id": 1,
  "urlImagem": "https://exemplo.com/trex.jpg",
  "nome": "Tyrannosaurus rex",
  "descricao": "Um dos maiores predadores terrestres que já existiram.",
  "era": "Cretáceo",
  "genero": "Tyrannosaurus",
  "comprimento": 12.3,
  "dieta": "Carnívoro",
  "familia": "Tyrannosauridae",
  "altura": 4.0,
  "peso": "8 toneladas"
}
```

> Os filtros de dieta comparam o texto exato (`Carnívoro`, `Herbívoro`, `Onívoro`, com acento), então os dados devem ser cadastrados com essa grafia.

## Pré-requisitos

- [JDK 21](https://adoptium.net/)
- [MySQL](https://dev.mysql.com/downloads/) rodando em `localhost:3306`
- Git

O Maven não precisa estar instalado, pois o projeto usa o Maven Wrapper.

## Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/LVDEV07/DinoDex.git
cd DinoDex
```

### 2. Configure o banco

As configurações ficam em `src/main/resources/application.yaml`:

```yaml
spring:
  application:
    name: Informassauro-API
  datasource:
    username: root
    password: root
    url: jdbc:mysql://localhost:3306/dinossauros?createDatabaseIfNotExist=true
```

O banco `dinossauros` é criado automaticamente e as tabelas são geradas pelo Hibernate (`ddl-auto: update`). Altere `username` e `password` conforme o seu MySQL.

### 3. Popule o banco

A API possui apenas endpoints de consulta, então os dinossauros precisam ser inseridos direto no banco:

```sql
INSERT INTO dinossauro
  (url_imagem, nome, descricao, era, genero, comprimento, dieta, familia, altura, peso)
VALUES
  ('https://exemplo.com/trex.jpg', 'Tyrannosaurus rex',
   'Um dos maiores predadores terrestres que já existiram.',
   'Cretáceo', 'Tyrannosaurus', 12.3, 'Carnívoro', 'Tyrannosauridae', 4.0, '8 toneladas');
```

## Documentação (Swagger)

Com a aplicação rodando, acesse:

```
http://localhost:8080/swagger-ui/index.html
```