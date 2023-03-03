## Annotations Kotlin Spring Boot

Repositório com exemplos de como utilizar as anotações do Spring Boot com Kotlin. Ele foi criado como material para o
artigo [Como criar e usar Annotations em Kotlin no Spring Framework]()

### Tecnologias

- Kotlin
- Spring Boot
- Maven

### Como executar

- Clone o repositório

- Execute o comando abaixo para gerar o pacote do projeto

```bash
mvn clean package
```

- Execute o comando abaixo para executar o projeto

```bash
mvn spring-boot:run
```

### Testando a aplicação

Quando realizamos uma chamada na API com um gênero inválido o retorno será 422 Unprocessable Entity.

``` bash
# Request
curl --location 'http://localhost:8080/book' \
--header 'Content-Type: application/json' \
--data '{
    "title": "Sapiens: Uma breve história da humanidade",
    "description": "O planeta Terra tem cerca de 4,5 bilhões de anos. Numa fração ínfima desse tempo, uma espécie entre incontáveis outras o dominou: nós, humanos.",
    "number": 1,
    "genre": "INVALID_BOOK"
}'

# Response
{
    "code": 422,
    "details": [
        "O gênero do livro é inválido"
    ]
}
```

Também podemos retornar uma lista com diversos erros, como por exemplo, quando o título do livro é nulo e o gênero é
inválido

``` bash
# Request
curl --location 'http://localhost:8080/book' \
--header 'Content-Type: application/json' \
--data '{
    "title": null,
    "description": "O planeta Terra tem cerca de 4,5 bilhões de anos. Numa fração ínfima desse tempo, uma espécie entre incontáveis outras o dominou: nós, humanos.",
    "number": 1,
    "genre": "INVALID_BOOK"
}'
# Response
{
    "code": 422,
    "details": [
        "Título não deve estar vazio",
        "O gênero do livro é inválido",
        "Descrição não deve estar vazia"
    ]
}
```

---
Desenvolvido por [Jean Jacques Barros](https://github.com/jjeanjacques10)
