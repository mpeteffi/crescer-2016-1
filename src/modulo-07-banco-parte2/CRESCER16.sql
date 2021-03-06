--Exercicio 01 - Liste os clientes e suas respectivas cidades. 

SELECT 
  Cli.IDCLIENTE, 
  Cli.NOME as NomeCliente, 
  Cid.NOME as NomeCidade, 
  Cid.UF
FROM Cliente Cli
JOIN Cidade Cid on Cli.IDCIDADE = Cid.IDCIDADE;


-- Exercicio 02 - Liste o total de pedidos realizados no m�s de maio de 2016. 

SELECT
  COUNT(1)
FROM Pedido Ped
WHERE Ped.DATAPEDIDO between TO_DATE('01-05-2016') and TO_DATE('31-05-2016');


-- Exercicio 03 - Liste todos os clientes que tenham o LTDA no nome ou razao social.

SELECT
  Cli.IDCLIENTE,
  Cli.NOME,
  Cli.RAZAOSOCIAL
FROM Cliente Cli
WHERE Cli.NOME like '%ltda%'
  or Cli.RAZAOSOCIAL like '%ltda%';
  
  
-- Exercicio 04 - Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es: Nome: Galocha Maragato Pre�o de custo: 35.67 Pre�o de venda: 77.95 Situa��o: A  

CREATE SEQUENCE SQPRODUTO START WITH 8001;

INSERT INTO Produto 
  (IDPRODUTO, NOME, PRECOCUSTO, PRECOVENDA, SITUACAO) 
VALUES 
  (SQPRODUTO.NEXTVAL,'Galocha Maragato', 35.67, 77.95, 'A');
  
COMMIT;


-- Exercicio 05 - Identifique e liste os produtos que n�o tiveram nenhum pedido, considere os relacionamentos no modelo de dados, pois n�o h� relacionamento direto entre Produto e Pedido (ser� preciso relacionar PedidoItem). 

SELECT 
  NOME
FROM PRODUTO Pro
WHERE Pro.IDPRODUTO NOT IN (
  SELECT 
    pro.IDPRODUTO
  FROM PRODUTO pro
  JOIN PEDIDOITEM peit on peit.IDPRODUTO = pro.IDPRODUTO
);


-- Exercicio 06 - Liste todos os pedidos de um determinado cliente, considere que sempre que for executar esta consulta ser� informado o IDCliente como par�metro. Dever�o ser listados: Data do Pedido, Produto, Quantide, Valor Unit�rio, e valor total. 

SELECT 
  Ped.DATAPEDIDO, 
  Pro.NOME, 
  Peit.QUANTIDADE, 
  Pro.PRECOVENDA as Valor_Unitario, 
  Ped.VALORPEDIDO as Valor_Total
FROM CLIENTE Cli
INNER JOIN PEDIDO Ped on Cli.IDCLIENTE = Ped.IDCLIENTE
INNER JOIN PEDIDOITEM Peit on ped.IDPEDIDO = Peit.IDPEDIDO
INNER JOIN PRODUTO Pro on peit.IDPRODUTO = Pro.IDPRODUTO
WHERE Cli.IDCLIENTE = :pIDCLIENTE;


-- Exercicio 07 - Fa�a uma consulta que receba um par�metro sendo o IDProduto e liste a quantidade de itens na tabela PedidoItem com este IDProduto foram vendidos no �ltimo ano (desde janeiro/2016). 

SELECT 
  sum(quantidade)
FROM PedidoItem Peit
INNER JOIN Pedido Ped on Ped.IDPEDIDO = Peit.IDPEDIDO
WHERE Peit.IDPRODUTO = :pIDPRODUTO
and Ped.DATAPEDIDO >= to_date('01/2016', 'mm/yyyy');


-- Exercicio 08 - Utilizando de fun��es de agrupamento (aggregation function), fa�a uma consulta que liste agrupando por ano e m�s a quantidade de pedidos comprados, a quantidade de produtos distintos comprados, o valor total dos pedidos, o menor valor de um pedido, o maior valor de um pedido e valor m�dio de um pedido. 

SELECT
  TO_CHAR(ped.DATAPEDIDO, 'mm/yyyy') ANO_MES,
  COUNT(distinct item.IDPRODUTO) as Distintos,
  SUM(ped.VALORPEDIDO) as Valor_Pedido,
  MIN(ped.VALORPEDIDO) as MIN_Pedido,
  MAX(ped.VALORPEDIDO) as MAX_Pedido,
  round(AVG(ped.VALORPEDIDO),2) as MEDIA_Pedido,
  COUNT(distinct ped.IDPEDIDO) as Total_Pedidos
FROM PEDIDO ped
INNER JOIN PEDIDOITEM item on item.IDPEDIDO = ped.IDPEDIDO
GROUP BY TO_CHAR(ped.DATAPEDIDO, 'mm/yyyy');
  