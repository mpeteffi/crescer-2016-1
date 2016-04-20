--exercicio 1

Select
	NomeEmpregado as Nome
From Empregado
Order By DataAdmissao

--exercicio 2

Select 
	NomeEmpregado as Nome,
	(salario*12) as SalarioAnual
From empregado
Where cargo in ('Atendente')
		or (salario*12)<18500

--exercicio 3

Select
	IDCidade as ID
From Cidade
Where Nome in ('Uberlândia')

--exercicio 4

Select
	IDCidade as ID,
	Nome as NomeCidade
From Cidade
Where UF in ('RS')