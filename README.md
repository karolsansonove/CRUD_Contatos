## Aplicação CRUD com Java

#### Manipulação de contatos através dos seguintes dados:

* Id
* Nome
* Telefone
* Data de cadastro



#### :woman_technologist: Tecnologias e linguagens utilizadas:

:coffee: Java

:game_die: MySQL

:m: Maven

:cd: Driver JDBC



#### Estrutura no banco de dados:

~~~sql
CREATE DATABASE Agenda;

USE Agenda;

CREATE TABLE Contato(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(50),
	telefone CHAR(11),
	dataCadastro DATE
);
~~~

