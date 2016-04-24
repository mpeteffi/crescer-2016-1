--Exercicio 1

Select 
	   e.NomeEmpregado as NomeEmpregado,
	   d.NomeDepartamento as Departamento
From empregado e
Inner Join Departamento d on e.IDDepartamento = d.IDDepartamento

--Exercicio 2

Select 
	a.Nome as NomeAssociado,
	c.Nome as Cidade
From Associado a
Inner Join Cidade c on a.IdCidade = c.IDCidade

--Exercicio 3

Select
	UF as Estado,
	count(1) as TotalCidades
From Cidade 
Where Nome not in (Select c.Nome
				   From Associado a
				   Inner Join Cidade c on a.IDCidade = c.IDCidade)
Group by UF
	
--Exercicio 4

Select 
	a.Nome as NomeAssociado,
	c.Nome as Cidade,
	case c.UF
		when 'RS' then '***'
		when 'PR' then '***'
		when 'SC' then '***'
		else 'Nulo'
	end as RegiaoSul
From Associado a
Inner Join Cidade c on a.IdCidade = c.IDCidade

--Exercicio 5

Select 
	e.IDempregado 
From Empregado e
Inner Join Departamento d on e.IDDepartamento = d.IDDepartamento
Inner Join Empregado g on e.IDGerente = g.IDEmpregado

--exercicio 6
begin transaction
go

Select * into EmpregadoAux from empregado

update EmpregadoAux
set Salario = (salario*1.145) 
where IDEmpregado in (
	Select 
	e.IDempregado 
	From Empregado e
	Inner Join Departamento d on e.IDDepartamento = d.IDDepartamento
	where d.Localizacao='SAO PAULO')

commit

--exercicio 7

select 
	(sum(ea.Salario)-sum(e.Salario)) as Diferen�a
From Empregado e
Inner Join EmpregadoAux ea on e.IDEmpregado=ea.IDEmpregado

--exercicio 8

Select
	d.NomeDepartamento as Departamento
From Empregado e
Inner Join Departamento d on e.IDDepartamento = d.IDDepartamento
Where e.salario = (
	Select 
		max(salario) 
	from Empregado
	where IDDepartamento IS NOT NULL)
