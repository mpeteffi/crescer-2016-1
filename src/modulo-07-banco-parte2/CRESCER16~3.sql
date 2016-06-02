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
