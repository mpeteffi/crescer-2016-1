-- Exercicio 01 - Fa�a um bloco PL/SQL que receba UM par�metro (em tempo de execu��o apenas): IDCliente, e ent�o pesquise nome do cliente e cidade (caso tenha), e outras informa��es referente a pedidos: o  Data da primeira compra (pedido) realizado; o  Data da �ltima compra realizada. o  Valor total dos pedidos, quantidade de pedidos e m�dia de valor dos pedidos

DECLARE 
vIdCliente number; 
vNomeCliente varchar2(100);
vNomeCidade varchar2(100);
vDataPrimeiro date;
vDataUltimo date;
vValorTotalPedidos number;

BEGIN 
  Select 
    Cli.Nome,
    Cid.Nome,
    min(Ped.DATAPEDIDO),
    max(Ped.DATAPEDIDO),
    sum(Ped.VALORPEDIDO)
  Into
    vNomeCliente,
    vNomeCidade,
    vDataPrimeiro,
    vDataUltimo,
    vValorTotalPedidos
  From   Cliente Cli
  Inner Join CIDADE Cid on Cli.IdCidade = Cid.IdCidade
  Inner Join PEDIDO Ped on Cli.IdCliente = Ped.IdCliente
  Where Cli.IDCliente = :pvIdCliente
  Group by Cli.Nome, Cid.Nome;
  
  DBMS_OUTPUT.PUT_LINE('Nome do Cliente: ' || vNomeCliente);
  DBMS_OUTPUT.PUT_LINE('Nome da Cidade: ' || vNomeCidade);
  DBMS_OUTPUT.PUT_LINE('Data Primeiro Pedido: ' || vDataPrimeiro);
  DBMS_OUTPUT.PUT_LINE('Data Ultimo Pedido: ' || vDataUltimo);
  DBMS_OUTPUT.PUT_LINE('Valor Total dos Pedidos: ' || vValorTotalPedidos);
end;


-- Exercicio 02 - Fa�a um bloco PL/SQL que receba DOIS par�metros (em tempo de execu��o apenas): nome e uf, verifique se j� existe um registro em Cidade para a combina��o, caso n�o exista fa�a um INSERT na tabela de Cidade.

DECLARE
  vNomeCidade varchar2;
  vUF varchar2(2);
  vQuantidade number;
  
BEGIN
  Select
    Count(1)
  Into vQuantidade
  From Cidade
  Where NOME = :pvNomeCidade
    and UF = :pvUF;
    
  if (vQuantidade = 0) then 
    Insert into Cidade (NOME, UF) Values (vNomeCidade, vUf);
  else 
    DBMS_OUTPUT.PUT_LINE('Cidade e UF j� existem.'); 
  End if;
End;