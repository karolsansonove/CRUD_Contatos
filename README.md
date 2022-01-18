## Aplicação CRUD Java - Contatos

#### Manipulação dos seguintes dados:

* Id
* Nome
* Telefone
* Data de cadastro



#### Tecnologias utilizadas:

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

