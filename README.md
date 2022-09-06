<h1 align="center">Shoe Workshop App</h1>

<br> 

<h3>Back-end Dependencies:</h3>

## spring-boot-starter-data-jpa
## spring-boot-starter-security
## spring-boot-starter-web
## spring-boot-starter-mail
## spring-boot-starter-test
## spring-boot-devtools
## postgresql

<br>

<h3>Currently Features:</h3>

## Spring Security:
### UserDetails with SimpleGrantedAuthority authorization
### JSON Web Token (JWT) authentication with token confirmation via email
### DaoAuthenticationProvider Bean encompassing a bCryptPasswordEncoder and a UserDetailsService
### Roles Levels: ADMIN, USER

## Spring Data JPA
### Entities Mapping (AppUser, ConfirmationToken)
### PostGreSQL DB Connection
### Sequence Ids Generators  
### 
<br>

<h3>The REST endpoints are described below.</h3>

## SignUpController
### POST - register new user and send confirmation email

`Request: POST api/v1/signup/`

`Response: HTTP/1.1 201 Created`

```
	6e0bf739-f987-4ed4-9400-23762ff0802f
```

### PATCH - confirm a token and enable the associated user

`Request: PATCH /api/v1/signup/confirm?token=6e0bf739-f987-4ed4-9400-23762ff0802f`

```
	confirmed
```

`Response: HTTP/1.1 200`
