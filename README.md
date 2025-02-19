# Catalogo de Filmes

## Descrição
Uma API GraphQL para gerenciar um catálogo de livros, desenvolvida com Spring Boot, MongoDB e GraphQL.

## Tecnologias
- Java 17
- Spring framework
- MongoDB
- GraphQL
- Lombok
- GraphiQL
- docker
- maven

## Diagrama de Classes (Domínio da API)
```mermaid
classDiagram
    class Autor {
        +String id
        +String nome
        +String nacionalidade
    }

    class Livro {
        +String id
        +String titulo
        +String genero
        +int anoPublicacao
        +Autor autor
    }

    class LivroService {
        +Livro addLivro(String titulo, String genero, int anoPublicacao, String autorId)
        +Livro updateLivro(String id, String titulo, String genero, int anoPublicacao, String autorId)
        +void deleteLivro(String id)
        +List<Livro> getLivros()
        +Livro getLivroById(String id)
    }

    class AutorService {
        +Autor addAutor(String nome, String nacionalidade)
        +Autor updateAutor(String id, String nome, String nacionalidade)
        +void deleteAutor(String id)
        +List<Autor> getAutores()
        +Autor getAutorById(String id)
    }

    class LivroController {
        +Livro addLivro(String titulo, String genero, int anoPublicacao, String autorId)
        +Livro updateLivro(String id, String titulo, String genero, int anoPublicacao, String autorId)
        +void deleteLivro(String id)
        +List<Livro> getLivros()
        +Livro getLivroById(String id)
    }

    class AutorController {
        +Autor addAutor(String nome, String nacionalidade)
        +Autor updateAutor(String id, String nome, String nacionalidade)
        +void deleteAutor(String id)
        +List<Autor> getAutores()
        +Autor getAutorById(String id)
    }

    class Repository {
        <<interface>>
    }

    class LivroRepository {
        +save(Livro livro)
        +findById(String id) : Optional<Livro>
        +findAll() : List<Livro>
        +deleteById(String id)
    }

    class AutorRepository {
        +save(Autor autor)
        +findById(String id) : Optional<Autor>
        +findAll() : List<Autor>
        +deleteById(String id)
    }

     Autor "1" --> "*" Livro : escreve
    Livro --|> Repository
    Autor --|> Repository
    LivroService --> LivroRepository
    AutorService --> AutorRepository
    LivroController --> LivroService
    AutorController --> AutorService


```

## Testes
Se ainda não subiu o MongoDB, rode:
```bash
docker-compose up -d
```
Para conferir se o container está rodando:
```bash
docker ps
```
Agora, basta rodar:
```bash
mvn spring-boot:run
```
Agora para testar a aplicação acesse: 
```bash
http://localhost:8080/graphiql
```


## Contribuição

Contribuições são bem-vindas! Siga os passos abaixo:

1. Fork o repositório.
2. Crie uma nova branch (git checkout -b feature/nova-feature).
3. Commit suas alterações (git commit -m 'Adiciona nova feature').
4. Push para a branch (git push origin feature/nova-feature).
5. Abra um Pull Request.
