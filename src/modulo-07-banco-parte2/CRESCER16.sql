--Exercicio 01 - Liste os clientes e suas respectivas cidades. 

SELECT 
  Cli.IDCLIENTE, 
  Cli.NOME as NomeCliente, 
  Cid.NOME as NomeCidade, 
  Cid.UF
FROM Cliente Cli
JOIN Cidade Cid on Cli.IDCIDADE = Cid.IDCIDADE;


-- Exercicio 02 - Liste o total de pedidos realizados no mês de maio de 2016. 

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
  
  
-- Exercicio 04 - Crie (insira) um novo registro na tabela de Produto, com as seguintes informações: Nome: Galocha Maragato Preço de custo: 35.67 Preço de venda: 77.95 Situação: A  

CREATE SEQUENCE SQPRODUTO START WITH 8001;

INSERT INTO Produto 
  (IDPRODUTO, NOME, PRECOCUSTO, PRECOVENDA, SITUACAO) 
VALUES 
  (SQPRODUTO.NEXTVAL,'Galocha Maragato', 35.67, 77.95, 'A');
  
COMMIT;


-- Exercicio 05 - Identifique e liste os produtos que não tiveram nenhum pedido, considere os relacionamentos no modelo de dados, pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem). 

SELECT 
  NOME
FROM PRODUTO Pro
WHERE Pro.IDPRODUTO NOT IN (
  SELECT 
    pro.IDPRODUTO
  FROM PRODUTO pro
  JOIN PEDIDOITEM peit on peit.IDPRODUTO = pro.IDPRODUTO
);


-- Exercicio 06 - Liste todos os pedidos de um determinado cliente, considere que sempre que for executar esta consulta será informado o IDCliente como parâmetro. Deverão ser listados: Data do Pedido, Produto, Quantide, Valor Unitário, e valor total. 

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


-- Exercicio 07 - 
