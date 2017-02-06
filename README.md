# test-rest-jwt

Projeto para testes JaxRs e Jwt

###Criar usuário:

Post para http://localhost:8080/teste-jpa-1.0/api/user

```sh
curl --request POST \
  --url http://localhost:8080/teste-jpa-1.0/api/user \
  --header 'content-type: application/json' \
  --data '{"name":"Marcelo Ortiz de Santana",\n"username":"marcelo",\n"password": "123456"}'

```

###Login:

Post para http://localhost:8080/teste-jpa-1.0/api/login

```sh
curl --request POST \
  --url http://localhost:8080/teste-jpa-1.0/api/login \
  --header 'content-type: application/json' \
  --data '{"username":"marcelo","password": "123456"}'  
  
```

### Teste de token

Copiar o Header Authorization do rest anterior e enviar no header Autorization do request:

Get para http://localhost:8080/teste-jpa-1.0/api/user

```sh
curl --request GET \
  --url http://localhost:8080/teste-jpa-1.0/api/user \
  --header 'authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMSIsInVzZXJuYW1lIjoibWFyY2VsbyJ9.XAVosyc3voE1KK5Tzs0rgogY0bEVFaj17EUEDcJqGgU'
```

## Migrar BD

```
mvn flyway:migrate
```