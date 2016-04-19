-- Gerado por Oracle SQL Developer Data Modeler 4.1.3.901
--   em:        2016-04-19 17:36:41 BRT
--   site:      SQL Server 2012
--   tipo:      SQL Server 2012




CREATE
  TABLE Beneficiario
  (
    IDBeneficiario INTEGER NOT NULL IDENTITY NOT FOR REPLICATION ,
    Nome           VARCHAR (50) NOT NULL
  )
  ON "default"
GO
ALTER TABLE Beneficiario ADD CONSTRAINT Beneficiario_PK PRIMARY KEY CLUSTERED (
IDBeneficiario)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
GO

CREATE
  TABLE BeneficiarioContrato
  (
    IDBeneficiarioContrato INTEGER NOT NULL IDENTITY NOT FOR REPLICATION ,
    IDContrato             INTEGER NOT NULL ,
    IDBeneficiario         INTEGER NOT NULL
  )
  ON "default"
GO
ALTER TABLE BeneficiarioContrato ADD CONSTRAINT BeneficiarioContrato_PK PRIMARY
KEY CLUSTERED (IDBeneficiarioContrato)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
GO

CREATE
  TABLE Cliente
  (
    IDCliente INTEGER NOT NULL IDENTITY NOT FOR REPLICATION ,
    Nome      VARCHAR (50) NOT NULL
  )
  ON "default"
GO
ALTER TABLE Cliente ADD CONSTRAINT Pedido_PK PRIMARY KEY CLUSTERED (IDCliente)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
GO

CREATE
  TABLE Contrato
  (
    IDContrato INTEGER NOT NULL IDENTITY NOT FOR REPLICATION ,
    DataInicio DATE NOT NULL ,
    DataFim    DATE NOT NULL ,
    IDCliente  INTEGER NOT NULL ,
    IDPRoduto  INTEGER NOT NULL
  )
  ON "default"
GO
ALTER TABLE Contrato ADD CONSTRAINT Relation_1_PK PRIMARY KEY CLUSTERED (
IDContrato)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
GO

CREATE
  TABLE Produto
  (
    IDPRoduto  INTEGER NOT NULL IDENTITY NOT FOR REPLICATION ,
    Modalidade VARCHAR (50) NOT NULL
  )
  ON "default"
GO
ALTER TABLE Produto ADD CONSTRAINT Produto_PK PRIMARY KEY CLUSTERED (IDPRoduto)
WITH
  (
    ALLOW_PAGE_LOCKS = ON ,
    ALLOW_ROW_LOCKS  = ON
  )
  ON "default"
GO

ALTER TABLE BeneficiarioContrato
ADD CONSTRAINT FK_Beneficiario FOREIGN KEY
(
IDBeneficiario
)
REFERENCES Beneficiario
(
IDBeneficiario
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE Contrato
ADD CONSTRAINT FK_Cliente FOREIGN KEY
(
IDCliente
)
REFERENCES Cliente
(
IDCliente
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE BeneficiarioContrato
ADD CONSTRAINT FK_Contrato FOREIGN KEY
(
IDContrato
)
REFERENCES Contrato
(
IDContrato
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE Contrato
ADD CONSTRAINT FK_Produto FOREIGN KEY
(
IDPRoduto
)
REFERENCES Produto
(
IDPRoduto
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO


-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             5
-- CREATE INDEX                             0
-- ALTER TABLE                              9
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE DATABASE                          0
-- CREATE DEFAULT                           0
-- CREATE INDEX ON VIEW                     0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE ROLE                              0
-- CREATE RULE                              0
-- CREATE SCHEMA                            0
-- CREATE SEQUENCE                          0
-- CREATE PARTITION FUNCTION                0
-- CREATE PARTITION SCHEME                  0
-- 
-- DROP DATABASE                            0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
