CREATE TABLE Permissao
	(
	 PermissaoId int IDENTITY NOT NULL PRIMARY KEY,
	 Permissao varchar(50) NOT NULL,
	 CONSTRAINT CHK_Permissao CHECK (Permissao = 'COMUM' OR Permissao = 'ADMIN')
	);

CREATE TABLE Usuario
	(
	 UsuarioId int IDENTITY NOT NULL PRIMARY KEY,
	 Nome varchar(50) NOT NULL,
	 Email varchar(100) UNIQUE NOT NULL,
	 Senha varchar(50) NOT NULL
	);

CREATE TABLE UsuarioPermissao
	(
	 UsuarioPermissaoId int IDENTITY NOT NULL PRIMARY KEY,
	 UsuarioId int,
	 PermissaoId int,
	 CONSTRAINT FK_UsuarioId FOREIGN KEY (UsuarioId) REFERENCES Usuario(UsuarioId),
	 CONSTRAINT FK_PermissaoId FOREIGN KEY (PermissaoId) REFERENCES Permissao(PermissaoId)
	);