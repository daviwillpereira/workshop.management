<h1 align="center">Shoe Workshop App</h1>

<br> 

<h3>Back-end Dependencies:</h3>
<ul>
  <li>spring-boot-starter-data-jpa</li>
  <li>spring-boot-starter-security</li>
  <li>spring-boot-starter-web</li>
  <li>spring-boot-starter-test</li>
  <li>spring-boot-devtools</li>
  <li>postgresql</li>
</ul>

<br>

<h3>Currently Features:</h3>
<ul>
  <li>Spring Security:</li>
  <ul>
	  <li>UserDetails with SimpleGrantedAuthority authorization</li>
	  <li>JSON Web Token (JWT) authentication with token confirmation via email</li>
	  <li>DaoAuthenticationProvider Bean encompassing a bCryptPasswordEncoder and a UserDetailsService</li>
	  <li>Roles Levels: ADMIN, USER</li>
  </ul>
  <li>Spring Data JPA:</li>
  <ul>
	  <li>Entities Mapping (AppUser, ConfirmationToken)</li>
	  <li>PostGreSQL DB Connection</li>
	  <li>Sequence Ids Generators</li>
  </ul>
</ul>

<br>
<br>

<h1>The REST endpoints are described below.</h1>
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
