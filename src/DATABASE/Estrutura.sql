/**
 * Author:  Patrick
 * Created: 08/10/2018
 */

DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
USE test;

CREATE TABLE filmes(
    id INT PRIMARY KEY AUTO_INCREMENT,
    filme VARCHAR (100),
    nome VARCHAR (100),
    diretor VARCHAR (100),
    atorPrincipal VARCHAR (100),
    categoria VARCHAR (100), 
    faixaEtaria VARCHAR (100), 
    idiomaOriginal VARCHAR (100),
    duracao INT,
    ano INT,
    legenda BOOLEAN,
    dublado BOOLEAN,
    orcamento DOUBLE, 
    faturamento DOUBLE
);




