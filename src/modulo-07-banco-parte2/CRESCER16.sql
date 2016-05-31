--Exercicio 01

SELECT 
  Cli.IDCLIENTE, 
  Cli.NOME as NomeCliente, 
  Cid.NOME as NomeCidade, 
  Cid.UF
FROM Cliente Cli
JOIN Cidade Cid on Cli.IDCIDADE = Cid.IDCIDADE;


-- Exercicio 02

SELECT
  COUNT(1)
FROM Pedido Ped
WHERE Ped.DATAPEDIDO between TO_DATE('01-05-2016') and TO_DATE('31-05-2016');


-- Exercicio 03

SELECT
  Cli.IDCLIENTE,
  Cli.NOME,
  Cli.RAZAOSOCIAL
FROM Cliente Cli
WHERE Cli.NOME like '%ltda%'
  or Cli.RAZAOSOCIAL like '%ltda%';
  
  
-- Exercicio 04

CREATE SEQUENCE SQPRODUTO START WITH 8001;

INSERT INTO Produto 
  (IDPRODUTO, NOME, PRECOCUSTO, PRECOVENDA, SITUACAO) 
VALUES 
  (SQPRODUTO.NEXTVAL,'Galocha Maragato', 35.67, 77.95, 'A');
  
COMMIT;