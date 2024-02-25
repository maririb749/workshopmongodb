<h1 align="center"> WorkshopmongoDB </h1>

<p align= "center">
    <img src="https://img.shields.io/badge/Spring_BootV3.2.2-F2F4F9?style=for-the-badge&logo=spring-boot"  style="height:  30px;"/>
   <img src="https://img.shields.io/badge/-Java-blue.svg?logo=java&style=plastic" style="height:  30px;">
    <img src="https://img.shields.io/badge/-Mongodb-47A248.svg?logo=mongodb&style=plastic" style="height:  30px;">
   <img src="https://img.shields.io/badge/-Postman-FF6C37.svg?logo=postman&style=plastic&height=40px"  style="height:  30px;">
   <img src="https://img.shields.io/badge/-Docker-1488C6.svg?logo=docker&style=plastic" style="height:  30px;">

</p>   

###

## Sobre o projeto

###

Esse é o projeto DsPosts, a qual é uma mine rede social com usuários e posts.

###

## Modelo Conceitual

![mr](https://github.com/maririb749/workshopmongodb/assets/85500087/634f2553-1532-4580-9095-04f8b0ff0d6e)

###

<div align= "justify">
   Na entidade user terão as referências para a entidade post, pois na entidade user não há entidade agregada.
A entidade, post, terá seus próprios atributos. E como a entidade post é agregada da entidade comment também terá os atributos do comments e também os atributos do author, pois também é agregada da entidade user.
A entidade comment também terá os atributos do author, pois também é agregada da entidade user.
Como resultado, teremos um objeto composto no banco de dados.


</div> 

###

![ob](https://github.com/maririb749/workshopmongodb/assets/85500087/a90815a1-99d2-423f-90b1-6f6d6c985ada)

###

## Tecnologias e ferramentas utilizadas;
###
## Backend
- Java 17
- Spring Boot
- Maven
- MongoDb
- Postman
- Docker( instalei o servidor do MongoDB via container Docker)
  
  







