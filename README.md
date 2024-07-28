<p align="center">
<a href="https://www.linkedin.com/in/soriamaximilianorodrigo/" target="_blank" rel="noopener noreferrer">
<img width="100%" height="100%" src="docs/img/banner.gif" alt="Linkedin"></a></p>


<p align="center">
  <a href="#"><img src="https://img.shields.io/badge/Spring_Boot-3.2.2-brightgreen" alt="Spring Boot"></a>
  <a href="#"><img src="https://img.shields.io/badge/chat-on%20Discord-7289da.svg?sanitize=true" alt="Chat"></a>
  <a href="#"><img src="https://img.shields.io/badge/Java-17-orange" alt="Chat"></a>
</p>

<br>
<br>
<p align="center">



## 🚀 Introduction

This is an application made with Spring boot and Maven.
This is used to execute a CRUD of candidates.

## 🔨 Build and Run

## Prerequisites

Ensure you have the following installed on your system:

- Java Development Kit (JDK 17)
- Maven


## Steps


### 1. Run docker compose

Run docker compose to start the external microservice that provides the candidate categories:

```bash
docker-compose up
```


### 2. Clone the Repository

Clone your Spring Boot API repository to your local machine:

```bash
git clone https://github.com/MaximilianoRodrigoSoria/candidate-api.git
```
```
cd candidate-api
```

### 3. Build the Project

Navigate to the root directory of your project and execute the following Maven command to build the project:
```
./mvnw clean install
```

### 4. Run the Application
Once the build is successful, you can run your Spring Boot application using the following command:
```
./mvnw spring-boot:run
```

### 5. Access the API
Your Spring Boot API should now be accessible at the default port 8080. Open your web browser or a tool like Postman and access the following URL:

> http://localhost:8080/candidate-api/swagger-ui.html

## Postman Collection

You can use the following Postman collection to test the API:

<a href="docs/postman/Candidate%20API.postman_collection.json" target="_blank" rel="noopener noreferrer">
<img width="auto" height="auto" src="docs/img/postman-button.png" alt="Linkedin"></a></p>


## 📚 Get the Token


1. Enter the endpoint authorization server:
>http://localhost:8080/candidate-api/.well-known/oauth-authorization-server

Copy authorization_endpoint


```JSON
{
"issuer": "http://localhost:8080/candidate-api",
"authorization_endpoint": "http://localhost:8080/candidate-api/oauth2/authorize",
"token_endpoint": "http://localhost:8080/candidate-api/oauth2/token",
"token_endpoint_auth_methods_supported": [
"client_secret_basic",
"client_secret_post",
"client_secret_jwt",
"private_key_jwt"
],
"jwks_uri": "http://localhost:8080/candidate-api/oauth2/jwks",
"response_types_supported": [
"code"
],
"grant_types_supported": [
"authorization_code",
"client_credentials",
"refresh_token"
],
"revocation_endpoint": "http://localhost:8080/candidate-api/oauth2/revoke",
"revocation_endpoint_auth_methods_supported": [
"client_secret_basic",
"client_secret_post",
"client_secret_jwt",
"private_key_jwt"
],
"introspection_endpoint": "http://localhost:8080/candidate-api/oauth2/introspect",
"introspection_endpoint_auth_methods_supported": [
"client_secret_basic",
"client_secret_post",
"client_secret_jwt",
"private_key_jwt"
],
"code_challenge_methods_supported": [
"S256"
]
}
```


2. Debugger authorization server:
>https://oauthdebugger.com/debug

| Key                          | Value                                           |
|------------------------------|-------------------------------------------------|
| app.client.id                | client                                          |
| app.client.secret            | secret                                          |
| app.client.scope.read        | read                                            |
| app.client.scope.write       | write                                           |
| app.client.redirect.debugger | https://oauthdebugger.com/debug                 |
| app.client.redirect.spring.doc | https://springone.io/authorized               |


The following configuration must be respected when changing the scope

![01.png](docs%2Fimg%2F01.png)

Then the form information will be sent with the send button

![02.png](docs%2Fimg%2F02.png)

Username and password are requested

List users

| Username           | Password Not Encrypted |
|--------------------|------------------------|
| read_laboratory    | readonly               |
| admin_laboratory   | admin                  |
| write_laboratory   | writeonly              |


![03.png](docs%2Fimg%2F03.png)

3. Get Grant token

![04.png](docs%2Fimg%2F04.png)


4. Use the token to access the API

```bash
curl --location 'http://localhost:8080/candidate-api/oauth2/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Authorization: Basic Y2xpZW50OnNlY3JldA==' \
--header 'Cookie: JSESSIONID=8F3C03E633204CAA6ED7400E13A8C0D1; JSESSIONID=C3DE96EB791B37D99867D7BB692E5B07' \
--data-urlencode 'redirect_uri=https://oauthdebugger.com/debug' \
--data-urlencode 'grant_type=authorization_code' \
--data-urlencode 'code=pDfLBO-aj7k6Tm5qVpxYYQ6FhjSlNQMGoShVpLH7FLISBZmX7glH9yAb4WtgWxCQCWWkklQM-3pcJ0k5Ga06kuANlRxVNSdFCrjagsx2cFejAB_AsQgsz6V7oPV_oMzL'
```
5. Use basic authentication to access the API

> Username: client
> 
> Password: secret


![05.png](docs%2Fimg%2F05.png)

Copy token

![06.png](docs%2Fimg%2F06.png)

Execute endpoints, use toke a barer token

![07.png](docs%2Fimg%2F07.png)




---
<br/>

### ⭐ Autor
<br>

> ‍💻 **Name:** Maximiliano Rodrigo Soria
>
> 📧 **Email:** MaximilianoRodrigoSoria@gmail.com
>
> 🏠 **From:** Florencio Varela, Alpino
>
> 💼 **Linkedin:** [SoriaMaximilianoRodrigo](https://www.linkedin.com/in/soriamaximilianorodrigo/)
>
> 💬 **Chat:**  [Inicia un chat](https://wa.me/1127043256)
>
> 📝 **CV:** [Link](https://www.canva.com/design/DAFxIt0xaNQ/tKTSodPQyHett1abRieMyw/view?utm_content=DAFxIt0xaNQ&utm_campaign=designshare&utm_medium=link&utm_source=publishsharelink)