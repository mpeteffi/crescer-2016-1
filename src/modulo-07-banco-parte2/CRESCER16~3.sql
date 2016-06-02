-- Exercicio 01 - Crie um procedimento que receba por parâmetro o IDPedido e atualize o valor do pedido conforme seus itens.

CREATE OR REPLACE PROCEDURE ATUALIZARPEDIDO(vIDPedido in PEDIDO.IdPedido%Type) As
  vValorPedido PEDIDO.ValorPedido%TYPE;

BEGIN
  SELECT 
    sum(Quantidade * PrecoUnitario) 
  INTO vValorPedido 
  FROM PEDIDOITEM 
  WHERE IDPEDIDO = vIDPedido;
  
  UPDATE PEDIDO 
  SET VALORPEDIDO = vValorPedido 
  WHERE IDPEDIDO = vIDPedido;
  DBMS_OUTPUT.PUT_LINE('Pedido atualizado com sucesso!');  
END;

-- Testar exercicio 1
exec ATUALIZARPEDIDO(&pIdPedido);
Select * From Pedido Where IDPEDIDO = &pIdPedido;


-- Exercicio 02 - Crie uma função que receba por parâmetro o IDCliente e retorne a data do último pedido realizado pelo cliente. 

CREATE OR REPLACE FUNCTION ULTIMOPEDIDO 
  (pIdCliente in PEDIDO.IdCliente%Type) 
RETURN PEDIDO.DataPedido%Type AS
vDataUltimoPedido PEDIDO.DataPedido%Type;

BEGIN
    Select max(DataPedido)
    Into vDataUltimoPedido
    From Pedido
    Where IdCliente = pIdCliente;
    
    Return vDataUltimoPedido;
END;

-- Testar exercicio 2
select ULTIMOPEDIDO(&IdCliente) from dual;