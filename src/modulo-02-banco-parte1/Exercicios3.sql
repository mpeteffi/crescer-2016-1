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
	e.NomeEmpregado as NomeEmpregado,
	g.NomeEmpregado as NomeGerente,
	d.NomeDepartamento as Departamento
From Empregado e
Inner Join Departamento d on e.IDDepartamento = d.IDDepartamento
Inner Join Empregado g on e.IDGerente = g.IDEmpregado