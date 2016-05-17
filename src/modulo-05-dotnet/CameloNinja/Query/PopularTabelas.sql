INSERT INTO Usuario (Nome, Email, Senha)
	VALUES
	('Administrador', 'admin@admin.com', '02421f21538429f52d59a08233b56224'), --testeadm
	('UsuarioComum', 'comum@comum.com', '1a38c1fd21a143d7418546cf3df6507c') --testecomum

INSERT INTO UsuarioPermissao(UsuarioId, PermissaoId)
	VALUES
	(1, 1),
	(1, 2), 
	(2, 1)