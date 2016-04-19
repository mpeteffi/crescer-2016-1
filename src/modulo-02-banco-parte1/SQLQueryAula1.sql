BEGIN TRANSACTION 
GO

/*exercicio 1*/

INSERT INTO ASSOCIADO
(IDAssociado, Nome, DataNascimento, Sexo, CPF)
VALUES
(3,'Julio de Castilhos', convert(datetime, '14/12/1947', 103), 'M', 21234567895),
(4,'Antonio Augusto Borges de Medeiros', convert(datetime, '19/03/1942', 103), 'M', 81234567891),
(5,'Osvaldo Aranha', convert(datetime, '08/02/1958', 103), 'M', 01234567893);

SELECT * FROM Associado

/*exercicio 2*/

SELECT *
INTO CidadeAux
FROM Cidade;

SELECT * FROM CidadeAux

/*exercicio 3*/

Truncate table CidadeAux;

INSERT 
INTO CidadeAux
SELECT * from Cidade

/*exercicio 4*/

CREATE TABLE PRODUTOS
(IDProduto int NOT NULL,
 NomeCurto varchar(20) NOT NULL, 
 NomeDescritivo varchar(70) NOT NULL, 
 DataDeCriacao datetime NOT NULL, 
 LocalNoEstoque varchar(25) NOT NULL, 
 Quantidade int NOT NULL, 
 Preco smallmoney NOT NULL,
	CONSTRAINT PK_Produto PRIMARY KEY (IDProduto)
 );

SELECT * FROM PRODUTOS

/*exercicio 5*/

INSERT INTO PRODUTOS
	(IDProduto, NomeCurto, NomeDescritivo, DataDeCriacao, LocalNoEstoque, Quantidade, Preco)
	VALUES
	(1, 'Martelo', 'Martelo com cabo de madeira', convert(datetime, '19/04/2016', 103), 'Armário', 1, 29.90),
	(2, 'Parafuso', 'Parafuso M8 em cobre', convert(datetime, '18/04/2016', 103), 'Gaveta', 1, 1.90);



COMMIT

ROLLBACK

