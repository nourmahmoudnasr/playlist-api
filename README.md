# Playlist API

A RESTful API for managing playlists and songs, built with Spring Boot and PostgreSQL.

## Prerequisites

Before running this project, make sure you have the following installed:

- **Java 17** — [Download here](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- **Maven** — comes bundled with the project (no installation needed)
- **PostgreSQL** — [Download here](https://www.postgresql.org/download/)

Make sure PostgreSQL is running before starting the application.

## Database Setup

**1. Open your PostgreSQL terminal (psql) and create the database:**

```sql
CREATE DATABASE playlistdb;
```

**2. Keep note of your PostgreSQL username and password** 

## Project Setup

**1. Clone the repository:**

```bash
git clone https://github.com/nourmahmoudnasr/playlist-api.git
cd playlist-api
```

**2. Configure the database connection:**

Open `src/main/resources/application.properties` and fill in your PostgreSQL credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/playlistdb
spring.datasource.username=YOUR_POSTGRES_USERNAME
spring.datasource.password=YOUR_POSTGRES_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false
```

## Running the Application

**On Mac/Linux:**
```bash
./mvnw spring-boot:run
```

**On Windows:**
```bash
mvnw.cmd spring-boot:run
```

The app will start on `http://localhost:8080`. The database tables will be created automatically on first run.

## API Endpoints

### Clients
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/clients` | Create a client |
| GET | `/clients/{id}` | Get a client by id |

### Songs
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/songs` | Create a song |
| GET | `/songs/{id}` | Get a song by id |
| DELETE | `/songs/{id}` | Delete a song |

### Playlists
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/playlists` | Create a playlist |
| GET | `/playlists/{id}` | Get a playlist by id |
| GET | `/playlists/client/{clientId}` | Get all playlists for a client |
| PUT | `/playlists/{id}` | Rename a playlist |
| DELETE | `/playlists/{id}` | Delete a playlist |
| POST | `/playlists/{playlistId}/songs/{songId}` | Add a song to a playlist |
| DELETE | `/playlists/{playlistId}/songs/{songId}` | Remove a song from a playlist |

## Example Usage

**Create a client:**
```bash
curl -X POST http://localhost:8080/clients -H "Content-Type: application/json" -d '{"username": "nour"}'
```

**Create a song:**
```bash
curl -X POST http://localhost:8080/songs -H "Content-Type: application/json" -d '{"title": "Blinding Lights", "artistName": "The Weeknd"}'
```

**Create a playlist:**
```bash
curl -X POST http://localhost:8080/playlists -H "Content-Type: application/json" -d '{"clientId": 1, "name": "Chill mix"}'
```

**Add a song to a playlist:**
```bash
curl -X POST http://localhost:8080/playlists/1/songs/1
```

**Get all playlists for a client:**
```bash
curl http://localhost:8080/playlists/client/1
```

## Technology Choices

**Spring Boot** — standard for building REST APIs in Java, handles dependency injection, request mapping, and database integration.

**PostgreSQL** — chosen for its reliability and strong support for relational data. The playlist domain has clear relationships between clients, playlists, and songs (many-to-many between playlists and songs), which maps naturally to a relational database. 

**Spring Data JPA with Hibernate** — handles table creation automatically via `ddl-auto=update`, and maps Java entities directly to database tables.
