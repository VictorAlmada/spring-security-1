# 🔐 Projeto Spring Security - Estudo

Este é um projeto Java com Spring Boot criado para fins **educacionais**, com o objetivo de praticar e entender os conceitos básicos do **Spring Security**.

## 🛠 Tecnologias Utilizadas

- Java 21  
- Spring Boot 3.4.5  
- Spring Security  
- Spring Data JPA  
- Banco de dados H2 (em memória)  
- Lombok  
- Maven  

## 🔐 Funcionalidades de Segurança

- Autenticação com **Basic Auth** e **Form Login personalizado**  
- Usuários em memória (`user`, `admin`) com roles distintas  
- Proteção de rotas com base nas roles:  
  - `/user` acessível apenas por usuários com role `USER`  
  - `/admin` acessível apenas por usuários com role `ADMIN`  
- Console H2 liberado para testes

## 👤 Usuários de Teste

| Usuário | Senha     | Role  |
|--------|-----------|--------|
| user   | 123456    | USER   |
| admin  | admin123  | ADMIN  |

## 🚧 Objetivo
Este projeto foi desenvolvido como parte da minha jornada de estudos em Java com Spring.
Ele não possui finalidade comercial ou de produção.
