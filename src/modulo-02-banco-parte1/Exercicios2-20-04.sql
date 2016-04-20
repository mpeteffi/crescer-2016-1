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
	   Datediff(Month,DataAdmissao,Getdate()) as MesesDeTrabalho
From empregado
Where DataAdmissao between '1980-05-01' and '1982-01-20'

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