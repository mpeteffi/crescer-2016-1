--exercicio 1

Select 
	Substring(Nome,0, Charindex(' ',Nome) ) as PrimeiroNome
From Associado

--exercicio 2

Select Nome,
	   Datediff(Year,DataNascimento,Getdate()) as Idade
From Associado

--exercicio 3

Select NomeEmpregado,
	   Datediff(Month,DataAdmissao,convert(datetime,'31/12/2000', 103)) as MesesDeTrabalho
From empregado
Where DataAdmissao between convert(datetime, '01/05/1980', 103) and convert(datetime,'20/01/1982', 103)

--exercicio 4

Select TOP(1)
	Cargo,
	count(1) as cont
From Empregado
group by Cargo
Order by cont DESC

--exercicio 6

Select Nome,
	   Dateadd(Year,50,DataNascimento) as Completa50,
	   datename(weekday,Dateadd(Year,50,DataNascimento)) as DiaDaSemana
From Associado

--exercicio 7

Select UF as Estado,
	count(1) as QuantidadeDeCidades
From Cidade
group by uf

--exercicio 8 

Select UF as Estado,
	   Nome as Cidade
From Cidade
group by uf, nome
having count(1) >= 2

--exercicio 9

Select MAX(IDAssociado)+1 as PróximoID
From Associado

--exercicio 10

Delete CidadeAux
Insert into CidadeAux (IDCidade, Nome, UF)
	select distinct min(IDCidade) as IDCidade,
			        Nome, 
					UF 
	from Cidade 
	group by Nome, UF 

--exercicio 11

begin transaction
go

update Cidade 
set Nome = CONCAT('*', Nome) 
where Nome in (
	Select Nome
	From Cidade
	group by nome, uf
	having count(1) >= 2
);

commit

--exercicio 12

Select
	Nome as NomeAssociado,
	Case Sexo
		 when 'M' then 'Masculino'
		 when 'F' then 'Feminino'
		 else 'Não Especificado'
	end as Sexo
From Associado

--exercicio 13

Select
	NomeEmpregado as Nome,
	Salario as SalarioMensal,
	case 
		when salario<1164 then '0%'
		when salario between 1164 and 2326 then '15%'
		when salario>2326 then '27,5%'
	end as PercentualIR
from Empregado

--exercicio 14

begin transaction
go

delete 
from Cidade
where substring(Nome,1,1)='*'
and IDCidade not in (select distinct min(IDCidade)
					 from Cidade 
					 group by Nome, UF)

commit

--exercicio 15

begin transaction
go

Alter Table Cidade
	Add Constraint UK_NomeUF Unique(Nome, UF)

commit