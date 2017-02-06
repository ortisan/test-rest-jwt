# Project

###Criar usuário:

Post para http://localhost:8080/teste-jpa-1.0/api/user

```json
{
  "name":"Marcelo Ortiz de Santana",
  "username":"marcelo",
  "password": "123456"
}

```

###Login:

Post para http://localhost:8080/teste-jpa-1.0/api/login

```json
{
  "username":"marcelo",
  "password": "123456"
}

```

Copiar o autorization

## Listar os usuários para teste de token

Copiar o Header Authorization do rest anterior e enviar no header Autorization do request:

http://localhost:8080/teste-jpa-1.0/api/user


### Migrate DB

```
mvn flyway:migrate
```